package Exer_17;
import java.util.List;

// Main class to test the Movie class
public class MovieMain {
    public static void main(String[] args) {
        System.out.println("=== MOVIE REVIEW SYSTEM ===\n");
        
        // Create a movie
        Movie movie1 = new Movie("The Adventure", "John Director");
        
        // Add actors
        movie1.addActor("Alice Star");
        movie1.addActor("Bob Famous");
        movie1.addActor("Charlie Talent");
        
        // Add reviews
        movie1.addReview("Amazing movie! Great acting and storyline.");
        movie1.addReview("Loved the special effects and cinematography.");
        movie1.addReview("The plot was predictable but entertaining.");
        movie1.addReview("Best movie I've seen this year!");
        
        // Display movie information
        movie1.displayMovieInfo();
        
        // Display all reviews
        movie1.displayReviews();
        
        // Test retrieving reviews as list
        System.out.println("\n=== Retrieving Reviews Programmatically ===");
        List<String> allReviews = movie1.getReviews();
        System.out.println("Retrieved " + allReviews.size() + " reviews:");
        for (String review : allReviews) {
            System.out.println("- " + review);
        }
        
        // Create another movie
        System.out.println("\n" + "=".repeat(50));
        Movie movie2 = new Movie("Mystery Island", "Jane Filmmaker");
        
        movie2.addActor("David Actor");
        movie2.addActor("Eva Performer");
        
        // Try to display reviews for movie with no reviews
        movie2.displayReviews();
        
        // Add one review and show again
        movie2.addReview("Interesting concept but poor execution.");
        movie2.displayReviews();
        
        // Show final movie info
        movie2.displayMovieInfo();
    }
}