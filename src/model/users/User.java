package model.users;

import model.events.Event;

import java.util.Map;

public class User extends Person{
    private static int count;
    private final int id;

    public User(String name, String surname) {
        super(name, surname);
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
