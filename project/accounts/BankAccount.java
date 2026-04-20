//BankAccount.java
package project.accounts;

public abstract class BankAccount {
    private double balance;        //Current balance of this bank account
    private String accountOwner;   //Name of the account owner

    //Default constructor
    public BankAccount() {
        this.balance = 0.0;
        this.accountOwner = "Unknown";
    }

    //Parameterized constructor
    public BankAccount(double amount, String name) {
        this.balance = amount;
        this.accountOwner = name;
    }

    //Getters
    public double getBalance() { return balance; }
    public String getAccountOwner() { return accountOwner; }

    //Setters
    public void setBalance(double amount) { this.balance = amount; }
    public void setAccountOwner(String owner) { this.accountOwner = owner; }

    //Display methods
    public void displayAmount() {
        System.out.println("Amount in account: $" + balance);
    }

    public void displayOwner() {
        System.out.println("Account owner: " + accountOwner);
    }

    //Abstract methods for derived classes
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}