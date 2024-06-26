import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("holla");

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setMiddleName("Smith");
        person.setEmailAddress("johnDoe1@me.com");
        person.setPhoneNumber("077900");
        person.personID = 1;
        person.createPerson(person);

        System.out.println(person.toString());

        Bank bank = new Bank();
        bank.accountCreation(person, AccountStatus.ACTIVE.toString());

        int amount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount to be deposited:");
        amount = scanner.nextInt();

        bank.deposit(amount, bank.getCustomerName(), bank.getCustomerAccountNumber());

        int withdrawAmount = 0;
        System.out.println("Do you want to withdraw ?: Type Y for Yes & N for No");
        Scanner responseScanner = new Scanner(System.in);
        String response = responseScanner.nextLine();

        // if (Objects.equals(response, new String("Y")) && Objects.equals(response, new
        // String("y"))) {
        transactionCycle(response, withdrawAmount, amount, bank);

    }

    // used static because i am calling it in a static method
    public static void transactionCycle(String response, int withdrawAmount, int amount, Bank bank) {
        if (response.equalsIgnoreCase("Y")) {

            System.out.println("Enter the amount you want to withdraw:");
            Scanner scanner = new Scanner(System.in);
            withdrawAmount = scanner.nextInt();
            boolean isTransactionComplete;
            isTransactionComplete = bank.withdrawal(withdrawAmount, amount, bank.getCustomerAccountNumber());

            if (isTransactionComplete) {
                System.out.println("Transaction Completed!!!");
            } else {
                // recursion
                transactionCycle(response, withdrawAmount, amount, bank);
                System.out.println("isTransactionComplete >>>>>" + isTransactionComplete);
            }

        } else {

            System.out.println("Transaction Completed!");
        }
    }

}