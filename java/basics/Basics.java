// Class representing a bank account
class BankAccount {

    // State: instance variables
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor with name and account number only
    public BankAccount(String holderName, String accountNumber) {
        this.accountHolderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;  // Default balance
    }

    // Constructor with all fields (full initialization)
    public BankAccount(String holderName, String accountNumber, double initialBalance) {
        this.accountHolderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Behavior: method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Depositing INR " + amount + " to " + accountHolderName + "'s account.");
            System.out.println("INR " + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Behavior: method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawing INR " + amount + " from " + accountHolderName + "'s account.");
            System.out.println("INR " + amount + " withdrawn successfully.");
        } else {
            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount.");
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        }
    }

    // Behavior: method to display account information
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: INR " + balance);
    }

    // Getters and Setters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// Main Class
public class Basics {
    public static void main(String[] args) {

        // Creating a bank account with full details
        System.out.println("Bank Account 1 --------------------------------------------");
        BankAccount account1 = new BankAccount("Piyush Tilokani", "SB1001", 50000.0);
        account1.displayAccountDetails();
        System.out.println();
        account1.deposit(2000);
        account1.withdraw(1000);
        System.out.println("\nFinal Account Status:");
        account1.displayAccountDetails();
        System.out.println();
        
        // Using Getters to retrieve data
        System.out.println("Account Balance: INR " + account1.getBalance());
        System.out.println("Account Holder Name: " + account1.getAccountHolderName());
        
        // Using Setters to update data
        System.out.println("\nUpdating Account Holder Name using Setter...");
        account1.setAccountHolderName("Piyush N Tilokani");
        System.out.println("Updated Account Holder: " + account1.getAccountHolderName());
        System.out.println();
        
        // Creating another account with only name and account number
        System.out.println("Bank Account 2 --------------------------------------------");
        BankAccount account2 = new BankAccount("Mike Tyson", "SB1002");
        account2.displayAccountDetails();
        System.out.println();

        account2.deposit(1000);
        account2.displayAccountDetails();

        // Updating account details using setters
        System.out.println("\nUpdating Account 2 using Setters...");
        account2.setBalance(2500.0);
        account2.setAccountHolderName("Peter Parker");
        System.out.println("Updated Details:");
        account2.displayAccountDetails();
    }
}
