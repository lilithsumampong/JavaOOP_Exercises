package Exer_21;
// Superclass: Vehicle

// Main class to test the vehicle system
public class VehicleMain {
    public static void main(String[] args) {
        System.out.println("=== VEHICLE MANAGEMENT SYSTEM ===\n");
        
        final int CURRENT_YEAR = 2024;
        
        // Create cars
        System.out.println("--- Creating Cars ---");
        Car sedan = new Car("Toyota", "Camry", 2022, 15.1, 4, "Gasoline");
        Car suv = new Car("Honda", "CR-V", 2023, 39.2, 5, "Hybrid");
        Car vintageCar = new Car("Ford", "Mustang", 1967, 9.8, 2, "Gasoline");
        
        // Create trucks
        System.out.println("--- Creating Trucks ---");
        Truck pickup = new Truck("Ford", "F-150", 2023, 2.5, 2, true);
        Truck semiTruck = new Truck("Freightliner", "Cascadia", 2021, 20.0, 5, false);
        Truck vintageTruck = new Truck("Chevrolet", "C10", 1975, 1.5, 2, false);
        
        // Display car details
        System.out.println("\n--- Displaying Car Details ---");
        sedan.displayDetails();
        suv.displayDetails();
        vintageCar.displayDetails();
        
        // Display truck details
        System.out.println("\n--- Displaying Truck Details ---");
        pickup.displayDetails();
        semiTruck.displayDetails();
        vintageTruck.displayDetails();
        
        // Test car-specific methods
        System.out.println("\n--- Testing Car-Specific Methods ---");
        sedan.honk();
        suv.honk();
        vintageCar.honk();
        
        // Test truck-specific methods
        System.out.println("\n--- Testing Truck-Specific Methods ---");
        pickup.loadCargo(2.0);
        pickup.loadCargo(3.0); // Should fail - exceeds capacity
        semiTruck.loadCargo(15.5);
        
        pickup.toggleFourWheelDrive();
        semiTruck.toggleFourWheelDrive();
        
        // Test inheritance and polymorphism
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        Vehicle[] vehicles = {
            new Car("BMW", "X5", 2024, 33.9, 5, "Diesel"),
            new Truck("Ram", "1500", 2023, 2.2, 2, true),
            new Car("Tesla", "Model 3", 2023, 19.8, 4, "Electric"),
            new Truck("International", "Lonestar", 2022, 25.0, 6, true)
        };
        
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails(); // Each vehicle uses its own displayDetails method
            System.out.println("Age: " + vehicle.getAge(CURRENT_YEAR) + " years");
            System.out.println("Vintage: " + (vehicle.isVintage(CURRENT_YEAR) ? "Yes" : "No"));
            System.out.println(); // Empty line for separation
        }
        
        // Test vintage vehicle check
        System.out.println("=== VINTAGE VEHICLE CHECK ===");
        System.out.println("1967 Ford Mustang is vintage: " + vintageCar.isVintage(CURRENT_YEAR));
        System.out.println("1975 Chevrolet C10 is vintage: " + vintageTruck.isVintage(CURRENT_YEAR));
        System.out.println("2023 Honda CR-V is vintage: " + suv.isVintage(CURRENT_YEAR));
        
        // Demonstrate accessing specific subclass methods
        System.out.println("\n=== SUBCLASS-SPECIFIC FEATURES ===");
        if (sedan instanceof Car) {
            Car carRef = (Car) sedan; // Cast to Car to access car-specific methods
            System.out.println(sedan.getMake() + " trunk size: " + carRef.getTrunkSize() + " cubic feet");
        }
        
        if (pickup instanceof Truck) {
            Truck truckRef = (Truck) pickup; // Cast to Truck to access truck-specific methods
            System.out.println(pickup.getMake() + " payload: " + truckRef.getPayloadCapacity() + " tons");
        }
        
        // Final summary
        System.out.println("\n=== VEHICLE INVENTORY SUMMARY ===");
        System.out.println("Total vehicles demonstrated: " + (vehicles.length + 3));
        System.out.println("Cars: Toyota Camry, Honda CR-V, Ford Mustang, BMW X5, Tesla Model 3");
        System.out.println("Trucks: Ford F-150, Freightliner Cascadia, Chevrolet C10, Ram 1500, International Lonestar");
    }
}