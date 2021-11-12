package model.events;

import model.users.User;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private final String eventName;
    private final User organizer;
    private List<User> participants;
    private List<User> animators;
    private EventsState eventsState;
    private EventDescription eventDescription;
    private EventEquipmentList eventEquipmentList;
    private List<String> comments;

    public Event(String eventName, User organizer) {
        this.eventName = eventName;
        this.organizer = organizer;
        participants = new ArrayList<>();
        animators = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public String getEventName() {
        return eventName;
    }

    public User getOrganizer() {
        return organizer;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public List<User> getAnimators() {
        return animators;
    }

    public void setAnimators(List<User> animators) {
        this.animators = animators;
    }

    public EventsState getEventsState() {
        return eventsState;
    }

    public void setEventsState(EventsState eventsState) {
        this.eventsState = eventsState;
    }

    public EventDescription getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(EventDescription eventDescription) {
        this.eventDescription = eventDescription;
    }

    public EventEquipmentList getEventEquipmentList() {
        return eventEquipmentList;
    }

    public void setEventEquipmentList(EventEquipmentList eventEquipmentList) {
        this.eventEquipmentList = eventEquipmentList;
    }

    public double getPreparationPercentage() {
        return 0;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String closeEvent(){
        String summary = "";
        return summary;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", organizer=" + organizer +
                ", participants=" + participants +
                ", animators=" + animators +
                '}';
    }
}
