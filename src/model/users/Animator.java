package model.users;

import model.events.Event;

public class Animator extends Person{
    private final int id;

    public Animator(User user) {
        super(user.getName(), user.getSurname());
        this.id = user.getId();
    }

    public void CreateEventEquipmentList(Event event) {

    }

    public void ReviewEventEquipmentDeliveryProposition() {

    }

    public void AcceptEventEquipmentDeliveryProposition() {

    }

    public int getId() {
        return id;
    }
}
