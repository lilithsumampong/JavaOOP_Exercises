package Exer_19;
import java.util.ArrayList;
import java.util.List;

class TravelReservationMain {
    private List<Flight> flights;
    private List<Hotel> hotels;
    private List<Reservation> reservations;
    
    public TravelReservationMain() {
        this.flights = new ArrayList<>();
        this.hotels = new ArrayList<>();
        this.reservations = new ArrayList<>();
        initializeData();
    }
    
    private void initializeData() {
        // Add some sample flights
        flights.add(new Flight("AA101", "American Airlines", "New York", "London", "2024-01-15", 450.00, 50));
        flights.add(new Flight("UA202", "United Airlines", "Chicago", "Tokyo", "2024-01-16", 850.00, 30));
        flights.add(new Flight("DL303", "Delta Airlines", "Los Angeles", "Paris", "2024-01-17", 600.00, 25));
        flights.add(new Flight("BA404", "British Airways", "London", "New York", "2024-01-18", 500.00, 40));
        
        // Add some sample hotels
        hotels.add(new Hotel("H001", "Grand Plaza", "New York", 200.00, 10));
        hotels.add(new Hotel("H002", "Tokyo Inn", "Tokyo", 150.00, 15));
        hotels.add(new Hotel("H003", "Paris Luxury", "Paris", 300.00, 8));
        hotels.add(new Hotel("H004", "London Suites", "London", 250.00, 12));
    }
    
    // Search methods
    public void searchFlights(String departure, String destination, String date) {
        System.out.println("\n=== SEARCHING FLIGHTS: " + departure + " → " + destination + " on " + date + " ===");
        boolean found = false;
        
        for (Flight flight : flights) {
            if (flight.getDeparture().equalsIgnoreCase(departure) &&
                flight.getDestination().equalsIgnoreCase(destination) &&
                flight.getDate().equals(date) &&
                flight.getAvailableSeats() > 0) {
                flight.displayInfo();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No available flights found for your search criteria.");
        }
    }
    
    public void searchHotels(String location, String date) {
        System.out.println("\n=== SEARCHING HOTELS in " + location + " for " + date + " ===");
        boolean found = false;
        
        for (Hotel hotel : hotels) {
            if (hotel.getLocation().equalsIgnoreCase(location) && 
                hotel.getAvailableRooms() > 0) {
                hotel.displayInfo();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No available hotels found in " + location);
        }
    }
    
    // Booking methods
    public boolean bookFlight(String flightNumber, String customerName, String date) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber) && flight.getAvailableSeats() > 0) {
                flight.bookSeat();
                Reservation reservation = new Reservation("flight", flightNumber, customerName, date);
                reservations.add(reservation);
                System.out.println("✓ Flight booked successfully!");
                reservation.displayInfo();
                return true;
            }
        }
        System.out.println("✗ Failed to book flight. Either flight not found or no seats available.");
        return false;
    }
    
    public boolean bookHotel(String hotelId, String customerName, String date) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelId().equals(hotelId) && hotel.getAvailableRooms() > 0) {
                hotel.bookRoom();
                Reservation reservation = new Reservation("hotel", hotelId, customerName, date);
                reservations.add(reservation);
                System.out.println("✓ Hotel booked successfully!");
                reservation.displayInfo();
                return true;
            }
        }
        System.out.println("✗ Failed to book hotel. Either hotel not found or no rooms available.");
        return false;
    }
    
    // Cancellation methods
    public boolean cancelReservation(int reservationId) {
        for (int i = 0; i < reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            if (reservation.getReservationId() == reservationId) {
                String type = reservation.getType();
                String itemId = reservation.getItemId();
                
                if (type.equals("flight")) {
                    for (Flight flight : flights) {
                        if (flight.getFlightNumber().equals(itemId)) {
                            flight.cancelSeat();
                            break;
                        }
                    }
                } else if (type.equals("hotel")) {
                    for (Hotel hotel : hotels) {
                        if (hotel.getHotelId().equals(itemId)) {
                            hotel.cancelRoom();
                            break;
                        }
                    }
                }
                
                reservations.remove(i);
                System.out.println("✓ Reservation #" + reservationId + " cancelled successfully!");
                return true;
            }
        }
        System.out.println("✗ Reservation #" + reservationId + " not found.");
        return false;
    }
    
    // Display all reservations for a customer
    public void displayCustomerReservations(String customerName) {
        System.out.println("\n=== RESERVATIONS FOR " + customerName.toUpperCase() + " ===");
        boolean found = false;
        
        for (Reservation reservation : reservations) {
            if (reservation.getCustomerName().equalsIgnoreCase(customerName)) {
                reservation.displayInfo();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No reservations found for " + customerName);
        }
    }
    
    // Display all available flights and hotels
    public void displayAllAvailable() {
        System.out.println("\n=== ALL AVAILABLE FLIGHTS ===");
        for (Flight flight : flights) {
            if (flight.getAvailableSeats() > 0) {
                flight.displayInfo();
            }
        }
        
        System.out.println("\n=== ALL AVAILABLE HOTELS ===");
        for (Hotel hotel : hotels) {
            if (hotel.getAvailableRooms() > 0) {
                hotel.displayInfo();
            }
        }
    }
}

// Main class to test the system
public class TravelSystemMain {
    public static void main(String[] args) {
        System.out.println("=== TRAVEL RESERVATION SYSTEM ===\n");
        
        TravelReservationMain system = new TravelReservationMain();
        
        // Display all available options
        system.displayAllAvailable();
        
        // Test flight search and booking
        System.out.println("\n" + "=".repeat(60));
        system.searchFlights("New York", "London", "2024-01-15");
        system.bookFlight("AA101", "John Smith", "2024-01-15");
        
        // Test hotel search and booking
        System.out.println("\n" + "=".repeat(60));
        system.searchHotels("London", "2024-01-15");
        system.bookHotel("H004", "John Smith", "2024-01-15");
        
        // Display customer reservations
        system.displayCustomerReservations("John Smith");
        
        // Test another booking
        System.out.println("\n" + "=".repeat(60));
        system.bookFlight("UA202", "Alice Johnson", "2024-01-16");
        system.bookHotel("H002", "Alice Johnson", "2024-01-16");
        
        // Display all reservations
        system.displayCustomerReservations("Alice Johnson");
        
        // Test cancellation
        System.out.println("\n" + "=".repeat(60));
        system.cancelReservation(1); // Cancel John's flight
        
        // Show updated reservations
        system.displayCustomerReservations("John Smith");
        
        // Test error cases
        System.out.println("\n" + "=".repeat(60));
        system.bookFlight("INVALID", "Bob Wilson", "2024-01-15"); // Invalid flight
        system.cancelReservation(999); // Invalid reservation ID
        
        // Show final available options
        system.displayAllAvailable();
    }
}