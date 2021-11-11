package model.users;

import model.events.Event;
import dataBase.EventsDataBase;

public class Organizer extends Person{
    private final int id;

    public Organizer(User user) {
        super(user.getName(), user.getSurname());
        this.id = user.getId();
    }

    public void reviewEventList(EventsDataBase eventsDataBase) {
    }

    public void editEvent(Event event) {

    }

    public void reviewParticipants(Event event) {

    }

    public int getId() {
        return id;
    }
}
