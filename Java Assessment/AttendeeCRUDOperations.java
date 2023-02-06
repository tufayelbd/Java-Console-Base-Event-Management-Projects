
import java.util.ArrayList;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;

interface AttendeeCRUDOperations {

    public Attendees createAttendees();

    public void showAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEvent);

    public void addAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEven);

    public void removeAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEvent);

}
