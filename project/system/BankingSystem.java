// BankingSystem.java
package project.system;

import java.util.ArrayList;
import java.util.List;

import project.accounts.BankAccount;
import project.accounts.CreditAccount;
import project.accounts.InterestFeature;

public class BankingSystem {
    private List<BankAccount> accounts;
    private int numberOfAccounts;

    //Default constructor
    public BankingSystem() {
        this.accounts = new ArrayList<>();
        this.numberOfAccounts = 0;
    }

    //Getters
    public List<BankAccount> getAccounts() { return accounts; }
    public int getNumberOfAccounts() { return numberOfAccounts; }

    //Add an account to system
    public void addAccount(BankAccount account) {
        if (account != null) {
            accounts.add(account);
            numberOfAccounts++;
        }
    }

    //Find an account by owner name
    //Throws an exception if no account under that name is found
    public BankAccount findAccount(String ownerName) throws ErrorAccountNotFound {
        for (BankAccount account : accounts) {
            if (account.getAccountOwner().equalsIgnoreCase(ownerName)) {
                return account;
            }
        }
        throw new ErrorAccountNotFound("Account for owner \"" + ownerName + "\" not found.");
    }

    //Deposit into an account
    public void depositToAccount(String ownerName, double amount) throws ErrorAccountNotFound {
        BankAccount account = findAccount(ownerName);
        account.deposit(amount);
    }

    //Withdraw from an account
    //Throws an exception if there are insufficient funds in an account
    public void withdrawFromAccount(String ownerName, double amount) throws ErrorAccountNotFound, ErrorLowFunds {
        BankAccount account = findAccount(ownerName);

        if (amount <= 0) {
            throw new ErrorLowFunds("Withdrawal amount must be greater than 0.");
        }

        //Apply low-funds rule only to non-credit accounts
        if (!(account instanceof CreditAccount) && amount > account.getBalance()) {
            throw new ErrorLowFunds("Not enough funds in account for withdrawal.");
        }

        account.withdraw(amount);
    }

    //Transfer money between two accounts
    //Throws an exception if there are insufficient funds in the source account
    public boolean transferMoney(String fromOwner, String toOwner, double amount) throws ErrorAccountNotFound, ErrorLowFunds {
        BankAccount fromAccount = findAccount(fromOwner);
        BankAccount toAccount = findAccount(toOwner);

        if (amount <= 0) {
            throw new ErrorLowFunds("Transfer amount must be greater than 0.");
        }

        if (amount > fromAccount.getBalance()) {
            throw new ErrorLowFunds("Not enough funds to transfer.");
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        return true;
    }

    //Display all account information in the banking system
    public void displayAccountInfo() {
        for (BankAccount account : accounts) {
            System.out.println("Account type: " + account.getClass().getSimpleName());
            account.displayOwner();
            account.displayAmount();

            if (account instanceof InterestFeature) {
                InterestFeature interestAccount = (InterestFeature) account;
                System.out.println("Interest amount: $" + interestAccount.interestAmount());
            }

            System.out.println();
        }
    }
}