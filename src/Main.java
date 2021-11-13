import controller.CsvReader;
import controller.actions.AnimatorActions;
import controller.actions.OrganizerActions;
import controller.actions.ParticipantActions;
import dataBase.EventsDataBase;
import dataBase.UsersDataBase;
import exceptions.EventAlreadyExists;
import model.events.Event;
import model.users.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventsDataBase eventsDataBase = new EventsDataBase();
        UsersDataBase usersDataBase = new UsersDataBase();

        usersDataBase.setUsersList(CsvReader.readUsers("users.csv"));

        Event event1 = new Event("Ognisko", usersDataBase.getUsersList().get(0));
        Event event2 = new Event("Piknik", usersDataBase.getUsersList().get(1));
        List<User> animatorsList = new ArrayList<>();
        List<User> participantList = new ArrayList<>();
        List<User> participantList2 = new ArrayList<>();
        List<User> candidateList = new ArrayList<>();
        animatorsList.add(usersDataBase.getUsersList().get(2));
        animatorsList.add(usersDataBase.getUsersList().get(3));
        participantList.add(usersDataBase.getUsersList().get(4));
        participantList.add(usersDataBase.getUsersList().get(5));
        participantList.add(usersDataBase.getUsersList().get(6));
        participantList2.add(usersDataBase.getUsersList().get(4));
        candidateList.add(usersDataBase.getUsersList().get(7));
        candidateList.add(usersDataBase.getUsersList().get(8));
        candidateList.add(usersDataBase.getUsersList().get(9));
        event1.setAnimators(animatorsList);
        event2.setAnimators(animatorsList);
        event1.setParticipants(participantList);
        event2.setParticipants(participantList2);
        event1.setCandidates(candidateList);
        event2.setCandidates(candidateList);
        event1.getEventDescription().setEventDate(LocalDate.parse("2018-05-05"));
        event1.getEventEquipmentList().addEquipmentDemand("item1", 20);

        try {
            eventsDataBase.addEvent(event1);
            eventsDataBase.addEvent(event2);
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
