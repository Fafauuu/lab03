package controller.actions;

import dataBase.EventsDataBase;
import exceptions.InvalidActionException;
import model.events.Event;
import model.users.User;
import view.organizer.OrganizerGui;
import view.organizer.OrganizerGuiImpl;

public class OrganizerActions {
    private final EventsDataBase eventsDataBase;
    private Event event;
    private User organizer;
    private final OrganizerGui organizerGui;

    public OrganizerActions(EventsDataBase eventsDataBase) {
        this.eventsDataBase = eventsDataBase;
        this.organizerGui = new OrganizerGuiImpl();
    }

    public void startActions() {
        event = chooseEvent();
        organizer = event.getOrganizer();
        menu();
    }

    private Event chooseEvent() {
        return organizerGui.chooseEvent(eventsDataBase);
    }

    private void menu() {
        int action;
        try {
            action = organizerMenu();
            switch (action) {
                case 1:
                    reviewEventList();
                    break;
                case 2:
                    editEvent();
                    break;
                case 3:
                    reviewParticipants();
                    break;
                case 4:
                    startActions();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    throw new InvalidActionException("Invalid action chosen");
            }
        } catch (InvalidActionException e) {
            menu();
        }
    }

    private int organizerMenu() {
        return organizerGui.organizerMenu(event);
    }

    public void reviewEventList() {
    }

    public void editEvent() {

    }

    public void reviewParticipants() {

    }
}
