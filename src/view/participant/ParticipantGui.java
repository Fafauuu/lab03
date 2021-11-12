package view.participant;

import dataBase.EventsDataBase;
import model.events.Event;
import model.users.User;

public interface ParticipantGui {
    Event chooseEvent(EventsDataBase eventsDataBase);
    User chooseParticipant(Event event);
    int participantMenu(Event event);
}
