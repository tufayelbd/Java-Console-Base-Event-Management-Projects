
import java.util.ArrayList;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;

interface EventsCRUDOperations {

    public Event createEvent(HashMap<Event, List<Attendees>> attedeesListInEvent);

    public Event createEvent2();

    public void updateEvent(HashMap<Event, List<Attendees>> attedeesListInEvent);

    public void deleteEvent(HashMap<Event, List<Attendees>> attedeesListInEvent);

//    public void showAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEvent, ArrayList<Event> eventList);
    //  public void removeAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEvent, ArrayList<Event> eventList);
    // public void addAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEvent, ArrayList<Event> eventList);
}
