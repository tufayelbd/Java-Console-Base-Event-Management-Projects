  
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.InputMismatchException;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class EventManagementSystem {

    public static void main(String[] args) throws IOException {

        // creating Map as event has attendees and attedee will be list 
        HashMap<Event, List<Attendees>> attedeesListInEvent = new HashMap<>();

     //   ArrayList<Event> eventList = new ArrayList<>(); //in event list

        Scanner scIn = new Scanner(System.in); // this for taking integer inout

        Scanner sc = new Scanner(System.in); // this is for taking String input

        System.out.println("*******************************************************************");
        System.out.println("*               Welcome To Event Management System                *");
        System.out.println("*                                                                 *");
        System.out.println("*******************************************************************");

        System.out.println("Enter The User Name: ");

        String userName = sc.nextLine();;
        System.out.println("Enter The User Password : ");

        String password = sc.nextLine();

        //int logIn=sc.nextInt();
        if (userName.equals("Tufayel") && password.equals("12345")) {

            boolean menuExit = false;
            String choice;
            do {
				

                System.out.println("*******************************************************************");
                System.out.println("*               Welcome To Event Management System                *");
                System.out.println("*                                                                 *");
                System.out.println("*******************************************************************");
                System.out.println("----------------------Enter Your Choice----------------------------");
                System.out.println("|                 1: Create The Event                              |");
                System.out.println("|                 2: Display Event                                 |");
                System.out.println("|                 3: Update An Event                               |");
                System.out.println("|                 4: Delete An Event                               |");
                System.out.println("|                 5: Add en Attendee Into An Event                 |");
                System.out.println("|                 6: Remove en Attendee From An Event              |");
                System.out.println("|                 7: Verify The Ticket                             |");
                System.out.println("| NB: Enter 0 for exit...!                                         |");
                System.out.println("--------------------------------------------------------------------");

                choice = sc.next();
                switch (choice) {

                    case "1":
                        Events events = new Events();
                        Event oneEvent = events.createEvent(attedeesListInEvent);

                        //eventList.add(oneEvent);
                        ArrayList<Attendees> attendeesList = new ArrayList<>();

                        int eventSlot = events.getNumberOfEventSlot();
                        int eventIdCheck = events.getEventId();
                        if (eventSlot <= 0 || eventIdCheck <= 0) {
                            break;
                        }
                        try {
                            Attendee attendee = new Attendee();

                            System.out.println(" How Many Attendee You Want [NB: Your number of event solt is : " + eventSlot + "]");
                            int attedeesSize;

                            while (true) {

                                attedeesSize = sc.nextInt();

                                // check event slot available for attedees
                                if (attedeesSize <= eventSlot) {
                                    break;
                                } else {
                                    if (attedeesSize != 0) {
                                        if (attedeesSize < 0) {
                                            System.out.println("Your Attendee List Out Of Slots, Please Update your event and enter a valid attedees number !\n Thanks! ");
                                        }
                                    } else {
                                        System.out.println("You Create An Event With Out Attendees !\n Thanks! ");

                                    }

                                }

                            }

                            if (attedeesSize != 0) {
                                for (int j = 0; j < attedeesSize; j++) {

                                    Attendees oneAttendee = attendee.createAttendees();

                                    attendeesList.add(oneAttendee); // it will call createAttendees() methods number of attendee size from Attedees class and add into the attendee list
                                    //	System.out.println(oneAttendee);
                                }
                            }
                            if (eventSlot == 0) {
                                System.out.println("You Have No Slot For this Event..!\n If you need more attedee,Please Update the Event...\nThank You...!");

                            }

                            attedeesListInEvent.put(oneEvent, attendeesList);
                        } catch (InputMismatchException e) {

                            System.out.println("Sorry Enter an Valid Number..");
                            break;

                        }

                        //<File Write start>
                        try ( FileOutputStream os = new FileOutputStream("EventDetails.dat");  ObjectOutputStream oos = new ObjectOutputStream(os);) {

                            oos.writeObject(attedeesListInEvent);

                            System.out.println("Data Add Into the Record..!");
                        } catch (Exception e) {

                            System.out.println(e);

                        }
                        //<File Write End >

                        break;

                    //<Creating An Event in user choice case 1 End>
                    /// <------------Event case 2 User Display Option start---------------->
                    case "2":
                        System.out.println();

                        try ( FileInputStream is = new FileInputStream("EventDetails.dat");  ObjectInputStream ois = new ObjectInputStream(is);) {
                            attedeesListInEvent = (HashMap<Event, List<Attendees>>) ois.readObject();

                        } catch (Exception e) {

                            System.out.println("There is File Record Found in The System");
                            break;

                        }

                        System.out.println("*****************************************************");
                        System.out.println("         1: Show all Event Name and ID  :");
                        System.out.println("         2: Display Event by your Given ID: ");
                        System.out.println("         3: Display All Event Details : ");
                        System.out.println("        Enter Your Choice :\n ");

                        System.out.println("*****************************************************");

                        String displayChoice = sc.next();

                        switch (displayChoice) {
                            // Dsiplay Choice Case 1 start  Event name and ID in The System Start
                            case "1":
                                System.out.println("**************** List of All Events in The System **************");
                                System.out.println();

                                for (Event eventsDetailsOne : attedeesListInEvent.keySet()) {
                                    System.out.println("Event Name : " + eventsDetailsOne.getEventName() + "\t And Event Id: " + eventsDetailsOne.getEventId());

                                }
                                System.out.println("******************************************************************");
                                System.out.println();
                                break;

                            // Dsiplay Choice Case 1 start  Event name and ID in The System End
                            case "2":
                                    // Display Choice case 2 Start Display Event Details by ID
									try {
                                boolean found = false;
                                System.out.print("Enter The Event Id You Want To Disply :");

                                int displayChoiceId = scIn.nextInt();

                                for (Event eventsDetailsOne : attedeesListInEvent.keySet()) {
                                    //  System.out.println("Event Name : " + eventsDetailsOne.getEventName() + "\t And Event Id: " + eventsDetailsOne.getEventId());

                                    int eventId = eventsDetailsOne.getEventId();

                                    if (eventId == (displayChoiceId)) {
                                        //	System.out.println("Match ID "+displayChoiceId+"AND "+e);

                                        // Details of all event with attendees	
                                        System.out.println("***********************************************");
                                        System.out.println();
                                        //System.out.println(tempEvent);

                                        System.out.println(" Enter 1 for Show Event Details with Anttendees ");
                                        System.out.println(" Enter 2 for Show Only  Event Details ");
                                        System.out.println(" Enter 3 for Show Only  Attendee Details ");

                                        System.out.println("***********************************************");
                                        int eventOption = scIn.nextInt();

                                        List attedeeListAnEvent = attedeesListInEvent.get(eventsDetailsOne);
                                        if (eventOption == 1) {
                                            // Show Event Details with Anttendees

                                            int attedeeListSize = attedeeListAnEvent.size();

                                            System.out.println("Event Details :");
                                            System.out.println(eventsDetailsOne);
                                            //	System.out.println("Event "+events2+ "\n \t Attendees : "+ x);
                                            if (attedeeListSize != 0) {
                                                System.out.println("\n Attendees are : \n ");
                                                for (int i = 0; i < attedeeListSize; i++) {
                                                    System.out.println(attedeeListAnEvent.get(i));
                                                }
                                            } else {
                                                System.out.println("\nThere is no Attendees in this Event  ");
                                            }
                                            System.out.println();

                                        } else if (eventOption == 2) {
                                            //only show event details
                                            System.out.println(eventsDetailsOne);

                                        } else if (eventOption == 3) {
                                            // only show attedees details in given id 
                                            int attedeeListSize = attedeeListAnEvent.size();
                                            if (attedeeListSize <= 0) {
                                                System.out.println("There is no attedee for this event..!");
                                            } else {
                                                for (int i = 0; i < attedeeListSize; i++) {
                                                    System.out.println(attedeeListAnEvent.get(i));
                                                }
                                            }
                                            System.out.println();

                                        }

                                        System.out.println("*******************************************");
                                        found = true;
                                        break;

                                    }

                                }

                                if (!found) {

                                    System.out.println("Record Not Found ");
                                }

                            } catch (InputMismatchException e) {

                                System.out.println("Sorry Invalid Entry..");

                            }

                            break;
                            // Display Choice case 2 End

                            // Display Choice case 2 END  Display Event Details by ID
                            // Display Choice case 3 Start
                            case "3":

                                // Details of all event with attendees	
                                System.out.println("***************** All events with attendees**********************");
                                for (Event eventsDetailsOne : attedeesListInEvent.keySet()) {

                                    List attedeeListAnEvent = attedeesListInEvent.get(eventsDetailsOne);
                                    int attedeeListSize = attedeeListAnEvent.size();
                                    int eventId = eventsDetailsOne.getEventId();

                                    System.out.println("Event Id : " + eventId + "Details \n " + eventsDetailsOne);
                                    //	System.out.println("Event "+events2+ "\n \t Attendees : "+ x);
                                    if (attedeeListSize != 0) {
                                        System.out.println("\n Attendees are :");
                                        for (int i = 0; i < attedeeListSize; i++) {
                                            System.out.println(attedeeListAnEvent.get(i));
                                        }
                                    } else {
                                        System.out.println("\nThere is no Attendees in this Event  ");
                                    }
                                    System.out.println();

                                }

                                System.out.println("*******************************************");

                                break;
                            default:
                                System.out.println("Sorry. Wrong User Option..");
                                break;
                            // Display Choice case 3 End
                            }

                        break;

                    /// <------------Event case 2 User Display Option End---------------->
                    /// <------------Event case 3  user Updating Event ---------------->
                    //case 3  event Update   
                    case "3":

                        Events refEventUpdate = new Events();
                        refEventUpdate.updateEvent(attedeesListInEvent);

                        break;

                    /// <------------Event case 4 Start Delete An event From the System By Id---------------->
                    //case 4 delete an event by id 
                    case "4":

                        Events refEventDelete = new Events();
                        refEventDelete.deleteEvent(attedeesListInEvent);

                        break;

                    case "5":

                        Attendee refEventAddAttendee = new Attendee();
                        refEventAddAttendee.addAnAttendeeIntoEvent(attedeesListInEvent);

                        break;

                    case "6":
                        Attendee refEventDeleteAttendee = new Attendee();
                        refEventDeleteAttendee.removeAnAttendeeIntoEvent(attedeesListInEvent);

                        break;
                    // Display Choice case 2 End
                    case "7":
                        Attendee refEventshowAnAttendeeByTicket = new Attendee();
                        refEventshowAnAttendeeByTicket.showAnAttendeeIntoEvent(attedeesListInEvent);
                        break;
                    case "0":
                        menuExit = true;
                        System.out.println("Bye..!");
                        break;
                    // Display Choice case 2 END  Display Event Details by ID
                    // Display Choice case 3 Start
                    }

            } while (menuExit != true);

        } else {
            System.out.println("***************************************************");
            System.out.println("Sorry User Name and Password Invalid..!");
            System.out.println("Try again!");
            System.out.println("***************************************************");
        }

    }

}
