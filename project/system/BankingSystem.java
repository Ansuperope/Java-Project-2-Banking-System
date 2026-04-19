package project.system;

import java.util.ArrayList;
import java.util.List;

import project.accounts.BankAccount;
import project.accounts.InterestFeature;

public class BankingSystem {
    private final List<BankAccount> accounts;
    private int numberOfAccounts;

    public BankingSystem() {
        accounts = new ArrayList<>();
        numberOfAccounts = 0;
    }

    public List<BankAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }

    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public void addAccount(BankAccount account) throws ErrorAccountNotFound {
        if (account == null) {
            throw new ErrorAccountNotFound("Cannot add a null account");
        }
        accounts.add(account);
        numberOfAccounts = accounts.size();
    }

    public BankAccount findAccount(String ownerName) throws ErrorAccountNotFound {
        for (BankAccount account : accounts) {
            if (account.getAccountOwner().equalsIgnoreCase(ownerName)) {
                return account;
            }
        }
        throw new ErrorAccountNotFound("Could not find account for owner: " + ownerName);
    }

    public void depositMoney(String ownerName, double amount) throws ErrorAccountNotFound {
        BankAccount account = findAccount(ownerName);
        account.addToAccount(amount);
    }

    public void withdrawMoney(String ownerName, double amount)
            throws ErrorAccountNotFound, ErrorLowFunds {
        BankAccount account = findAccount(ownerName);
        account.removeFromAccount(amount);
    }

    public boolean transferMoney(String fromOwner, String toOwner, double amount)
            throws ErrorAccountNotFound, ErrorLowFunds {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than 0");
        }

        BankAccount fromAccount = findAccount(fromOwner);
        BankAccount toAccount = findAccount(toOwner);

        fromAccount.removeFromAccount(amount);
        toAccount.addToAccount(amount);
        return true;
    }

    public void displayAccountInfo() {
        for (BankAccount account : accounts) {
            displaySingleAccountInfo(account);
            System.out.println();
        }
    }

    public void displayAccountInfo(String ownerName) throws ErrorAccountNotFound {
        displaySingleAccountInfo(findAccount(ownerName));
    }

    private void displaySingleAccountInfo(BankAccount account) {
        account.displayAccount();
        if (account instanceof InterestFeature interestAccount) {
            System.out.printf("Interest-capable account, current interest amount: $%.2f%n",
                    interestAccount.interestAmount());
        }
    }
}