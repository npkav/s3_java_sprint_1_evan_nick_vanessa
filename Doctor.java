// Doctor represents a doctor. Each doctor has a specialization and a list of
// patients they are managing.

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private Patient[] patients;

    // default constructor
    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.patients = new Patient[0];
    }

    // getters
    public int getDoctorId() {
        return id;
    }

    public String getDoctorName() {
        return name;
    }

    public String getDoctorSpecialization() {
        return specialization;
    }

    public Patient[] getDoctorPatients() {
        return patients;
    }

    // setters
    public void setDoctorId(int id) {
        this.id = id;
    }

    public void setDoctorName(String name) {
        this.name = name;
    }

    public void setDoctorSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setDoctorPatients(Patient[] patients) {
        this.patients = patients;
    }

    // toString method
    public String toString() {
        return "Doctor ID: " + id + "\nDoctor Name: " + name + "\nSpecialization: " + specialization;
    }
}
