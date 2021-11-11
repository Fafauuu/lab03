package view;

import dataBase.EventsDataBase;
import dataBase.UsersDataBase;
import model.events.Event;
import model.users.User;

public class DataPrinter{
    private EventsDataBase eventsDataBase;
    private UsersDataBase usersDataBase;

    public DataPrinter(EventsDataBase eventsDataBase, UsersDataBase usersDataBase) {
        this.eventsDataBase = eventsDataBase;
        this.usersDataBase = usersDataBase;
    }

    public void print() {
        System.out.println("Users:");
        for (User user : usersDataBase.getUsersList()) {
            System.out.println(user);
        }
        System.out.println("\nEvents:");
        for (Event event : eventsDataBase.getEventList()) {
            System.out.println(event);
        }
    }
}
