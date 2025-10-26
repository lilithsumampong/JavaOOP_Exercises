package Exer_20;

class SavingsAccount extends BankAccount {
    private double interestRate; // Annual interest rate as percentage

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double interestRate) {
        super(accountNumber, accountHolderName, initialBalance); // Call parent constructor
        this.interestRate = interestRate;
        System.out.println("Savings account created with " + interestRate + "% interest rate");
    }

    // Apply interest to the balance
    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("✓ Interest applied: $" + String.format("%.2f", interest) +
                " at " + interestRate + "% rate");
        System.out.println("  New balance: $" + String.format("%.2f", balance));
    }

    // Override withdraw to potentially add restrictions
    @Override
    public void withdraw(double amount) {
        // Savings account might have minimum balance requirement
        double minimumBalance = 50.0;
        if (amount > 0) {
            if (amount <= balance) {
                if ((balance - amount) >= minimumBalance) {
                    balance -= amount;
                    System.out.println("✓ Withdrawn from Savings: $" + amount);
                    System.out.println("  New balance: $" + String.format("%.2f", balance));
                } else {
                    System.out.println("✗ Cannot withdraw! Minimum balance of $" +
                            minimumBalance + " must be maintained.");
                }
            } else {
                System.out.println("✗ Insufficient funds! Available: $" + String.format("%.2f", balance));
            }
        } else {
            System.out.println("✗ Withdrawal amount must be positive!");
        }
    }

    // Get interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Set interest rate
    public void setInterestRate(double interestRate) {
        if (interestRate >= 0) {
            this.interestRate = interestRate;
            System.out.println("Interest rate updated to: " + interestRate + "%");
        } else {
            System.out.println("✗ Interest rate cannot be negative!");
        }
    }

    // Override display to show savings-specific info
    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo(); // Call parent's display method
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Projected interest: $" +
                String.format("%.2f", balance * (interestRate / 100)));
    }
}
