package project.accounts;

import project.system.ErrorLowFunds;

public class CreditAccount extends BankAccount implements InterestFeature {
    public static final int MAX_LIMIT = 5000;
    private static final double PENALTY_RATE = 0.02;

    private double amountTaken;
    private boolean paidCredit;
    private double interestPercent;
    private int timePass;

    public CreditAccount() {
        this("Unknown", 18.0, 1);
    }

    public CreditAccount(String accountOwner, double interestPercent, int timePass) {
        super(MAX_LIMIT, accountOwner);
        this.amountTaken = 0.0;
        this.paidCredit = true;
        this.interestPercent = Math.max(0.0, interestPercent);
        this.timePass = Math.max(0, timePass);
    }

    public double getAmountTaken() {
        return amountTaken;
    }

    public void setAmountTaken(double amountTaken) {
        this.amountTaken = Math.max(0.0, Math.min(amountTaken, MAX_LIMIT));
        setAmountInAccount(MAX_LIMIT - this.amountTaken);
        this.paidCredit = this.amountTaken == 0.0;
    }

    public boolean isPaidCredit() {
        return paidCredit;
    }

    public void setPaidCredit(boolean paidCredit) {
        this.paidCredit = paidCredit;
    }

    public boolean applyPenalty() {
        return !paidCredit && timePass > 0;
    }

    public double calcPenalty() {
        return applyPenalty() ? amountTaken * PENALTY_RATE : 0.0;
    }

    @Override
    public double getInterestPercent() {
        return interestPercent;
    }

    @Override
    public void setInterestPercent(double interestPercent) {
        this.interestPercent = Math.max(0.0, interestPercent);
    }

    @Override
    public int getTimePass() {
        return timePass;
    }

    @Override
    public void setTimePass(int timePass) {
        this.timePass = Math.max(0, timePass);
    }

    @Override
    public double interestAmount() {
        return amountTaken * (interestPercent / 100.0) * timePass;
    }

    @Override
    public void addToAccount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0");
        }

        double paymentApplied = Math.min(amount, amountTaken);
        amountTaken -= paymentApplied;
        setAmountInAccount(MAX_LIMIT - amountTaken);
        paidCredit = amountTaken == 0.0;
    }

    @Override
    public void removeFromAccount(double amount) throws ErrorLowFunds {
        if (amount <= 0) {
            throw new IllegalArgumentException("Borrowed amount must be greater than 0");
        }
        if (amount > getAmountInAccount()) {
            throw new ErrorLowFunds("Credit limit exceeded for " + getAccountOwner());
        }

        setAmountInAccount(getAmountInAccount() - amount);
        amountTaken += amount;
        paidCredit = false;
    }

    @Override
    public void displayAccount() {
        System.out.println("Account type: " + getClass().getSimpleName());
        displayOwner();
        System.out.printf("Available credit: $%.2f%n", getAmountInAccount());
        System.out.printf("Amount borrowed: $%.2f%n", amountTaken);
        System.out.println("Credit paid off: " + paidCredit);
        System.out.printf("Interest preview: $%.2f%n", interestAmount());
        System.out.printf("Penalty preview: $%.2f%n", calcPenalty());
    }
}