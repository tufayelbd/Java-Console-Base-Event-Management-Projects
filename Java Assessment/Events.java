
import java.util.ArrayList;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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

    public int getEventId() {
        return this.eventId;
    }

    @Override
    public Event createEvent2() {

        Scanner scIn = new Scanner(System.in); // this for taking integer inout

        Scanner sc = new Scanner(System.in).useDelimiter("\n"); // this is for taking String input

        System.out.println("Enter Event Details :");
        System.out.println("Event Id");
        this.eventId = scIn.nextInt();
        System.out.println();
        //this.eventId=eventId;

        System.out.println("Event name");
        this.eventName = sc.nextLine();
        System.out.println();
        //this.eventName=eventName;
        System.out.println("Event Time ");
        this.eventTime = sc.nextLine();
        //this.eventTime=eventTime;
        System.out.println();
        System.out.println("Event Place ");
        this.eventPlace = sc.nextLine();
        //this.eventPlace=eventPlace;
        System.out.println();
        System.out.println("Event Date ");
        this.eventDate = sc.nextLine();
        System.out.println();
        //	this.eventDate=eventDate;
        System.out.println("Event Slot");
        this.eventSlot = scIn.nextInt();
        System.out.println();
        //this.eventSlot=eventSlot;

        Event refEvent = new Event(this.eventId, this.eventName, this.eventTime, this.eventPlace, this.eventDate, this.eventSlot);

        return refEvent;
    }

    @Override
    public Event createEvent(HashMap<Event, List<Attendees>> attedeesListInEvent) {
        attedeesListInEvent = attedeesListInEvent;

        boolean eventIdExist = false;
         
        //HashMap<Event, List<Attendees>> attedeesListInEvent = new HashMap<>();

        Scanner scIn = new Scanner(System.in); // this for taking integer inout

        Scanner sc = new Scanner(System.in).useDelimiter("\n"); // this is for taking String input

        try ( FileInputStream is = new FileInputStream("EventDetails.dat");  ObjectInputStream ois = new ObjectInputStream(is);) {

            //	List<Student> students = (List<Student>) ois.readObject();
            attedeesListInEvent = (HashMap<Event, List<Attendees>>) ois.readObject();
            //System.out.println(attedeesListInEvent);

        } catch (Exception e) {

            System.out.println("There is No File Record Found");
            //break;
        }
        System.out.println("Enter Event Details :");
        System.out.println("Event Id");

        try {

            do {

                this.eventId = scIn.nextInt();
                System.out.println();

                for (Event eventsDetailsOne : attedeesListInEvent.keySet()) {

                    int eventIdInListOfEvent = eventsDetailsOne.getEventId();
                    if (eventId == (eventIdInListOfEvent)) {
						
                        System.out.println("This Event ID Already Exists ...Please Try With Different ID...\nEnter 0 for Back to Menu.");
                        eventIdExist = true;
                        if(eventId==0){
							// if exit then press 0 for exit from creating event 
							eventIdExist = false;
							break;
						}
						break;

                    } else {
                        eventIdExist = false;

                    }

                }

            } while (eventIdExist != false);
			
			if(eventId!=0){
				
            System.out.println("Event name ");
            this.eventName = sc.nextLine();
            System.out.println();
            //this.eventName=eventName;
            System.out.println("Event Time ");
            this.eventTime = sc.nextLine();
            //this.eventTime=eventTime;
            System.out.println();
            System.out.println("Event Place ");
            this.eventPlace = sc.nextLine();
            //this.eventPlace=eventPlace;
            System.out.println();
            System.out.println("Event Date ");
            this.eventDate = sc.nextLine();
            System.out.println();
            //	this.eventDate=eventDate;
            System.out.println("Event Slot");
            this.eventSlot = scIn.nextInt();
            System.out.println();
            //this.eventSlot=eventSlot;
            //eventList.add(oneEvent);  

			}
			
        } catch (InputMismatchException e) {

            System.out.println("Sorry Enter an Valid Number..");

        }

        Event refEvent = new Event(this.eventId, this.eventName, this.eventTime, this.eventPlace, this.eventDate, this.eventSlot);

        return refEvent;
    }

    @Override
    public void updateEvent(HashMap<Event, List<Attendees>> attedeesListInEvent) {

        attedeesListInEvent = attedeesListInEvent;
        
        boolean isFile = true;
        try ( FileInputStream is = new FileInputStream("EventDetails.dat");  ObjectInputStream ois = new ObjectInputStream(is);) {

            //	List<Student> students = (List<Student>) ois.readObject();
            attedeesListInEvent = (HashMap<Event, List<Attendees>>) ois.readObject();

        } catch (Exception e) {
            isFile = false;
            System.out.println("There is No File  Record Found");

        }
        if (isFile == true) {
            try {

                Scanner scIn = new Scanner(System.in); // this for taking integer inout

                Scanner sc = new Scanner(System.in).useDelimiter("\n"); // this is for taking String input

                boolean found = false;
                //List tempAttendees = new ArrayList();
                List<Attendees> tempAttendees = new ArrayList<>();

                System.out.print("Enter The Event Id You Want To Update :");

                int updateChoiceId = scIn.nextInt();
                //int x;

                for (Event eventsDetailsOne : attedeesListInEvent.keySet()) {

                    int eventIdInListOfEvent = eventsDetailsOne.getEventId();
                    if (updateChoiceId == (eventIdInListOfEvent)) {
                        System.out.println("Found Id ");
                        found = true;

                        List<Attendees> attendeesListInAnEvent = attedeesListInEvent.get(eventsDetailsOne);

                        attedeesListInEvent.remove(eventsDetailsOne);

                        Events tempEvents = new Events();

                        //Create an Event and add it into the event List
                        Event oneEventTemp = tempEvents.createEvent2();
                       //deleteEvent eventList.add(oneEventTemp);

                        //			System.out.println(oneEventTemp+"tempAttendees "+tempAttendees);
                        attedeesListInEvent.put(oneEventTemp, tempAttendees);

                        break;

                    }

                }

                if (!found) {
                    System.out.println();
                    System.out.println("Record Not Found... ");

                    System.out.println();
                } else {

                    //<File Write start>
                    try ( FileOutputStream os = new FileOutputStream("EventDetails.dat");  ObjectOutputStream oos = new ObjectOutputStream(os);) {

                        oos.writeObject(attedeesListInEvent);

                    } catch (Exception e) {

                        System.out.println("Data is not inserting ....");

                    }
                    //<File read End >

                    System.out.println("Event Update Successfully..!");

                }
            } catch (InputMismatchException e) {

                System.out.println("Sorry Invalid Entry..");

            }
        }

        /// <------------Event case 3 User option End Event Updating option  ---------------->
    }

    //Delete an event option start
    @Override
    public void deleteEvent(HashMap<Event, List<Attendees>> attedeesListInEvent) {

        attedeesListInEvent = attedeesListInEvent;
        //eventList = eventList;
        boolean isFile = true;
        try ( FileInputStream is = new FileInputStream("EventDetails.dat");  ObjectInputStream ois = new ObjectInputStream(is);) {

            //	List<Student> students = (List<Student>) ois.readObject();
            attedeesListInEvent = (HashMap<Event, List<Attendees>>) ois.readObject();

        } catch (Exception e) {

            System.out.println("There is No Record Found");
            isFile = false;
        }
        if (isFile == true) {
            try {
                Scanner scIn = new Scanner(System.in); // this for taking integer inout

                Scanner sc = new Scanner(System.in).useDelimiter("\n"); // this is for taking String input

                // Display Choice case 2 Start Display Event Details by ID
                boolean found = false;
                System.out.print("Enter The Event Id You Want To Delete :");

                int deleteEventChoiceId = scIn.nextInt();

                for (Event eventsDetailsOne : attedeesListInEvent.keySet()) {

                    int eventIdInListOfEvent = eventsDetailsOne.getEventId();
                    if (deleteEventChoiceId == (eventIdInListOfEvent)) {
                        System.out.println("Found Id ");
                        found = true;
                        attedeesListInEvent.remove(eventsDetailsOne);
                        break;

                    }

                }

                if (!found) {

                    System.out.println("There is no Event Found in the System Record..!");
                } else {
                    System.out.println("The Event is Removed from the System Record..!");

                    //<File Write start>
                    try ( FileOutputStream os = new FileOutputStream("EventDetails.dat");  ObjectOutputStream oos = new ObjectOutputStream(os);) {

                        oos.writeObject(attedeesListInEvent);

                    } catch (Exception e) {

                        System.out.println("Data is not inserting ....");

                    }
                    //<File read End >

                }
            } catch (InputMismatchException e) {

                System.out.println("Sorry Invalid Entry..");

            }
        }

    }

    // Delete an event option end 
}
