package Exer_27;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class CustomerOrder {
    private String orderId;
    private String customerName;
    private LocalDate orderDate;
    private List<String> orderItems;
    private double totalAmount;
    private String status;

    // Constructor
    public CustomerOrder(String orderId, String customerName, LocalDate orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.orderItems = new ArrayList<>();
        this.totalAmount = 0.0;
        this.status = "Pending";
        System.out.println("Order created: " + orderId + " for " + customerName);
    }

    // Add item to order
    public void addItem(String itemName, double price) {
        orderItems.add(itemName);
        totalAmount += price;
        System.out.println("✓ Added: " + itemName + " - $" + String.format("%.2f", price));
    }

    // Calculate days since order was placed
    public long getDaysSinceOrder() {
        return ChronoUnit.DAYS.between(orderDate, LocalDate.now());
    }

    // Check if order is recent (within 7 days)
    public boolean isRecentOrder() {
        return getDaysSinceOrder() <= 7;
    }

    // Update order status
    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Order " + orderId + " status updated to: " + newStatus);
    }

    // Display order details
    public void displayOrderDetails() {
        System.out.println("\n=== ORDER DETAILS ===");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + status);
        System.out.println("Total Amount: $" + String.format("%.2f", totalAmount));
        System.out.println("Items: " + (orderItems.isEmpty() ? "None" : String.join(", ", orderItems)));
        System.out.println("Days Since Order: " + getDaysSinceOrder());
        System.out.println("Recent Order: " + (isRecentOrder() ? "Yes" : "No"));
    }

    // Calculate estimated processing time (base implementation)
    public int calculateProcessingTime() {
        // Base processing time: 2 business days
        return 2;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<String> getOrderItems() {
        return new ArrayList<>(orderItems);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }
}
