// Doctor represents a doctor. Each doctor has a specialization and a list of
// patients they are managing.

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private List<Patient> patients;

    // default constructor
    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<Patient>();
    }

    // getters
    public int getDoctorId() {return id;}
    public String getDoctorName() {return name;}
    public String getDoctorSpecialization() {return specialization;}
    public Patient[] getDoctorPatients() {return patients.toArray(new Patient[patients.size()]);}

    // setters
    public void setDoctorId(int id) {this.id = id;}
    public void setDoctorName(String name) {this.name = name;}
    public void setDoctorSpecialization(String specialization) {this.specialization = specialization;}

    public void setDoctorPatients(Patient[] patients) {
        this.patients = new ArrayList<Patient>();
        for (Patient patient : patients) {
            this.patients.add(patient);
        }
    }

    // toString method
    public String toString() {
        return "Doctor ID: " + id +
               "\nDoctor Name: " + name +
               "\nSpecialization: " + specialization;
    }
}
