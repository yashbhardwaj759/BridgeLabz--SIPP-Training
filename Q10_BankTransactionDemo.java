
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance = 1000;

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        } else if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful, new balance: " + balance);
        }
    }
}

public class Q10_BankTransactionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        try {
            account.withdraw(1500);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
