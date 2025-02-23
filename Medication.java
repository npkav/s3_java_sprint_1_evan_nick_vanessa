// The Medication class represents a medication. It contains the following attributes:
// · ID: A unique identifier for each medication.
// · Name: The name of the medication.
// · Dose: The dosage of the medication.
// · Quantity in stock: the amount of medication in stock
// · ExpiryDate: The expiry date of the medication ( try and set the date to be a random date inclusive of the past)

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

// default constructor
public class Medication {
    private int id;
    private String name;
    private String dose;
    private int inStock;
    private Date expiryDate;
    private List<Prescription> prescriptions;

    // calculate random expiry date between 4 months ago and 8 months from now
    private static Date calcExpiryDate() {
        Calendar cal = Calendar.getInstance();
        int randomMonths = (int)(Math.random() * 12) - 4;
        int randomDays = (int)(Math.random() * 31);
        cal.set(Calendar.DAY_OF_MONTH, randomDays + 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0); 
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.MONTH, randomMonths);
        return cal.getTime();
    }

    // constructor
    public Medication(int id, String name, String dose, int inStock) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.inStock = inStock;
        this.expiryDate = calcExpiryDate();
        this.prescriptions = new ArrayList<Prescription>();
    }

    // getters
    public int getId() {return id;}
    public String getName() {return name;}
    public String getDose() {return dose;}
    public int getInStock() {return inStock;}
    public Date getExpiryDate() {return expiryDate;}

    // setters
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setDose(String dose) {this.dose = dose;}
    public void setInStock(int inStock) {this.inStock = inStock;}
    public void setExpiryDate(Date expiryDate) {this.expiryDate = expiryDate;}

    // add a prescription to the medication's list of prescriptions
    public void addPrescription(Prescription prescription) {prescriptions.add(prescription);}

    // remove a prescription from the medication's list of prescriptions
    public void removePrescription(Prescription prescription) {prescriptions.remove(prescription);}

    // toString method
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Dose='" + dose + '\'' +
                ", Quantity in Stock=" + inStock +
                ", Expiry Date=" + expiryDate +
                '}';
    }
}
