
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class Attendee implements AttendeeCRUDOperations {

    private String attendeesName;
    private String addendeesPhone;
    private String addendeesTicketNumber;
    private String addendeesAddress;

    public Attendee() {
        this.attendeesName = attendeesName;
        this.addendeesPhone = addendeesPhone;
        this.addendeesTicketNumber = addendeesTicketNumber;
        this.addendeesAddress = addendeesAddress;

    }

    @Override
    public Attendees createAttendees() {
        try {
            Scanner scIn = new Scanner(System.in); // this for taking integer inout

            Scanner sc = new Scanner(System.in); // this is for taking String input

            //double posX=a1.getPointX()+(this.rectWidth);
            //double posY=a1.getPointY()+(this.rectHeight);
            //Point p=new Point(posX,posY);
            System.out.println("Enter Attendee Name :");

            this.attendeesName = scIn.nextLine();
            //	this.attendeesName=attendeesName;
            System.out.println("Enter Attendee Phone :");

            this.addendeesPhone = scIn.nextLine();
            //this.addendeesPhone=addendeesPhone;

            System.out.println("Enter Attendee addendees Ticket Number :");

            this.addendeesTicketNumber = scIn.nextLine();
            //this.addendeesTicketNumber=addendeesTicketNumber;
            System.out.println("Enter Attendee addendeesAddress :");

            this.addendeesAddress = scIn.nextLine();
            //this.addendeesAddress=addendeesAddress;
        } catch (InputMismatchException e) {

            System.out.println("Sorry Invalid Entry..");

        }

        Attendees attendees = new Attendees(this.attendeesName, this.addendeesPhone, this.addendeesTicketNumber, this.addendeesAddress);
        return attendees;
    }

    //Show an Attendee into an event 
    @Override

    public void showAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEvent) {

        attedeesListInEvent = attedeesListInEvent;
     //   eventList = eventList;
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

                // Details of all event with attendees	
                System.out.println("***********************************************");

                System.out.println("Enter Attendee Ticket Number that you want to Verify ");

                Scanner scc = new Scanner(System.in);
                String attedeeCheckOption = scc.nextLine();
                for (Event eventsList : attedeesListInEvent.keySet()) {
                    //System.out.println(eventsList);
                    System.out.println();

                    System.out.println("***********************************************");

                    List<Attendees> attendeesListInAnEvent = attedeesListInEvent.get(eventsList);

                    //System.out.println(x);
                    for (Attendees attedeesInEvent : attendeesListInAnEvent) {

                        // System.out.println(attedeesInEvent+ "\n \t Attendees : "+attedeesInEvent.getAddendeesTicketNumber());
                        if (attedeesInEvent.getAddendeesTicketNumber().equals(attedeeCheckOption)) {
                            System.out.println("This Ticket is Valid...!");

                            System.out.println("Attendee Name : " + attedeesInEvent.getAddendeesName());
                            System.out.println("Event Name " + eventsList.getEventName());
                            System.out.println("Event Time " + eventsList.getEventTime());
                            System.out.println("Event Date " + eventsList.getEventDate());

                            //	x.remove(attedeesInEvent);
                            found = true;

                            // System.out.println("After Attendee Deleted"+x);
                            break;
                        }
                    }

                }
                System.out.println("*******************************************");

                //break;
                if (!found) {

                    System.out.println("Ticket is not Found in the System Record..!");
                }
            } catch (InputMismatchException e) {

                System.out.println("Sorry Invalid Entry..");

            }
        }

    }

    @Override
    public void addAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEvent) {

        attedeesListInEvent = attedeesListInEvent;
       // eventList = eventList;
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
                System.out.print("Enter The Event Id You Want To Add The attedee Into the Event : ");

                int displayChoiceId = scIn.nextInt();

                for (Event eventsDetailsOne : attedeesListInEvent.keySet()) {
                    // System.out.println("eventsDetailsOne: " + eventsDetailsOne);

                    int eventIdInListOfEvent = eventsDetailsOne.getEventId();
                    if (displayChoiceId == (eventIdInListOfEvent)) {

                        System.out.println("*******************************************");
                        System.out.print("How Many Attendee you want to Add into the Event : ");

                        int newAttendeeListSize = scIn.nextInt();
                        if (newAttendeeListSize != 0) {

                            for (int i = 0; i < newAttendeeListSize; i++) {
                                List<Attendees> attendeesListInAnEvent = attedeesListInEvent.get(eventsDetailsOne);

                                Attendee newAttendee = new Attendee();
                                Attendees newAttendeeList = newAttendee.createAttendees();
                                attendeesListInAnEvent.add(newAttendeeList);
                                //	System.out.println(getEventIteam+"tempAttendees "+tempAttendeesTemp);
                                attedeesListInEvent.put(eventsDetailsOne, attendeesListInAnEvent);
                                found = true;
                            }
                        }

                    }
                }

                if (!found) {

                    System.out.println("Attendee Details Not added into the System Record..!");
                } else {
                    System.out.println("This Attendee Details recorded into the System...!");

                    //<File Write start>
                    try ( FileOutputStream os = new FileOutputStream("EventDetails.dat");  ObjectOutputStream oos = new ObjectOutputStream(os);) {

                        oos.writeObject(attedeesListInEvent);

                        System.out.println("Data Add Into the Record..!");
                    } catch (Exception e) {

                        System.out.println(e);

                    }
                    //<File read End >

                }
            } catch (InputMismatchException e) {

                System.out.println("Sorry Invalid Entry..");

            }
        }

    }

    @Override
    public void removeAnAttendeeIntoEvent(HashMap<Event, List<Attendees>> attedeesListInEvent) {

        attedeesListInEvent = attedeesListInEvent;
       // eventList = eventList;
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
                System.out.print("Enter The Event Id You Want To Delete The attedee :");

                int displayChoiceId = scIn.nextInt();

                for (Event eventsDetailsOne : attedeesListInEvent.keySet()) {
                    // System.out.println("eventsDetailsOne: " + eventsDetailsOne);

                    int eventIdInListOfEvent = eventsDetailsOne.getEventId();
                    if (displayChoiceId == (eventIdInListOfEvent)) {
                        // System.out.println(displayChoiceId + "Event Id Found Id " + eventIdInListOfEvent);

                        // Details of all event with attendees	
                        System.out.println("***********************************************");

                        System.out.println("Enter Attendee Ticket Number that you want to Delete.. ");

                        Scanner scc = new Scanner(System.in);
                        String attedeeCheckOption = scc.nextLine();
                        for (Event eventsList : attedeesListInEvent.keySet()) {
                            //System.out.println(eventsList);
                            System.out.println();

                            System.out.println("***********************************************");

                            List<Attendees> attendeesListInAnEvent = attedeesListInEvent.get(eventsList);

                            //System.out.println(x);
                            for (Attendees attedeesInEvent : attendeesListInAnEvent) {

                                // System.out.println(attedeesInEvent+ "\n \t Attendees : "+attedeesInEvent.getAddendeesTicketNumber());
                                if (attedeesInEvent.getAddendeesTicketNumber().equals(attedeeCheckOption)) {
                                    System.out.println("This Ticket is Valid and Now Removed From The Records...!");

                                    attendeesListInAnEvent.remove(attedeesInEvent);
                                    found = true;

                                    // System.out.println("After Attendee Deleted"+x);
                                    break;
                                }
                            }

                        }
                        System.out.println("*******************************************");

                    }
                }

                if (!found) {

                    System.out.println("Ticket is not in the System Found Record..!");
                } else {

                    //<File Write start>
                    try ( FileOutputStream os = new FileOutputStream("EventDetails.dat");  ObjectOutputStream oos = new ObjectOutputStream(os);) {

                        oos.writeObject(attedeesListInEvent);
                        System.out.println("This Attendee is Removed from the System Record..!");

                        // System.out.println("Data Add Into the Record..!");
                    } catch (Exception e) {

                        System.out.println(e);

                    }
                    //<File read End >

                }
            } catch (InputMismatchException e) {

                System.out.println("Sorry Invalid Entry..");

            }
        }

    }

    @Override
    public String toString() {

        String returnMessage = " \nAttendee Name : " + this.attendeesName + "\n Attendee Phone : " + this.addendeesPhone + "\n Attendee Ticket Numner : " + this.addendeesTicketNumber + "\n Attendee Address : " + this.addendeesAddress;

        return returnMessage;
    }

}
