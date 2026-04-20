//CheckingAccount.java
package project.accounts;

public class CheckingAccount extends BankAccount {
    private static final int MAX_WITHDRAWALS = 5;   //Withdrawal limit for a checking account
    private int numWithdrawals;                     //Number of withdrawals on this account

    //Default constructor
    public CheckingAccount() {
        super();
        this.numWithdrawals = 0;
    }

    //Parameterized constructor
    public CheckingAccount(double amount, String name) {
        super(amount, name);
        this.numWithdrawals = 0;
    }

    //Getter
    public int getNumWithdrawals() { return numWithdrawals; }
    public int getMaxWithdrawals() { return MAX_WITHDRAWALS; }

    //Setter
    public void setNumWithdrawals(int numWithdrawals) { this.numWithdrawals = numWithdrawals; }

    //Checks whether the account reached max withdrawals
    public boolean atMaxWithdrawal() { 
        return numWithdrawals >= MAX_WITHDRAWALS; 
    }

    //Deposit money
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
        }
    }

    //Withdraw money
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && !atMaxWithdrawal() && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            numWithdrawals++;
        }
    }
}