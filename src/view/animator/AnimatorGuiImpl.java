package view.animator;

import dataBase.EventsDataBase;
import model.events.Event;
import model.users.User;

import java.util.Scanner;

public class AnimatorGuiImpl implements AnimatorGui{
    @Override
    public Event chooseEvent(EventsDataBase eventsDataBase) {
        System.out.println("Choose event:");
        int index = 1;
        for (Event event : eventsDataBase.getEventList()) {
            System.out.println(index + " - " + event.getEventName() + " - animators: " + event.getAnimators());
            index++;
        }
        Scanner scanner = new Scanner(System.in);
        int chosenEventIndex = scanner.nextInt();

        Event event = null;
        try {
            event = eventsDataBase.getEventList().get(chosenEventIndex-1);
        }catch (Exception e){
            System.out.println("Invalid event");
            chooseEvent(eventsDataBase);
        }
        return event;
    }

    @Override
    public User chooseAnimator(Event event) {
        System.out.println("Choose animator");
        int index = 1;
        for (User animator : event.getAnimators()) {
            System.out.println(index + " - " + animator);
            index++;
        }
        Scanner scanner = new Scanner(System.in);
        int chosenAnimatorIndex = scanner.nextInt();

        User user = null;
        try {
            user = event.getAnimators().get(chosenAnimatorIndex-1);
        }catch (Exception e){
            System.out.println("Invalid animator");
            chooseAnimator(event);
        }
        return user;
    }

    @Override
    public int animatorMenu(Event event) {
        System.out.println("Choose action:");
        System.out.println("1 - Create event equipment list");
        System.out.println("2 - Review event equipment delivery propositions");
        System.out.println("3 - Choose different animator");
        System.out.println("4 - Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
