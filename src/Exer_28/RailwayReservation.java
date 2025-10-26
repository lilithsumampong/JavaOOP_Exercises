package Exer_28;

import java.time.LocalDate;

class RailwayReservation extends Reservation {
    private String seatNumber;
    private String trainNumber;
    private String coachType;
    private String departureStation;
    private String arrivalStation;
    private double ticketPrice;
    private String berthType; // Lower, Middle, Upper, Side

    // Constructor
    public RailwayReservation(String customerName, LocalDate reservationDate,
            String trainNumber, String coachType,
            String departureStation, String arrivalStation,
            double ticketPrice, String berthType) {
        super(customerName, reservationDate);
        this.seatNumber = generateSeatNumber(coachType);
        this.trainNumber = trainNumber;
        this.coachType = coachType;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.ticketPrice = ticketPrice;
        this.berthType = berthType;
        System.out.println("Railway reservation - Train " + trainNumber + ", Seat " + seatNumber);
    }

    // Generate seat number based on coach type
    private String generateSeatNumber(String coachType) {
        String prefix = "";
        switch (coachType.toUpperCase()) {
            case "AC1":
                prefix = "A1";
                break;
            case "AC2":
                prefix = "B2";
                break;
            case "AC3":
                prefix = "C3";
                break;
            case "SLEEPER":
                prefix = "SL";
                break;
            default:
                prefix = "GN";
        }
        return prefix + (1 + (int) (Math.random() * 80)); // Random seat 1-80
    }

    // Modify seat/berth type
    public void modifyBerthType(String newBerthType) {
        if (isActive()) {
            String oldBerth = this.berthType;
            this.berthType = newBerthType;
            System.out.println("✓ Berth type updated from '" + oldBerth + "' to '" + newBerthType + "'");
        } else {
            System.out.println("✗ Cannot modify cancelled reservation!");
        }
    }

    // Modify coach type
    public void modifyCoachType(String newCoachType) {
        if (isActive()) {
            String oldCoach = this.coachType;
            this.coachType = newCoachType;
            this.seatNumber = generateSeatNumber(newCoachType); // Generate new seat number
            System.out.println("✓ Coach type updated from '" + oldCoach + "' to '" + newCoachType + "'");
            System.out.println("  New seat number: " + seatNumber);
        } else {
            System.out.println("✗ Cannot modify cancelled reservation!");
        }
    }

    // Check if ticket can be cancelled (within cancellation period)
    public boolean isCancellable() {
        long hoursUntil = java.time.temporal.ChronoUnit.HOURS.between(
                java.time.LocalDateTime.now(),
                getReservationDate().atTime(10, 0) // Assume 10 AM departure
        );
        return isActive() && hoursUntil > 4; // Can cancel up to 4 hours before
    }

    // Calculate cancellation charges
    public double calculateCancellationCharges() {
        long hoursUntil = java.time.temporal.ChronoUnit.HOURS.between(
                java.time.LocalDateTime.now(),
                getReservationDate().atTime(10, 0));

        if (hoursUntil > 48) {
            return ticketPrice * 0.10; // 10% charges if > 48 hours
        } else if (hoursUntil > 24) {
            return ticketPrice * 0.25; // 25% charges if > 24 hours
        } else if (hoursUntil > 4) {
            return ticketPrice * 0.50; // 50% charges if > 4 hours
        } else {
            return ticketPrice; // No cancellation < 4 hours
        }
    }

    // Override displayReservationDetails to show railway specific information
    @Override
    public void displayReservationDetails() {
        System.out.println("\n=== RAILWAY RESERVATION ===");
        super.displayReservationDetails();
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Coach Type: " + coachType);
        System.out.println("Departure: " + departureStation);
        System.out.println("Arrival: " + arrivalStation);
        System.out.println("Berth Type: " + berthType);
        System.out.println("Ticket Price: $" + String.format("%.2f", ticketPrice));
        System.out.println("Cancellable: " + (isCancellable() ? "Yes" : "No"));
        System.out.println("Cancellation Charges: $" + String.format("%.2f", calculateCancellationCharges()));

        // Railway-specific insights
        if (isUpcoming()) {
            System.out.println("🚆 Journey soon! Don't forget your ID proof.");
        }
        if (coachType.equalsIgnoreCase("AC1") || coachType.equalsIgnoreCase("AC2")) {
            System.out.println("💺 Comfort travel! Meals included.");
        }
    }

    // Railway-specific method: check PNR status (simulated)
    public void checkPNRStatus() {
        if (isActive()) {
            if (isUpcoming()) {
                System.out.println("PNR Status: CONFIRMED - Seat " + seatNumber + " in " + coachType);
            } else {
                System.out.println("PNR Status: WAITLISTED - Current position: " +
                        (5 + (int) (Math.random() * 20)));
            }
        } else {
            System.out.println("PNR Status: CANCELLED");
        }
    }

    // Railway-specific method: calculate journey distance (simulated)
    public int calculateJourneyDistance() {
        // Simple simulation based on station names
        int baseDistance = 200;
        if (departureStation.contains("Delhi") && arrivalStation.contains("Mumbai"))
            return 1400;
        if (departureStation.contains("Kolkata") && arrivalStation.contains("Chennai"))
            return 1600;
        return baseDistance + (int) (Math.random() * 800);
    }

    // Getters
    public String getSeatNumber() {
        return seatNumber;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getCoachType() {
        return coachType;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getBerthType() {
        return berthType;
    }
}