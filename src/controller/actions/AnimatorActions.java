package controller.actions;

import dataBase.EventsDataBase;
import exceptions.InvalidActionException;
import model.events.Event;
import model.users.User;
import view.animator.AnimatorGui;
import view.animator.AnimatorGuiImpl;

import java.util.List;

public class AnimatorActions {
    private final EventsDataBase eventsDataBase;
    private Event event;
    private User animator;
    private final AnimatorGui animatorGui;

    public AnimatorActions(EventsDataBase eventsDataBase) {
        this.eventsDataBase = eventsDataBase;
        this.animatorGui = new AnimatorGuiImpl();
    }

    public void startActions() {
        event = chooseEvent();
        animator = chooseAnimator(event);
        menu();
    }

    private Event chooseEvent() {
        Event event = null;
        try {
            event = animatorGui.chooseEvent(eventsDataBase);
        }catch (NullPointerException e){
            System.out.println("Invalid event\n");
            chooseEvent();
        }
        return event;
    }

    private User chooseAnimator(Event event) {
        return animatorGui.chooseAnimator(event);
    }

    private void menu() {
        try {
            int action = animatorGui.animatorMenu(event);
            switch (action) {
                case 1:
                    addEquipmentDemand();
                    break;
                case 2:
                    reviewDeliveredEquipment();
                    break;
                case 3:
                    reviewEventEquipmentDeliveryProposition();
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

    private void addEquipmentDemand() {
        List<String> data = animatorGui.addEquipmentDemand();
        event.getEventEquipmentList().addEquipmentDemand(data.get(0), Integer.parseInt(data.get(1)));
        menu();
    }

    private void reviewDeliveredEquipment(){
        animatorGui.reviewDeliveredEquipment(event);
        menu();
    }

    private void reviewEventEquipmentDeliveryProposition() {
        int input = animatorGui.reviewDeliveryPropositions(event);
        if (input != 0){
            List<String> offer = event.getEventEquipmentList().getEquipmentOffers().get(input-1);
            event.getEventEquipmentList().getEquipmentOffers().remove(offer);
            for (String equipmentName : event.getEventEquipmentList().getEquipmentDelivery().keySet()) {
                if (equipmentName.equals(offer.get(1))){
                    event.getEventEquipmentList().acceptEquipmentOffer(equipmentName, Integer.parseInt(offer.get(2)));
                }
            }
        }
        menu();
    }
}
