// Doctor represents a doctor. Each doctor has a specialization and a list of
// patients they are managing.

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private List<Patient> patients;
    private List<Prescription> prescriptions;

    // default constructor
    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<Patient>();
        this.prescriptions = new ArrayList<Prescription>();
    }

    // getters
    public int getId() {return id;}
    public String getName() {return name;}
    public String getSpecialization() {return specialization;}
    public Patient[] getPatients() {return patients.toArray(new Patient[patients.size()]);}

    // setters
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setSpecialization(String specialization) {this.specialization = specialization;}

    public void setPatients(Patient[] patients) {
        this.patients = new ArrayList<Patient>();
        for (Patient patient : patients) {
            this.patients.add(patient);
        }
    }

    // add a patient to the doctor's list of patients
    public void addPatient(Patient patient) {patients.add(patient);}

    // add a prescription to the doctor's list of prescriptions
    public void addPrescription(Prescription prescription) {prescriptions.add(prescription);}

    // remove a patient from the doctor's list of patients
    public void removePatient(Patient patient) {patients.remove(patient);}

    // remove a prescription from the doctor's list of prescriptions
    public void removePrescription(Prescription prescription) {prescriptions.remove(prescription);}

    // toString method
    public String toString() {
        return "Doctor ID: " + id +
               ", Doctor Name: " + name +
               ", Specialization: " + specialization;
    }
}
