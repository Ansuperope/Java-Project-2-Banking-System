//SavingAccount.java
package project.accounts;

public class SavingAccount extends BankAccount implements InterestFeature {
    //The max amount of transactions a user can perform to get the benefit of low activity
    private static final int MAX_LOW_ACTIVITY = 10;

    private int transactions;         //Tracks the number of transactions on this account
    private boolean lowActivity;      //True if the user qualifies for low activity
    private double interestPercent;   //Percent interest on this savings account
    private int timePass;             //How much time has passed

    //Default constructor
    public SavingAccount() {
        super();
        this.transactions = 0;
        this.lowActivity = true;
        this.interestPercent = 0.02;
        this.timePass = 1;
    }

    //Parameterized constructor
    public SavingAccount(double amount, String name, double interestPercent, int timePass) {
        super(amount, name);
        this.transactions = 0;
        this.interestPercent = interestPercent;
        this.timePass = timePass;
        this.lowActivity = qualifyForLowActivity();
    }

    //Getters
    public int getTransactions() { return transactions; }
    public boolean getLowActivity() { return lowActivity; }
    public double getInterestPercent() { return interestPercent; }
    public int getTimePass() { return timePass; }
    public int getMaxLowActivity() { return MAX_LOW_ACTIVITY; }

    //Setters
    public void setTransactions(int transactions) {
        this.transactions = transactions;
        this.lowActivity = qualifyForLowActivity();
    }

    public void setLowActivity(boolean lowActivity) { this.lowActivity = lowActivity; }
    public void setInterestPercent(double interestPercent) { this.interestPercent = interestPercent; }
    public void setTimePass(int timePass) { this.timePass = timePass; }

    //Checks whether the account qualifies for low activity benefits
    public boolean qualifyForLowActivity() {
        return transactions <= MAX_LOW_ACTIVITY;
    }

    //Calculates the extra money earned from low activity status
    public double lowActivityBenefit() {
        if (qualifyForLowActivity()) {
            return getBalance() * 0.01;
        }
        return 0.0;
    }

    //InterestFeature interface method
    @Override
    public double interestAmount() {
        return getBalance() * interestPercent * timePass;
    }

    //Deposit money
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            transactions++;
            lowActivity = qualifyForLowActivity();
        }
    }

    //Withdraw money
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            transactions++;
            lowActivity = qualifyForLowActivity();
        }
    }
}