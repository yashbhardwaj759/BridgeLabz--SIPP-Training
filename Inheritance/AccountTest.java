
class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println();
    }
}
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        displayDetails();
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
        System.out.println();
    }
}
class FixedDepositAccount extends BankAccount {
    private int lockInPeriod; 

    public FixedDepositAccount(String accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        displayDetails();
        System.out.println("Lock-in Period: " + lockInPeriod + " months");
        System.out.println();
    }
}
public class AccountTest {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 50000, 4.5);
        CheckingAccount checking = new CheckingAccount("CA456", 30000, 10000);
        FixedDepositAccount fd = new FixedDepositAccount("FD789", 100000, 12);

        savings.displayAccountType();
        checking.displayAccountType();
        fd.displayAccountType();
    }
}
