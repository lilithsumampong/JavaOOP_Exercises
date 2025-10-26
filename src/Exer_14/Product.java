package Exer_14;
class Product {
    private String name, prodID, category;
    private int quantity;
    private double price;

    Product(String name, String prodID, String category, int quantity, double price) {
        this.name = name;
        this.prodID = prodID;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProdId() {
        return prodID;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void displayProduct() {
        System.out.println("\nCategory: " + category);
        System.out.println("Name: " + name);
        System.out.println("Product Id: " + prodID);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price for each: " + price);
    }
}