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
    private EventsStatus eventsStatus;
    private EventEquipmentList eventEquipmentList;
    private List<String> comments;

    public Event(String eventName, User organizer) {
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
                + "\nDate: " + eventDescription.getEventDate()
                + "\nApplication deadline: " + eventDescription.getApplicationsDeadline()
                + "\n";
    }
}
