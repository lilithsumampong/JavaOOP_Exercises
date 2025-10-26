package Exer_20;

// Main class to test the bank system
public class BankSystemTest {
    public static void main(String[] args) {
        System.out.println("=== BANK ACCOUNT MANAGEMENT SYSTEM ===\n");

        // Create a regular bank account
        System.out.println("--- Creating Regular Bank Account ---");
        BankAccount regularAccount = new BankAccount("ACC001", "John Doe", 1000.00);
        regularAccount.displayAccountInfo();

        // Test regular account operations
        System.out.println("\n--- Testing Regular Account Operations ---");
        regularAccount.deposit(500.00);
        regularAccount.withdraw(200.00);
        regularAccount.checkBalance();
        regularAccount.withdraw(2000.00); // Should fail - insufficient funds

        // Create a savings account
        System.out.println("\n--- Creating Savings Account ---");
        SavingsAccount savingsAccount = new SavingsAccount("SAV001", "Jane Smith", 2000.00, 2.5);
        savingsAccount.displayAccountInfo();

        // Test savings account operations
        System.out.println("\n--- Testing Savings Account Operations ---");
        savingsAccount.deposit(1000.00);
        savingsAccount.applyInterest(); // Apply interest to current balance
        savingsAccount.checkBalance();

        // Test savings account withdrawal with minimum balance
        System.out.println("\n--- Testing Savings Withdrawal Restrictions ---");
        savingsAccount.withdraw(2950.00); // Should fail due to minimum balance
        savingsAccount.withdraw(500.00); // Should succeed

        // Display updated information
        System.out.println("\n--- Updated Account Information ---");
        savingsAccount.displayAccountInfo();

        // Test transfer between accounts
        System.out.println("\n--- Testing Transfer Between Accounts ---");
        System.out.println("Before transfer:");
        regularAccount.checkBalance();
        savingsAccount.checkBalance();

        regularAccount.transfer(savingsAccount, 300.00);

        System.out.println("\nAfter transfer:");
        regularAccount.checkBalance();
        savingsAccount.checkBalance();

        // Test error handling
        System.out.println("\n--- Testing Error Handling ---");
        regularAccount.deposit(-100.00); // Invalid deposit
        regularAccount.withdraw(-50.00); // Invalid withdrawal
        savingsAccount.setInterestRate(-5.0); // Invalid interest rate

        // Final account summaries
        System.out.println("\n=== FINAL ACCOUNT SUMMARIES ===");
        regularAccount.displayAccountInfo();
        System.out.println();
        savingsAccount.displayAccountInfo();

        // Demonstrate polymorphism
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        BankAccount[] accounts = {
                new BankAccount("ACC002", "Bob Wilson", 500.00),
                new SavingsAccount("SAV002", "Alice Brown", 1500.00, 3.0)
        };

        for (BankAccount account : accounts) {
            account.displayAccountInfo();
            System.out.println(); // Empty line for separation
        }
    }
}