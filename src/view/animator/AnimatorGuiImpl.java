package view.animator;

import dataBase.EventsDataBase;
import model.events.Event;
import model.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnimatorGuiImpl implements AnimatorGui{
    @Override
    public Event chooseEvent(EventsDataBase eventsDataBase) {
        System.out.println("\nChoose event:");
        int index = 1;
        for (Event event : eventsDataBase.getEventList()) {
            System.out.println(index + " - " + event.getEventName() + " - animators: " + event.getAnimators());
            index++;
        }
        Scanner scanner = new Scanner(System.in);
        int chosenEventIndex = scanner.nextInt();

        Event event;
        try {
            event = eventsDataBase.getEventList().get(chosenEventIndex-1);
        }catch (Exception e){
            System.out.println("Invalid event\n");
            event = chooseEvent(eventsDataBase);
        }
        return event;
    }

    @Override
    public User chooseAnimator(Event event) {
        System.out.println("\nChoose animator");
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
        System.out.println("\nChoose action:");
        System.out.println("1 - Create event equipment list");
        System.out.println("2 - Review demanded and delivered equipment");
        System.out.println("3 - Review event equipment delivery propositions");
        System.out.println("4 - Choose different animator");
        System.out.println("5 - Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public List<String> addEquipmentDemand() {
        List<String> data = new ArrayList<>();
        System.out.println("\nADD EQUIPMENT DEMAND");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        data.add(scanner.nextLine());
        System.out.print("Amount: ");
        int amount = scanner.nextInt();
        data.add(Integer.toString(amount));
        return data;
    }

    @Override
    public void reviewDeliveredEquipment(Event event) {
        System.out.println("\nEQUIPMENT DEMANDS");
        int index = 1;
        Map<String, Integer> demands = event.getEventEquipmentList().getEquipmentDemand();
        for (String equipmentDemanded : demands.keySet()) {
            System.out.println(index + " " + equipmentDemanded + " amount: " + demands.get(equipmentDemanded));
            index++;
        }
        System.out.println();

        System.out.println("\nEQUIPMENT ALREADY DELIVERED");
        index = 1;
        Map<String, Integer> delivered = event.getEventEquipmentList().getEquipmentDelivery();
        for (String deliveredItem : delivered.keySet()) {
            System.out.println(index + " " + deliveredItem + " amount: " + delivered.get(deliveredItem));
            index++;
        }
        System.out.println();
    }

    @Override
    public int reviewDeliveryPropositions(Event event) {
        System.out.println("EQUIPMENT DELIVERY PROPOSITIONS");

        if (event.getEventEquipmentList().getEquipmentOffers().isEmpty()){
            System.out.println("No propositions available");
            return 0;
        }

        int index = 1;
        for (List<String> equipmentOffer : event.getEventEquipmentList().getEquipmentOffers()) {
            System.out.println(index
                    + " - supplier: " + equipmentOffer.get(0)
                    + " - equipment name: " + equipmentOffer.get(1)
                    + " - amount: " + equipmentOffer.get(2)
                    );
            index++;
        }
        System.out.println("Choose offer to accept: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
