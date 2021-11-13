package view.participant;

import dataBase.EventsDataBase;
import model.events.Event;
import model.users.User;

import java.util.List;

public interface ParticipantGui {
    Event chooseEvent(EventsDataBase eventsDataBase);
    User chooseParticipant(Event event);
    int participantMenu(Event event);
    void reviewEventList(EventsDataBase eventsDataBase);
    int reportDesireToParticipate(EventsDataBase eventsDataBase);
    void reviewEquipmentList(Event event);
    List<String> reportEquipmentDeliveryProposition(User participant);
}
