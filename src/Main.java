import controller.CsvReader;
import dataBase.EventsDataBase;
import dataBase.UsersDataBase;
import exceptions.EventAlreadyExists;
import model.events.Event;
import view.DataPrinter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventsDataBase eventsDataBase = new EventsDataBase();
        UsersDataBase usersDataBase = new UsersDataBase();

        usersDataBase.setUsersList(CsvReader.readUsers("users.csv"));

        try {
            eventsDataBase.addEvent(new Event("Ognisko", usersDataBase.getUsersList().get(0)));
            eventsDataBase.addEvent(new Event("Ognisko1", usersDataBase.getUsersList().get(1)));
            eventsDataBase.addEvent(new Event("Ognisko2", usersDataBase.getUsersList().get(2)));
        } catch (EventAlreadyExists e) {
            e.printStackTrace();
        }

        DataPrinter dataPrinter = new DataPrinter(eventsDataBase, usersDataBase);
        dataPrinter.print();

        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        System.out.println(a);
    }
}
