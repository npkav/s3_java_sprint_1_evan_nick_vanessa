// The Person class is the base class for both the Patient and Doctor classes.
// It contains the following attributes:
// · ID: A unique identifier for each person.
// · Name: The name of the person.
// · Age: The age of the person.
// · Phone Number: the persons contact information


public class Person {
    private int id;
    private String name;
    private int age;
    private String phoneNumber;

    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // the getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phoneNumber;
    }

    // the setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // converting everything into a toString format
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Phone Number: " + phoneNumber;
    }
}