package Exer_20;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    protected double balance; // protected so subclass can access it

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        System.out.println("Bank account created for " + accountHolderName);
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✓ Deposited: $" + amount);
            System.out.println("  New balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("✗ Deposit amount must be positive!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("✓ Withdrawn: $" + amount);
                System.out.println("  New balance: $" + String.format("%.2f", balance));
            } else {
                System.out.println("✗ Insufficient funds! Available: $" + String.format("%.2f", balance));
            }
        } else {
            System.out.println("✗ Withdrawal amount must be positive!");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Account Balance: $" + String.format("%.2f", balance));
    }

    // Transfer money to another account
    public void transfer(BankAccount recipient, double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                this.balance -= amount;
                recipient.balance += amount;
                System.out.println("✓ Transferred: $" + amount + " to " + recipient.accountHolderName);
                System.out.println("  Your new balance: $" + String.format("%.2f", balance));
            } else {
                System.out.println("✗ Insufficient funds for transfer!");
            }
        } else {
            System.out.println("✗ Transfer amount must be positive!");
        }
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Display account information
    public void displayAccountInfo() {
        System.out.println("\n=== ACCOUNT INFORMATION ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + String.format("%.2f", balance));
    }
}