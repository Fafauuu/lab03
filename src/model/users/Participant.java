package model.users;

import model.events.Event;
import model.events.EventEquipmentList;
import dataBase.EventsDataBase;

public class Participant extends Person{
    private final int id;

    public Participant(User user) {
        super(user.getName(), user.getSurname());
        this.id = user.getId();
    }

    public void reviewEventList(EventsDataBase eventsDataBase) {

    }

    public void reportDesireToParticipate(Event event) {

    }

    public void reviewEventEquipmentList(EventEquipmentList equipmentList) {

    }

    public void reportDesireToDeliverEquipment(EventEquipmentList equipmentList) {

    }

    public int getId() {
        return id;
    }
}
