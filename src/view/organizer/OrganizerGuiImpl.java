package view.organizer;

import dataBase.EventsDataBase;
import model.events.Event;

import java.util.Scanner;

public class OrganizerGuiImpl implements OrganizerGui{

    @Override
    public Event chooseEvent(EventsDataBase eventsDataBase) {
        System.out.println("Choose event:");
        int index = 1;
        for (Event event : eventsDataBase.getEventList()) {
            System.out.println(index + " - " + event.getEventName() + " - organizer: " + event.getOrganizer());
            index++;
        }
        Scanner scanner = new Scanner(System.in);
        int chosenEventIndex = scanner.nextInt();

        Event event = null;
        try {
            event = eventsDataBase.getEventList().get(chosenEventIndex-1);
        }catch (Exception e){
            System.out.println("Invalid event");
            chooseEvent(eventsDataBase);
        }
        return event;
    }

    @Override
    public int organizerMenu(Event event) {
        System.out.println("Choose action:");
        System.out.println("1 - Review event list");
        System.out.println("2 - Edit event");
        System.out.println("3 - Review participants");
        System.out.println("4 - Choose different organizer");
        System.out.println("5 - Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
