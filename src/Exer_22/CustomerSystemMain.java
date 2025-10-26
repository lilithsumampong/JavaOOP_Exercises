package Exer_22;

// Main class to test the customer system
public class CustomerSystemMain {
    public static void main(String[] args) {
        System.out.println("=== CUSTOMER MANAGEMENT SYSTEM ===\n");
        
        // Create regular customers
        System.out.println("--- Creating Regular Customers ---");
        Customer customer1 = new Customer("John Smith", "john.smith@email.com");
        Customer customer2 = new Customer("Sarah Johnson", "sarah.j@email.com");
        
        // Create loyal customers
        System.out.println("\n--- Creating Loyal Customers ---");
        LoyalCustomer loyalCustomer1 = new LoyalCustomer("Mike Wilson", "mike.w@email.com", 15.0);
        LoyalCustomer loyalCustomer2 = new LoyalCustomer("Emily Davis", "emily.d@email.com", 10.0);
        
        // Test regular customer purchases
        System.out.println("\n--- Testing Regular Customer Purchases ---");
        customer1.addPurchase(50.00);
        customer1.addPurchase(75.50);
        customer1.addPurchase(120.25);
        
        customer2.addPurchase(25.99);
        customer2.addPurchase(45.75);
        
        // Test loyal customer purchases (with discount)
        System.out.println("\n--- Testing Loyal Customer Purchases ---");
        loyalCustomer1.addPurchase(100.00); // Should be $85.00 after 15% discount
        loyalCustomer1.addPurchase(200.00); // Should be $170.00 after 15% discount
        loyalCustomer1.addPurchase(75.00);  // Should be $63.75 after 15% discount
        
        loyalCustomer2.addPurchase(150.00); // Should be $135.00 after 10% discount
        loyalCustomer2.addPurchase(80.00);  // Should be $72.00 after 10% discount
        
        // Display customer information
        System.out.println("\n--- Customer Information ---");
        customer1.displayCustomerInfo();
        customer1.displayPurchaseHistory();
        
        customer2.displayCustomerInfo();
        customer2.displayPurchaseHistory();
        
        loyalCustomer1.displayCustomerInfo();
        loyalCustomer1.displayPurchaseHistory();
        
        loyalCustomer2.displayCustomerInfo();
        loyalCustomer2.displayPurchaseHistory();
        
        // Test loyalty points redemption
        System.out.println("\n--- Testing Loyalty Points Redemption ---");
        loyalCustomer1.redeemPoints(50); // Should redeem 50 points
        loyalCustomer1.redeemPoints(200); // Should fail - not enough points
        
        // Add bonus points and test again
        loyalCustomer1.addBonusPoints(100);
        loyalCustomer1.redeemPoints(80);
        
        // Test error handling
        System.out.println("\n--- Testing Error Handling ---");
        customer1.addPurchase(-20.00); // Invalid purchase amount
        loyalCustomer1.setDiscountRate(60.0); // Invalid discount rate
        loyalCustomer1.setDiscountRate(20.0); // Valid discount rate update
        
        // Test email validation
        customer1.setEmail("invalid-email"); // Invalid email
        customer1.setEmail("john.new@email.com"); // Valid email
        
        // Demonstrate polymorphism
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        Customer[] customers = {
            new Customer("Bob Brown", "bob.b@email.com"),
            new LoyalCustomer("Lisa Green", "lisa.g@email.com", 12.5),
            new Customer("Tom White", "tom.w@email.com"),
            new LoyalCustomer("Anna Black", "anna.b@email.com", 8.0)
        };
        
        // Add purchases to all customers
        for (Customer customer : customers) {
            customer.addPurchase(60.00);
            customer.addPurchase(45.00);
            customer.displayCustomerInfo();
            System.out.println(); // Empty line for separation
        }
        
        // Final summary
        System.out.println("=== CUSTOMER SYSTEM SUMMARY ===");
        System.out.println("Total customers created: " + (customers.length + 4));
        System.out.println("Regular customers: John Smith, Sarah Johnson, Bob Brown, Tom White");
        System.out.println("Loyal customers: Mike Wilson, Emily Davis, Lisa Green, Anna Black");
    }
}