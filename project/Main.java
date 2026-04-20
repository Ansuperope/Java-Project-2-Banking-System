//Main.java
package project;

//Abstract base class
import project.accounts.BankAccount;

//Derived classes
import project.accounts.CheckingAccount;
import project.accounts.CreditAccount;
import project.accounts.SavingAccount;

//Manager class
import project.system.BankingSystem;

//Exception classes
import project.system.ErrorAccountNotFound;
import project.system.ErrorLowFunds;

public class Main {

    public static void main(String[] args) {
        //Creates an instance of the manager class to manage all BankAccount objects
        BankingSystem bank = new BankingSystem();

        //Create account objects for each type of account
        BankAccount checking = new CheckingAccount(1000.0, "Aspen");
        BankAccount savings = new SavingAccount(2000.0, "Hobs", 0.03, 2);
        BankAccount credit = new CreditAccount(0.0, "Christian", 0.05, 1);

        //Store accounts polymorphically
        bank.addAccount(checking);
        bank.addAccount(savings);
        bank.addAccount(credit);

        //Display all current BankAccount objects
        System.out.println("=== Initial Account Information ===");
        bank.displayAccountInfo();

        //Testing functionality of the BankingSystem class
        System.out.println("=== Performing Transactions ===");
        try {
            bank.depositToAccount("Aspen", 250.0);
            bank.withdrawFromAccount("Hobs", 300.0);
            bank.transferMoney("Aspen", "Hobs", 200.0);

            //For CreditAccount, withdraw = borrow, deposit = pay back
            bank.withdrawFromAccount("Christian", 500.0);
            bank.depositToAccount("Christian", 200.0);

        } catch (ErrorAccountNotFound | ErrorLowFunds e) {
            System.out.println("Transaction error: " + e.getMessage());
        }

        //Display all current BankAccount objects after transactions
        System.out.println("\n=== Updated Account Information ===");
        bank.displayAccountInfo();

        //Testing custom exception classes
        System.out.println("=== Demonstrating Exceptions ===");

        //Exception 1: Account not found
        try {
            bank.depositToAccount("Avin", 100.0);
        } catch (ErrorAccountNotFound e) {
            System.out.println("Caught ErrorAccountNotFound: " + e.getMessage());
        }

        //Exception 2: Insufficient funds
        try {
            bank.withdrawFromAccount("Aspen", 5000.0);
        } catch (ErrorAccountNotFound | ErrorLowFunds e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}