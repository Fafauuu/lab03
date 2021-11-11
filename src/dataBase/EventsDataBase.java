package dataBase;

import exceptions.EventAlreadyExists;
import exceptions.NoSuchEventExistence;
import model.events.Event;

import java.util.ArrayList;
import java.util.List;

public class EventsDataBase {
    private final List<Event> eventList;

    public EventsDataBase() {
        eventList = new ArrayList<>();
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public Event getEvent(String eventName) throws NoSuchEventExistence{
        for (Event event : eventList) {
            if (event.getEventName().equals(eventName)){
                return event;
            }
        }
        throw new NoSuchEventExistence(eventName + " doesn't exist");
    }

    public void addEvent(Event newEvent) throws EventAlreadyExists {
        for (Event event : eventList) {
            if (event.getEventName().equals(newEvent.getEventName())){
                throw new EventAlreadyExists(newEvent.getEventName() + " already exists");
            }
        }
        eventList.add(newEvent);
    }
}
