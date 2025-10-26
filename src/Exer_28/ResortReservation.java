package Exer_28;
import java.time.LocalDate;

class ResortReservation extends Reservation {
    private String roomNumber;
    private String roomType;
    private int numberOfNights;
    private double roomRate;
    private boolean hasBreakfast;
    private boolean hasSpaAccess;

    // Constructor
    public ResortReservation(String customerName, LocalDate reservationDate,
            String roomType, int numberOfNights, double roomRate,
            boolean hasBreakfast, boolean hasSpaAccess) {
        super(customerName, reservationDate);
        this.roomNumber = generateRoomNumber();
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.roomRate = roomRate;
        this.hasBreakfast = hasBreakfast;
        this.hasSpaAccess = hasSpaAccess;
        System.out.println("Resort reservation - Room " + roomNumber + " (" + roomType + ")");
    }

    // Generate unique room number
    private String generateRoomNumber() {
        return "RM" + (100 + (int) (Math.random() * 400)); // Random room number 100-499
    }

    // Modify room type
    public void modifyRoomType(String newRoomType) {
        if (isActive()) {
            String oldType = this.roomType;
            this.roomType = newRoomType;
            System.out.println("✓ Room type updated from '" + oldType + "' to '" + newRoomType + "'");
        } else {
            System.out.println("✗ Cannot modify cancelled or completed reservation!");
        }
    }

    // Modify number of nights
    public void modifyNumberOfNights(int newNumberOfNights) {
        if (isActive() && newNumberOfNights > 0) {
            int oldNights = this.numberOfNights;
            this.numberOfNights = newNumberOfNights;
            System.out.println("✓ Number of nights updated from " + oldNights + " to " + newNumberOfNights);
        } else {
            System.out.println("✗ Invalid number of nights or reservation not active!");
        }
    }

    // Add breakfast option
    public void addBreakfastOption() {
        if (isActive() && !hasBreakfast) {
            hasBreakfast = true;
            System.out.println("✓ Breakfast option added to reservation");
        } else if (hasBreakfast) {
            System.out.println("Breakfast option is already included");
        } else {
            System.out.println("✗ Cannot modify cancelled reservation!");
        }
    }

    // Add spa access
    public void addSpaAccess() {
        if (isActive() && !hasSpaAccess) {
            hasSpaAccess = true;
            System.out.println("✓ Spa access added to reservation");
        } else if (hasSpaAccess) {
            System.out.println("Spa access is already included");
        } else {
            System.out.println("✗ Cannot modify cancelled reservation!");
        }
    }

    // Calculate total cost
    public double calculateTotalCost() {
        double total = numberOfNights * roomRate;
        if (hasBreakfast) {
            total += numberOfNights * 25; // $25 per night for breakfast
        }
        if (hasSpaAccess) {
            total += 50; // $50 one-time spa access fee
        }
        return total;
    }

    // Calculate check-out date
    public LocalDate getCheckoutDate() {
        return getReservationDate().plusDays(numberOfNights);
    }

    // Override displayReservationDetails to show resort specific information
    @Override
    public void displayReservationDetails() {
        System.out.println("\n=== RESORT RESERVATION ===");
        super.displayReservationDetails();
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + numberOfNights);
        System.out.println("Room Rate: $" + String.format("%.2f", roomRate) + "/night");
        System.out.println("Breakfast Included: " + (hasBreakfast ? "Yes" : "No"));
        System.out.println("Spa Access: " + (hasSpaAccess ? "Yes" : "No"));
        System.out.println("Check-out Date: " + getCheckoutDate());
        System.out.println("Total Cost: $" + String.format("%.2f", calculateTotalCost()));

        // Resort-specific insights
        if (isUpcoming()) {
            System.out.println("🎯 Upcoming stay! Prepare for check-in.");
        }
        if (numberOfNights >= 7) {
            System.out.println("🌟 Long stay! Consider our weekly discount.");
        }
    }

    // Resort-specific method: check early check-in availability
    public boolean isEarlyCheckinAvailable() {
        return isActive() && getDaysUntilReservation() <= 1;
    }

    // Resort-specific method: calculate loyalty points
    public int calculateLoyaltyPoints() {
        return (int) (calculateTotalCost() / 10); // 1 point per $10 spent
    }

    // Getters
    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public double getRoomRate() {
        return roomRate;
    }

    public boolean hasBreakfast() {
        return hasBreakfast;
    }

    public boolean hasSpaAccess() {
        return hasSpaAccess;
    }
}
