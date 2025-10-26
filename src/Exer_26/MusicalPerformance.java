package Exer_26;

import java.util.ArrayList;
import java.util.List;

class MusicalPerformance extends Event {
    private List<String> performerList;
    private String musicGenre;
    private double ticketPrice;
    private int ticketsSold;
    private int venueCapacity;
    private boolean hasOpeningAct;

    // Constructor
    public MusicalPerformance(String eventName, String date, String location, String startTime, String endTime,
            String musicGenre, double ticketPrice, int venueCapacity, boolean hasOpeningAct) {
        super(eventName, date, location, startTime, endTime);
        this.musicGenre = musicGenre;
        this.ticketPrice = ticketPrice;
        this.venueCapacity = venueCapacity;
        this.hasOpeningAct = hasOpeningAct;
        this.ticketsSold = 0;
        this.performerList = new ArrayList<>();
        System.out.println("Musical Performance: " + musicGenre + " genre, Ticket: $" + ticketPrice);
    }

    // Add a performer
    public void addPerformer(String performerName) {
        performerList.add(performerName);
        System.out.println("✓ Performer added: " + performerName);
    }

    // Sell tickets
    public boolean sellTickets(int numberOfTickets) {
        if (ticketsSold + numberOfTickets <= venueCapacity) {
            ticketsSold += numberOfTickets;
            double revenue = numberOfTickets * ticketPrice;
            System.out.println("✓ Sold " + numberOfTickets + " tickets for $" +
                    String.format("%.2f", revenue));
            System.out.println("  Total sold: " + ticketsSold + "/" + venueCapacity);
            return true;
        } else {
            System.out.println("✗ Cannot sell " + numberOfTickets + " tickets. Only " +
                    (venueCapacity - ticketsSold) + " available!");
            return false;
        }
    }

    // Calculate total revenue
    public double calculateTotalRevenue() {
        return ticketsSold * ticketPrice;
    }

    // Calculate occupancy percentage
    public double calculateOccupancyPercentage() {
        if (venueCapacity > 0) {
            return (ticketsSold * 100.0) / venueCapacity;
        }
        return 0;
    }

    // Check if sold out
    public boolean isSoldOut() {
        return ticketsSold >= venueCapacity;
    }

    // Override displayEventDetails to show musical performance specific information
    @Override
    public void displayEventDetails() {
        System.out.println("\n=== MUSICAL PERFORMANCE ===");
        super.displayEventDetails();
        System.out.println("Music Genre: " + musicGenre);
        System.out.println(
                "Performers: " + (performerList.isEmpty() ? "Not specified" : String.join(", ", performerList)));
        System.out.println("Ticket Price: $" + String.format("%.2f", ticketPrice));
        System.out.println("Venue Capacity: " + venueCapacity);
        System.out.println("Tickets Sold: " + ticketsSold);
        System.out.println("Available Tickets: " + (venueCapacity - ticketsSold));
        System.out.println("Occupancy: " + String.format("%.1f", calculateOccupancyPercentage()) + "%");
        System.out.println("Total Revenue: $" + String.format("%.2f", calculateTotalRevenue()));
        System.out.println("Opening Act: " + (hasOpeningAct ? "Yes" : "No"));
        System.out.println("Duration: " + calculateDuration() + " hours");
        System.out.println("Sold Out: " + (isSoldOut() ? "Yes" : "No"));

        // Performance-specific insights
        if (calculateOccupancyPercentage() > 80) {
            System.out.println("🎵 Popular Event: High demand!");
        }
        if (hasOpeningAct && calculateDuration() > 2) {
            System.out.println("💡 Note: Long performance with opening act - plan set times accordingly");
        }
    }

    // Musical performance specific method: calculate potential revenue if sold out
    public double calculatePotentialRevenue() {
        return venueCapacity * ticketPrice;
    }

    // Check if it's a premium event (high ticket price)
    public boolean isPremiumEvent() {
        return ticketPrice > 100.0;
    }

    // Getters
    public List<String> getPerformerList() {
        return new ArrayList<>(performerList);
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public int getVenueCapacity() {
        return venueCapacity;
    }

    public boolean hasOpeningAct() {
        return hasOpeningAct;
    }
}
