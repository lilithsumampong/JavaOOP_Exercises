package Exer_19;

class Flight {
    private String flightNumber;
    private String airline;
    private String departure;
    private String destination;
    private String date;
    private double price;
    private int availableSeats;

    public Flight(String flightNumber, String airline, String departure, String destination,
            String date, double price, int availableSeats) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    public void cancelSeat() {
        availableSeats++;
    }

    public void displayInfo() {
        System.out.println(flightNumber + " | " + airline + " | " + departure + " → " +
                destination + " | " + date + " | $" + price + " | Seats: " + availableSeats);
    }
}
