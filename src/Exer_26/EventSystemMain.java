package Exer_26;
import java.util.List;

// Main class to test the event system
public class EventSystemMain
 {
    public static void main(String[] args) {
        System.out.println("=== EVENT MANAGEMENT SYSTEM ===\n");

        // Create seminars
        System.out.println("--- Creating Seminars ---");
        Seminar techSeminar = new Seminar("AI Conference", "2024-03-15", "Convention Center",
                "09:00", "17:00", 5, "Artificial Intelligence", 200);
        Seminar businessSeminar = new Seminar("Leadership Summit", "2024-03-15", "Convention Center",
                "14:00", "18:00", 3, "Business Leadership", 150);
        Seminar scienceSeminar = new Seminar("Climate Change", "2024-04-10", "University Hall",
                "10:00", "12:00", 2, "Environmental Science", 100);

        // Create musical performances
        System.out.println("\n--- Creating Musical Performances ---");
        MusicalPerformance rockConcert = new MusicalPerformance("Rock Festival", "2024-03-20", "City Stadium",
                "19:00", "23:00", "Rock", 75.0, 5000, true);
        MusicalPerformance jazzNight = new MusicalPerformance("Jazz Night", "2024-03-25", "Music Hall",
                "20:00", "23:00", "Jazz", 50.0, 300, false);
        MusicalPerformance classicalConcert = new MusicalPerformance("Symphony", "2024-04-05", "Concert Hall",
                "19:30", "22:00", "Classical", 120.0, 800, true);

        // Add speakers to seminars
        System.out.println("\n--- Adding Speakers to Seminars ---");
        techSeminar.addSpeaker("Dr. Alice Smith");
        techSeminar.addSpeaker("Prof. Bob Johnson");
        techSeminar.addSpeaker("Ms. Carol Davis");

        businessSeminar.addSpeaker("John Leadership");
        businessSeminar.addSpeaker("Sarah Manager");

        // Add performers to musical performances
        System.out.println("\n--- Adding Performers ---");
        rockConcert.addPerformer("The Rock Band");
        rockConcert.addPerformer("Guitar Legends");

        jazzNight.addPerformer("Jazz Quartet");
        jazzNight.addPerformer("Saxophone Master");

        classicalConcert.addPerformer("City Symphony Orchestra");
        classicalConcert.addPerformer("Famous Pianist");

        // Register attendees for seminars
        System.out.println("\n--- Seminar Registrations ---");
        techSeminar.registerAttendee();
        techSeminar.registerAttendee();
        techSeminar.registerAttendee();

        businessSeminar.registerAttendee();
        businessSeminar.registerAttendee();

        // Sell tickets for musical performances
        System.out.println("\n--- Ticket Sales ---");
        rockConcert.sellTickets(4500);
        jazzNight.sellTickets(250);
        classicalConcert.sellTickets(600);

        // Display seminar details
        System.out.println("\n--- Seminar Details ---");
        techSeminar.displayEventDetails();
        System.out.println("\n" + "=".repeat(70));
        businessSeminar.displayEventDetails();
        System.out.println("\n" + "=".repeat(70));
        scienceSeminar.displayEventDetails();

        // Display musical performance details
        System.out.println("\n--- Musical Performance Details ---");
        rockConcert.displayEventDetails();
        System.out.println("\n" + "=".repeat(70));
        jazzNight.displayEventDetails();
        System.out.println("\n" + "=".repeat(70));
        classicalConcert.displayEventDetails();

        // Test scheduling conflicts
        System.out.println("\n=== SCHEDULING CONFLICT ANALYSIS ===");
        System.out.println("Checking all events for conflicts...");
        for (Event event : Event.getAllEvents()) {
            if (event.hasSchedulingConflict()) {
                System.out.println("❌ " + event.getEventName() + " has scheduling conflicts!");
            }
        }

        // Test seminar-specific features
        System.out.println("\n=== SEMINAR-SPECIFIC FEATURES ===");
        System.out.println("AI Conference speaking time per speaker: " +
                String.format("%.1f", techSeminar.calculateSpeakingTimePerSpeaker()) + " minutes");
        System.out.println("Leadership Summit available seats: " + businessSeminar.hasAvailableSeats());

        // Test musical performance-specific features
        System.out.println("\n=== MUSICAL PERFORMANCE FEATURES ===");
        System.out.println("Rock Festival potential revenue: $" +
                String.format("%.2f", rockConcert.calculatePotentialRevenue()));
        System.out.println("Symphony premium event: " + classicalConcert.isPremiumEvent());
        System.out.println("Jazz Night sold out: " + jazzNight.isSoldOut());

        // Test event location filtering
        System.out.println("\n=== EVENTS AT CONVENTION CENTER ===");
        List<Event> conventionEvents = Event.getEventsAtLocation("Convention Center");
        for (Event event : conventionEvents) {
            System.out.println("- " + event.getEventName() + " on " + event.getDate());
        }

        // Demonstrate polymorphism
        System.out.println("\n=== ALL EVENTS SUMMARY (POLYMORPHISM) ===");
        Event[] allEventsArray = Event.getAllEvents().toArray(new Event[0]);
        for (Event event : allEventsArray) {
            event.displayEventDetails();
            System.out.println("\n" + "-".repeat(50));
        }

        // Final statistics
        System.out.println("\n=== EVENT SYSTEM STATISTICS ===");
        System.out.println("Total Events: " + Event.getAllEvents().size());
        System.out.println("Seminars: AI Conference, Leadership Summit, Climate Change");
        System.out.println("Musical Performances: Rock Festival, Jazz Night, Symphony");
        System.out.println("Locations: Convention Center, City Stadium, Music Hall, University Hall, Concert Hall");
    }
}