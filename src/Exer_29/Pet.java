package Exer_29;

import java.time.LocalDate;
import java.time.Period;

class Pet {
    private String name;
    private String species;
    private LocalDate birthDate;
    private String color;
    private double weight; // in kg
    private String ownerName;

    // Constructor
    public Pet(String name, String species, LocalDate birthDate, String color, double weight, String ownerName) {
        this.name = name;
        this.species = species;
        this.birthDate = birthDate;
        this.color = color;
        this.weight = weight;
        this.ownerName = ownerName;
        System.out.println("Pet registered: " + name + " the " + species);
    }

    // Calculate age in years
    public int getAgeInYears() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Calculate age in months
    public int getAgeInMonths() {
        return Period.between(birthDate, LocalDate.now()).getMonths();
    }

    // Calculate age in human years (base implementation)
    public double calculateHumanAge() {
        // Base conversion - varies by species
        return getAgeInYears() * 7; // General approximation
    }

    // Check if pet is a baby (less than 1 year)
    public boolean isBaby() {
        return getAgeInYears() < 1;
    }

    // Check if pet is senior (varies by species)
    public boolean isSenior() {
        return getAgeInYears() > 10; // General approximation
    }

    // Calculate daily food requirement (base implementation)
    public double calculateDailyFood() {
        // General formula: 2% of body weight
        return weight * 0.02;
    }

    // Display pet details
    public void displayPetDetails() {
        System.out.println("\n=== PET DETAILS ===");
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Age: " + getAgeInYears() + " years, " + getAgeInMonths() + " months");
        System.out.println("Human Age Equivalent: " + String.format("%.1f", calculateHumanAge()) + " years");
        System.out.println("Color: " + color);
        System.out.println("Weight: " + String.format("%.1f", weight) + " kg");
        System.out.println("Owner: " + ownerName);
        System.out.println("Life Stage: " + getLifeStage());
        System.out.println("Daily Food: " + String.format("%.2f", calculateDailyFood()) + " kg");
    }

    // Get life stage description
    public String getLifeStage() {
        if (isBaby()) {
            return "Baby";
        } else if (isSenior()) {
            return "Senior";
        } else {
            return "Adult";
        }
    }

    // Make sound (to be overridden by subclasses)
    public void makeSound() {
        System.out.println(name + " makes a generic pet sound");
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public String getOwnerName() {
        return ownerName;
    }

    // Setters with validation
    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
            System.out.println("✓ " + name + "'s weight updated to: " + weight + " kg");
        } else {
            System.out.println("✗ Weight must be positive!");
        }
    }

    public void setOwnerName(String ownerName) {
        if (ownerName != null && !ownerName.trim().isEmpty()) {
            this.ownerName = ownerName;
            System.out.println("✓ Owner updated to: " + ownerName);
        } else {
            System.out.println("✗ Owner name cannot be empty!");
        }
    }
}
