package view.participant;

import dataBase.EventsDataBase;
import model.events.Event;
import model.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

        Event event;
        try {
            event = eventsDataBase.getEventList().get(chosenEventIndex-1);
        }catch (Exception e){
            System.out.println("Invalid event\n");
            event = chooseEvent(eventsDataBase);
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
        System.out.println("5 - Read comments");
        System.out.println("6 - Choose different participant");
        System.out.println("7 - Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void reviewEventList(EventsDataBase eventsDataBase) {
        System.out.println("\nEVENT LIST");
        int eventIndex = 1;
        for (Event event : eventsDataBase.getEventList()) {
            System.out.println(eventIndex + " - " + event.getEventName());
            eventIndex++;
            System.out.println(event);
        }
    }

    @Override
    public int reportDesireToParticipate(EventsDataBase eventsDataBase) {
        System.out.println("\nEVENT LIST");
        int eventIndex = 1;
        for (Event event : eventsDataBase.getEventList()) {
            System.out.println(eventIndex + " - " + event.getEventName());
            eventIndex++;
        }
        System.out.println(eventIndex + " - GO BACK");
        System.out.println("\n Choose event to participate");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void reviewEquipmentList(Event event) {
        System.out.println("\nEQUIPMENT DEMANDS");
        int index = 1;
        Map<String, Integer> demands = event.getEventEquipmentList().getEquipmentDemand();
        for (String equipmentDemanded : demands.keySet()) {
            System.out.println(index + " - " + equipmentDemanded + " amount: " + demands.get(equipmentDemanded));
            index++;
        }
        System.out.println();
    }

    @Override
    public List<String> reportEquipmentDeliveryProposition(User participant) {
        List<String> data = new ArrayList<>();
        System.out.println("REPORT EQUIPMENT DELIVERY PROPOSITION");
        data.add(participant.getName());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Equipment name: ");
        data.add(scanner.nextLine());
        System.out.print("Amount");
        data.add(scanner.nextLine());
        return data;
    }

    @Override
    public void readComments(Event event) {
        if (event.getComments().isEmpty()){
            System.out.println("No comments added yet");
        }
        for (String comment : event.getComments()) {
            System.out.println(comment);
        }
    }
}
