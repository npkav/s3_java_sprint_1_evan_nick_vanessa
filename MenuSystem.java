// The MedicationTrackingSystem class manages the entire system. It contains lists of patients, medications, and doctors, and provides the following functionalities:
// · Search for drugs, patients, and doctors by name and display relevant details for each
// · Add a patient to a doctor's list.
// · Accept a prescription (staff manually inputs the prescription details from the doctor), linking the prescription and drug to the patient.
// · Edit and delete medications, patients, and doctors
// · Generate a report containing all system data, including drugs, patients, doctors, and prescriptions
// · Check for expired medications and display a message if any are found.
// · Print a list of all prescription's issued by a specific doctor.
// · Restock the drugs in the pharmacy in some capacity. You can just add a random number to the stock, you can add a specific number. Its up to you!

import java.util.Scanner;

public class MenuSystem {
    private Scanner scanner;

    public MenuSystem() {
        this.scanner = new Scanner(System.in);
    }

    public int showMainMenu() {
        System.out.println("Medication System");
        System.out.println("1. Search for Drugs, Patients, and Doctors");
        System.out.println("2. Add/Remove Doctor");
        System.out.println("3. Add/Remove Patient");
        System.out.println("4. Add/Remove Medication");
        System.out.println("5. Print All Prescriptions by a Specific Doctor");
        System.out.println("6. Restock Medications");
        System.out.println("7. Check for Expired Medications");
        System.out.println("8. Generate Report");
        System.out.println("9. Exit");

        System.out.print("Please enter your choice: ");
        return scanner.nextInt();
    }

    public int showSearchMenu() {
        System.out.println("Search for Drugs, Patients, and Doctors");
        System.out.println("1. Search for Drugs");
        System.out.println("2. Search for Patients");
        System.out.println("3. Search for Doctors");

        System.out.print("Please enter your choice: ");
        return scanner.nextInt();
    }

    public int showModifyMenu(String menuType) {
        System.out.println("Add/Remove " + menuType);
        System.out.println("1. Add " + menuType);
        System.out.println("2. Remove " + menuType);
        System.out.println("3. Edit " + menuType);

        System.out.print("Please enter your choice: ");
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
} 