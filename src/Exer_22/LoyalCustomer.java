package Exer_22;

class LoyalCustomer extends Customer {
    private double discountRate; // as percentage (e.g., 10.0 for 10%)
    private int loyaltyPoints;

    // Constructor
    public LoyalCustomer(String name, String email, double discountRate) {
        super(name, email); // Call parent constructor
        this.discountRate = discountRate;
        this.loyaltyPoints = 0;
        System.out.println("Loyal customer created with " + discountRate + "% discount");
    }

    // Override addPurchase to include loyalty points
    @Override
    public void addPurchase(double amount) {
        if (amount > 0) {
            // Calculate discounted amount
            double discountedAmount = applyDiscount(amount);
            double discountAmount = amount - discountedAmount;

            // Add the discounted purchase to history
            super.addPurchase(discountedAmount);

            // Add loyalty points (1 point per $10 spent)
            int pointsEarned = (int) (discountedAmount / 10);
            loyaltyPoints += pointsEarned;

            System.out.println("  Discount applied: -$" + String.format("%.2f", discountAmount));
            System.out.println("  Loyalty points earned: +" + pointsEarned);
            System.out.println("  Total loyalty points: " + loyaltyPoints);
        } else {
            System.out.println("✗ Purchase amount must be positive!");
        }
    }

    // Apply discount to a purchase amount
    public double applyDiscount(double amount) {
        double discountAmount = amount * (discountRate / 100);
        return amount - discountAmount;
    }

    // Redeem loyalty points for discount
    public void redeemPoints(int pointsToRedeem) {
        if (pointsToRedeem > 0 && pointsToRedeem <= loyaltyPoints) {
            double discountValue = pointsToRedeem * 0.1; // Each point worth $0.10
            loyaltyPoints -= pointsToRedeem;
            System.out.println("✓ Redeemed " + pointsToRedeem + " points for $" +
                    String.format("%.2f", discountValue) + " discount");
            System.out.println("  Remaining points: " + loyaltyPoints);
        } else {
            System.out.println("✗ Cannot redeem " + pointsToRedeem + " points. Available: " + loyaltyPoints);
        }
    }

    // Get discount rate
    public double getDiscountRate() {
        return discountRate;
    }

    // Set discount rate
    public void setDiscountRate(double discountRate) {
        if (discountRate >= 0 && discountRate <= 50) {
            this.discountRate = discountRate;
            System.out.println("Discount rate updated to: " + discountRate + "%");
        } else {
            System.out.println("✗ Discount rate must be between 0% and 50%!");
        }
    }

    // Get loyalty points
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Add bonus points
    public void addBonusPoints(int bonusPoints) {
        if (bonusPoints > 0) {
            loyaltyPoints += bonusPoints;
            System.out.println("✓ Added " + bonusPoints + " bonus points to " + getName());
            System.out.println("  Total loyalty points: " + loyaltyPoints);
        }
    }

    // Override display to show loyal customer info
    @Override
    public void displayCustomerInfo() {
        System.out.println("\n=== LOYAL CUSTOMER INFORMATION ===");
        super.displayCustomerInfo(); // Call parent's display method
        System.out.println("Discount Rate: " + discountRate + "%");
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Points Value: $" + String.format("%.2f", loyaltyPoints * 0.1));

        // Show savings calculation
        double totalWithoutDiscount = 0;
        for (double purchase : getPurchaseHistory()) {
            // Reverse calculate original amount before discount
            totalWithoutDiscount += purchase / (1 - discountRate / 100);
        }
        double totalSavings = totalWithoutDiscount - calculateTotalExpenditure();
        System.out.println("Total Savings: $" + String.format("%.2f", totalSavings));
    }
}
