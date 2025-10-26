package Exer_26;

import java.util.ArrayList;
import java.util.List;

class Seminar extends Event {
    private int numberOfSpeakers;
    private List<String> speakerList;
    private String topic;
    private int maxAttendees;
    private int registeredAttendees;

    // Constructor
    public Seminar(String eventName, String date, String location, String startTime, String endTime,
            int numberOfSpeakers, String topic, int maxAttendees) {
        super(eventName, date, location, startTime, endTime);
        this.numberOfSpeakers = numberOfSpeakers;
        this.topic = topic;
        this.maxAttendees = maxAttendees;
        this.registeredAttendees = 0;
        this.speakerList = new ArrayList<>();
        System.out.println("Seminar on '" + topic + "' with " + numberOfSpeakers + " speakers");
    }

    // Add a speaker to the seminar
    public void addSpeaker(String speakerName) {
        speakerList.add(speakerName);
        System.out.println("✓ Speaker added: " + speakerName);
    }

    // Register an attendee
    public boolean registerAttendee() {
        if (registeredAttendees < maxAttendees) {
            registeredAttendees++;
            System.out.println("✓ Attendee registered. Total: " + registeredAttendees + "/" + maxAttendees);
            return true;
        } else {
            System.out.println("✗ Registration failed: Seminar is full!");
            return false;
        }
    }

    // Calculate occupancy rate
    public double calculateOccupancyRate() {
        if (maxAttendees > 0) {
            return (registeredAttendees * 100.0) / maxAttendees;
        }
        return 0;
    }

    // Check if seminar has available seats
    public boolean hasAvailableSeats() {
        return registeredAttendees < maxAttendees;
    }

    // Override displayEventDetails to show seminar specific information
    @Override
    public void displayEventDetails() {
        System.out.println("\n=== SEMINAR DETAILS ===");
        super.displayEventDetails();
        System.out.println("Topic: " + topic);
        System.out.println("Number of Speakers: " + numberOfSpeakers);
        System.out.println("Speakers: " + (speakerList.isEmpty() ? "Not specified" : String.join(", ", speakerList)));
        System.out.println("Max Attendees: " + maxAttendees);
        System.out.println("Registered Attendees: " + registeredAttendees);
        System.out.println("Available Seats: " + (maxAttendees - registeredAttendees));
        System.out.println("Occupancy Rate: " + String.format("%.1f", calculateOccupancyRate()) + "%");
        System.out.println("Duration: " + calculateDuration() + " hours");

        // Seminar-specific recommendations
        if (calculateDuration() > 3) {
            System.out.println("💡 Recommendation: Consider adding breaks for this long seminar");
        }
    }

    // Seminar-specific method: calculate speaking time per speaker
    public double calculateSpeakingTimePerSpeaker() {
        if (numberOfSpeakers > 0) {
            double totalTime = calculateDuration() * 60; // Convert to minutes
            double presentationTime = totalTime * 0.7; // 70% for presentations
            return presentationTime / numberOfSpeakers;
        }
        return 0;
    }

    // Getters
    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public List<String> getSpeakerList() {
        return new ArrayList<>(speakerList);
    }

    public String getTopic() {
        return topic;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

    public int getRegisteredAttendees() {
        return registeredAttendees;
    }
}
