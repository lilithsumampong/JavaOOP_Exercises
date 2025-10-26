package Exer_17;

import java.util.ArrayList;
import java.util.List;

class Movie {
    private String title;
    private String director;
    private List<String> actors;
    private List<String> reviews;

    // Constructor
    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
        this.actors = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    // Add actors to the movie
    public void addActor(String actor) {
        actors.add(actor);
        System.out.println("Added actor: " + actor);
    }

    // Add multiple actors at once
    public void addActors(List<String> actorsList) {
        actors.addAll(actorsList);
        System.out.println("Added " + actorsList.size() + " actors");
    }

    // Add a review
    public void addReview(String review) {
        reviews.add(review);
        System.out.println("Review added: \"" + review + "\"");
    }

    // Get all reviews
    public List<String> getReviews() {
        return new ArrayList<>(reviews); // Return copy to protect original list
    }

    // Get number of reviews
    public int getReviewCount() {
        return reviews.size();
    }

    // Display all reviews
    public void displayReviews() {
        if (reviews.isEmpty()) {
            System.out.println("No reviews yet for \"" + title + "\"");
        } else {
            System.out.println("\n=== Reviews for \"" + title + "\" ===");
            for (int i = 0; i < reviews.size(); i++) {
                System.out.println((i + 1) + ". " + reviews.get(i));
            }
        }
    }

    // Display movie information
    public void displayMovieInfo() {
        System.out.println("\n=== Movie Information ===");
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);

        System.out.println("Actors: " + String.join(", ", actors));
        System.out.println("Total Reviews: " + getReviewCount());
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getActors() {
        return new ArrayList<>(actors); // Return copy
    }
}