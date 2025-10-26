package Exer_25;

// Base class Building
class Building {
    private String address;
    private int numberOfFloors;
    private double totalArea; // in square meters

    // Constructor
    public Building(String address, int numberOfFloors, double totalArea) {
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.totalArea = totalArea;
    }

    // Getters and Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    // Method to display building information
    public void displayInfo() {
        System.out.println("Address: " + address);
        System.out.println("Number of Floors: " + numberOfFloors);
        System.out.println("Total Area: " + totalArea + " sqm");
    }
}

// Subclass for Residential Building
class ResidentialBuilding extends Building {
    private int numberOfApartments;
    private double rentPerApartment;

    // Constructor
    public ResidentialBuilding(String address, int numberOfFloors, double totalArea,
            int numberOfApartments, double rentPerApartment) {
        super(address, numberOfFloors, totalArea);
        this.numberOfApartments = numberOfApartments;
        this.rentPerApartment = rentPerApartment;
    }

    // Getters and Setters
    public int getNumberOfApartments() {
        return numberOfApartments;
    }

    public void setNumberOfApartments(int numberOfApartments) {
        this.numberOfApartments = numberOfApartments;
    }

    public double getRentPerApartment() {
        return rentPerApartment;
    }

    public void setRentPerApartment(double rentPerApartment) {
        this.rentPerApartment = rentPerApartment;
    }

    // Method to calculate total rent
    public double calculateTotalRent() {
        return numberOfApartments * rentPerApartment;
    }

    // Override displayInfo to include residential-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Apartments: " + numberOfApartments);
        System.out.println("Rent per Apartment: $" + rentPerApartment);
        System.out.println("Total Monthly Rent: $" + calculateTotalRent());
    }
}

// Subclass for Commercial Building
class CommercialBuilding extends Building {
    private int numberOfOffices;
    private double rentPerOffice;
    private boolean hasParking;

    // Constructor
    public CommercialBuilding(String address, int numberOfFloors, double totalArea,
            int numberOfOffices, double rentPerOffice, boolean hasParking) {
        super(address, numberOfFloors, totalArea);
        this.numberOfOffices = numberOfOffices;
        this.rentPerOffice = rentPerOffice;
        this.hasParking = hasParking;
    }

    // Getters and Setters
    public int getNumberOfOffices() {
        return numberOfOffices;
    }

    public void setNumberOfOffices(int numberOfOffices) {
        this.numberOfOffices = numberOfOffices;
    }

    public double getRentPerOffice() {
        return rentPerOffice;
    }

    public void setRentPerOffice(double rentPerOffice) {
        this.rentPerOffice = rentPerOffice;
    }

    public boolean hasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    // Method to calculate total rent
    public double calculateTotalRent() {
        double totalRent = numberOfOffices * rentPerOffice;
        // Add 10% premium if building has parking
        if (hasParking) {
            totalRent *= 1.10;
        }
        return totalRent;
    }

    // Override displayInfo to include commercial-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Offices: " + numberOfOffices);
        System.out.println("Rent per Office: $" + rentPerOffice);
        System.out.println("Has Parking: " + (hasParking ? "Yes" : "No"));
        System.out.println("Total Monthly Rent: $" + calculateTotalRent());
    }
}

// Main class to test the program
public class BuildingManagementMain {
    public static void main(String[] args) {
        System.out.println("=== Building Management System ===\n");

        // Create a residential building
        ResidentialBuilding residential = new ResidentialBuilding(
                "123 Main Street", 5, 2000.0, 20, 1200.0);

        // Create a commercial building
        CommercialBuilding commercial = new CommercialBuilding(
                "456 Business Ave", 8, 3500.0, 15, 2500.0, true);

        // Display information for both buildings
        System.out.println("RESIDENTIAL BUILDING:");
        System.out.println("--------------------");
        residential.displayInfo();

        System.out.println("\nCOMMERCIAL BUILDING:");
        System.out.println("-------------------");
        commercial.displayInfo();

        // Demonstrate individual rent calculations
        System.out.println("\n=== Rent Calculations ===");
        System.out.println("Residential Building Total Rent: $" + residential.calculateTotalRent());
        System.out.println("Commercial Building Total Rent: $" + commercial.calculateTotalRent());

        // Show polymorphism in action
        System.out.println("\n=== Polymorphism Example ===");
        Building[] buildings = { residential, commercial };

        for (Building building : buildings) {
            System.out.println("\nBuilding at: " + building.getAddress());
            if (building instanceof ResidentialBuilding) {
                System.out.println("Type: Residential Building");
                System.out.println("Total Rent: $" + ((ResidentialBuilding) building).calculateTotalRent());
            } else if (building instanceof CommercialBuilding) {
                System.out.println("Type: Commercial Building");
                System.out.println("Total Rent: $" + ((CommercialBuilding) building).calculateTotalRent());
            }
        }
    }
}