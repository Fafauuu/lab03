import controller.CsvReader;
import controller.actions.AnimatorActions;
import controller.actions.OrganizerActions;
import controller.actions.ParticipantActions;
import dataBase.EventsDataBase;
import dataBase.UsersDataBase;
import exceptions.EventAlreadyExists;
import model.events.Event;
import model.users.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventsDataBase eventsDataBase = new EventsDataBase();
        UsersDataBase usersDataBase = new UsersDataBase();

        usersDataBase.setUsersList(CsvReader.readUsers("users.csv"));

        Event event1 = new Event("Ognisko", usersDataBase.getUsersList().get(0));
        Event event2 = new Event("Piknik", usersDataBase.getUsersList().get(1));
        Event event3 = new Event("Wedrowka", usersDataBase.getUsersList().get(2));
        List<User> animatorsList = new ArrayList<>();
        animatorsList.add(usersDataBase.getUsersList().get(3));
        animatorsList.add(usersDataBase.getUsersList().get(4));
        animatorsList.add(usersDataBase.getUsersList().get(5));
        event1.setAnimators(animatorsList);
        event2.setAnimators(animatorsList);
        event3.setAnimators(animatorsList);

        try {
            eventsDataBase.addEvent(event1);
            eventsDataBase.addEvent(event2);
            eventsDataBase.addEvent(event3);
        } catch (EventAlreadyExists e) {
            e.printStackTrace();
        }

        int userInterface = Integer.parseInt(args[0]);
        switch (userInterface) {
            case 0: {
                OrganizerActions organizerActions = new OrganizerActions(eventsDataBase);
                organizerActions.startActions();
            }
            break;
            case 1: {
                AnimatorActions animatorActions = new AnimatorActions(eventsDataBase);
                animatorActions.startActions();
            }
            break;
            case 2: {
                ParticipantActions participantActions = new ParticipantActions(eventsDataBase);
                participantActions.startActions();
            }
            break;
            default:
                System.out.println("Invalid argument");
        }
    }
}
