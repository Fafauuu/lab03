package dataBase;

import exceptions.EventAlreadyExists;
import exceptions.NoSuchEventExistence;
import fileHandlers.JsonHandler;
import model.events.Event;

import java.util.List;

public class EventsDataBase {
    private List<Event> eventList;

    public EventsDataBase() {
        eventList = JsonHandler.readEventList();
    }

    public List<Event> getEventList() {
        eventList = JsonHandler.readEventList();
        return eventList;
    }

    public Event getEvent(Event event) throws NoSuchEventExistence{
        eventList = JsonHandler.readEventList();
        for (Event eventInDataBase : eventList) {
            if (eventInDataBase.getEventName().equals(event.getEventName()))
            {
                return event;
            }
        }
        throw new NoSuchEventExistence(event.getEventName() + " doesn't exist");
    }

    public void addEvent(Event newEvent) throws EventAlreadyExists {
        for (Event event : eventList) {
            if (event.getEventName().equals(newEvent.getEventName())){
                throw new EventAlreadyExists(newEvent.getEventName() + " already exists");
            }
        }
        eventList.add(newEvent);
        JsonHandler.writeEventList(eventList);
    }

    public void update(Event event) {
        int index = 0;
        for (Event eventOnList : eventList) {
            if (event.getId() == eventOnList.getId()){
                eventList.set(index, event);
            }
            index++;
        }
        JsonHandler.writeEventList(eventList);
    }
}
