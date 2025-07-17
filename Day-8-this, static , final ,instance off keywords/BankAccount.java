public class BankAccount {
    // Static variable
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;

    // Instance variables
    private String accountHolderName;
    private final String accountNumber;
    private double balance;

    // Constructor using this
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    // Static method
    public static void getTotalAccounts() {
        System.out.println("Total Accounts in " + bankName + ": " + totalAccounts);
    }

    // Instance method with instanceof check
    public void displayDetails(Object obj) {
        if (obj instanceof BankAccount) {
            BankAccount account = (BankAccount) obj;
            System.out.println("Bank Account Details:");
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + account.accountHolderName);
            System.out.println("Account Number: " + account.accountNumber);
            System.out.println("Balance: $" + account.balance);
        } else {
            System.out.println("Invalid object: Not a BankAccount instance");
        }
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Alice Smith", "ACC001", 1000.0);
        BankAccount account2 = new BankAccount("Bob Jones", "ACC002", 2000.0);
        account1.displayDetails(account1);
        account2.displayDetails(account2);
        BankAccount.getTotalAccounts();
        // Test instanceof with non-BankAccount object
        account1.displayDetails(new String("Invalid"));
    }
}