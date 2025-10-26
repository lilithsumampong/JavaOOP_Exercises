package Exer_24;

class ElectronicsProduct {
    private String productId;
    private String name;
    protected double price; // protected so subclass can access it
    private double discount;

    // Constructor
    public ElectronicsProduct(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.discount = 0.0; // Default no discount
        System.out.println("Electronics product created: " + name + " (ID: " + productId + ")");
    }

    // Apply discount as percentage
    public void applyDiscount(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 50) {
            this.discount = discountPercentage;
            System.out.println("✓ " + discountPercentage + "% discount applied to " + name);
            System.out.println("  Original price: $" + String.format("%.2f", price));
            System.out.println("  Discount amount: $" + String.format("%.2f", calculateDiscountAmount()));
            System.out.println("  Final price: $" + String.format("%.2f", calculateFinalPrice()));
        } else {
            System.out.println("✗ Discount must be between 0% and 50%!");
        }
    }

    // Calculate discount amount
    public double calculateDiscountAmount() {
        return price * (discount / 100);
    }

    // Calculate final price after discount
    public double calculateFinalPrice() {
        return price - calculateDiscountAmount();
    }

    // Remove discount
    public void removeDiscount() {
        System.out.println("Discount removed from " + name);
        this.discount = 0.0;
    }

    // Display product information
    public void displayProductInfo() {
        System.out.println("\n=== PRODUCT INFORMATION ===");
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Original Price: $" + String.format("%.2f", price));
        System.out.println("Discount: " + discount + "%");
        System.out.println("Discount Amount: $" + String.format("%.2f", calculateDiscountAmount()));
        System.out.println("Final Price: $" + String.format("%.2f", calculateFinalPrice()));
    }

    // Check if product is on sale
    public boolean isOnSale() {
        return discount > 0;
    }

    // Get savings amount
    public double getSavings() {
        return calculateDiscountAmount();
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    // Setters with validation
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
            System.out.println("Price updated to: $" + String.format("%.2f", price) + " for " + name);
        } else {
            System.out.println("✗ Price must be positive!");
        }
    }
}
