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

    // constructor
    public Medication(int id, String name, String dose, int inStock) { // was noticing an issue with (int, string, string, int, date), so i just removed expiryDate from this
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.inStock = inStock;

        // takes today's date, adds 1 to the year
        Calendar defaultExpiry = Calendar.getInstance();
        defaultExpiry.add(Calendar.YEAR, 1);
        this.expiryDate = defaultExpiry.getTime();
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
