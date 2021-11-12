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
        try {
            int action = organizerGui.organizerMenu();
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

    public void reviewEventList() {
        System.out.println(eventsDataBase.getEventList());
        menu();
    }

    private void editEvent() {
        try {
            int action = organizerGui.editEvent();
            switch (action) {
                case 1:
                    event.setEventName(organizerGui.changeEventName());
                    editEvent();
                    break;
                case 2:
                    event.getEventDescription().setDescription(organizerGui.changeEventDescription());
                    editEvent();
                    break;
                case 3:
                    event.getEventDescription().setEventDate(organizerGui.changeEventDate());
                    editEvent();
                    break;
                case 4:
                    event.getEventDescription().setApplicationsDeadline(organizerGui.changeApplicationDeadline());
                    editEvent();
                    break;
                case 5:
                    menu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    throw new InvalidActionException("Invalid action chosen");
            }
        } catch (InvalidActionException e) {
            reviewEventList();
        }
    }

    private void reviewParticipants() {
        try {
            int action = organizerGui.reviewParticipants();
            switch (action) {
                case 1:
                    if (!event.getCandidates().isEmpty()){
                        int input = organizerGui.reviewCandidates(event.getCandidates());
                        if (input == event.getCandidates().size() + 1){
                            reviewParticipants();
                            break;
                        }
                        int acceptedCandidateIndex = input - 1;
                        User acceptedCandidate = event.getCandidates().get(acceptedCandidateIndex);
                        event.acceptCandidate(acceptedCandidate);
                    } else {
                        System.out.println("No candidates available");
                    }
                    reviewParticipants();
                    break;
                case 2:
                    if (!event.getParticipants().isEmpty()){
                        int input = organizerGui.designateAnimators(event.getParticipants());
                        if (input == event.getParticipants().size() + 1){
                            reviewParticipants();
                            break;
                        }
                        int designatedAnimatorIndex = input - 1;
                        User designatedAnimator = event.getParticipants().get(designatedAnimatorIndex);
                        event.addAnimator(designatedAnimator);
                    } else {
                        System.out.println("No participants available");
                    }
                    reviewParticipants();
                    break;
                case 3:
                    menu();
                    break;
                case 4:
                    System.exit(0);
                default:
                    throw new InvalidActionException("Invalid action chosen");
            }
        } catch (InvalidActionException e) {
            reviewEventList();
        }
    }
}
