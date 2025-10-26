package Exer_19;

class Reservation {
    private static int reservationCounter = 1;
    private int reservationId;
    private String type; // "flight" or "hotel"
    private String itemId; // flight number or hotel ID
    private String customerName;
    private String date;
    
    public Reservation(String type, String itemId, String customerName, String date) {
        this.reservationId = reservationCounter++;
        this.type = type;
        this.itemId = itemId;
        this.customerName = customerName;
        this.date = date;
    }
    
    // Getters
    public int getReservationId() { return reservationId; }
    public String getType() { return type; }
    public String getItemId() { return itemId; }
    public String getCustomerName() { return customerName; }
    public String getDate() { return date; }
    
    public void displayInfo() {
        System.out.println("Reservation #" + reservationId + " | " + type.toUpperCase() + 
                          " | " + itemId + " | Customer: " + customerName + " | Date: " + date);
    }
}