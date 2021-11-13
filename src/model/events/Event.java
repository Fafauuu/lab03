package model.events;

import model.users.User;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private final User organizer;
    private List<User> participants;
    private List<User> animators;
    private List<User> candidates;
    private String eventName;
    private EventDescription eventDescription;
    private EventsState eventsState;
    private EventEquipmentList eventEquipmentList;
    private List<String> comments;

    public Event(String eventName, User organizer) {
        this.eventName = eventName;
        this.organizer = organizer;
        participants = new ArrayList<>();
        animators = new ArrayList<>();
        candidates = new ArrayList<>();
        comments = new ArrayList<>();
        eventDescription = new EventDescription();
        eventEquipmentList = new EventEquipmentList();
        comments = new ArrayList<>();
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

    public void addAnimator(User designatedAnimator){
        animators.add(designatedAnimator);
        participants.remove(designatedAnimator);
    }

    public void setAnimators(List<User> animators) {
        this.animators = animators;
    }

    public List<User> getCandidates() {
        return candidates;
    }

    public void addCandidate(User candidate){
        candidates.add(candidate);
    }

    public void acceptCandidate(User candidate){
        participants.add(candidate);
        candidates.remove(candidate);
    }

    public void setCandidates(List<User> candidates) {
        this.candidates = candidates;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventDescription getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(EventDescription eventDescription) {
        this.eventDescription = eventDescription;
    }

    public EventsState getEventsState() {
        return eventsState;
    }

    public void setEventsState(EventsState eventsState) {
        this.eventsState = eventsState;
    }

    public EventEquipmentList getEventEquipmentList() {
        return eventEquipmentList;
    }

    public void setEventEquipmentList(EventEquipmentList eventEquipmentList) {
        this.eventEquipmentList = eventEquipmentList;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Organizer - " + organizer
                + "\nParticipants: " + participants
                + "\nAnimators: " + animators
                + "\nDescription: " + eventDescription.getDescription()
                + "\nDate: " + eventDescription.getEventDate()
                + "\nApplication deadline: " + eventDescription.getApplicationsDeadline()
                + "\nComments: " + comments
                + "\n";
    }
}
