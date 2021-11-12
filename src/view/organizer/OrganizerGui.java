package view.organizer;

import dataBase.EventsDataBase;
import model.events.Event;

public interface OrganizerGui {
    Event chooseEvent(EventsDataBase eventsDataBase);
    int organizerMenu(Event event);

}
