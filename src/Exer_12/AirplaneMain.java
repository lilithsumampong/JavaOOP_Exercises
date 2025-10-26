package Exer_12;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AirplaneMain {

    private String destination, departureTime, status, flightNumber;

    AirplaneMain(String flightNumber, String departureTime, String destination, String status) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.destination = destination;
        this.status = status;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public String getStatus() {
        return status;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void flightStatus() {
        System.out.println("\nflight number: " + flightNumber);
        System.out.println("destination: " + destination);
        System.out.println("departure time: " + departureTime);
        System.out.println("status: " + status);
    }

    public void delayFlight(String departureTime, int hourDelay, int minuteDelay) {

        if (hourDelay < 0 || minuteDelay < 0) {
            System.out.println("This time is invalid!");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        LocalTime time = LocalTime.parse(departureTime, formatter);

        // operation
        LocalTime newTime = time.plusHours(hourDelay).plusMinutes(minuteDelay);
        String result = newTime.format(formatter);

        String delayMessage = buildDelayMessage(hourDelay, minuteDelay);

        System.out.println();
        System.out.println(getDepartureTime() + " departure time is delayed for " + delayMessage);
        System.out.println("Delayed Departure Time: " + result);

        setDepartureTime(result);
        setStatus("Delayed");
    }


    public String buildDelayMessage(int hours, int minutes) {
        StringBuilder message = new StringBuilder();

        if (hours > 0) {
            message.append(hours).append(hours == 1 ? " hour" : " hours");
        }

        if (minutes > 0) {
            if (hours > 0) {
                message.append(" and ");
            }
            message.append(minutes).append(minutes == 1 ? " minute" : " minutes");
        }

        return message.toString();
    }

    public static void main(String[] args) {

        AirplaneMain airplane1 = new AirplaneMain("FL001", "7:00 AM", "England", "On-Time");

        airplane1.flightStatus();
        airplane1.delayFlight(airplane1.getDepartureTime(), 1, 30);
        airplane1.flightStatus();

    }
}
