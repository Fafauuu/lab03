package view.organizer;

import dataBase.EventsDataBase;
import model.events.Event;
import model.users.User;

import java.util.List;

public interface OrganizerGui {
    Event chooseEvent(EventsDataBase eventsDataBase);
    int organizerMenu();
    List<String> createNewEvent();
    void reviewEventList(EventsDataBase eventsDataBase);
    int editEvent();
    String changeEventName();
    String changeEventDescription();
    String changeEventDate();
    String changeApplicationDeadline();
    int reviewParticipants();
    int reviewCandidates(List<User> candidates);
    int designateAnimators(List<User> participants);
    int closeEvent();
    String addEventSummary();
}
