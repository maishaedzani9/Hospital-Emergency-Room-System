public class TestHospitalER {
    public static void main(String[] args) {
        HospitalERSystem hospital = new HospitalERSystem();
        
        System.out.println("Starting Hospital ER System Test");
        System.out.println("================================\n");
        
        hospital.showCurrentStatus();
        
        System.out.println("Test 1: Adding patients");
        hospital.admitPatient("John Smith", false);
        hospital.admitPatient("Maria Garcia", true);
        hospital.admitPatient("David Lee", false);
        hospital.admitPatient("Sarah Johnson", true);
        hospital.admitPatient("Mike Brown", false);
        hospital.showCurrentStatus();
        
        System.out.println("Test 2: Treating patients");
        hospital.treatPatient();
        hospital.treatPatient();
        hospital.treatPatient();
        hospital.showCurrentStatus();
        
        System.out.println("Test 3: Undoing treatment");
        hospital.undoTreatment();
        hospital.showCurrentStatus();
        
        System.out.println("Test 4: More treatments");
        hospital.treatPatient();
        hospital.treatPatient();
        hospital.treatPatient();
        hospital.showCurrentStatus();
        
        System.out.println("Test 5: Edge cases");
        hospital.treatPatient();
        hospital.undoTreatment();
        
        System.out.println("Test 6: Adding more patients");
        hospital.admitPatient("Tom Wilson", false);
        hospital.admitPatient("Lisa Chen", true);
        hospital.showCurrentStatus();
        
        System.out.println("Test 7: Final treatments");
        hospital.treatPatient();
        hospital.treatPatient();
        hospital.showCurrentStatus();
        
        System.out.println("\nAll tests completed successfully!");
    }
}