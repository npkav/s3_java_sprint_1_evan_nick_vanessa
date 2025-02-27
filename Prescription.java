// The Prescription class represents a prescription issued by a doctor for a patient
// · ID: A unique identifier for each prescription.
// · Doctor: A reference to the prescribing doctor.
// · Patient: A reference to the patient.
// · Medication: A reference to the prescribed medication.
// · Prescription Expiry: The expiration date of the prescription, which defaults to one year from the date it was issued.

import java.util.Date;
import java.util.Calendar;

public class Prescription {
    private int id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private Date expiryDate;

    public Prescription(int id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;

        // as a default, the expiry date will be today's date, plus one year.
        Calendar defaultExpiry = Calendar.getInstance();
        defaultExpiry.add(Calendar.YEAR, 1);
        this.expiryDate = defaultExpiry.getTime();
    }

    // the getters
    public int getId() {return id;}
    public Doctor getDoctor() {return doctor;}
    public Patient getPatient() {return patient;}
    public Medication getMedication() {return medication;}
    public Date getExpiryDate() {return expiryDate;}

    // the setters
    public void setId(int id) {this.id = id;}
    public void setDoctor(Doctor doctor) {this.doctor = doctor;}
    public void setPatient(Patient patient) {this.patient = patient;}
    public void setMedication(Medication medication) {this.medication = medication;}
    public void setExpiry(Date expiryDate) {this.expiryDate = expiryDate;}

    // converting everything into a toString format
    public String toString() {
        return "Prescription ID: " + id + "\n" +
               "Doctor: " + doctor.getName() + "\n" +
               "Patient: " + patient.getName() + "\n" +
               "Medication: " + medication.getName() + "\n" +
               "Expiry Date: " + expiryDate + "\n";
    }
}