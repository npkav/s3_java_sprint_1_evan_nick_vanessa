// Patient represents a patient. Each patient has a list of medications they are
// taking and a list of prescriptions active in the pharmacy.

import java.util.List;
import java.util.ArrayList;

public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    // default constructor
    public Patient(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.medications = new ArrayList<Medication>();
        this.prescriptions = new ArrayList<Prescription>();
    }

    // getters
    public int getPatientId() {return id;}
    public String getPatientFirstName() {return firstName;}
    public String getPatientLastName() {return lastName;}
    public List<Medication> getPatientMedications() {return medications;}
    public List<Prescription> getPatientPrescriptions() {return prescriptions;}

    // setters
    public void setPatientId(int id) {this.id = id;}
    public void setPatientFirstName(String firstName) {this.firstName = firstName;}
    public void setPatientLastName(String lastName) {this.lastName = lastName;}
    public void setPatientMedications(List<Medication> medications) {this.medications = medications;}
    public void setPatientPrescriptions(List<Prescription> prescriptions) {this.prescriptions = prescriptions;}

    // add a medication to the patient's list of medications
    public void addPatientMedication(Medication medication) {medications.add(medication);}

    // add a prescription to the patient's list of prescriptions
    public void addPatientPrescription(Prescription prescription) {prescriptions.add(prescription);}

    // remove a medication from the patient's list of medications
    public void removePatientMedication(Medication medication) {medications.remove(medication);}

    // remove a prescription from the patient's list of prescriptions
    public void removePatientPrescription(Prescription prescription) {prescriptions.remove(prescription);}

    // toString method
    public String toString() {
        return "Patient ID: " + id + "\n" +
               "Patient Name: " + firstName + " " + lastName + "\n" +
               "Medications: " + medications + "\n" +
               "Prescriptions: " + prescriptions + "\n";
    }
}
