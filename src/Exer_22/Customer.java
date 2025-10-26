package Exer_22;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private String email;
    private List<Double> purchaseHistory;

    // Constructor
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.purchaseHistory = new ArrayList<>();
        System.out.println("New customer created: " + name);
    }

    // Add a purchase to history
    public void addPurchase(double amount) {
        if (amount > 0) {
            purchaseHistory.add(amount);
            System.out.println("✓ Purchase added: $" + String.format("%.2f", amount) + " for " + name);
        } else {
            System.out.println("✗ Purchase amount must be positive!");
        }
    }

    // Add multiple purchases at once
    public void addPurchases(List<Double> purchases) {
        for (double purchase : purchases) {
            if (purchase > 0) {
                purchaseHistory.add(purchase);
            }
        }
        System.out.println("✓ Added " + purchases.size() + " purchases for " + name);
    }

    // Calculate total expenditure
    public double calculateTotalExpenditure() {
        double total = 0;
        for (double purchase : purchaseHistory) {
            total += purchase;
        }
        return total;
    }

    // Get number of purchases
    public int getNumberOfPurchases() {
        return purchaseHistory.size();
    }

    // Get average purchase amount
    public double getAveragePurchase() {
        if (purchaseHistory.isEmpty()) {
            return 0;
        }
        return calculateTotalExpenditure() / purchaseHistory.size();
    }

    // Display purchase history
    public void displayPurchaseHistory() {
        if (purchaseHistory.isEmpty()) {
            System.out.println("No purchases yet for " + name);
            return;
        }

        System.out.println("\n=== PURCHASE HISTORY FOR " + name.toUpperCase() + " ===");
        for (int i = 0; i < purchaseHistory.size(); i++) {
            System.out.println((i + 1) + ". $" + String.format("%.2f", purchaseHistory.get(i)));
        }
        System.out.println("Total: $" + String.format("%.2f", calculateTotalExpenditure()));
        System.out.println("Average: $" + String.format("%.2f", getAveragePurchase()));
    }

    // Display customer information
    public void displayCustomerInfo() {
        System.out.println("\n=== CUSTOMER INFORMATION ===");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Total Purchases: " + getNumberOfPurchases());
        System.out.println("Total Expenditure: $" + String.format("%.2f", calculateTotalExpenditure()));
        System.out.println("Average Purchase: $" + String.format("%.2f", getAveragePurchase()));
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Double> getPurchaseHistory() {
        return new ArrayList<>(purchaseHistory); // Return copy to protect original
    }

    // Setter for email with validation
    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
            System.out.println("Email updated for " + name);
        } else {
            System.out.println("✗ Invalid email format!");
        }
    }
}