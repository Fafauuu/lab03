package controller.actions;

import dataBase.EventsDataBase;
import exceptions.InvalidActionException;
import model.events.Event;
import model.users.User;
import view.participant.ParticipantGui;
import view.participant.ParticipantGuiImpl;

import java.util.Scanner;

public class ParticipantActions {
    private final EventsDataBase eventsDataBase;
    private Event event;
    private User participant;
    private final ParticipantGui participantGui;

    public ParticipantActions(EventsDataBase eventsDataBase) {
        this.eventsDataBase = eventsDataBase;
        this.participantGui = new ParticipantGuiImpl();
    }

    public void startActions() {
        event = chooseEvent();
        participant = chooseParticipant(event);
        menu();
    }

    private Event chooseEvent() {
        Event event = null;
        try {
            event = participantGui.chooseEvent(eventsDataBase);
        }catch (NullPointerException e){
            System.out.println("Invalid event");
            chooseEvent();
        }
        return event;
    }

    private User chooseParticipant(Event event) {
        return participantGui.chooseParticipant(event);
    }

    private void menu() {
        try {
            int action = participantMenu();
            switch (action) {
                case 1:
                    reviewEventList();
                    break;
                case 2:
                    reportDesireToParticipate();
                    break;
                case 3:
                    reviewEventEquipmentList();
                    break;
                case 4:
                    reportDesireToDeliverEquipment();
                    break;
                case 5:
                    startActions();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    throw new InvalidActionException("Invalid action chosen");
            }
        } catch (InvalidActionException e) {
            menu();
        }
    }

    private int participantMenu() {
        return participantGui.participantMenu(event);
    }

    public void reviewEventList() {

    }

    public void reportDesireToParticipate() {

    }

    public void reviewEventEquipmentList() {

    }

    public void reportDesireToDeliverEquipment() {

    }
}
