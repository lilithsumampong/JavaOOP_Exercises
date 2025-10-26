package Exer_29;

import java.time.LocalDate;

class Dog extends Pet {
    private String breed;
    private String favoriteToy;
    private boolean isTrained;
    private String size; // Small, Medium, Large
    private boolean isGoodWithKids;

    // Constructor
    public Dog(String name, LocalDate birthDate, String color, double weight,
            String ownerName, String breed, String favoriteToy,
            boolean isTrained, String size, boolean isGoodWithKids) {
        super(name, "Dog", birthDate, color, weight, ownerName);
        this.breed = breed;
        this.favoriteToy = favoriteToy;
        this.isTrained = isTrained;
        this.size = size;
        this.isGoodWithKids = isGoodWithKids;
        System.out.println("Dog profile created: " + breed + " breed");
    }

    // Override human age calculation for dogs
    @Override
    public double calculateHumanAge() {
        int dogAge = getAgeInYears();
        double humanAge;

        // More accurate dog-to-human age conversion
        if (dogAge <= 2) {
            humanAge = dogAge * 10.5; // Faster aging in first 2 years
        } else {
            humanAge = 21 + (dogAge - 2) * 4; // Slower aging after 2 years
        }
        return humanAge;
    }

    // Override daily food calculation for dogs
    @Override
    public double calculateDailyFood() {
        double baseFood = getWeight() * 0.025; // 2.5% of body weight for dogs

        // Adjust based on size and age
        if (getAgeInYears() < 1) {
            baseFood *= 1.5; // Puppies need more food
        } else if (isSenior()) {
            baseFood *= 0.8; // Seniors need less food
        }

        if (size.equalsIgnoreCase("large")) {
            baseFood *= 1.2; // Large breeds need more food
        }

        return baseFood;
    }

    // Override displayPetDetails to show dog specific information
    @Override
    public void displayPetDetails() {
        System.out.println("\n=== DOG PROFILE ===");
        super.displayPetDetails();
        System.out.println("Breed: " + breed);
        System.out.println("Favorite Toy: " + favoriteToy);
        System.out.println("Trained: " + (isTrained ? "Yes" : "No"));
        System.out.println("Size: " + size);
        System.out.println("Good with Kids: " + (isGoodWithKids ? "Yes" : "No"));
        System.out.println("Barking Sound: ");
        makeSound();

        // Dog-specific insights
        if (isBaby()) {
            System.out.println("🐶 Puppy alert! Needs vaccination and training.");
        }
        if (isSenior()) {
            System.out.println("❤️  Senior dog - consider joint supplements and regular vet checkups.");
        }
    }

    // Override makeSound for dogs
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof! Woof!");
    }

    // Dog-specific method: calculate exercise needs
    public String getExerciseNeeds() {
        switch (size.toLowerCase()) {
            case "small":
                return "30 minutes daily";
            case "medium":
                return "1-2 hours daily";
            case "large":
                return "2+ hours daily";
            default:
                return "1 hour daily";
        }
    }

    // Dog-specific method: check if needs grooming
    public boolean needsGrooming() {
        return breed.toLowerCase().contains("poodle") ||
                breed.toLowerCase().contains("shih tzu") ||
                breed.toLowerCase().contains("terrier");
    }

    // Train the dog
    public void trainDog() {
        if (!isTrained) {
            isTrained = true;
            System.out.println("✓ " + getName() + " is now trained! Good dog!");
        } else {
            System.out.println(getName() + " is already trained.");
        }
    }

    // Getters
    public String getBreed() {
        return breed;
    }

    public String getFavoriteToy() {
        return favoriteToy;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public String getSize() {
        return size;
    }

    public boolean isGoodWithKids() {
        return isGoodWithKids;
    }
}
