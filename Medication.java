// The Medication class represents a medication. It contains the following attributes:
// · ID: A unique identifier for each medication.
// · Name: The name of the medication.
// · Dose: The dosage of the medication.
// · Quantity in stock: the amount of medication in stock
// · ExpiryDate: The expiry date of the medication ( try and set the date to be a random date inclusive of the past)

import java.util.Date;
import java.util.Calendar;

// default constructor
public class Medication {
    private int id;
    private String name;
    private String dose;
    private int inStock;
    private Date expiryDate;

    // calculate random expiry date between 4 months ago and 8 months from now
    private static Date calcExpiryDate() {
        Calendar cal = Calendar.getInstance();
        int randomMonths = (int)(Math.random() * 12) - 4;
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
