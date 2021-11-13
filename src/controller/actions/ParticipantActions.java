package controller.actions;

import dataBase.EventsDataBase;
import exceptions.InvalidActionException;
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
        event = chooseEvent();
        participant = chooseParticipant(event);
        mainMenu();
    }

    private Event chooseEvent() {
        Event event = null;
        try {
            event = participantGui.chooseEvent(eventsDataBase);
        }catch (NullPointerException e){
            System.out.println("Invalid event\n");
            chooseEvent();
        }
        return event;
    }

    private User chooseParticipant(Event event) {
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
            mainMenu();
        }
    }

    public void reviewEventList() {
        participantGui.reviewEventList(eventsDataBase);
        mainMenu();
    }

    public void reportDesireToParticipate() {
        int input = participantGui.reportDesireToParticipate(eventsDataBase);
        if (input == eventsDataBase.getEventList().size() + 1){
            mainMenu();
            return;
        }
        if (input <= eventsDataBase.getEventList().size() && input > 0){
            eventsDataBase.getEventList().get(input-1).addCandidate(participant);
        }
        mainMenu();
    }

    public void reviewEventEquipmentList() {
        participantGui.reviewEquipmentList(event);
        mainMenu();
    }

    public void reportDesireToDeliverEquipment() {
        List<String> deliveryProposition = participantGui.reportEquipmentDeliveryProposition(participant);
        boolean equipmentFound = false;
        for (String equipmentName : event.getEventEquipmentList().getEquipmentDemand().keySet()) {
            if (equipmentName.equals(deliveryProposition.get(1))){
                event.getEventEquipmentList().addEquipmentOffer(deliveryProposition);
                equipmentFound = true;
            }
        }
        if (!equipmentFound){
            System.out.println("Invalid equipment name\n");
        }
        mainMenu();
    }
}
