public class TestMedicationSystem {
    public static void main(String[] args) {
        MedicationSystem system = new MedicationSystem();


        // SAMPLE ADD DOCTORS TEST
        Doctor doc1 = new Doctor(1, "Dr. Hibbert", "Cardiology");
        Doctor doc2 = new Doctor(2, "Dr. Nick", "Pediatrics");
        Doctor doc3 = new Doctor(3, "Dr. Velimirovic", "Plastic Surgery");
        Doctor doc4 = new Doctor(4, "Dr. Wolfe", "Orthodontics");
        Doctor doc5 = new Doctor(5, "Dr. Foster", "Psychology");

        system.addDoctor(doc1);
        system.addDoctor(doc2);
        system.addDoctor(doc3);
        system.addDoctor(doc4);
        system.addDoctor(doc5);


        // SAMPLE ADD PATIENTS TEST
        Patient pat1 = new Patient(1, "Homer", "Simpson");
        Patient pat2 = new Patient(2, "Marge", "Simpson");
        Patient pat3 = new Patient(3, "Bart", "Simpson");
        Patient pat4 = new Patient(4, "Lisa", "Simpson");
        Patient pat5 = new Patient(5, "Maggie", "Simpson");
        Patient pat6 = new Patient(6, "Ned", "Flanders");
        Patient pat7 = new Patient(7, "Todd", "Flanders");
        Patient pat8 = new Patient(8, "Rod", "Flanders");
        Patient pat9 = new Patient(9, "Lenny", "Leonard");
        Patient pat10 = new Patient(10, "Carl", "Carlson");
        Patient pat11 = new Patient(11, "Barney", "Gumble");
        Patient pat12 = new Patient(12, "Moe", "Szyslak");
        Patient pat13 = new Patient(13, "Krusty", "The Clown");

        system.addPatient(pat1);
        system.addPatient(pat2);
        system.addPatient(pat3);
        system.addPatient(pat4);
        system.addPatient(pat5);
        system.addPatient(pat6);
        system.addPatient(pat7);
        system.addPatient(pat8);
        system.addPatient(pat9);
        system.addPatient(pat10);
        system.addPatient(pat11);
        system.addPatient(pat12);
        system.addPatient(pat13);


        // SAMPLE ADD MEDICATIONS TEST
        Medication med1 = new Medication(1, "Aspirin", "300mg", 2100);
        Medication med2 = new Medication(2, "Acetaminophen", "325mg", 1650);
        Medication med3 = new Medication(3, "Ibuprofen", "200mg", 1820);
        Medication med4 = new Medication(4, "Naproxen", "275mg", 560);
        Medication med5 = new Medication(5, "Sudafed", "60mg", 370);
        Medication med6 = new Medication(6, "Benadryl", "25mg", 680);
        Medication med7 = new Medication(7, "Mucinex", "200mg", 290);
        Medication med8 = new Medication(8, "Robitussin", "20mL", 450);
        
        system.addMedication(med1);
        system.addMedication(med2);
        system.addMedication(med3);
        system.addMedication(med4);
        system.addMedication(med5);
        system.addMedication(med6);
        system.addMedication(med7);
        system.addMedication(med8);


        // ASSIGN PATIENTS TO DOCTORS TEST
        system.addTestPatientToDoctor(1, 1);
        system.addTestPatientToDoctor(2, 2);
        system.addTestPatientToDoctor(3, 3);
        system.addTestPatientToDoctor(4, 4);
        system.addTestPatientToDoctor(5, 5);
        system.addTestPatientToDoctor(1, 6);
        system.addTestPatientToDoctor(2,7);
        system.addTestPatientToDoctor(3, 8);
        system.addTestPatientToDoctor(4, 9);
        system.addTestPatientToDoctor(5, 10);
        system.addTestPatientToDoctor(1, 11);
        system.addTestPatientToDoctor(2, 12);
        system.addTestPatientToDoctor(3, 13);


        // START TEST
        system.start();
    }
} 