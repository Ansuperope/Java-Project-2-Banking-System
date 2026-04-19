// BankAccount.java
package project.accounts;

import project.system.ErrorLowFunds;

public abstract class BankAccount {
    private double amountInAccount;
    private String accountOwner;

    public BankAccount() {
        this(0.0, "Unknown");
    }

    public BankAccount(double amountInAccount, String accountOwner) {
        this.amountInAccount = Math.max(0.0, amountInAccount);
        this.accountOwner = (accountOwner == null || accountOwner.isBlank())
                ? "Unknown"
                : accountOwner;
    }

    public double getAmountInAccount() {
        return amountInAccount;
    }

    public void setAmountInAccount(double amountInAccount) {
        this.amountInAccount = Math.max(0.0, amountInAccount);
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = (accountOwner == null || accountOwner.isBlank())
                ? "Unknown"
                : accountOwner;
    }

    protected void increaseBalance(double amount) {
        amountInAccount += amount;
    }

    protected void decreaseBalance(double amount) throws ErrorLowFunds {
        if (amount > amountInAccount) {
            throw new ErrorLowFunds("Insufficient funds for " + accountOwner);
        }
        amountInAccount -= amount;
    }

    public void displayAmount() {
        System.out.printf("Amount in account: $%.2f%n", amountInAccount);
    }

    public void displayOwner() {
        System.out.println("Owner: " + accountOwner);
    }

    public void displayAccount() {
        System.out.println("Account type: " + getClass().getSimpleName());
        displayOwner();
        displayAmount();
    }

    public abstract void addToAccount(double amount);

    public abstract void removeFromAccount(double amount) throws ErrorLowFunds;
}