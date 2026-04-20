package project.accounts;

public class CreditAccount extends BankAccount implements InterestFeature {
    //Maximum credit account limit
    private static final double MAX_LIMIT = 5000.0;

    private boolean paidCredit;       //True if credit has been fully paid
    private double interestPercent;   //Interest rate on borrowed amount
    private int timePass;             //How much time has passed

    //Default constructor
    public CreditAccount() {
        super();
        this.paidCredit = true;
        this.interestPercent = 0.03;
        this.timePass = 1;
    }

    //Parameterized constructor
    public CreditAccount(double amount, String name, double interestPercent, int timePass) {
        super(amount, name);
        this.paidCredit = (amount == 0);
        this.interestPercent = interestPercent;
        this.timePass = timePass;
    }

    //Getters
    public boolean getPaidCredit() { return paidCredit; }
    public double getInterestPercent() { return interestPercent; }
    public int getTimePass() { return timePass; }
    public double getMaxLimit() { return MAX_LIMIT; }

    //Setters
    public void setPaidCredit(boolean paidCredit) { this.paidCredit = paidCredit; }
    public void setInterestPercent(double interestPercent) { this.interestPercent = interestPercent; }
    public void setTimePass(int timePass) { this.timePass = timePass; }

    //Determines if a penalty should be applied
    public boolean applyPenalty() {
        return !paidCredit;
    }

    //Calculates penalty fee
    public double calcPenalty() {
        if (applyPenalty()) {
            return getBalance() * 0.02;
        }
        return 0.0;
    }

    //InterestFeature interface method
    @Override
    public double interestAmount() {
        return getBalance() * interestPercent * timePass;
    }

    //Deposit money to pay back credit
    @Override
    public void deposit(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            paidCredit = (getBalance() == 0);
        }
    }

    //Withdraw money to borrow credit
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() + amount <= MAX_LIMIT) {
            setBalance(getBalance() + amount);
            paidCredit = false;
        }
    }
}