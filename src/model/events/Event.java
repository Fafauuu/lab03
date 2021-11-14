package model.events;

import fileHandlers.JsonHandler;
import model.users.User;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private final int id;
    private final User organizer;
    private List<User> participants;
    private List<User> animators;
    private List<User> candidates;
    private String eventName;
    private EventDescription eventDescription;
    private EventsStatus eventsStatus;
    private EventEquipmentList eventEquipmentList;
    private List<String> comments;

    public Event(int id, String eventName, User organizer) {
        this.id = id;
        this.eventName = eventName;
        this.organizer = organizer;
        participants = new ArrayList<>();
        animators = new ArrayList<>();
        candidates = new ArrayList<>();
        eventDescription = new EventDescription();
        eventsStatus = EventsStatus.SUBMITTED;
        eventEquipmentList = new EventEquipmentList();
        comments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public User getOrganizer() {
        return organizer;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public List<User> getAnimators() {
        return animators;
    }

    public void addAnimator(User designatedAnimator){
        animators.add(designatedAnimator);
        participants.remove(designatedAnimator);
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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventDescription getEventDescription() {
        return eventDescription;
    }

    public void setEventsStatus(EventsStatus eventsStatus) {
        this.eventsStatus = eventsStatus;
    }

    public EventEquipmentList getEventEquipmentList() {
        return eventEquipmentList;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addComment(String comment){
        comments.add(comment);
    }

    @Override
    public String toString() {
        return "Organizer - " + organizer
                + "\nParticipants: " + participants
                + "\nAnimators: " + animators
                + "\nDescription: " + eventDescription.getDescription()
                + "\nStatus: " + eventsStatus
                + "\nPreparation percentage: " + eventEquipmentList.getPreparationPercentage() + "%"
                + "\nDate: " + eventDescription.getEventDate()
                + "\nApplication deadline: " + eventDescription.getApplicationsDeadline()
                + "\n";
    }
}
