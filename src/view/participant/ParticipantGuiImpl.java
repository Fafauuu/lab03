package view.participant;

import dataBase.EventsDataBase;
import model.events.Event;
import model.users.User;

import java.util.Scanner;

public class ParticipantGuiImpl implements ParticipantGui{
    @Override
    public Event chooseEvent(EventsDataBase eventsDataBase) {
        System.out.println("Choose event:");
        int index = 1;
        for (Event event : eventsDataBase.getEventList()) {
            System.out.println(index + " - " + event.getEventName() + " - participants: " + event.getParticipants());
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
    public User chooseParticipant(Event event) {
        System.out.println("Choose participant");
        int index = 1;
        for (User participant : event.getParticipants()) {
            System.out.println(index + " - " + participant);
            index++;
        }
        Scanner scanner = new Scanner(System.in);
        int chosenParticipantIndex = scanner.nextInt();

        User user = null;
        try {
            user = event.getParticipants().get(chosenParticipantIndex-1);
        }catch (Exception e){
            System.out.println("Invalid participant");
            chooseParticipant(event);
        }
        return user;
    }

    @Override
    public int participantMenu(Event event) {
        System.out.println("Choose action:");
        System.out.println("1 - Review event list");
        System.out.println("2 - Report desire to participate");
        System.out.println("3 - Review event equipment list");
        System.out.println("4 - Report desire to deliver equipment");
        System.out.println("5 - Choose different participant");
        System.out.println("6 - Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
