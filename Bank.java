import java.io.File;
import java.io.FileWriter;

public class Bank {

    private String customerID;
    private String customerName;

    private String customerAccountNumber;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public void accountCreation(Person person, String status) {

        customerName = person.getFirstName();
        customerAccountNumber = "214567";
        customerID = "001";

        try {
            // creates a file in an absolute path
            // if in a specific path, use "c:\\xxx\\xxx\\xxx\\filename.txt"
            File myfile = new File("AccountBook.txt");
            if (myfile.createNewFile()) {
                System.out.println("file created: >>>" + myfile.getName());
            } else {
                System.out.println("File already exist");
            }

            FileWriter fileWriter = new FileWriter("AccountBook.txt");

            fileWriter.write(customerID + " " + customerName + " " + customerAccountNumber + " " + status);

            fileWriter.close();

            System.out.println("writing to file was successful!!!");

        } catch (Exception e) {
            System.out.println("Error occured !!!");
            e.printStackTrace();

        }

    }

    public boolean withdrawal(int amountToWithdraw, int initialAmount, String accountNumber) {

        boolean isComplete = false;

        try {
            // creates a file in an absolute path
            // if in a specific path, use "c:\\xxx\\xxx\\xxx\\filename.txt"
            if (initialAmount > amountToWithdraw) {

                File myfile = new File("DepositBook.txt");

                if (myfile.createNewFile()) {

                    System.out.println("file created: >>>" + myfile.getName());
                } else {
                    System.out.println("File already exist");
                }

                FileWriter fileWriter = new FileWriter("DepositBook.txt");

                int totalAmount;

                totalAmount = initialAmount - amountToWithdraw;

                fileWriter.write(accountNumber + " " + customerName + "  " + totalAmount);

                fileWriter.close();

                System.out.println("writing to file was successful!!!");

                isComplete = true;

            } else {

                System.out.println("insufficient balance!!!");

                isComplete = false;
            }

        } catch (Exception e) {
            System.out.println("Error occured !!!");
            e.printStackTrace();
            isComplete = false;
        }

        return isComplete;

    }

    public void deposit(int amount, String accountNumber, String customerName) {

        try {
            // creates a file in an absolute path
            // if in a specific path, use "c:\\xxx\\xxx\\xxx\\filename.txt"
            File myfile = new File("DepositBook.txt");
            if (myfile.createNewFile()) {
                System.out.println("file created: >>>" + myfile.getName());
            } else {
                System.out.println("File already exist");
            }

            FileWriter fileWriter = new FileWriter("DepositBook.txt");

            fileWriter.write(accountNumber + " " + customerName + "  " + amount);

            fileWriter.close();

            System.out.println("writing to file was successful!!!");

        } catch (Exception e) {
            System.out.println("Error occured !!!");
            e.printStackTrace();

        }

    }
}
