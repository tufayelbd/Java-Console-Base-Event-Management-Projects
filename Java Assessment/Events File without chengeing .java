
import java.util.ArrayList;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.io.IOException;

class Events implements EventsCRUDOperations {

    private int eventId;
    private String eventName;
    private String eventTime;
    private String eventPlace;
    private String eventDate;
    private int eventSlot;

    public Events() {
        this.eventId = eventId;

        this.eventName = eventName;
        this.eventTime = eventTime;
        this.eventPlace = eventPlace;
        this.eventDate = eventDate;
        this.eventSlot = eventSlot;

    }

    public int getNumberOfEventSlot() {
        return this.eventSlot;
    }

    @Override
    public Event createEvent() {

        Scanner scIn = new Scanner(System.in); // this for taking integer inout

        Scanner sc = new Scanner(System.in).useDelimiter("\n"); // this is for taking String input

        System.out.println("Enter Event Details :");
        System.out.println("Event Id");
        this.eventId = scIn.nextInt();
        //this.eventId=eventId;

        System.out.println("Event name");
        this.eventName = sc.nextLine();
        //this.eventName=eventName;
        System.out.println("Event Time ");
        this.eventTime = sc.nextLine();
        //this.eventTime=eventTime;
        System.out.println("Event Place ");
        this.eventPlace = sc.nextLine();
        //this.eventPlace=eventPlace;
        System.out.println("Event Date ");
        this.eventDate = sc.nextLine();
        //	this.eventDate=eventDate;
        System.out.println("Event Slot");
        this.eventSlot = scIn.nextInt();
        //this.eventSlot=eventSlot;

        Event refEvent = new Event(this.eventId, this.eventName, this.eventTime, this.eventPlace, this.eventDate, this.eventSlot);

        return refEvent;
    }

    @Override
    public void updateEvent(HashMap<Event, List<Attendees>> attedeesListInEvent, ArrayList<Event> eventList) {
        attedeesListInEvent = attedeesListInEvent;
        eventList = eventList;

        Scanner scIn = new Scanner(System.in); // this for taking integer inout

        Scanner sc = new Scanner(System.in).useDelimiter("\n"); // this is for taking String input

        boolean found = false;
        //List tempAttendees = new ArrayList();
        List<Attendees> tempAttendees = new ArrayList<>();

        System.out.print("Enter The Event Id You Want To Update :");

        int displayChoiceId = scIn.nextInt();
        //int x;

        Iterator<Event> it = eventList.iterator();
        while (it.hasNext()) {
            Event getEvent = it.next();
            //System.out.println("Iterator :     "+e);
            if (getEvent.getEventId() == (displayChoiceId)) {

                System.out.println("***************** Update Event details Only **********************8");
                for (Event events2 : attedeesListInEvent.keySet()) {
                    //System.out.println(events2);
                    System.out.println();
                    Event tempEvent = getEvent;
                    //System.out.println(tempEvent);
                    if (events2.equals(tempEvent)) {

//							System.out.println(events2);
                        //System.out.println(events2+ "\n \t Attendees : "+ attedeesListInEvent.get(events2));
                        System.out.println();
                        //						tempAttendees=attedeesListInEvent.get(events2);
                        attedeesListInEvent.remove(events2);
                        break;
                    }

                }
                it.remove();
                Events eventstemp = new Events();

                //Create an Event and add it into the event List
                Event oneEventTemp = eventstemp.createEvent();
                eventList.add(oneEventTemp);

                //			System.out.println(oneEventTemp+"tempAttendees "+tempAttendees);
                attedeesListInEvent.put(oneEventTemp, tempAttendees);

                System.out.println("*******************************************");
                found = true;
                break;
            }
            //break;

        }

        if (!found) {
            System.out.println();
            System.out.println("Record Not Found... ");

            System.out.println();
        } else {
            System.out.println("Event Update Successfully..!");

        }

        /// <------------Event case 3 User option End Event Updating option  ---------------->
    }

    @Override
    public void deleteEvent(HashMap<Event, List<Attendees>> attedeesListInEvent, ArrayList<Event> eventList) {
        attedeesListInEvent = attedeesListInEvent;
        eventList = eventList;

        Scanner scIn = new Scanner(System.in); // this for taking integer inout

        Scanner sc = new Scanner(System.in).useDelimiter("\n"); // this is for taking String input

        boolean found = false;
        System.out.print("Enter The Event Id You Want To Delete :");

        int displayChoiceId2 = scIn.nextInt();
        //int x2;

        Iterator<Event> it2 = eventList.iterator();
        while (it2.hasNext()) {
            Event e = it2.next();
            //System.out.println("Iterator :     "+e);
            if (e.getEventId() == (displayChoiceId2)) {
                for (Event events2 : attedeesListInEvent.keySet()) {

                    System.out.println();
                    Event tempEvent = e;
                    if (events2.equals(tempEvent)) {

                        attedeesListInEvent.remove(events2);
                        eventList.remove(events2);
                        System.out.println();
                        break;
                    }

                }
                System.out.println("*******************************************");
                found = true;
                break;

            }
            //break;

        }

        if (!found) {

            System.out.println("Record Not Found ");
        } else {
            System.out.println();
            System.out.println("Record Delete Successfully... !");

        }

        /// <------------Event case 4 End ---------------->
    }

    @Override

    public void showAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEvent, ArrayList<Event> eventList) {

        attedeesListInEvent = attedeesListInEvent;
        eventList = eventList;

        Scanner scIn = new Scanner(System.in); // this for taking integer inout

        Scanner sc = new Scanner(System.in).useDelimiter("\n"); // this is for taking String input

        // Display Choice case 2 Start Display Event Details by ID
        boolean found = false;

        // Details of all event with attendees	
        System.out.println("***********************************************");
        for (Event events2 : attedeesListInEvent.keySet()) {
            //System.out.println(events2);
            System.out.println();

            System.out.println("Enter Attendee Ticket Number that you want to Verify ");

            Scanner scc = new Scanner(System.in);
            String attedeeCheckOption = scc.nextLine();
            System.out.println("***********************************************");

            List<Attendees> x = attedeesListInEvent.get(events2);

            //System.out.println(x);
            for (Attendees aaa : x) {

                // System.out.println(aaa+ "\n \t Attendees : "+aaa.getAddendeesTicketNumber());
                if (aaa.getAddendeesTicketNumber().equals(attedeeCheckOption)) {
                    System.out.println("This Ticket is Valid...!");

                    System.out.println("Attendee Name : " + aaa.getAddendeesName());
                    System.out.println("Event Name " + events2.getEventName());
                    System.out.println("Event Time " + events2.getEventTime());
                    System.out.println("Event Date " + events2.getEventDate());

                    //	x.remove(aaa);
                    found = true;

                    // System.out.println("After Attendee Deleted"+x);
                    break;
                }
            }

        }
        System.out.println("*******************************************");

        //break;
        if (!found) {

            System.out.println("Ticket is not in the System Found Record..!");
        }

    }

    @Override
    public void removeAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEvent, ArrayList<Event> eventList) {

        attedeesListInEvent = attedeesListInEvent;
        eventList = eventList;

        Scanner scIn = new Scanner(System.in); // this for taking integer inout

        Scanner sc = new Scanner(System.in).useDelimiter("\n"); // this is for taking String input

        // Display Choice case 2 Start Display Event Details by ID
        boolean found = false;
        System.out.print("Enter The Event Id You Want To Delete From The attedee :");

        int displayChoiceId = scIn.nextInt();
        //	int x;

        Iterator<Event> itx = eventList.iterator();
        while (itx.hasNext()) {
            Event e = itx.next();
            //System.out.println("Iterator :     "+e);
            if (e.getEventId() == (displayChoiceId)) {
                //	System.out.println("Match ID "+displayChoiceId+"AND "+e);

                // Details of all event with attendees	
                System.out.println("***********************************************");
                for (Event events2 : attedeesListInEvent.keySet()) {
                    //System.out.println(events2);
                    System.out.println();
                    Event tempEvent = e;
                    //System.out.println(tempEvent);
                    if (events2.equals(tempEvent)) {

                        System.out.println("Enter AttendeeTicket Number that you want to delete  ");
                        Scanner scc = new Scanner(System.in);
                        String attedeeDeleteOption = scc.nextLine();

                        List<Attendees> x = attedeesListInEvent.get(events2);

                        System.out.println(x);

                        for (Attendees aaa : x) {
                            System.out.println(aaa + "\n \t Attendees : " + aaa.getAddendeesTicketNumber());

                            if (aaa.getAddendeesTicketNumber().equals(attedeeDeleteOption)) {

                                // System.out.println("Before Attendee Deleted"+x);
                                x.remove(aaa);

                                found = true;

                                // System.out.println("After Attendee Deleted"+x);
                                break;
                            }
                        }

                    }

                }
                System.out.println("*******************************************");

                break;

            }
            //break;

        }

        if (!found) {

            System.out.println("Ticket is not in the System Found Record..!");
        }

    }

    @Override
    public void addAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEvent, ArrayList<Event> eventList) {

        attedeesListInEvent = attedeesListInEvent;
        eventList = eventList;

        Scanner scIn = new Scanner(System.in); // this for taking integer inout

        Scanner sc = new Scanner(System.in).useDelimiter("\n"); // this is for taking String input

        /// <------------Event case 3  user Updating Event ---------------->
        //case 3  event Update   
        boolean found = false;

        List<Attendees> tempAttendeesTemp = new ArrayList<>();

        System.out.print("Enter The Event Id You Want  Add To Attendees :");
        System.out.println();

        int eventIdForNewAttendee = scIn.nextInt();
        //int x;

        Iterator<Event> iteratorEventList = eventList.iterator();
        while (iteratorEventList.hasNext()) {
            Event getEventIteam = iteratorEventList.next();
            //		System.out.println("Iterator :     "+getEventIteam);

            if (getEventIteam.getEventId() == (eventIdForNewAttendee)) {

                System.out.println("***************** Enter New Attendee Details **********************");
                for (Event eventsList : attedeesListInEvent.keySet()) {
                    //	System.out.println("eventsList :: "+eventsList);
                    //		System.out.println();
                    Event tempEventsList = getEventIteam;
                    //System.out.println(tempEvent);
                    if (eventsList.equals(tempEventsList)) {

                        ///	System.out.println(tempEventsList);
                        //System.out.println(events2+ "\n \t Attendees : "+ attedeesListInEvent.get(events2));
                        //	System.out.println();
                        tempAttendeesTemp = attedeesListInEvent.get(tempEventsList);
                        attedeesListInEvent.remove(tempEventsList);
                        break;
                    }

                }

                Attendee newAttendee = new Attendee();
                Attendees newAttendeeList = newAttendee.createAttendees();
                tempAttendeesTemp.add(newAttendeeList);
                //	System.out.println(getEventIteam+"tempAttendees "+tempAttendeesTemp);
                attedeesListInEvent.put(getEventIteam, tempAttendeesTemp);

                System.out.println("*******************************************");
                found = true;
                break;
            }
            //break;

        }

        if (!found) {
            System.out.println();
            System.out.println("Record Not Found... ");

            System.out.println();
        } else {
            System.out.println("Event Update Successfully..!");

        }

        /// <------------Event case 3 User option End Event Updating option  ---------------->
    }
//public abstract Attendees createAttendees();

    @Override
    public String toString() {

        //	String returnMessage= " Event Name : "+this.eventName+"\n Event Place : "+super.getEventPlace()+"\n Event Date : "+super.getEventDate()+"\n Event Time : "+super.getEventTime()+"\n Numner of Slots : "+super.getEventNumberOfSlot();
        return "hh";

    }
}
