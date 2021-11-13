package controller.actions;

import dataBase.EventsDataBase;
import exceptions.EventAlreadyExists;
import exceptions.InvalidActionException;
import model.events.Event;
import model.events.EventsStatus;
import model.users.User;
import view.organizer.OrganizerGui;
import view.organizer.OrganizerGuiImpl;

import java.time.LocalDate;
import java.util.List;

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
        mainMenu();
    }

    private Event chooseEvent() {
        return organizerGui.chooseEvent(eventsDataBase);
    }

    private void mainMenu() {
        try {
            int action = organizerGui.organizerMenu();
            switch (action) {
                case 1:
                    createNewEvent();
                    break;
                case 2:
                    reviewEventList();
                    break;
                case 3:
                    editEvent();
                    break;
                case 4:
                    closeEvent();
                    break;
                case 5:
                    reviewParticipants();
                    break;
                case 6:
                    startActions();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    throw new InvalidActionException("Invalid action chosen");
            }
        } catch (InvalidActionException e) {
            mainMenu();
        }
    }

    private void createNewEvent() {
        List<String> newEventData = organizerGui.createNewEvent();
        Event event = new Event(newEventData.get(0), this.organizer);
        event.getEventDescription().setDescription(newEventData.get(1));
        event.getEventDescription().setEventDate(LocalDate.parse(newEventData.get(2)));
        event.getEventDescription().setApplicationsDeadline(LocalDate.parse(newEventData.get(3)));
        try {
            eventsDataBase.addEvent(event);
        } catch (EventAlreadyExists e) {
            System.out.println("Event with this name already exists");
            createNewEvent();
        }
        mainMenu();
    }

    public void reviewEventList() {
        organizerGui.reviewEventList(eventsDataBase);
        mainMenu();
    }

    private void editEvent() {
        try {
            int action = organizerGui.editEvent();
            switch (action) {
                case 1:
                    event.setEventName(organizerGui.changeEventName());
                    event.setEventsStatus(EventsStatus.EDITED);
                    editEvent();
                    break;
                case 2:
                    event.getEventDescription().setDescription(organizerGui.changeEventDescription());
                    event.setEventsStatus(EventsStatus.EDITED);
                    editEvent();
                    break;
                case 3:
                    String date = organizerGui.changeEventDate();
                    event.getEventDescription().setEventDate(LocalDate.parse(date));
                    event.setEventsStatus(EventsStatus.EDITED);
                    editEvent();
                    break;
                case 4:
                    String deadline = organizerGui.changeApplicationDeadline();
                    event.getEventDescription().setEventDate(LocalDate.parse(deadline));
                    event.setEventsStatus(EventsStatus.EDITED);
                    editEvent();
                    break;
                case 5:
                    mainMenu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    throw new InvalidActionException("Invalid action chosen");
            }
        } catch (InvalidActionException e) {
            editEvent();
        }
    }

    private void closeEvent() {
        try {
            int action = organizerGui.closeEvent();
            switch (action) {
                case 1:
                    addEventSummary();
                    event.setEventsStatus(EventsStatus.ENDED);
                    break;
                case 2:
                    mainMenu();
                    break;
                default:
                    throw new InvalidActionException("Invalid action chosen");
            }
        } catch (InvalidActionException e) {
            reviewParticipants();
        }
    }

    private void addEventSummary() {
        String summary = organizerGui.addEventSummary();
        event.addComment(summary);
    }

    private void reviewParticipants() {
        try {
            int action = organizerGui.reviewParticipants();
            switch (action) {
                case 1:
                    reviewCandidates();
                    break;
                case 2:
                    designateAnimators();
                    break;
                case 3:
                    mainMenu();
                    break;
                case 4:
                    System.exit(0);
                default:
                    throw new InvalidActionException("Invalid action chosen");
            }
        } catch (InvalidActionException e) {
            reviewParticipants();
        }
    }

    private void reviewCandidates() {
        if (!event.getCandidates().isEmpty()) {
            int input = organizerGui.reviewCandidates(event.getCandidates());
            if (input < 1 || input > event.getCandidates().size() + 1){
                reviewCandidates();
                return;
            }
            if (input == event.getCandidates().size() + 1) {
                reviewParticipants();
                return;
            }
            int acceptedCandidateIndex = input - 1;
            User acceptedCandidate = event.getCandidates().get(acceptedCandidateIndex);
            event.acceptCandidate(acceptedCandidate);
        } else {
            System.out.println("No candidates available");
        }
        reviewParticipants();
    }

    private void designateAnimators() {
        if (!event.getParticipants().isEmpty()) {
            int input = organizerGui.designateAnimators(event.getParticipants());
            if (input < 1 || input > event.getParticipants().size() + 1){
                designateAnimators();
                return;
            }
            if (input == event.getParticipants().size() + 1) {
                reviewParticipants();
                return;
            }
            int designatedAnimatorIndex = input - 1;
            User designatedAnimator = event.getParticipants().get(designatedAnimatorIndex);
            event.addAnimator(designatedAnimator);
        } else {
            System.out.println("No participants available");
        }
        reviewParticipants();
    }
}
