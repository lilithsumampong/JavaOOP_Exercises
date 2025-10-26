package Exer_19;

class Hotel {
    private String hotelId;
    private String name;
    private String location;
    private double pricePerNight;
    private int availableRooms;
    
    public Hotel(String hotelId, String name, String location, double pricePerNight, int availableRooms) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.availableRooms = availableRooms;
    }
    
    // Getters
    public String getHotelId() { return hotelId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public double getPricePerNight() { return pricePerNight; }
    public int getAvailableRooms() { return availableRooms; }
    
    public void bookRoom() {
        if (availableRooms > 0) {
            availableRooms--;
        }
    }
    
    public void cancelRoom() {
        availableRooms++;
    }
    
    public void displayInfo() {
        System.out.println(hotelId + " | " + name + " | " + location + 
                          " | $" + pricePerNight + "/night | Rooms: " + availableRooms);
    }
}
