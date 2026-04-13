[![Java CI](https://github.com/Ansuperope/Java-Project-2-Banking-System/actions/workflows/java.yml/badge.svg)](https://github.com/Ansuperope/Java-Project-2-Banking-System/actions/workflows/java.yml)
[![Documentation](https://img.shields.io/badge/Documentation-Doxygen-blue?logo=doxygen)](https://ansuperope.github.io/Java-Project-2-Banking-System/)

## **<u>Important Links</u>**

- [<u>Original Class
  Assignment</u>](https://docs.google.com/document/d/1_azypNXBbCi_irpjK6iTcaE8TDdGcEviP4DNlee3fSo/edit?tab=t.0#heading=h.a7myqzjyjha4)

- [<u>Canvas Submit
  Link</u>](https://online.saddleback.edu/courses/30087/assignments/1077200)

- [<u>UML
  Diagrams</u>](https://drive.google.com/file/d/1_iePTjSNVr3_Zu6jHpc5LuP7scUtxnKQ/view?usp=sharing)

- [<u>Github</u>](https://github.com/Ansuperope/Java-Project-2-Banking-System)

- [<u>Google
  Doc</u>](https://docs.google.com/document/d/19Z-F2WiKFrBjV9tquQqSN_utwX2Rrgt57--4UwpNle4/edit?usp=drivesdk)

- Examples of Diagrams + About Relationships:
  [<u>GeeksforGeeks</u>](https://www.geeksforgeeks.org/system-design/unified-modeling-language-uml-class-diagrams/) +
  [<u>Creately</u>](https://creately.com/guides/class-diagram-relationships/)

## **<u>Program</u>**

1.  ***<u>Abstract Base Class / BankAccount:</u>*** All accounts
    (derived classes) will have the following features from BankAccount

    1.  Fields:

        1.  double **amountInAccount**: how much money in account

        2.  string **accountOwner**

    2.  Non Abstract Methods (will all be the same, implementation
        details included):

        1.  **BankAccount()**: default constructor

            1.  amountInAccount = 0

            2.  accountOwner = "Unknown"

        2.  **BankAccount(double amount, string name)**: default
            constructor

            1.  amountInAccount = amount

            2.  accountOwner = name

        3.  getter functions

        4.  setter functions

        5.  void **displayAmount()**: outputs amount in account

        6.  void **displayOwner():** outputs who owns the account

    3.  Abstract Methods (will vary, not have implementation details):

        1.  **addToAccount()**: add to amount

            1.  might need to account for interest

        2.  **removeFromAccount()**: removes from amount

            1.  might need to account for interest

    4.  Relationship with others

        1.  **Inheritance:** derived class

2.  ***<u>Interface / InterestFeature:</u>*** Each account that allows
    you to transfer money should have the following features:

    1.  Fields

        1.  double **interestPercent**: percent of interest

        2.  int **timePass**: how much time has passed

    2.  Non Abstract Methods (will all be the same, implementation
        details included):

        1.  

    3.  Abstract Methods (will vary, not have implementation details):

        1.  double **interestAmount**(): calculate the amount of
            interest

    4.  Relationship with others

        1.  **Realization:** derived class

3.  ***<u>Derived Classes:</u>*** Program will have the following
    accounts

    1.  ***<u>CheckingAccount</u>***: everyday spending. Deposit and
        withdraw money

        1.  Fields

            1.  const int **MAX_WITHDRAWLS** = 5

            2.  int **numWithdrawls**

        2.  Methods

            1.  getter functions

            2.  setter functions

            3.  bool **atMaxWithdrawl()**: outputs if at max or not

                1.  true = at max

                2.  false = not at max, can keep withdrawing

        3.  Relationship with others

            1.  **Inheritance:** BankAccount

            2.  **Aggregation:** BankingSystem

    2.  ***<u>SavingAccount</u>***: store money, earn interest. If user
        has low activity they get a benefit

        1.  Fields

            1.  const **MAX_LOW_ACTIVITY** = 10

                1.  the max amount of transactions a user can do in
                    order to get the benefit of low activity

            2.  int **activity**: keeps track of how many transactions
                done

            3.  boolean **lowActivity**: if user qualifies for low
                activity benefits

        2.  Methods

            1.  getter functions

            2.  setter functions

            3.  boolean **qualifyForLowActivity()**: calculates if user
                qualifies for low activity benefits

                1.  true = qualifies

                2.  false = does not qualify

            4.  double **lowActivityBenefit()**: calculates extra money
                low activity give user

        3.  Relationship with others

            1.  **Inheritance:** BankAccount

            2.  **Realization:** interface class

            3.  **Aggregation:** BankingSystem

    3.  ***<u>CreditAccount:</u>*** borrow money

        1.  Fields

            1.  const int **MAX_LIMIT** = 5000

            2.  double **amountTaken**

            3.  boolean **paidCredit**: if credit is paid

        2.  Methods

            1.  getter functions

            2.  setter functions

            3.  boolean **applyPenalty()**: determine if user needs to
                pay a penalty fee

                1.  true = user pays a fee

                2.  false = user needs to pay a fee

            4.  double **calcPenalty()**: calculates fee user needs to
                pay

        3.  Relationship with others

            1.  **Inheritance:** BankAccount

            2.  **Realization:** interface class

            3.  **Aggregation:** BankingSystem

4.  ***<u>Manager Class / BankingSystem:</u>*** will be used to do the
    following commands on all the accounts / derived classes:

    1.  Fields

        1.  **accounts**: List\<BankAccount\>

            1.  stored polymorphically, vector of all bank accounts

        2.  int **numberOfAccounts**:

    2.  Methods

        1.  void **addAccount(BankAccount)**: add bank account to
            manage. Will be data type abstract base class

            1.  will throw exception ErrorAccountNotFound if account not
                found

        2.  boolean **transferMoney()**: transfer money between
            accounts, returns if successful

            1.  true = successful

            2.  false = not successful

            3.  will throw exception ErrorLowFunds if funcs are low

        3.  void **displayAccountInfo()**: outputs account info

            1.  account type

            2.  owner name

            3.  other info related to account

    3.  Relationship with others

        1.  **Aggregation (has-a, child can still exist):** Derived
            class

        2.  **Dependency:** Exception class

5.  ***<u>Exception Classes:</u>*** The manager will also call protocols
    if certain criteria are met (relationship dependencies):

    1.  **ErrorAccountNotFound**: if you're doing a transaction or a

    2.  **ErrorLowFunds**: not enough money to do action

    3.  Relationship with others

        1.  **Dependency:** BankingSystem
