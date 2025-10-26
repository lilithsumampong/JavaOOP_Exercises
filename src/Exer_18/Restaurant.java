package Exer_18;

import java.util.ArrayList;
import java.util.List;

class Restaurant {
    private List<String> menuItems;
    private List<Double> prices;
    private List<Double> ratings;

    public Restaurant() {
        this.menuItems = new ArrayList<>();
        this.prices = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public void addMenuItem(String itemName, double price, double rating) {
        if (price < 0) {
            System.out.println("Error: Price cannot be negative!");
            return;
        }
        if (rating < 0 || rating > 5) {
            System.out.println("Error: Rating must be between 0 and 5!");
            return;
        }

        menuItems.add(itemName);
        prices.add(price);
        ratings.add(rating);
        System.out.println("Added: " + itemName + " - $" + price + " (Rating: " + rating + ")");
    }

    public void removeMenuItem(String itemName) {
        int index = menuItems.indexOf(itemName);
        if (index != -1) {
            menuItems.remove(index);
            prices.remove(index);
            ratings.remove(index);
            System.out.println("Removed: " + itemName);
        } else {
            System.out.println("Error: Item '" + itemName + "' not found in menu!");
        }
    }

    public void updateRating(String itemName, double newRating) {
        int index = menuItems.indexOf(itemName);
        if (index != -1) {
            if (newRating >= 0 && newRating <= 5) {
                ratings.set(index, newRating);
                System.out.println("Updated rating for " + itemName + " to: " + newRating);
            } else {
                System.out.println("Error: Rating must be between 0 and 5!");
            }
        } else {
            System.out.println("Error: Item '" + itemName + "' not found!");
        }
    }

    public double calculateAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        for (double rating : ratings) {
            total += rating;
        }
        return total / ratings.size();
    }

    public void displayMenu() {
        if (menuItems.isEmpty()) {
            System.out.println("The menu is currently empty.");
            return;
        }

        System.out.println("\n=== RESTAURANT MENU ===");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i) +
                    " - $" + String.format("%.2f", prices.get(i)) +
                    " (Rating: " + ratings.get(i) + ")");
        }
        System.out.println("Average Restaurant Rating: " + String.format("%.2f", calculateAverageRating()));
    }

    public void findItem(String itemName) {
        int index = menuItems.indexOf(itemName);
        if (index != -1) {
            System.out.println("Found: " + menuItems.get(index) +
                    " - $" + prices.get(index) +
                    " (Rating: " + ratings.get(index) + ")");
        } else {
            System.out.println("Item '" + itemName + "' not found in menu.");
        }
    }

    public void getHighlyRatedItems(double minRating) {
        System.out.println("\n=== ITEMS WITH RATING ABOVE " + minRating + " ===");
        boolean found = false;
        for (int i = 0; i < menuItems.size(); i++) {
            if (ratings.get(i) >= minRating) {
                System.out.println("- " + menuItems.get(i) + " (Rating: " + ratings.get(i) + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found with rating above " + minRating);
        }
    }

    public List<String> getMenuItems() {
        return new ArrayList<>(menuItems);
    }

    public List<Double> getPrices() {
        return new ArrayList<>(prices);
    }

    public List<Double> getRatings() {
        return new ArrayList<>(ratings);
    }
}
