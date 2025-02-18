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
import java.util.List;

public class MedicationSystem {
    private List<Patient> patients;
    private List<Medication> medications;
    private List<Doctor> doctors;
    private MenuSystem menus;

    public MedicationSystem() {
        this.patients = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.menus = new MenuSystem();
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
                    printPrescriptions();
                    break;
                case 6:
                    restockMedications();
                    break;
                case 7:
                    checkExpiredMedications();
                    break;
                case 8:
                    generateReport();
                    break;
                case 9:
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

    private void searchDrugs() {
    }

    private void searchPatients() {
    }

    private void searchDoctors() {
    }


// MODIFY DOCTOR MENU
    private void modifyDoctor() {
        int choice = menus.showModifyMenu("Doctor");
        switch (choice) {
            case 1:
                addDoctor();
                break;
            case 2:
                removeDoctor();
                break;
        }
    }

    private void addDoctor() {
    }

    private void removeDoctor() {
    }


// MODIFY PATIENT MENU
    private void modifyPatient() {
        int choice = menus.showModifyMenu("Patient");
        switch (choice) {
            case 1:
                addPatient();
                break;
            case 2:
                removePatient();
                break;
        }   
    }

    private void addPatient() {
    }

    private void removePatient() {
    }


// MODIFY MEDICATION MENU
    private void modifyMedication() {
        int choice = menus.showModifyMenu("Medication");
        switch (choice) {
            case 1:
                addMedication();
                break;
            case 2:
                removeMedication();
                break;
        }
    }

    private void addMedication() {
    }

    private void removeMedication() {
    }


// PRINT PRESCRIPTIONS
    private void printPrescriptions() {
    }


// RESTOCK MEDICATIONS
    private void restockMedications() {
    }


// CHECK EXPIRED MEDICATIONS
    private void checkExpiredMedications() {
    }


// GENERATE REPORT
    private void generateReport() {
    }
}
