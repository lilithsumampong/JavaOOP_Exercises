package Exer_24;

class WashingMachine extends ElectronicsProduct {
    private int warrantyPeriod; // in months
    private String capacity;
    private String energyRating;

    // Constructor
    public WashingMachine(String productId, String name, double price,
            int warrantyPeriod, String capacity, String energyRating) {
        super(productId, name, price); // Call parent constructor
        this.warrantyPeriod = warrantyPeriod;
        this.capacity = capacity;
        this.energyRating = energyRating;
        System.out.println("Washing machine created with " + warrantyPeriod + " months warranty");
    }

    // Extend warranty period
    public void extendWarranty(int additionalMonths) {
        if (additionalMonths > 0) {
            warrantyPeriod += additionalMonths;
            double extensionCost = calculateWarrantyExtensionCost(additionalMonths);
            System.out.println("✓ Warranty extended by " + additionalMonths + " months");
            System.out.println("  New warranty period: " + warrantyPeriod + " months");
            System.out.println("  Extension cost: $" + String.format("%.2f", extensionCost));
        } else {
            System.out.println("✗ Additional months must be positive!");
        }
    }

    // Calculate cost for warranty extension
    public double calculateWarrantyExtensionCost(int additionalMonths) {
        // Base cost: $5 per month for warranty extension
        return additionalMonths * 5.0;
    }

    // Check if warranty is expired (assuming current month as reference)
    public boolean isWarrantyExpired(int currentMonth, int purchaseYear) {
        // Simple calculation - in real scenario you'd use actual dates
        int monthsSincePurchase = (2024 - purchaseYear) * 12 + currentMonth;
        return monthsSincePurchase > warrantyPeriod;
    }

    // Get remaining warranty months
    public int getRemainingWarranty(int currentMonth, int purchaseYear) {
        int monthsSincePurchase = (2024 - purchaseYear) * 12 + currentMonth;
        int remaining = warrantyPeriod - monthsSincePurchase;
        return Math.max(0, remaining);
    }

    // Override displayProductInfo to show washing machine specific information
    @Override
    public void displayProductInfo() {
        System.out.println("\n=== WASHING MACHINE DETAILS ===");
        super.displayProductInfo(); // Call parent's display method
        System.out.println("Warranty Period: " + warrantyPeriod + " months");
        System.out.println("Capacity: " + capacity);
        System.out.println("Energy Rating: " + energyRating);
        System.out.println("On Sale: " + (isOnSale() ? "Yes" : "No"));

        // Show warranty status
        int remainingWarranty = getRemainingWarranty(6, 2023); // Example: current month 6, purchased 2023
        System.out.println("Remaining Warranty: " + remainingWarranty + " months");
        System.out.println("Warranty Status: " + (remainingWarranty > 0 ? "Active" : "Expired"));
    }

    // Washing machine specific method - calculate energy savings
    public double calculateAnnualEnergySavings() {
        // Different energy ratings provide different savings
        switch (energyRating.toUpperCase()) {
            case "A+++":
                return 150.0;
            case "A++":
                return 120.0;
            case "A+":
                return 90.0;
            case "A":
                return 60.0;
            default:
                return 30.0;
        }
    }

    // Washing machine specific method - display features
    public void displayFeatures() {
        System.out.println("\n--- " + getName().toUpperCase() + " FEATURES ---");
        System.out.println("• Capacity: " + capacity);
        System.out.println("• Energy Rating: " + energyRating);
        System.out.println("• Warranty: " + warrantyPeriod + " months");
        System.out.println("• Annual Energy Savings: $" + String.format("%.2f", calculateAnnualEnergySavings()));
        System.out.println("• Final Price: $" + String.format("%.2f", calculateFinalPrice()));

        if (isOnSale()) {
            System.out.println("• SAVE: $" + String.format("%.2f", getSavings()) + " with current discount!");
        }
    }

    // Getters for washing machine specific attributes
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getEnergyRating() {
        return energyRating;
    }
}
