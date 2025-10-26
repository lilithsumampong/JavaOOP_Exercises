package Exer_27;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class OnlineOrder extends CustomerOrder {
    private String deliveryAddress;
    private String trackingNumber;
    private String deliveryStatus;
    private LocalDate estimatedDeliveryDate;

    // Constructor
    public OnlineOrder(String orderId, String customerName, LocalDate orderDate,
            String deliveryAddress, String trackingNumber) {
        super(orderId, customerName, orderDate);
        this.deliveryAddress = deliveryAddress;
        this.trackingNumber = trackingNumber;
        this.deliveryStatus = "Order Received";
        this.estimatedDeliveryDate = calculateEstimatedDeliveryDate();
        System.out.println("Online order - Delivery to: " + deliveryAddress);
    }

    // Calculate delivery time based on address distance
    public int calculateDeliveryTime() {
        String address = deliveryAddress.toLowerCase();

        // Simple logic based on address keywords
        if (address.contains("downtown") || address.contains("city center")) {
            return 1; // 1 day for local delivery
        } else if (address.contains("suburb") || address.contains("town")) {
            return 2; // 2 days for suburban areas
        } else if (address.contains("rural") || address.contains("countryside")) {
            return 5; // 5 days for rural areas
        } else {
            return 3; // 3 days default
        }
    }

    // Calculate estimated delivery date
    private LocalDate calculateEstimatedDeliveryDate() {
        int deliveryDays = calculateDeliveryTime();
        int processingDays = calculateProcessingTime();
        return getOrderDate().plusDays(processingDays + deliveryDays);
    }

    // Update tracking status
    public void updateTrackingStatus(String newStatus) {
        this.deliveryStatus = newStatus;
        System.out.println("Tracking updated for order " + getOrderId() + ": " + newStatus);

        // Auto-update parent order status based on delivery status
        switch (newStatus.toLowerCase()) {
            case "shipped":
                updateStatus("Shipped");
                break;
            case "out for delivery":
                updateStatus("Out for Delivery");
                break;
            case "delivered":
                updateStatus("Delivered");
                break;
            case "delivery failed":
                updateStatus("Delivery Failed");
                break;
        }
    }

    // Check if order is delivered
    public boolean isDelivered() {
        return deliveryStatus.equalsIgnoreCase("delivered");
    }

    // Check if delivery is overdue
    public boolean isDeliveryOverdue() {
        return LocalDate.now().isAfter(estimatedDeliveryDate) && !isDelivered();
    }

    // Calculate days until estimated delivery
    public long getDaysUntilDelivery() {
        if (isDelivered()) {
            return 0;
        }
        return ChronoUnit.DAYS.between(LocalDate.now(), estimatedDeliveryDate);
    }

    // Override processing time for online orders
    @Override
    public int calculateProcessingTime() {
        // Online orders might have faster processing
        return 1; // 1 business day
    }

    // Override displayOrderDetails to show online order specific information
    @Override
    public void displayOrderDetails() {
        System.out.println("\n=== ONLINE ORDER DETAILS ===");
        super.displayOrderDetails();
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Delivery Status: " + deliveryStatus);
        System.out.println("Estimated Delivery Date: " + estimatedDeliveryDate);
        System.out.println("Estimated Delivery Time: " + calculateDeliveryTime() + " days");
        System.out.println("Days Until Delivery: " + getDaysUntilDelivery());
        System.out.println("Delivery Overdue: " + (isDeliveryOverdue() ? "Yes" : "No"));
        System.out.println("Delivered: " + (isDelivered() ? "Yes" : "No"));

        // Delivery insights
        if (isDeliveryOverdue()) {
            System.out.println("⚠️  Alert: Delivery is overdue! Consider contacting customer support.");
        }
        if (getDaysUntilDelivery() == 0 && !isDelivered()) {
            System.out.println("📦 Expected delivery today!");
        }
    }

    // Online order specific method: calculate shipping cost
    public double calculateShippingCost() {
        double baseCost = 5.99;
        int deliveryTime = calculateDeliveryTime();

        // Add surcharge for longer delivery times (rural areas)
        if (deliveryTime > 3) {
            return baseCost + 3.99;
        } else if (deliveryTime > 1) {
            return baseCost + 1.99;
        }
        return baseCost;
    }

    // Online order specific method: validate address
    public boolean isValidAddress() {
        return deliveryAddress != null &&
                !deliveryAddress.trim().isEmpty() &&
                deliveryAddress.length() >= 10; // Basic validation
    }

    // Simulate delivery process
    public void simulateDeliveryProcess() {
        System.out.println("\n--- DELIVERY SIMULATION FOR ORDER " + getOrderId() + " ---");
        updateTrackingStatus("Processing");
        updateTrackingStatus("Shipped");
        updateTrackingStatus("Out for Delivery");
        updateTrackingStatus("Delivered");
        System.out.println("✓ Delivery simulation completed");
    }

    // Getters
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }
}
