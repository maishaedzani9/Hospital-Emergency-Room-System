public class Patient {
    private String name;
    private boolean emergencyCase;
    
    public Patient(String name, boolean isEmergency) {
        this.name = name;
        this.emergencyCase = isEmergency;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isEmergency() {
        return emergencyCase;
    }
    
    public String toString() {
        if (emergencyCase) {
            return name + " (Emergency)";
        } else {
            return name + " (Normal)";
        }
    }
}