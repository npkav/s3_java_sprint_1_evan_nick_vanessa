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
    private String doctor;
    private String patient;
    private String medication;
    private Date expiryDate;

    public Prescription(int id, String doctor, String patient, String medication) { // was noticing an issue with (int, string, string, int, date) in medication, so i just removed expiryDate from this just in case it causes issues
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
    public String getDoctor() {return doctor;}
    public String getPatient() {return patient;}
    public String getMedication() {return medication;}
    public Date getExpiryDate() {return expiryDate;}

    // the setters
    public void setId(int id) {this.id = id;}
    public void setDoctor(String doctor) {this.doctor = doctor;}
    public void setPatient(String patient) {this.patient = patient;}
    public void setMedication(String medication) {this.medication = medication;}
    public void setExpiry(Date expiryDate) {this.expiryDate = expiryDate;}

    // converting everything into a toString format
    public String toString() {
        return "Medication ID: " + id +
               ", Doctor: " + doctor +
               ", Patient: " + patient +
               ", Medication: " + medication +
               ", Expiry Date: " + expiryDate;
    }
}