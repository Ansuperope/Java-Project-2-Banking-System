package project;

// abs base class
import project.accounts.BankAccount;

// derived classes
import project.accounts.CheckingAccount;
import project.accounts.CreditAccount;
import project.accounts.SavingAccount;
import project.accounts.InterestFeature;

// manager class
import project.system.BankingSystem;

// exception classes
import project.system.ErrorAccountNotFound;
import project.system.ErrorLowFunds;

public class Main {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        BankAccount checking = new CheckingAccount(1200.00, "Joshua");
        SavingAccount savings = new SavingAccount(3500.00, "Ava", 3.0, 1);
        CreditAccount credit = new CreditAccount("Liam", 18.0, 1);

        try {
            bank.addAccount(checking);
            bank.addAccount(savings);
            bank.addAccount(credit);

            bank.depositMoney("Joshua", 300.00);
            bank.withdrawMoney("Joshua", 150.00);
            bank.transferMoney("Ava", "Joshua", 250.00);

            credit.removeFromAccount(800.00);
            credit.addToAccount(300.00);

            savings.applyGrowth();

            InterestFeature interestView = savings;
            System.out.printf("Savings interest through interface: $%.2f%n%n",
                    interestView.interestAmount());

            bank.displayAccountInfo();

            try {
                bank.withdrawMoney("Joshua", 50000.00);
            } catch (ErrorLowFunds e) {
                System.out.println("Caught ErrorLowFunds: " + e.getMessage());
            }

            try {
                bank.displayAccountInfo("Ghost");
            } catch (ErrorAccountNotFound e) {
                System.out.println("Caught ErrorAccountNotFound: " + e.getMessage());
            }

        } catch (ErrorAccountNotFound | ErrorLowFunds e) {
            System.out.println("Banking error: " + e.getMessage());
        }
    }
}

/* OUTPUT ==================================================================
Savings interest through interface: $101.40

Account type: CheckingAccount
Owner: Joshua
Amount in account: $1600.00
Withdrawals used: 1/5

Account type: SavingAccount
Owner: Ava
Amount in account: $3380.00
Activity count: 1
Qualifies for low activity benefit: true
Interest preview: $101.40
Interest-capable account, current interest amount: $101.40

Account type: CreditAccount
Owner: Liam
Available credit: $4500.00
Amount borrowed: $500.00
Credit paid off: false
Interest preview: $90.00
Penalty preview: $10.00
Interest-capable account, current interest amount: $90.00

Caught ErrorLowFunds: Insufficient funds for Joshua
Caught ErrorAccountNotFound: Could not find account for owner: Ghost
*/