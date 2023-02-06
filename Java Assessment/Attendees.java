
import java.io.Serializable;

class Attendees implements Serializable {
    //attendees_id, attendees_name,attendees_phone, event_name, ticket_number, address

    private String attendeesName;
    private String addendeesPhone;
    private String addendeesTicketNumber;
    private String addendeesAddress;

    public Attendees(String attendeesName, String addendeesPhone, String addendeesTicketNumber, String addendeesAddress) {
        this.attendeesName = attendeesName;
        this.addendeesPhone = addendeesPhone;
        this.addendeesTicketNumber = addendeesTicketNumber;
        this.addendeesAddress = addendeesAddress;

    }

    public String getAddendeesTicketNumber() {
        return this.addendeesTicketNumber;
    }

    public String getAddendeesName() {
        return this.attendeesName;
    }

    @Override
    public String toString() {

        String returnMessage = " \nAttendee Name : " + this.attendeesName + "\n Attendee Phone : " + this.addendeesPhone + "\n Attendee Ticket Numner : " + this.addendeesTicketNumber + "\n Attendee Address : " + this.addendeesAddress;

        return returnMessage;
    }
}
