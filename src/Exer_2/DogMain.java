package Exer_2;

// Dog class definition
class Dog {
    // Attributes (instance variables)
    private String name;
    private String breed;

    // Constructor to initialize the attributes
    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Setter method for breed
    public void setBreed(String breed) {
        this.breed = breed;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for breed
    public String getBreed() {
        return breed;
    }

    // Method to display dog information
    public void displayInfo() {
        System.out.println("Name: " + name + ", Breed: " + breed);
    }
}

// Main class to test the Dog class
public class DogMain {
    public static void main(String[] args) {
        // Create two instances of Dog class using constructor
        Dog dog1 = new Dog("Lobo", "Poodle");
        Dog dog2 = new Dog("Messi", "Bulldog");

        // Display initial values
        System.out.println("Initial Dog Information:");
        dog1.displayInfo();
        dog2.displayInfo();
        System.out.println();

        // Modify attributes using setter methods
        dog1.setName("Jobo");
        dog1.setBreed("Dalmatian");

        dog2.setName("Charlie");
        dog2.setBreed("Bulldog");

        // Display updated values
        System.out.println("Updated Dog Information:");
        dog1.displayInfo();
        dog2.displayInfo();

        // Also demonstrate using getter methods
        System.out.println("\nUsing Getter Methods:");
        System.out.println("Dog1 - Name: " + dog1.getName() + ", Breed: " + dog1.getBreed());
        System.out.println("Dog2 - Name: " + dog2.getName() + ", Breed: " + dog2.getBreed());
    }
}
