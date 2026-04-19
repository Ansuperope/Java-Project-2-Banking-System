package project.accounts;

import project.system.ErrorLowFunds;

public class SavingAccount extends BankAccount implements InterestFeature {
    public static final int MAX_LOW_ACTIVITY = 10;
    private static final double LOW_ACTIVITY_BONUS_RATE = 0.01;

    private int activity;
    private boolean lowActivity;
    private double interestPercent;
    private int timePass;

    public SavingAccount() {
        this(0.0, "Unknown", 2.5, 1);
    }

    public SavingAccount(double amountInAccount, String accountOwner, double interestPercent, int timePass) {
        super(amountInAccount, accountOwner);
        this.activity = 0;
        this.interestPercent = Math.max(0.0, interestPercent);
        this.timePass = Math.max(0, timePass);
        this.lowActivity = true;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = Math.max(0, activity);
        this.lowActivity = qualifyForLowActivity();
    }

    public boolean isLowActivity() {
        return lowActivity;
    }

    public void setLowActivity(boolean lowActivity) {
        this.lowActivity = lowActivity;
    }

    public boolean qualifyForLowActivity() {
        lowActivity = activity <= MAX_LOW_ACTIVITY;
        return lowActivity;
    }

    public double lowActivityBenefit() {
        return qualifyForLowActivity() ? getAmountInAccount() * LOW_ACTIVITY_BONUS_RATE : 0.0;
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
        return getAmountInAccount() * (interestPercent / 100.0) * timePass;
    }

    public void applyGrowth() {
        increaseBalance(interestAmount() + lowActivityBenefit());
    }

    @Override
    public void addToAccount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }
        increaseBalance(amount);
        activity++;
        lowActivity = qualifyForLowActivity();
    }

    @Override
    public void removeFromAccount(double amount) throws ErrorLowFunds {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        }
        decreaseBalance(amount);
        activity++;
        lowActivity = qualifyForLowActivity();
    }

    @Override
    public void displayAccount() {
        super.displayAccount();
        System.out.println("Activity count: " + activity);
        System.out.println("Qualifies for low activity benefit: " + qualifyForLowActivity());
        System.out.printf("Interest preview: $%.2f%n", interestAmount());
    }
}