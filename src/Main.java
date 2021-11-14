import dataBase.EventsDataBase;
import userActions.AnimatorActions;
import userActions.OrganizerActions;
import userActions.ParticipantActions;

public class Main {
    public static void main(String[] args) {
        EventsDataBase eventsDataBase = new EventsDataBase();

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
