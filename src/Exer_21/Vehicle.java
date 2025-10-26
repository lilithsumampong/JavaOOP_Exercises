package Exer_21;

class Vehicle {
    private String make;
    private String model;
    private int year;

    // Constructor
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    // Display basic vehicle information
    public void displayDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    // Method to check if vehicle is vintage (older than 25 years)
    public boolean isVintage(int currentYear) {
        return (currentYear - year) >= 25;
    }

    // Method to get vehicle age
    public int getAge(int currentYear) {
        return currentYear - year;
    }
}

// Subclass: Car
class Car extends Vehicle {
    private double trunkSize; // in cubic feet
    private int numberOfDoors;
    private String fuelType;

    // Constructor
    public Car(String make, String model, int year, double trunkSize, int numberOfDoors, String fuelType) {
        super(make, model, year); // Call parent constructor
        this.trunkSize = trunkSize;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    // Getters for Car-specific attributes
    public double getTrunkSize() {
        return trunkSize;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    // Override displayDetails to show car-specific information
    @Override
    public void displayDetails() {
        System.out.println("\n=== CAR DETAILS ===");
        super.displayDetails(); // Call parent's display method
        System.out.println("Trunk Size: " + trunkSize + " cubic feet");
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Vehicle Type: Car");
    }

    // Car-specific method
    public void honk() {
        System.out.println("Beep beep! The " + getMake() + " " + getModel() + " is honking!");
    }
}

// Subclass: Truck
class Truck extends Vehicle {
    private double payloadCapacity; // in tons
    private int numberOfAxles;
    private boolean hasFourWheelDrive;

    // Constructor
    public Truck(String make, String model, int year, double payloadCapacity, int numberOfAxles,
            boolean hasFourWheelDrive) {
        super(make, model, year); // Call parent constructor
        this.payloadCapacity = payloadCapacity;
        this.numberOfAxles = numberOfAxles;
        this.hasFourWheelDrive = hasFourWheelDrive;
    }

    // Getters for Truck-specific attributes
    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public boolean hasFourWheelDrive() {
        return hasFourWheelDrive;
    }

    // Override displayDetails to show truck-specific information
    @Override
    public void displayDetails() {
        System.out.println("\n=== TRUCK DETAILS ===");
        super.displayDetails(); // Call parent's display method
        System.out.println("Payload Capacity: " + payloadCapacity + " tons");
        System.out.println("Number of Axles: " + numberOfAxles);
        System.out.println("4-Wheel Drive: " + (hasFourWheelDrive ? "Yes" : "No"));
        System.out.println("Vehicle Type: Truck");
    }

    // Truck-specific method
    public void loadCargo(double weight) {
        if (weight <= payloadCapacity) {
            System.out.println("✓ Loaded " + weight + " tons of cargo into the " + getMake() + " " + getModel());
        } else {
            System.out.println("✗ Cannot load " + weight + " tons! Maximum capacity is " + payloadCapacity + " tons.");
        }
    }

    // Another truck-specific method
    public void toggleFourWheelDrive() {
        hasFourWheelDrive = !hasFourWheelDrive;
        System.out.println("4-Wheel Drive " + (hasFourWheelDrive ? "engaged" : "disengaged") +
                " on " + getMake() + " " + getModel());
    }
}