// The MedicationTrackingSystem class manages the entire system. It contains lists of patients, medications, and doctors, and provides the following functionalities:
// · Search for drugs, patients, and doctors by name and display relevant details for each
// · Add a patient to a doctor's list.
// · Accept a prescription (staff manually inputs the prescription details from the doctor), linking the prescription and drug to the patient.
// · Edit and delete medications, patients, and doctors
// · Generate a report containing all system data, including drugs, patients, doctors, and prescriptions
// · Check for expired medications and display a message if any are found.
// · Print a list of all prescription's issued by a specific doctor.
// · Restock the drugs in the pharmacy in some capacity. You can just add a random number to the stock, you can add a specific number. Its up to you!

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MedicationSystem {
    private List<Patient> patients;
    private List<Medication> medications;
    private List<Doctor> doctors;
    private List<Prescription> prescriptions;
    private MenuSystem menus;
    private Scanner scanner;

    public MedicationSystem() {
        this.patients = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.menus = new MenuSystem();
        this.scanner = new Scanner(System.in);
    }


// MAIN MENU
    public void start() {
        while (true) {
            int choice = menus.showMainMenu();
    
            switch (choice) {
                case 1:
                    search();
                    break;
                case 2:
                    modifyDoctor();
                    break;
                case 3:
                    modifyPatient();
                    break;
                case 4:
                    modifyMedication();
                    break;
                case 5:
                    modifyPrescriptions();
                    break;
                case 6:
                    printPrescriptions();
                    break;
                case 7:
                    restockMedications();
                    break;
                case 8:
                    checkExpiredMedications();
                    break;
                case 9:
                    generateReport();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    menus.close();
                    return;
            }
        }
    }


// SEARCH MENU
    private void search() {
        int choice = menus.showSearchMenu();
        switch (choice) {
            case 1:
                searchDrugs();
                break;
            case 2:
                searchPatients();
                break;
            case 3:
                searchDoctors();
                break;
        }
    }


// SEARCH DRUGS
    private void searchDrugs() {
        System.out.println("Enter drug name or ID and press enter (leave blank to see all drugs in the system): ");
        String search = scanner.nextLine().toLowerCase();
        
        boolean found = false;
        for (Medication medication : medications) {
            if (search.isEmpty() || 
                medication.getName().toLowerCase().contains(search) ||
                String.valueOf(medication.getId()).equals(search)) {
                System.out.println(medication);
                found = true;
            }
        }
        
        if (!found && !search.isEmpty()) {
            System.out.println("ERROR: Drug not found.");
        }
    }


// SEARCH PATIENTS
    private void searchPatients() {
        System.out.println("Enter patient name or ID and press enter (leave blank to see all patients in the system): ");
        String search = scanner.nextLine().toLowerCase();
        
        boolean found = false;
        for (Patient patient : patients) {
            if (search.isEmpty() || 
                patient.getName().toLowerCase().contains(search) ||
                String.valueOf(patient.getId()).equals(search)) {
                System.out.println(patient);
                found = true;
            }
        }
        
        if (!found && !search.isEmpty()) {
            System.out.println("ERROR: Patient not found.");
        }
    }


// SEARCH DOCTORS
    private void searchDoctors() {
        System.out.println("Enter doctor name or ID and press enter (leave blank to see all doctors in the system): ");
        String search = scanner.nextLine().toLowerCase();
        
        boolean found = false;
        for (Doctor doctor : doctors) {
            if (search.isEmpty() || 
                doctor.getName().toLowerCase().contains(search) ||
                String.valueOf(doctor.getId()).equals(search)) {
                System.out.println(doctor);
                found = true;
            }
        }
        
        if (!found && !search.isEmpty()) {
            System.out.println("ERROR: Doctor not found.");
        }
    }


// MODIFY DOCTOR MENU
    private void modifyDoctor() {
        int choice = menus.showDoctorMenu();
        switch (choice) {
            case 1:
                addDoctor();
                break;
            case 2:
                removeDoctor();
                break;
            case 3:
                editDoctor();
                break;
            case 4:
                addPatientToDoctor();
                break;
            case 5:
                removePatientFromDoctor();
                break;
        }
    }


// ADD DOCTOR
private void addDoctor() {
    System.out.println("Enter Doctor ID:");
    int id = scanner.nextInt();
    scanner.nextLine(); 
    System.out.println("Enter Doctor Name:");
    String name = scanner.nextLine();
    System.out.println("Enter Doctor Specialization:");
    String specialization = scanner.nextLine();

    Doctor newDoctor = new Doctor(id, name, specialization);
    doctors.add(newDoctor);
    System.out.println("Doctor added successfully.");
}


// REMOVE DOCTOR
    private void removeDoctor() {
        System.out.println("Enter Doctor ID to remove:");
        int idToRemove = scanner.nextInt();
        scanner.nextLine(); 

        for (Prescription prescription : new ArrayList<>(prescriptions)) {
            if (prescription.getDoctor().getId() == idToRemove) {
                prescription.getPatient().removePrescription(prescription);
                prescription.getPatient().removeMedication(prescription.getMedication());
                prescription.getMedication().removePrescription(prescription);
                prescriptions.remove(prescription);
            }
        }

        doctors.removeIf(doctor -> doctor.getId() == idToRemove);
        System.out.println("Doctor removed successfully.");
    }


// EDIT DOCTOR
    private void editDoctor() {
        System.out.println("Enter Doctor ID to edit:");
        int idToEdit = scanner.nextInt();
        scanner.nextLine();
    
        Doctor doctorToEdit = doctors.stream()
            .filter(d -> d.getId() == idToEdit)
            .findFirst()
            .orElse(null);
    
        if (doctorToEdit == null) {
            System.out.println("Doctor not found.");
            return;
        }
    
        System.out.println("Current Doctor Info:");
        System.out.println(doctorToEdit);
        
        System.out.println("\nEnter new Doctor Name (or press enter to keep current):");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            doctorToEdit.setName(newName);
        }
    
        System.out.println("Enter new Specialization (or press enter to keep current):");
        String newSpecialization = scanner.nextLine();
        if (!newSpecialization.isEmpty()) {
            doctorToEdit.setSpecialization(newSpecialization);
        }
    
        System.out.println("Doctor information updated successfully.");
        System.out.println("Updated Information:");
        System.out.println(doctorToEdit);
    }


// ADD PATIENT TO DOCTOR
    private void addPatientToDoctor() {
        System.out.println("Enter Doctor ID:");
        int doctorId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Patient ID:");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Doctor doctor = doctors.stream()
            .filter(d -> d.getId() == doctorId)
            .findFirst()
            .orElse(null);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        Patient patient = patients.stream()
            .filter(p -> p.getId() == patientId)
            .findFirst()
            .orElse(null);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        doctor.addPatient(patient);
        System.out.println("Patient added to doctor successfully.");
    }


// REMOVE PATIENT FROM DOCTOR
    private void removePatientFromDoctor() {
        System.out.println("Enter Doctor ID:");
        int doctorId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Patient ID:");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Doctor doctor = doctors.stream()
            .filter(d -> d.getId() == doctorId)
            .findFirst()
            .orElse(null);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        Patient patient = patients.stream()
            .filter(p -> p.getId() == patientId)
            .findFirst()
            .orElse(null);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        doctor.removePatient(patient);
        System.out.println("Patient removed from doctor successfully.");
    }


// MODIFY PATIENT MENU
    private void modifyPatient() {
        int choice = menus.showPatientMenu();
        switch (choice) {
            case 1:
                addPatient();
                break;
            case 2:
                removePatient();
                break;
            case 3:
                editPatient();
                break;
        }   
    }


// ADD PATIENT
private void addPatient() {
    System.out.println("Enter Patient ID:");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Enter Patient First Name:");
    String firstName = scanner.nextLine();
    System.out.println("Enter Patient Last Name:");
    String lastName = scanner.nextLine();

    Patient newPatient = new Patient(id, firstName, lastName);
    patients.add(newPatient);
    System.out.println("Patient added successfully.");
}


// REMOVE PATIENT
    private void removePatient() {
        System.out.println("Enter Patient ID to remove:");
        int idToRemove = scanner.nextInt();
        scanner.nextLine();

        for (Prescription prescription : new ArrayList<>(prescriptions)) {
            if (prescription.getPatient().getId() == idToRemove) {
                prescription.getDoctor().removePrescription(prescription);
                prescription.getPatient().removeMedication(prescription.getMedication());
                prescription.getMedication().removePrescription(prescription);
                prescriptions.remove(prescription);
            }
        }

        patients.removeIf(patient -> patient.getId() == idToRemove);
        System.out.println("Patient removed successfully.");
    }


// EDIT PATIENT
    private void editPatient() {
        System.out.println("Enter Patient ID to edit:");
        int idToEdit = scanner.nextInt();
        scanner.nextLine();

        Patient patientToEdit = patients.stream()
            .filter(p -> p.getId() == idToEdit)
            .findFirst()
            .orElse(null);

        if (patientToEdit == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Current Patient Information:");
        System.out.println(patientToEdit);
        
        System.out.println("\nEnter new Patient First Name (or press enter to keep current):");
        String newFirstName = scanner.nextLine();
        if (!newFirstName.isEmpty()) {
            patientToEdit.setFirstName(newFirstName);
        }

        System.out.println("Enter new Patient Last Name (or press enter to keep current):");
        String newLastName = scanner.nextLine();
        if (!newLastName.isEmpty()) {
            patientToEdit.setLastName(newLastName);
        }

        System.out.println("Patient information updated successfully.");
        System.out.println("Updated Information:");
        System.out.println(patientToEdit);
    }


// MODIFY MEDICATION MENU
    private void modifyMedication() {
        int choice = menus.showMedicationMenu();
        switch (choice) {
            case 1:
                addMedication();
                break;
            case 2:
                removeMedication();
                break;
            case 3:
                editMedication();
                break;
        }
    }


// ADD MEDICATION
    private void addMedication() {
        System.out.println("Please enter medication ID: ");
        int medicationId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter medication name: ");
        String name = scanner.nextLine();

        System.out.println("Please enter medication dose: ");
        String dose = scanner.nextLine();

        System.out.println("Please enter medication quantity: ");
        int inStock = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Getting expiry date...");

        Medication medication = new Medication(medicationId, name, dose, inStock);

        medications.add(medication);
        System.out.println(name + " added to list! Expiry Date: " + medication.getExpiryDate());
    }


// REMOVE MEDICATION
    private void removeMedication() {
        System.out.println("Please enter the ID you wish to remove: ");
        int idToRemove = scanner.nextInt();
        scanner.nextLine();

        for (Prescription prescription : new ArrayList<>(prescriptions)) {
            if (prescription.getMedication().getId() == idToRemove) {
                prescription.getDoctor().removePrescription(prescription);
                prescription.getPatient().removePrescription(prescription);
                prescription.getPatient().removeMedication(prescription.getMedication());
                prescriptions.remove(prescription);
            }
        }

        medications.removeIf(medication -> medication.getId() == idToRemove);
        System.out.println("Medication removed!");
    }


// EDIT MEDICATION
    private void editMedication() {
        System.out.println("Enter Medication ID to edit:");
        int idToEdit = scanner.nextInt();
        scanner.nextLine();

        Medication medicationToEdit = medications.stream()
            .filter(m -> m.getId() == idToEdit)
            .findFirst()
            .orElse(null);

        if (medicationToEdit == null) {
            System.out.println("Medication not found.");
            return;
        }

        System.out.println("Current Medication Information:");
        System.out.println(medicationToEdit);
        
        System.out.println("\nEnter new Medication Name (or press enter to keep current):");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            medicationToEdit.setName(newName);
        }

        System.out.println("Enter new Medication Dose (or press enter to keep current):");
        String newDose = scanner.nextLine();
        if (!newDose.isEmpty()) {
            medicationToEdit.setDose(newDose);
        }

        System.out.println("Medication information updated successfully.");
        System.out.println("Updated Information:");
        System.out.println(medicationToEdit);
    }


    private void modifyPrescriptions() {
        int choice = menus.showPrescriptionMenu();
        switch (choice) {
            case 1:
                addPrescription();
                break;
            case 2:
                removePrescription();
                break;
        }
    }

// ADD PRESCRIPTIONS
    private void addPrescription() {
        System.out.println("Please enter prescription ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter one of the following doctor IDs: ");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getId() + ": " + doctor.getName());
        }

        int doctorId = scanner.nextInt();
        scanner.nextLine();

        Doctor selectDoctor = null;
        for (Doctor doctor : doctors) {
            if (doctor.getId() == doctorId) {
                selectDoctor = doctor;
                break;
            }
        }
    
        if (selectDoctor == null) {
            System.out.println("ERROR! Doctor not found.");
            return;
        }

        System.out.println("Please enter one of the following patient IDs: ");
        for (Patient patient : patients) {
            System.out.println(patient.getId() + ": " + patient.getName());
        }

        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient selectPatient = null;
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                selectPatient = patient;
                break;
            }
        }
    
        if (selectPatient == null) {
            System.out.println("ERROR! Patient not found.");
            return;
        }

        System.out.println("Please enter one of the following medication IDs: ");
        for (Medication medication : medications) {
            System.out.println(medication.getId() + ": " + medication.getName());
        }

        int medicationId = scanner.nextInt();
        scanner.nextLine();

        Medication selectMedication = null;
        for (Medication medication : medications) {
            if (medication.getId() == medicationId) {
                selectMedication = medication;
                break;
            }
        }
    
        if (selectMedication == null) {
            System.out.println("ERROR! Medication not found.");
            return;
        }

        System.out.println("Getting expiry date...");

        Prescription prescription = new Prescription(id, selectDoctor, selectPatient, selectMedication);

        prescriptions.add(prescription);
        selectDoctor.addPrescription(prescription);
        selectPatient.addPrescription(prescription);
        selectPatient.addMedication(selectMedication);
        System.out.println("Prescription successfully created!");
        System.out.println("Id: " + id + ", Doctor Name: " + selectDoctor.getName() + ", Patient Name: " + selectPatient.getName()  + ", Medication Name: " + selectMedication.getName()  + ", Expiry Date: " + prescription.getExpiryDate());
    }

// REMOVE PRESCRIPTION
    private void removePrescription() {
        System.out.println("Enter Prescription ID to remove:");
        int idToRemove = scanner.nextInt();
        scanner.nextLine(); 

        prescriptions.removeIf(prescription -> prescription.getId() == idToRemove);
        System.out.println("Prescription removed successfully.");
}

// PRINT PRESCRIPTION FROM SPECIFIED DOCTOR
    private void printPrescriptions() {
        System.out.println("Please enter one of the following doctor IDs: ");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getId() + ": " + doctor.getName());
        }
        String search = scanner.nextLine().toLowerCase();
    
        boolean found = false;
        for (Doctor doctor : doctors) {
            if (search.isEmpty() || 
                doctor.getName().toLowerCase().contains(search) ||
                String.valueOf(doctor.getId()).equals(search)) {
                    
                System.out.println("Prescriptions issued by " + doctor.getName() + ":");
                for (Prescription prescription : prescriptions) {
                    if (prescription.getDoctor().getId() == doctor.getId()) {
                        System.out.println(prescription);
                        found = true;
                    }
                }
            }
        }
        
        if (!found && !search.isEmpty()) {
            System.out.println("ERROR: Doctor not found or no prescriptions found.");
        }
    }


// RESTOCK MEDICATIONS
    private void restockMedications() {
        System.out.println("Restocking medications!");
        for (Medication medication : medications) {
            int restock = 500;
            medication.setInStock(medication.getInStock() + restock);
            System.out.println(medication.getName() + " successfully restocked! Current amount: " + medication.getInStock());
        }
    }


// CHECK EXPIRED MEDICATIONS
    private void checkExpiredMedications() {
        Date currentDate = new Date();

        for (Medication medication : medications) {
            if (medication.getExpiryDate().before(currentDate)) {
                System.out.println("Uh oh! " + medication.getName() + " has expired! Expiry Date: " + medication.getExpiryDate());
            }
        }
    }


// GENERATE REPORT
    private void generateReport() {
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
        }

        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }

        System.out.println("Medications:");
        for (Medication medication : medications) {
            System.out.println(medication.toString());
        }
    }

    public List<Doctor> getDoctors() {
        return this.doctors;
    }

    public List<Patient> getPatients() {
        return this.patients;
    }

    public List<Medication> getMedications() {

        return this.medications;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }




    // TEST METHOD -- REMOVE LATER
    public void addTestPatientToDoctor(int doctorId, int patientId) {
        Doctor doctor = doctors.stream()
            .filter(d -> d.getId() == doctorId)
            .findFirst()
            .orElse(null);

        Patient patient = patients.stream()
            .filter(p -> p.getId() == patientId)
            .findFirst()
            .orElse(null);

        if (doctor != null && patient != null) {
            doctor.addPatient(patient);
        }
    }
}
