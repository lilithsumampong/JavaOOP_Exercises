package Exer_14;
import java.util.HashMap;

public class InventoryMain {
    private HashMap<String, Product> inventory;

    InventoryMain() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        boolean keyChecker = productExists(product.getProdId(), product.getName());

        if (keyChecker) {
            System.out.println("\nThis product item already exist in inventory!");
            System.out.println("If you want to restock this item then choose the restock method!");
        } else {
            inventory.put(product.getProdId(), product);
            System.out.println("The product " + product.getName() + " successfully added!");
        }
    }

    public void removeProduct(Product product) {
        boolean keyChecker = productExists(product.getProdId(), product.getName());

        if (keyChecker) {
            inventory.remove(product.getProdId());
            System.out.println("\nProduct " + product.getName() + " successfully removed!");
        } else {
            System.out.println("\nThis product did not exist in inventory!");
        }
    }

    public boolean productExists(String prodID, String name) {

        for (Product product : inventory.values()) {
            if (product.getProdId().equals(prodID) && product.getName().equals(name))
                return true;
            else if (product.getProdId().equals(prodID))
                return true;

        }
        return false;
    }

    public void lowInventoryChecker(Product product) {
        System.out.println();
        if (product.getQuantity() <= 50) {
            System.out.println(product.getName() + " has low stock!");
            System.out.println(product.getName() + " has " + product.getQuantity() + " left!");
        } else {
            System.out.println(product.getName() + " has Moderate stock!");
            System.out.println(product.getName() + " has " + product.getQuantity() + " left!");
        }
    }

    public void displayProducts() {
        System.out.println("----------INVENTORY----------");
        if (inventory.isEmpty()) {
            System.out.println("The inventory is empty!");
            return;
        }

        for (Product product : inventory.values()) {
            product.displayProduct();
        }
    }

    public static void main(String[] args) {

        InventoryMain inventory = new InventoryMain();

        Product product1 = new Product("apple", "001", "fruits", 25, 25.00);
        Product product2 = new Product("cabbage", "002", "vegetables", 50, 15.00);
        Product product3 = new Product("chicken meat", "003", "animals", 200, 15.00);

        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        // display products
        inventory.displayProducts();

        inventory.removeProduct(product2);

        System.out.println("\nDisplaying updated Inventory:");
        inventory.displayProducts();

        // checking if it has low inventory
        inventory.lowInventoryChecker(product3);
        inventory.lowInventoryChecker(product1);
    }
}
