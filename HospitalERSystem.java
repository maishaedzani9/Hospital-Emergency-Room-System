public class HospitalERSystem {
    private QueueAsMyLinkedList<Patient> waitingRoom;
    private StackAsMyLinkedList<Patient> treatmentHistory;
    
    public HospitalERSystem() {
        waitingRoom = new QueueAsMyLinkedList<Patient>();
        treatmentHistory = new StackAsMyLinkedList<Patient>();
    }
    
    public void admitPatient(String patientName, boolean emergency) {
        Patient newPatient = new Patient(patientName, emergency);
        
        if (emergency) {
            QueueAsMyLinkedList<Patient> tempQueue = new QueueAsMyLinkedList<Patient>();
            
            while (!waitingRoom.isEmpty() && waitingRoom.peek().isEmergency()) {
                tempQueue.enqueue(waitingRoom.dequeue());
            }
            
            tempQueue.enqueue(newPatient);
            
            while (!waitingRoom.isEmpty()) {
                tempQueue.enqueue(waitingRoom.dequeue());
            }
            
            while (!tempQueue.isEmpty()) {
                waitingRoom.enqueue(tempQueue.dequeue());
            }
        } else {
            waitingRoom.enqueue(newPatient);
        }
        
        System.out.println("Patient admitted: " + newPatient);
    }
    
    public void treatPatient() {
        if (waitingRoom.isEmpty()) {
            System.out.println("No patients waiting for treatment");
            return;
        }
        
        Patient treated = waitingRoom.dequeue();
        treatmentHistory.push(treated);
        System.out.println("Treated patient: " + treated);
    }
    
    public void undoTreatment() {
        if (treatmentHistory.isEmpty()) {
            System.out.println("No treatments to undo");
            return;
        }
        
        Patient lastPatient = treatmentHistory.pop();
        admitPatient(lastPatient.getName(), lastPatient.isEmergency());
        System.out.println("Undid treatment for: " + lastPatient);
    }
    
    public void showCurrentStatus() {
        System.out.println("=== HOSPITAL ER STATUS ===");
        System.out.println("Waiting patients: " + waitingRoom.size());
        System.out.println("Queue: " + waitingRoom);
        System.out.println("Treatments done: " + treatmentHistory.size());
        System.out.println("Treatment history: " + treatmentHistory);
        System.out.println("==========================");
    }
    
    public int getWaitingCount() {
        return waitingRoom.size();
    }
    
    public int getTreatmentCount() {
        return treatmentHistory.size();
    }
}