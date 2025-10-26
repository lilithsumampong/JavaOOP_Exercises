package Exer_26;

import java.util.ArrayList;
import java.util.List;

class Event {
    private String eventName;
    private String date;
    private String location;
    private String startTime;
    private String endTime;
    private static List<Event> allEvents = new ArrayList<>();

    // Constructor
    public Event(String eventName, String date, String location, String startTime, String endTime) {
        this.eventName = eventName;
        this.date = date;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        allEvents.add(this);
        System.out.println("Event created: " + eventName + " on " + date);
    }

    // Check for scheduling conflicts with other events
    public boolean hasSchedulingConflict() {
        for (Event otherEvent : allEvents) {
            if (this != otherEvent && isConflicting(otherEvent)) {
                System.out.println("⚠️  CONFLICT: " + eventName + " conflicts with " + otherEvent.eventName);
                return true;
            }
        }
        return false;
    }

    // Check if this event conflicts with another event
    private boolean isConflicting(Event otherEvent) {
        // Check if same date and location
        if (!this.date.equals(otherEvent.date) || !this.location.equals(otherEvent.location)) {
            return false;
        }

        // Check time overlap
        return isTimeOverlap(this.startTime, this.endTime, otherEvent.startTime, otherEvent.endTime);
    }

    // Helper method to check time overlap
    private boolean isTimeOverlap(String start1, String end1, String start2, String end2) {
        // Simple time comparison (in real app, use proper time parsing)
        return start1.compareTo(end2) < 0 && end1.compareTo(start2) > 0;
    }

    // Display basic event information
    public void displayEventDetails() {
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + date);
        System.out.println("Location: " + location);
        System.out.println("Time: " + startTime + " - " + endTime);
        System.out.println("Has Conflict: " + (hasSchedulingConflict() ? "Yes" : "No"));
    }

    // Calculate event duration in hours (simplified)
    public double calculateDuration() {
        // Simple calculation - in real app, parse times properly
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        int startHour = Integer.parseInt(start[0]);
        int endHour = Integer.parseInt(end[0]);
        return endHour - startHour;
    }

    // Check if event is in the future (simplified date check)
    public boolean isFutureEvent(String currentDate) {
        return date.compareTo(currentDate) > 0;
    }

    // Get all events at a specific location
    public static List<Event> getEventsAtLocation(String location) {
        List<Event> locationEvents = new ArrayList<>();
        for (Event event : allEvents) {
            if (event.location.equals(location)) {
                locationEvents.add(event);
            }
        }
        return locationEvents;
    }

    // Getters
    public String getEventName() {
        return eventName;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public static List<Event> getAllEvents() {
        return new ArrayList<>(allEvents);
    }
}