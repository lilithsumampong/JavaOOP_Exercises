package Exer_18;

public class RestaurantMain {
    public static void main(String[] args) {
        System.out.println("=== RESTAURANT MANAGEMENT SYSTEM ===\n");
        
        Restaurant myRestaurant = new Restaurant();
        
        System.out.println("--- Adding Menu Items ---");
        myRestaurant.addMenuItem("Cheeseburger", 8.99, 4.5);
        myRestaurant.addMenuItem("Caesar Salad", 7.50, 4.2);
        myRestaurant.addMenuItem("Spaghetti Carbonara", 12.99, 4.8);
        myRestaurant.addMenuItem("Chocolate Cake", 6.00, 4.9);
        myRestaurant.addMenuItem("French Fries", 3.50, 4.0);
        
        myRestaurant.displayMenu();
        
        System.out.println("\n--- Removing an Item ---");
        myRestaurant.removeMenuItem("French Fries");
        
        myRestaurant.displayMenu();
        
        System.out.println("\n--- Updating Ratings ---");
        myRestaurant.updateRating("Cheeseburger", 4.7);
        myRestaurant.updateRating("Caesar Salad", 4.5);
        
        myRestaurant.displayMenu();
        
        System.out.println("\n--- Searching for Items ---");
        myRestaurant.findItem("Cheeseburger");
        myRestaurant.findItem("Pizza"); 
        
        // Show highly rated items
        myRestaurant.getHighlyRatedItems(4.5);
    }
}