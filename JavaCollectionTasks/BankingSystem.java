import java.util.*;

class Account {
    String holder;
    double balance;

    Account(String holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void display() {
        System.out.println("Account Holder: " + holder + ", Balance: " + balance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Account acc = new Account("Ashu", 1000);
        acc.deposit(500);
        acc.withdraw(300);
        acc.display();
    }
}