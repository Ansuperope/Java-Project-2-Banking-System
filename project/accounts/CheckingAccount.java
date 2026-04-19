package project.accounts;

import project.system.ErrorLowFunds;

public class CheckingAccount extends BankAccount {
    public static final int MAX_WITHDRAWALS = 5;

    private int numWithdrawals;

    public CheckingAccount() {
        super();
        numWithdrawals = 0;
    }

    public CheckingAccount(double amountInAccount, String accountOwner) {
        super(amountInAccount, accountOwner);
        numWithdrawals = 0;
    }

    public int getNumWithdrawals() {
        return numWithdrawals;
    }

    public void setNumWithdrawals(int numWithdrawals) {
        this.numWithdrawals = Math.max(0, numWithdrawals);
    }

    public boolean atMaxWithdrawl() {
        return numWithdrawals >= MAX_WITHDRAWALS;
    }

    @Override
    public void addToAccount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }
        increaseBalance(amount);
    }

    @Override
    public void removeFromAccount(double amount) throws ErrorLowFunds {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        }
        if (atMaxWithdrawl()) {
            throw new IllegalStateException("Maximum withdrawals reached for checking account");
        }
        decreaseBalance(amount);
        numWithdrawals++;
    }

    @Override
    public void displayAccount() {
        super.displayAccount();
        System.out.println("Withdrawals used: " + numWithdrawals + "/" + MAX_WITHDRAWALS);
    }
}