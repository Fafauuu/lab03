package view.animator;

import dataBase.EventsDataBase;
import model.events.Event;
import model.users.User;

public interface AnimatorGui {
    Event chooseEvent(EventsDataBase eventsDataBase);
    User chooseAnimator(Event event);
    int animatorMenu(Event event);
}
