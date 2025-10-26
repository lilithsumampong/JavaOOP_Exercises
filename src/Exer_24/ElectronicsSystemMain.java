package Exer_24;

// Main class to test the electronics system
public class ElectronicsSystemMain {
    public static void main(String[] args) {
        System.out.println("=== ELECTRONICS PRODUCT MANAGEMENT SYSTEM ===\n");

        // Create general electronics products
        System.out.println("--- Creating General Electronics Products ---");
        ElectronicsProduct laptop = new ElectronicsProduct("ELEC001", "Gaming Laptop", 1200.00);
        ElectronicsProduct smartphone = new ElectronicsProduct("ELEC002", "Smartphone X", 800.00);

        // Create washing machines
        System.out.println("\n--- Creating Washing Machines ---");
        WashingMachine washer1 = new WashingMachine("WM001", "Super Clean 2000", 650.00,
                24, "8kg", "A+++");
        WashingMachine washer2 = new WashingMachine("WM002", "Eco Wash Pro", 450.00,
                12, "6kg", "A+");
        WashingMachine washer3 = new WashingMachine("WM003", "Compact Washer", 350.00,
                18, "4kg", "A");

        // Test discount application on general products
        System.out.println("\n--- Testing Discounts on General Products ---");
        laptop.applyDiscount(15.0);
        smartphone.applyDiscount(10.0);

        // Display general product information
        System.out.println("\n--- General Product Information ---");
        laptop.displayProductInfo();
        smartphone.displayProductInfo();

        // Test discount application on washing machines
        System.out.println("\n--- Testing Discounts on Washing Machines ---");
        washer1.applyDiscount(20.0);
        washer2.applyDiscount(5.0);
        washer3.applyDiscount(0.0); // No discount

        // Display washing machine information
        System.out.println("\n--- Washing Machine Information ---");
        washer1.displayProductInfo();
        washer2.displayProductInfo();
        washer3.displayProductInfo();

        // Test warranty extension
        System.out.println("\n--- Testing Warranty Extension ---");
        washer1.extendWarranty(12);
        washer2.extendWarranty(6);
        washer3.extendWarranty(-5); // Test invalid input

        // Display updated warranty information
        System.out.println("\n--- Updated Warranty Information ---");
        washer1.displayProductInfo();
        washer2.displayProductInfo();

        // Test washing machine features
        System.out.println("\n--- Washing Machine Features ---");
        washer1.displayFeatures();
        washer2.displayFeatures();
        washer3.displayFeatures();

        // Test warranty status
        System.out.println("\n=== WARRANTY STATUS CHECK ===");
        System.out.println("Super Clean 2000 - Remaining warranty: " +
                washer1.getRemainingWarranty(6, 2023) + " months");
        System.out.println("Eco Wash Pro - Warranty expired: " +
                washer2.isWarrantyExpired(6, 2020));

        // Test error handling
        System.out.println("\n=== TESTING ERROR HANDLING ===");
        laptop.applyDiscount(60.0); // Invalid discount
        washer1.setPrice(-100.0); // Invalid price
        washer1.setPrice(700.0); // Valid price update

        // Test energy savings calculation
        System.out.println("\n=== ENERGY SAVINGS CALCULATION ===");
        System.out.println("Super Clean 2000 annual savings: $" +
                String.format("%.2f", washer1.calculateAnnualEnergySavings()));
        System.out.println("Eco Wash Pro annual savings: $" +
                String.format("%.2f", washer2.calculateAnnualEnergySavings()));
        System.out.println("Compact Washer annual savings: $" +
                String.format("%.2f", washer3.calculateAnnualEnergySavings()));

        // Demonstrate polymorphism
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        ElectronicsProduct[] products = {
                new ElectronicsProduct("ELEC003", "Bluetooth Speaker", 120.00),
                new WashingMachine("WM004", "Ultra Clean", 550.00, 36, "7kg", "A++"),
                new ElectronicsProduct("ELEC004", "Tablet", 300.00),
                new WashingMachine("WM005", "Mega Wash", 850.00, 24, "10kg", "A+++")
        };

        // Apply discounts and display all products
        for (ElectronicsProduct product : products) {
            product.applyDiscount(10.0); // Apply 10% discount to all
            product.displayProductInfo();

            // Check if it's a washing machine to access washing machine specific methods
            if (product instanceof WashingMachine) {
                WashingMachine washer = (WashingMachine) product;
                washer.displayFeatures();
            }
            System.out.println("\n" + "=".repeat(50));
        }

        // Final summary
        System.out.println("=== ELECTRONICS INVENTORY SUMMARY ===");
        System.out.println("General Electronics: Gaming Laptop, Smartphone X, Bluetooth Speaker, Tablet");
        System.out.println("Washing Machines: Super Clean 2000, Eco Wash Pro, Compact Washer, " +
                "Ultra Clean, Mega Wash");
        System.out.println("Energy Ratings: A+++, A++, A+, A");
        System.out.println("All products support discount application and price calculation");
    }
}