package Exer_27;
import java.time.LocalDate;

// Main class to test the order system
public class OrderSystemMain {
    public static void main(String[] args) {
        System.out.println("=== CUSTOMER ORDER MANAGEMENT SYSTEM ===\n");

        // Create regular customer orders
        System.out.println("--- Creating Regular Customer Orders ---");
        CustomerOrder inStoreOrder = new CustomerOrder("ORD001", "John Smith", LocalDate.of(2024, 1, 10));
        CustomerOrder phoneOrder = new CustomerOrder("ORD002", "Sarah Johnson", LocalDate.now().minusDays(3));

        // Create online orders
        System.out.println("\n--- Creating Online Orders ---");
        OnlineOrder localOrder = new OnlineOrder("ONL001", "Mike Wilson", LocalDate.now().minusDays(2),
                "123 Downtown Main St, City Center", "TRK123456");
        OnlineOrder suburbanOrder = new OnlineOrder("ONL002", "Emily Davis", LocalDate.now().minusDays(5),
                "456 Oak Suburb Avenue, Townsville", "TRK789012");
        OnlineOrder ruralOrder = new OnlineOrder("ONL003", "Robert Brown", LocalDate.now().minusDays(7),
                "789 Countryside Road, Rural Area", "TRK345678");

        // Add items to regular orders
        System.out.println("\n--- Adding Items to Regular Orders ---");
        inStoreOrder.addItem("Laptop", 999.99);
        inStoreOrder.addItem("Mouse", 25.50);
        inStoreOrder.updateStatus("Ready for Pickup");

        phoneOrder.addItem("Smartphone", 699.99);
        phoneOrder.addItem("Case", 15.99);
        phoneOrder.updateStatus("Processing");

        // Add items to online orders
        System.out.println("\n--- Adding Items to Online Orders ---");
        localOrder.addItem("Books", 45.99);
        localOrder.addItem("Notebooks", 12.50);

        suburbanOrder.addItem("Gaming Console", 399.99);
        suburbanOrder.addItem("Games", 59.99);

        ruralOrder.addItem("Furniture", 299.99);
        ruralOrder.addItem("Home Decor", 45.00);

        // Display regular order details
        System.out.println("\n--- Regular Order Details ---");
        inStoreOrder.displayOrderDetails();
        System.out.println("\n" + "=".repeat(70));
        phoneOrder.displayOrderDetails();

        // Display online order details
        System.out.println("\n--- Online Order Details ---");
        localOrder.displayOrderDetails();
        System.out.println("\n" + "=".repeat(70));
        suburbanOrder.displayOrderDetails();
        System.out.println("\n" + "=".repeat(70));
        ruralOrder.displayOrderDetails();

        // Test tracking updates
        System.out.println("\n--- Testing Tracking Updates ---");
        localOrder.updateTrackingStatus("Shipped");
        suburbanOrder.updateTrackingStatus("Out for Delivery");
        ruralOrder.updateTrackingStatus("Delivered");

        // Display updated online orders
        System.out.println("\n--- Updated Online Orders ---");
        localOrder.displayOrderDetails();
        System.out.println("\n" + "=".repeat(70));
        suburbanOrder.displayOrderDetails();

        // Test online order specific methods
        System.out.println("\n=== ONLINE ORDER SPECIFIC FEATURES ===");
        System.out.println("Local Order Shipping Cost: $" +
                String.format("%.2f", localOrder.calculateShippingCost()));
        System.out.println("Rural Order Shipping Cost: $" +
                String.format("%.2f", ruralOrder.calculateShippingCost()));
        System.out.println("Suburban Order Valid Address: " + suburbanOrder.isValidAddress());
        System.out.println("Rural Order Delivery Time: " + ruralOrder.calculateDeliveryTime() + " days");

        // Test delivery simulation
        System.out.println("\n--- Delivery Simulation ---");
        OnlineOrder testOrder = new OnlineOrder("TEST001", "Test Customer", LocalDate.now(),
                "999 Test Street, Downtown", "TRK999999");
        testOrder.addItem("Test Product", 19.99);
        testOrder.simulateDeliveryProcess();
        testOrder.displayOrderDetails();

        // Test error cases and validations
        System.out.println("\n=== TESTING VALIDATIONS ===");
        OnlineOrder invalidOrder = new OnlineOrder("INV001", "Invalid Customer", LocalDate.now(),
                "Short", "TRK111111");
        System.out.println("Invalid Address Validation: " + invalidOrder.isValidAddress());

        // Test overdue delivery
        System.out.println("\n=== DELIVERY STATUS CHECK ===");
        System.out.println("Local Order Delivered: " + localOrder.isDelivered());
        System.out.println("Rural Order Delivered: " + ruralOrder.isDelivered());
        System.out.println("Suburban Order Overdue: " + suburbanOrder.isDeliveryOverdue());

        // Demonstrate polymorphism
        System.out.println("\n=== ALL ORDERS SUMMARY (POLYMORPHISM) ===");
        CustomerOrder[] allOrders = {
                new CustomerOrder("ORD003", "Alice Green", LocalDate.now().minusDays(1)),
                new OnlineOrder("ONL004", "Bob White", LocalDate.now().minusDays(4),
                        "321 Urban Plaza, City Center", "TRK444444"),
                new CustomerOrder("ORD004", "Carol Black", LocalDate.now().minusDays(6)),
                new OnlineOrder("ONL005", "David Lee", LocalDate.now().minusDays(2),
                        "654 Mountain View, Rural County", "TRK555555")
        };

        // Add items and display all orders
        for (CustomerOrder order : allOrders) {
            order.addItem("Sample Product", 29.99);
            order.displayOrderDetails();

            // Check if it's an online order to access online-specific methods
            if (order instanceof OnlineOrder) {
                OnlineOrder onlineOrder = (OnlineOrder) order;
                System.out.println("Shipping Cost: $" +
                        String.format("%.2f", onlineOrder.calculateShippingCost()));
                System.out.println("Delivery Time: " + onlineOrder.calculateDeliveryTime() + " days");
            }
            System.out.println("\n" + "=".repeat(70));
        }

        // Final statistics
        System.out.println("=== ORDER SYSTEM STATISTICS ===");
        System.out.println("Regular Orders: ORD001, ORD002, ORD003, ORD004");
        System.out.println("Online Orders: ONL001, ONL002, ONL003, ONL004, ONL005, TEST001");
        System.out.println("Delivery Areas: Downtown, Suburban, Rural");
        System.out.println("All online orders support tracking and delivery time calculation");
    }
}