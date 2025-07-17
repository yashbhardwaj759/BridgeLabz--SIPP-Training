import java.util.Scanner;

/**
 * Demonstrates association: Bank and Customer have a relationship via accounts.
 * Integrates cab service-like billing (guideline #7: private fields).
 */
public class BankAccountHolders {
    static class Bank {
        private String name;
        private Account[] accounts;
        private int accountCount;
        private static final int MAX_ACCOUNTS = 100;

        public Bank(String name) {
            this.name = name;
            this.accounts = new Account[MAX_ACCOUNTS];
            this.accountCount = 0;
        }

        public void openAccount(Customer customer, double initialBalance) {
            if (accountCount >= MAX_ACCOUNTS) {
                throw new IllegalStateException("Cannot open more accounts");
            }
            accounts[accountCount++] = new Account(customer, initialBalance, this);
        }

        public String getBankDetails() {
            return "Bank: " + name;
        }
    }

    static class Customer {
        private String customerId;
        private String name;
        private Account[] accounts;
        private int accountCount;
        private static final int MAX_ACCOUNTS = 10;

        public Customer(String customerId, String name) {
            this.customerId = customerId;
            this.name = name;
            this.accounts = new Account[MAX_ACCOUNTS];
            this.accountCount = 0;
        }

        public void addAccount(Account account) {
            if (accountCount >= MAX_ACCOUNTS) {
                throw new IllegalStateException("Customer cannot have more accounts");
            }
            accounts[accountCount++] = account;
        }

        public String viewBalance() {
            StringBuilder sb = new StringBuilder("Customer: " + name + "\n");
            double totalBalance = 0.0;
            for (int i = 0; i < accountCount; i++) {
                sb.append("Account ").append(i + 1).append(": $").append(accounts[i].getBalance()).append("\n");
                totalBalance += accounts[i].getBalance();
            }
            sb.append("Total Balance: $").append(totalBalance);
            return sb.toString();
        }
    }

    static class Account {
        private Customer customer;
        private double balance;
        private Bank bank;

        public Account(Customer customer, double balance, Bank bank) {
            this.customer = customer;
            this.balance = balance;
            this.bank = bank;
            customer.addAccount(this);
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter bank name: ");
        String bankName = scanner.nextLine();
        Bank bank = new Bank(bankName);

        System.out.print("Enter number of customers: ");
        int numCustomers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCustomers; i++) {
            System.out.print("Enter customer ID: ");
            String customerId = scanner.nextLine();
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();
            System.out.print("Enter initial balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();

            Customer customer = new Customer(customerId, name);
            bank.openAccount(customer, balance);
            System.out.println(customer.viewBalance());
        }

        scanner.close();
    }
}