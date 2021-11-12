package controller.actions;

import dataBase.EventsDataBase;
import exceptions.InvalidActionException;
import model.events.Event;
import model.users.User;
import view.animator.AnimatorGui;
import view.animator.AnimatorGuiImpl;

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
            System.out.println("Invalid event");
            chooseEvent();
        }
        return event;
    }

    private User chooseAnimator(Event event) {
        return animatorGui.chooseAnimator(event);
    }

    private void menu() {
        try {
            int action = animatorMenu();
            switch (action) {
                case 1:
                    createEventEquipmentList();
                    break;
                case 2:
                    reviewEventEquipmentDeliveryProposition();
                    break;
                case 3:
                    startActions();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    throw new InvalidActionException("Invalid action chosen");
            }
        } catch (InvalidActionException e) {
            menu();
        }
    }

    private int animatorMenu() {
        return animatorGui.animatorMenu(event);
    }

    private void createEventEquipmentList() {

    }

    private void reviewEventEquipmentDeliveryProposition() {

    }

    private void acceptEventEquipmentDeliveryProposition() {

    }
}
