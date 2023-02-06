
import java.io.Serializable;

class Event implements Serializable {

    private int eventId;
    private String eventName;
    private String eventTime;
    private String eventPlace;
    private String eventDate;
    private int numberOfSlot;
    //private String eventTicketNumber;

    public Event(int eventId, String eventName, String eventTime, String eventPlace, String eventDate, int numberOfSlot) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.eventTime = eventTime;
        this.eventPlace = eventPlace;
        this.eventDate = eventDate;
        this.numberOfSlot = numberOfSlot;
    }

    public int getEventId() {
        return this.eventId;
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getEventTime() {
        return this.eventTime;
    }

    public String getEventPlace() {
        return this.eventPlace;
    }

    public String getEventDate() {
        return this.eventDate;
    }

    public int getEventNumberOfSlot() {
        return this.numberOfSlot;
    }

    public String toString() {

        return "Event Name : " + this.eventName + " Event Time : " + this.eventTime + " Event Data: " + this.eventDate + " Event Place : " + this.eventPlace + " Event Slot : " + this.numberOfSlot;
    }
}
