package userActions;

import dataBase.EventsDataBase;
import exceptions.InvalidActionException;
import exceptions.UserAlreadyParticipates;
import model.events.Event;
import model.users.User;
import view.participant.ParticipantGui;
import view.participant.ParticipantGuiImpl;

import java.util.List;

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
        try {
            event = chooseEvent();
            participant = chooseParticipant(event);
        }catch (UserAlreadyParticipates e){
            startActions();
        }
        mainMenu();
    }

    private Event chooseEvent() {
        Event event = null;
        try {
            event = participantGui.chooseEvent(eventsDataBase);
        } catch (NullPointerException e) {
            System.out.println("Invalid event\n");
            chooseEvent();
        }
        return event;
    }

    private User chooseParticipant(Event event) throws UserAlreadyParticipates{
        if (event.getParticipants().isEmpty()){
            System.out.println("No participants available");
            throw new UserAlreadyParticipates(participant + " already participates in: " + event.getEventName());
        }
        return participantGui.chooseParticipant(event);
    }

    private void mainMenu() {
        try {
            int action = participantGui.participantMenu(event);
            switch (action) {
                case 1:
                    reviewEventList();
                    break;
                case 2:
                    try {
                        reportDesireToParticipate();
                    } catch (UserAlreadyParticipates e) {
                        System.out.println(e.getMessage());
                        mainMenu();
                    }
                    break;
                case 3:
                    reviewEventEquipmentList();
                    break;
                case 4:
                    reportDesireToDeliverEquipment();
                    break;
                case 5:
                    readComments();
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

    private void readComments() {
        participantGui.readComments(event);
        mainMenu();
    }

    public void reviewEventList() {
        participantGui.reviewEventList(eventsDataBase);
        mainMenu();
    }

    public void reportDesireToParticipate() throws UserAlreadyParticipates {
        int input = participantGui.reportDesireToParticipate(eventsDataBase);
        if (input > 0 && input <= eventsDataBase.getEventList().size() + 1){
            if (input == eventsDataBase.getEventList().size() + 1) {
                mainMenu();
            }
            Event eventToParticipate = eventsDataBase.getEventList().get(input - 1);
            if(userAlreadyParticipates(eventToParticipate)) {
                throw new UserAlreadyParticipates(participant
                        + " already participates in: " + eventToParticipate.getEventName());
            }
            else {
                eventToParticipate.addCandidate(participant);
                eventsDataBase.update(eventToParticipate);
                mainMenu();
            }
        } else {
            reportDesireToParticipate();
        }
    }

    private boolean userAlreadyParticipates(Event event) {
        User organizer = event.getOrganizer();
        List<User> animatorsList = event.getAnimators();
        List<User> participantList = event.getParticipants();
        List<User> candidatesList = event.getCandidates();
        if (participant.equals(organizer)) return true;
        for (User user : animatorsList) {
            if (user.equals(participant)) return true;
        }
        for (User user : participantList) {
            if (user.equals(participant)) return true;
        }
        for (User user : candidatesList) {
            if(user.equals(participant)) return true;
        }
        return false;
    }

    public void reviewEventEquipmentList() {
        participantGui.reviewEquipmentList(event);
        mainMenu();
    }

    public void reportDesireToDeliverEquipment() {
        List<String> deliveryProposition = participantGui.reportEquipmentDeliveryProposition(participant);
        boolean equipmentFound = false;
        for (String equipmentName : event.getEventEquipmentList().getEquipmentDemand().keySet()) {
            if (equipmentName.equals(deliveryProposition.get(1))) {
                event.getEventEquipmentList().addEquipmentOffer(deliveryProposition);
                equipmentFound = true;
            }
        }
        if (!equipmentFound) {
            System.out.println("Invalid equipment name\n");
        }
        eventsDataBase.update(event);
        mainMenu();
    }
}
