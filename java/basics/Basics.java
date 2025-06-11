// Class representing a bank account
class BankAccount {

    // State: instance variables
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor: initializes account details
    public BankAccount(String holderName, String accountNumber, double initialBalance) {
        this.accountHolderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Behavior: method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Behavior: method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    // Behavior: method to display account information
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }
}


//Main Class
public class Basics{
    public static void main(String[] args) {
        // Creating an object (instance) of BankAccount class
        BankAccount account1 = new BankAccount("Piyush Tilokani", "SB1001", 5000.0);

        // Using behaviors (methods)
        account1.displayAccountDetails();

        System.out.println("\nDepositing ₹2000...");
        account1.deposit(2000);

        System.out.println("\nWithdrawing ₹1500...");
        account1.withdraw(1500);

        System.out.println("\nFinal Account Status:");
        account1.displayAccountDetails();
    }
}