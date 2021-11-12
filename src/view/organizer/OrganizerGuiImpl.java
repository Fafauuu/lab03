package view.organizer;

import dataBase.EventsDataBase;
import model.events.Event;
import model.users.User;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrganizerGuiImpl implements OrganizerGui{

    @Override
    public Event chooseEvent(EventsDataBase eventsDataBase) {
        System.out.println("ORGANIZER INTERFACE");
        System.out.println("Choose organizer of an event:");
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
    public int organizerMenu() {
        System.out.println("\nMAIN MENU");
        System.out.println("Choose action:");
        System.out.println("1 - Review event list");
        System.out.println("2 - Edit event");
        System.out.println("3 - Review participants");
        System.out.println("4 - Choose different organizer");
        System.out.println("5 - EXIT");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public int editEvent() {
        System.out.println("\nChoose action:");
        System.out.println("1 - Change event name");
        System.out.println("2 - Change description");
        System.out.println("3 - Change date");
        System.out.println("4 - Change application deadline");
        System.out.println("5 - MAIN MENU");
        System.out.println("6 - EXIT");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public String changeEventName() {
        System.out.println("\nEnter new event name:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public String changeEventDescription() {
        System.out.println("\nEnter new event description:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public Date changeEventDate() {
        return null;
    }

    @Override
    public Date changeApplicationDeadline() {
        return null;
    }

    @Override
    public int reviewParticipants() {
        System.out.println("\nChoose action");
        System.out.println("1 - Review candidates");
        System.out.println("2 - Designate animators");
        System.out.println("3 - MAIN MENU");
        System.out.println("4 - EXIT");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public int reviewCandidates(List<User> candidates) {
        System.out.println("\nChoose candidate to accept as participant");
        int index = 1;
        for (User candidate : candidates) {
            System.out.println(index + " - " + candidate);
            index++;
        }
        System.out.println(index + " - GO BACK");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public int designateAnimators(List<User> participants) {
        System.out.println("\nChoose participant to designate as animator");
        int index = 1;
        for (User participant : participants) {
            System.out.println(index + " - " + participant);
            index++;
        }
        System.out.println(index + " - GO BACK");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
