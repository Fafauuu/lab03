package view.organizer;

import dataBase.EventsDataBase;
import model.events.Event;
import model.users.User;

import java.util.Date;
import java.util.List;

public interface OrganizerGui {
    Event chooseEvent(EventsDataBase eventsDataBase);
    int organizerMenu();
    int editEvent();
    String changeEventName();
    String changeEventDescription();
    Date changeEventDate();
    Date changeApplicationDeadline();
    int reviewParticipants();
    int reviewCandidates(List<User> candidates);
    int designateAnimators(List<User> participants);
}
