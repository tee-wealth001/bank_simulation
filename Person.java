import java.io.File;
import java.io.FileWriter;

public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String emailAddress;
    int personID;
    String accountNumber;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        // private String phoneNumber;
        // private String emailAddress;

        return "Person {firstName='" + firstName + "', lastName='" + lastName + "' , middleName='" + middleName
                + "', phoneNumber='" + phoneNumber + "', emailAddress='" + emailAddress + '}';
    }

    public Person() {

    }

    public void createPerson(Person person) {

        try {
            // creates a file in an absolute path
            // if in a specific path, use "c:\\xxx\\xxx\\xxx\\filename.txt"
            File myfile = new File("Person.txt");
            if (myfile.createNewFile()) {
                System.out.println("file created: >>>" + myfile.getName());
            } else {
                System.out.println("File already exist");
            }

            FileWriter fileWriter = new FileWriter("Person.txt");

            fileWriter.write(person.personID + " " + person.getFirstName()+ " " + person.getLastName()+ " " + person.getMiddleName()+ " "+ person.getEmailAddress()+ " " + person.getPhoneNumber());

            fileWriter.close();

            System.out.println("writing to file was successful!!!");

        } catch (Exception e) {
            System.out.println("Error occured !!!");
            e.printStackTrace();
        }

    }

}
