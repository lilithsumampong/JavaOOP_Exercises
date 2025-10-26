package Exer_28;

import java.time.LocalDate;

class Reservation {
    private String reservationId;
    private String customerName;
    private LocalDate reservationDate;
    protected String status; // protected for subclass access
    private static int reservationCounter = 1000;

    // Constructor
    public Reservation(String customerName, LocalDate reservationDate) {
        this.reservationId = "RES" + reservationCounter++;
        this.customerName = customerName;
        this.reservationDate = reservationDate;
        this.status = "Confirmed";
        System.out.println("Reservation created: " + reservationId + " for " + customerName);
    }

    // Check reservation status
    public void checkStatus() {
        System.out.println("Reservation " + reservationId + " Status: " + status);
    }

    // Modify customer name
    public void modifyCustomerName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            String oldName = this.customerName;
            this.customerName = newName;
            System.out.println("✓ Customer name updated from '" + oldName + "' to '" + newName + "'");
        } else {
            System.out.println("✗ Invalid customer name!");
        }
    }

    // Modify reservation date
    public void modifyReservationDate(LocalDate newDate) {
        if (newDate != null && !newDate.isBefore(LocalDate.now())) {
            LocalDate oldDate = this.reservationDate;
            this.reservationDate = newDate;
            System.out.println("✓ Reservation date updated from " + oldDate + " to " + newDate);
        } else {
            System.out.println("✗ Invalid reservation date! Date cannot be in the past.");
        }
    }

    // Cancel reservation
    public void cancelReservation() {
        if (!status.equals("Cancelled")) {
            String oldStatus = this.status;
            this.status = "Cancelled";
            System.out.println("✓ Reservation " + reservationId + " cancelled (was: " + oldStatus + ")");
        } else {
            System.out.println("Reservation " + reservationId + " is already cancelled.");
        }
    }

    // Check if reservation is active
    public boolean isActive() {
        return !status.equals("Cancelled") && !status.equals("Completed");
    }

    // Check if reservation is upcoming (within next 7 days)
    public boolean isUpcoming() {
        long daysUntil = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), reservationDate);
        return isActive() && daysUntil <= 7 && daysUntil >= 0;
    }

    // Calculate days until reservation
    public long getDaysUntilReservation() {
        return java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), reservationDate);
    }

    // Display reservation details
    public void displayReservationDetails() {
        System.out.println("\n=== RESERVATION DETAILS ===");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Reservation Date: " + reservationDate);
        System.out.println("Status: " + status);
        System.out.println("Active: " + (isActive() ? "Yes" : "No"));
        System.out.println("Upcoming: " + (isUpcoming() ? "Yes" : "No"));
        System.out.println("Days Until: " + getDaysUntilReservation());
    }

    // Getters
    public String getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public String getStatus() {
        return status;
    }
}
