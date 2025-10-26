package Exer_28;

import java.time.LocalDate;

// Main class to test the reservation system
public class ReservationSystemMain {
        public static void main(String[] args) {
                System.out.println("=== RESERVATION MANAGEMENT SYSTEM ===\n");

                // Create resort reservations
                System.out.println("--- Creating Resort Reservations ---");
                ResortReservation beachResort = new ResortReservation("Alice Johnson",
                                LocalDate.now().plusDays(5), "Deluxe Suite", 3, 199.99, true, false);
                ResortReservation mountainResort = new ResortReservation("Bob Smith",
                                LocalDate.now().plusDays(10), "Standard Room", 7, 129.99, false, true);
                ResortReservation luxuryResort = new ResortReservation("Carol Davis",
                                LocalDate.now().minusDays(2), "Presidential Suite", 2, 399.99, true, true);

                // Create railway reservations
                System.out.println("\n--- Creating Railway Reservations ---");
                RailwayReservation expressTrain = new RailwayReservation("David Wilson",
                                LocalDate.now().plusDays(3), "12345", "AC2", "New York", "Chicago",
                                89.99, "Lower");
                RailwayReservation longRoute = new RailwayReservation("Emma Brown",
                                LocalDate.now().plusDays(7), "67890", "Sleeper", "Los Angeles", "Seattle",
                                129.99, "Upper");
                RailwayReservation localTrain = new RailwayReservation("Frank Miller",
                                LocalDate.now().plusDays(1), "54321", "AC1", "Boston", "Washington",
                                45.99, "Side");

                // Display resort reservation details
                System.out.println("\n--- Resort Reservation Details ---");
                beachResort.displayReservationDetails();
                System.out.println("\n" + "=".repeat(70));
                mountainResort.displayReservationDetails();
                System.out.println("\n" + "=".repeat(70));
                luxuryResort.displayReservationDetails();

                // Display railway reservation details
                System.out.println("\n--- Railway Reservation Details ---");
                expressTrain.displayReservationDetails();
                System.out.println("\n" + "=".repeat(70));
                longRoute.displayReservationDetails();
                System.out.println("\n" + "=".repeat(70));
                localTrain.displayReservationDetails();

                // Test modification methods for resort reservations
                System.out.println("\n--- Modifying Resort Reservations ---");
                beachResort.modifyRoomType("Premium Suite");
                beachResort.addSpaAccess();
                beachResort.modifyNumberOfNights(4);

                mountainResort.addBreakfastOption();
                mountainResort.modifyCustomerName("Robert Smith");

                // Test modification methods for railway reservations
                System.out.println("\n--- Modifying Railway Reservations ---");
                expressTrain.modifyBerthType("Middle");
                expressTrain.modifyCoachType("AC3");
                longRoute.modifyReservationDate(LocalDate.now().plusDays(10));

                // Test cancellation and status checks
                System.out.println("\n--- Testing Cancellations ---");
                luxuryResort.cancelReservation();
                localTrain.cancelReservation();

                // Display updated details
                System.out.println("\n--- Updated Reservation Details ---");
                beachResort.displayReservationDetails();
                System.out.println("\n" + "=".repeat(70));
                expressTrain.displayReservationDetails();

                // Test reservation-specific features
                System.out.println("\n=== RESERVATION-SPECIFIC FEATURES ===");
                System.out.println("Beach Resort Total Cost: $" +
                                String.format("%.2f", beachResort.calculateTotalCost()));
                System.out.println("Beach Resort Loyalty Points: " + beachResort.calculateLoyaltyPoints());
                System.out.println("Beach Resort Early Check-in: " + beachResort.isEarlyCheckinAvailable());

                System.out.println("Express Train Cancellable: " + expressTrain.isCancellable());
                System.out.println(
                                "Express Train Journey Distance: " + expressTrain.calculateJourneyDistance() + " km");
                expressTrain.checkPNRStatus();

                // Test error handling
                System.out.println("\n=== TESTING ERROR HANDLING ===");
                luxuryResort.modifyRoomType("Suite"); // Should fail - cancelled reservation
                beachResort.modifyNumberOfNights(-2); // Should fail - invalid nights
                beachResort.modifyReservationDate(LocalDate.now().minusDays(1)); // Should fail - past date

                // Demonstrate polymorphism
                System.out.println("\n=== ALL RESERVATIONS SUMMARY (POLYMORPHISM) ===");
                Reservation[] allReservations = {
                                new ResortReservation("Grace Lee", LocalDate.now().plusDays(4),
                                                "Family Room", 5, 179.99, true, false),
                                new RailwayReservation("Henry Taylor", LocalDate.now().plusDays(6),
                                                "98765", "AC2", "Miami", "Atlanta", 75.99, "Lower"),
                                new ResortReservation("Ivy Chen", LocalDate.now().plusDays(2),
                                                "Honeymoon Suite", 3, 299.99, true, true),
                                new RailwayReservation("Jack Wilson", LocalDate.now().plusDays(8),
                                                "24680", "Sleeper", "Denver", "Phoenix", 110.99, "Middle")
                };

                // Display all reservations
                for (Reservation reservation : allReservations) {
                        reservation.displayReservationDetails();

                        // Access subclass-specific methods
                        if (reservation instanceof ResortReservation) {
                                ResortReservation resort = (ResortReservation) reservation;
                                System.out.println("Resort - Total Cost: $" +
                                                String.format("%.2f", resort.calculateTotalCost()));
                        } else if (reservation instanceof RailwayReservation) {
                                RailwayReservation railway = (RailwayReservation) reservation;
                                System.out.println("Railway - Cancellable: " + railway.isCancellable());
                                railway.checkPNRStatus();
                        }
                        System.out.println("\n" + "=".repeat(70));
                }

                // Final statistics
                System.out.println("=== RESERVATION SYSTEM STATISTICS ===");
                System.out.println(
                                "Resort Reservations: Beach Resort, Mountain Resort, Luxury Resort, Family Resort, Honeymoon Resort");
                System.out
                                .println("Railway Reservations: Express Train, Long Route, Local Train, Regional Train, Cross-country");
                System.out.println(
                                "Features: Room/Seat assignment, Cost calculation, Modification, Cancellation, Status tracking");
        }
}