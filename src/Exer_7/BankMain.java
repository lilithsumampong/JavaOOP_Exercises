package Exer_7;

import java.util.ArrayList;

public class BankMain {

    private static ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void displayAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void deposit(Account account, double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    public void withdraw(Account account, double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public static void main(String[] args) {

        Account account1 = new Account("Connie Manguiran", "Programmer", 1000);
        Account account2 = new Account("Carl Manguiran", "Scientist", 2000);

        BankMain bank = new BankMain();

        // displaying initial accounts
        System.out.println("Initial Accounts:");
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.displayAccounts();

        System.out.println("\nAfter Transactions:");
        // deposit
        bank.deposit(account1, 500);
        // withdraw
        bank.withdraw(account2, 300);
        bank.displayAccounts();

        

    }
}
