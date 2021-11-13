package view.animator;

import dataBase.EventsDataBase;
import model.events.Event;
import model.users.User;

import java.util.List;

public interface AnimatorGui {
    Event chooseEvent(EventsDataBase eventsDataBase);
    User chooseAnimator(Event event);
    int animatorMenu(Event event);
    List<String> addEquipmentDemand();
    void reviewDeliveredEquipment(Event event);
    int reviewDeliveryPropositions(Event event);
    String addComment();
}
