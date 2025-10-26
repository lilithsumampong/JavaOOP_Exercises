package Exer_29;

import java.time.LocalDate;

class Bird extends Pet {
    private double wingspan; // in cm
    private boolean canFly;
    private String songType;
    private String cageSize;
    private boolean canTalk;

    // Constructor
    public Bird(String name, LocalDate birthDate, String color, double weight,
            String ownerName, double wingspan, boolean canFly,
            String songType, String cageSize, boolean canTalk) {
        super(name, "Bird", birthDate, color, weight, ownerName);
        this.wingspan = wingspan;
        this.canFly = canFly;
        this.songType = songType;
        this.cageSize = cageSize;
        this.canTalk = canTalk;
        System.out.println("Bird profile created: " + (canFly ? "Flying" : "Flightless") + " bird");
    }

    // Override human age calculation for birds
    @Override
    public double calculateHumanAge() {
        int birdAge = getAgeInYears();
        double humanAge;

        // Bird-to-human age conversion varies by species
        if (birdAge <= 1) {
            humanAge = birdAge * 12; // Fast maturation in first year
        } else if (getSpecies().toLowerCase().contains("parrot")) {
            humanAge = 12 + (birdAge - 1) * 3; // Parrots age slower
        } else {
            humanAge = 12 + (birdAge - 1) * 6; // Other birds age faster
        }
        return humanAge;
    }

    // Override daily food calculation for birds
    @Override
    public double calculateDailyFood() {
        // Birds typically eat 10-15% of their body weight
        double baseFood = getWeight() * 0.12;

        // Adjust based on activity level
        if (canFly) {
            baseFood *= 1.3; // Flying birds need more energy
        }

        if (isBaby()) {
            baseFood *= 1.5; // Baby birds need more food
        }

        return baseFood;
    }

    // Override displayPetDetails to show bird specific information
    @Override
    public void displayPetDetails() {
        System.out.println("\n=== BIRD PROFILE ===");
        super.displayPetDetails();
        System.out.println("Wingspan: " + String.format("%.1f", wingspan) + " cm");
        System.out.println("Can Fly: " + (canFly ? "Yes" : "No"));
        System.out.println("Song Type: " + songType);
        System.out.println("Cage Size: " + cageSize);
        System.out.println("Can Talk: " + (canTalk ? "Yes" : "No"));
        System.out.println("Singing Sound: ");
        makeSound();

        // Bird-specific insights
        if (canFly && cageSize.equalsIgnoreCase("small")) {
            System.out.println("⚠️  Consider larger cage for flying exercise.");
        }
        if (canTalk) {
            System.out.println("🗣️  Talking bird! Great for interaction and training.");
        }
    }

    // Override makeSound for birds
    @Override
    public void makeSound() {
        if (canTalk) {
            System.out.println(getName() + " says: Hello! Pretty bird!");
        } else {
            System.out.println(getName() + " sings: " + songType + "!");
        }
    }

    // Bird-specific method: calculate flight capability score
    public double calculateFlightScore() {
        if (!canFly)
            return 0;

        double score = wingspan / getWeight(); // Higher ratio = better flight
        if (getAgeInYears() > 5) {
            score *= 0.8; // Older birds may have reduced flight capability
        }
        return score;
    }

    // Bird-specific method: check if needs special perches
    public boolean needsSpecialPerches() {
        return getSpecies().toLowerCase().contains("parrot") ||
                wingspan > 30; // Larger birds need special perches
    }

    // Teach bird to talk
    public void teachToTalk(String newPhrase) {
        if (canTalk) {
            System.out.println("✓ " + getName() + " learned: \"" + newPhrase + "\"");
        } else {
            System.out.println(getName() + " cannot learn to talk - not a talking species.");
        }
    }

    // Getters
    public double getWingspan() {
        return wingspan;
    }

    public boolean canFly() {
        return canFly;
    }

    public String getSongType() {
        return songType;
    }

    public String getCageSize() {
        return cageSize;
    }

    public boolean canTalk() {
        return canTalk;
    }
}
