<p>[![Java CI](<a
href="https://github.com/Ansuperope/Java-Project-2-Banking-System/actions/workflows/java.yml/badge.svg)%5D(https://github.com/Ansuperope/Java-Project-2-Banking-System/actions/workflows/java.yml"><u>https://github.com/Ansuperope/Java-Project-2-Banking-System/actions/workflows/java.yml/badge.svg)](https://github.com/Ansuperope/Java-Project-2-Banking-System/actions/workflows/java.yml</u></a>)</p>
<p>[![Documentation](https://img.shields.io/badge/Documentation-Doxygen-blue?logo=doxygen)](https://ansuperope.github.io/Java-Project-2-Banking-System/)</p>
<h2 id="important-links"><strong><u>Important Links</u></strong></h2>
<ul>
<li><p><a
href="https://docs.google.com/document/d/1_azypNXBbCi_irpjK6iTcaE8TDdGcEviP4DNlee3fSo/edit?tab=t.0#heading=h.a7myqzjyjha4"><u>Original
Class Assignment</u></a></p></li>
<li><p><a
href="https://online.saddleback.edu/courses/30087/assignments/1077200"><u>Canvas
Submit Link</u></a></p></li>
<li><p><a
href="https://drive.google.com/file/d/1_iePTjSNVr3_Zu6jHpc5LuP7scUtxnKQ/view?usp=sharing"><u>UML
Diagrams</u></a></p></li>
<li><p><a
href="https://github.com/Ansuperope/Java-Project-2-Banking-System"><u>Github</u></a></p></li>
<li><p><a
href="https://docs.google.com/document/d/19Z-F2WiKFrBjV9tquQqSN_utwX2Rrgt57--4UwpNle4/edit?usp=drivesdk"><u>Google
Doc</u></a></p></li>
<li><p>Examples of Diagrams + About Relationships: <a
href="https://www.geeksforgeeks.org/system-design/unified-modeling-language-uml-class-diagrams/"><u>GeeksforGeeks</u></a>
+ <a
href="https://creately.com/guides/class-diagram-relationships/"><u>Creately</u></a></p></li>
</ul>
<h2 id="program"><strong><u>Program</u></strong></h2>
<ol type="1">
<li><p><em><strong><u>Abstract Base Class /
BankAccount:</u></strong></em> All accounts (derived classes) will have
the following features from BankAccount</p>
<ol type="a">
<li><p>Fields:</p>
<ol type="i">
<li><p>double <strong>amountInAccount</strong>: how much money in
account</p></li>
<li><p>string <strong>accountOwner</strong></p></li>
</ol></li>
<li><p>Non Abstract Methods (will all be the same, implementation
details included):</p>
<ol type="i">
<li><p><strong>BankAccount()</strong>: default constructor</p>
<ol type="1">
<li><p>amountInAccount = 0</p></li>
<li><p>accountOwner = "Unknown"</p></li>
</ol></li>
<li><p><strong>BankAccount(double amount, string name)</strong>: default
constructor</p>
<ol type="1">
<li><p>amountInAccount = amount</p></li>
<li><p>accountOwner = name</p></li>
</ol></li>
<li><p>getter functions</p></li>
<li><p>setter functions</p></li>
<li><p>void <strong>displayAmount()</strong>: outputs amount in
account</p></li>
<li><p>void <strong>displayOwner():</strong> outputs who owns the
account</p></li>
</ol></li>
<li><p>Abstract Methods (will vary, not have implementation
details):</p>
<ol type="i">
<li><p><strong>addToAccount()</strong>: add to amount</p>
<ol type="1">
<li><p>might need to account for interest</p></li>
</ol></li>
<li><p><strong>removeFromAccount()</strong>: removes from amount</p>
<ol type="1">
<li><p>might need to account for interest</p></li>
</ol></li>
</ol></li>
<li><p>Relationship with others</p>
<ol type="i">
<li><p><strong>Inheritance:</strong> derived class</p></li>
</ol></li>
</ol></li>
<li><p><em><strong><u>Interface / InterestFeature:</u></strong></em>
Each account that allows you to transfer money should have the following
features:</p>
<ol type="a">
<li><p>Fields</p>
<ol type="i">
<li><p>double <strong>interestPercent</strong>: percent of
interest</p></li>
<li><p>int <strong>timePass</strong>: how much time has passed</p></li>
</ol></li>
<li><p>Non Abstract Methods (will all be the same, implementation
details included):</p>
<ol type="i">
<li></li>
</ol></li>
<li><p>Abstract Methods (will vary, not have implementation
details):</p>
<ol type="i">
<li><p>double <strong>interestAmount</strong>(): calculate the amount of
interest</p></li>
</ol></li>
<li><p>Relationship with others</p>
<ol type="i">
<li><p><strong>Realization:</strong> derived class</p></li>
</ol></li>
</ol></li>
<li><p><em><strong><u>Derived Classes:</u></strong></em> Program will
have the following accounts</p>
<ol type="a">
<li><p><em><strong><u>CheckingAccount</u></strong></em>: everyday
spending. Deposit and withdraw money</p>
<ol type="i">
<li><p>Fields</p>
<ol type="1">
<li><p>const int <strong>MAX_WITHDRAWLS</strong> = 5</p></li>
<li><p>int <strong>numWithdrawls</strong></p></li>
</ol></li>
<li><p>Methods</p>
<ol type="1">
<li><p>getter functions</p></li>
<li><p>setter functions</p></li>
<li><p>bool <strong>atMaxWithdrawl()</strong>: outputs if at max or
not</p>
<ol type="a">
<li><p>true = at max</p></li>
<li><p>false = not at max, can keep withdrawing</p></li>
</ol></li>
</ol></li>
<li><p>Relationship with others</p>
<ol type="1">
<li><p><strong>Inheritance:</strong> BankAccount</p></li>
<li><p><strong>Aggregation:</strong> BankingSystem</p></li>
</ol></li>
</ol></li>
<li><p><em><strong><u>SavingAccount</u></strong></em>: store money, earn
interest. If user has low activity they get a benefit</p>
<ol type="i">
<li><p>Fields</p>
<ol type="1">
<li><p>const <strong>MAX_LOW_ACTIVITY</strong> = 10</p>
<ol type="a">
<li><p>the max amount of transactions a user can do in order to get the
benefit of low activity</p></li>
</ol></li>
<li><p>int <strong>activity</strong>: keeps track of how many
transactions done</p></li>
<li><p>boolean <strong>lowActivity</strong>: if user qualifies for low
activity benefits</p></li>
</ol></li>
<li><p>Methods</p>
<ol type="1">
<li><p>getter functions</p></li>
<li><p>setter functions</p></li>
<li><p>boolean <strong>qualifyForLowActivity()</strong>: calculates if
user qualifies for low activity benefits</p>
<ol type="a">
<li><p>true = qualifies</p></li>
<li><p>false = does not qualify</p></li>
</ol></li>
<li><p>double <strong>lowActivityBenefit()</strong>: calculates extra
money low activity give user</p></li>
</ol></li>
<li><p>Relationship with others</p>
<ol type="1">
<li><p><strong>Inheritance:</strong> BankAccount</p></li>
<li><p><strong>Realization:</strong> interface class</p></li>
<li><p><strong>Aggregation:</strong> BankingSystem</p></li>
</ol></li>
</ol></li>
<li><p><em><strong><u>CreditAccount:</u></strong></em> borrow money</p>
<ol type="i">
<li><p>Fields</p>
<ol type="1">
<li><p>const int <strong>MAX_LIMIT</strong> = 5000</p></li>
<li><p>double <strong>amountTaken</strong></p></li>
<li><p>boolean <strong>paidCredit</strong>: if credit is paid</p></li>
</ol></li>
<li><p>Methods</p>
<ol type="1">
<li><p>getter functions</p></li>
<li><p>setter functions</p></li>
<li><p>boolean <strong>applyPenalty()</strong>: determine if user needs
to pay a penalty fee</p>
<ol type="a">
<li><p>true = user pays a fee</p></li>
<li><p>false = user needs to pay a fee</p></li>
</ol></li>
<li><p>double <strong>calcPenalty()</strong>: calculates fee user needs
to pay</p></li>
</ol></li>
<li><p>Relationship with others</p>
<ol type="1">
<li><p><strong>Inheritance:</strong> BankAccount</p></li>
<li><p><strong>Realization:</strong> interface class</p></li>
<li><p><strong>Aggregation:</strong> BankingSystem</p></li>
</ol></li>
</ol></li>
</ol></li>
<li><p><em><strong><u>Manager Class / BankingSystem:</u></strong></em>
will be used to do the following commands on all the accounts / derived
classes:</p>
<ol type="a">
<li><p>Fields</p>
<ol type="i">
<li><p><strong>accounts</strong>: List&lt;BankAccount&gt;</p>
<ol type="1">
<li><p>stored polymorphically, vector of all bank accounts</p></li>
</ol></li>
<li><p>int <strong>numberOfAccounts</strong>:</p></li>
</ol></li>
<li><p>Methods</p>
<ol type="i">
<li><p>void <strong>addAccount(BankAccount)</strong>: add bank account
to manage. Will be data type abstract base class</p>
<ol type="1">
<li><p>will throw exception ErrorAccountNotFound if account not
found</p></li>
</ol></li>
<li><p>boolean <strong>transferMoney()</strong>: transfer money between
accounts, returns if successful</p>
<ol type="1">
<li><p>true = successful</p></li>
<li><p>false = not successful</p></li>
<li><p>will throw exception ErrorLowFunds if funcs are low</p></li>
</ol></li>
<li><p>void <strong>displayAccountInfo()</strong>: outputs account
info</p>
<ol type="1">
<li><p>account type</p></li>
<li><p>owner name</p></li>
<li><p>other info related to account</p></li>
</ol></li>
<li></li>
</ol></li>
<li><p>Relationship with others</p>
<ol type="i">
<li><p><strong>Aggregation (has-a, child can still exist):</strong>
Derived class</p></li>
<li><p><strong>Dependency:</strong> Exception class</p></li>
</ol></li>
</ol></li>
<li><p><em><strong><u>Exception Classes:</u></strong></em> The manager
will also call protocols if certain criteria are met (relationship
dependencies):</p>
<ol type="a">
<li><p><strong>ErrorAccountNotFound</strong>: if you're doing a
transaction or a</p></li>
<li><p><strong>ErrorLowFunds</strong>: not enough money to do
action</p></li>
<li><p>Relationship with others</p>
<ol type="i">
<li><p><strong>Dependency:</strong> BankingSystem</p></li>
</ol></li>
</ol></li>
</ol>
