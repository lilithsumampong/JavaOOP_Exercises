package Exer_29;
import java.time.LocalDate;

public class PetSystemMain {
    public static void main(String[] args) {
        System.out.println("=== PET MANAGEMENT SYSTEM ===\n");

        // Create dogs
        System.out.println("--- Creating Dogs ---");
        Dog goldenRetriever = new Dog("Buddy", LocalDate.of(2020, 3, 15),
                "Golden", 30.5, "John Smith",
                "Golden Retriever", "Tennis Ball",
                true, "Large", true);

        Dog chihuahua = new Dog("Coco", LocalDate.of(2023, 8, 10),
                "Brown", 2.8, "Sarah Johnson",
                "Chihuahua", "Squeaky Toy",
                false, "Small", false);

        Dog germanShepherd = new Dog("Max", LocalDate.of(2018, 11, 25),
                "Black/Tan", 35.2, "Mike Wilson",
                "German Shepherd", "Frisbee",
                true, "Large", true);

        // Create birds
        System.out.println("\n--- Creating Birds ---");
        Bird africanGrey = new Bird("Einstein", LocalDate.of(2019, 6, 5),
                "Grey", 0.45, "Emily Davis",
                46.0, true, "Whistles and Words",
                "Large", true);

        Bird canary = new Bird("Sunny", LocalDate.of(2023, 2, 20),
                "Yellow", 0.02, "Robert Brown",
                22.5, true, "Melodic Songs",
                "Medium", false);

        Bird penguin = new Bird("Waddles", LocalDate.of(2021, 12, 10),
                "Black/White", 25.0, "Aquarium Zoo",
                15.0, false, "Honks",
                "Extra Large", false);

        // Display dog details
        System.out.println("\n--- Dog Details ---");
        goldenRetriever.displayPetDetails();
        System.out.println("\n" + "=".repeat(70));
        chihuahua.displayPetDetails();
        System.out.println("\n" + "=".repeat(70));
        germanShepherd.displayPetDetails();

        // Display bird details
        System.out.println("\n--- Bird Details ---");
        africanGrey.displayPetDetails();
        System.out.println("\n" + "=".repeat(70));
        canary.displayPetDetails();
        System.out.println("\n" + "=".repeat(70));
        penguin.displayPetDetails();

        // Test dog-specific methods
        System.out.println("\n=== DOG-SPECIFIC FEATURES ===");
        System.out.println("Buddy's exercise needs: " + goldenRetriever.getExerciseNeeds());
        System.out.println("Buddy needs grooming: " + goldenRetriever.needsGrooming());
        System.out.println("Coco's exercise needs: " + chihuahua.getExerciseNeeds());

        // Train Coco
        chihuahua.trainDog();

        // Test bird-specific methods
        System.out.println("\n=== BIRD-SPECIFIC FEATURES ===");
        System.out.println("Einstein's flight score: " +
                String.format("%.2f", africanGrey.calculateFlightScore()));
        System.out.println("Einstein needs special perches: " + africanGrey.needsSpecialPerches());
        System.out.println("Sunny's flight score: " +
                String.format("%.2f", canary.calculateFlightScore()));

        // Teach Einstein to talk
        africanGrey.teachToTalk("I'm a smart bird!");

        // Test sound methods
        System.out.println("\n=== PET SOUNDS ===");
        goldenRetriever.makeSound();
        chihuahua.makeSound();
        africanGrey.makeSound();
        canary.makeSound();
        penguin.makeSound();

        // Test modifications
        System.out.println("\n=== TESTING MODIFICATIONS ===");
        chihuahua.setWeight(3.2);
        africanGrey.setOwnerName("Emily Johnson");

        // Test error handling
        System.out.println("\n=== TESTING ERROR HANDLING ===");
        chihuahua.setWeight(-1.0); // Invalid weight
        chihuahua.setOwnerName(""); // Invalid owner name

        // Demonstrate polymorphism
        System.out.println("\n=== ALL PETS SUMMARY (POLYMORPHISM) ===");
        Pet[] allPets = {
                new Dog("Luna", LocalDate.of(2022, 4, 12), "White", 18.5, "Lisa Green",
                        "Samoyed", "Rope Toy", true, "Medium", true),
                new Bird("Kiwi", LocalDate.of(2022, 9, 8), "Green", 0.08, "Tom White",
                        28.0, true, "Chirps", "Small", false),
                new Dog("Rocky", LocalDate.of(2017, 7, 30), "Brindle", 28.3, "Anna Black",
                        "Boxer", "Chew Bone", true, "Large", true),
                new Bird("Polly", LocalDate.of(2015, 3, 22), "Rainbow", 0.35, "David Lee",
                        38.0, true, "Mimics", "Large", true)
        };

        // Display all pets and their specific features
        for (Pet pet : allPets) {
            pet.displayPetDetails();

            // Access subclass-specific methods
            if (pet instanceof Dog) {
                Dog dog = (Dog) pet;
                System.out.println("Dog - Exercise Needs: " + dog.getExerciseNeeds());
                System.out.println("Dog - Needs Grooming: " + dog.needsGrooming());
            } else if (pet instanceof Bird) {
                Bird bird = (Bird) pet;
                System.out.println("Bird - Flight Score: " +
                        String.format("%.2f", bird.calculateFlightScore()));
                System.out.println("Bird - Special Perches: " + bird.needsSpecialPerches());
            }

            // Make each pet sound
            pet.makeSound();
            System.out.println("\n" + "=".repeat(70));
        }

        // Final statistics
        System.out.println("=== PET SYSTEM STATISTICS ===");
        System.out.println(
                "Dogs: Buddy (Golden Retriever), Coco (Chihuahua), Max (German Shepherd), Luna (Samoyed), Rocky (Boxer)");
        System.out.println(
                "Birds: Einstein (African Grey), Sunny (Canary), Waddles (Penguin), Kiwi (Parakeet), Polly (Macaw)");
        System.out.println(
                "Features: Age calculation, Human age conversion, Food requirements, Species-specific behaviors");
    }
}