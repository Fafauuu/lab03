package controller;

import model.users.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<User> readUsers(String fileName){
        List<User> users = new ArrayList<>();


        try{
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            String line;

            csvReader.readLine();

            while ((line = csvReader.readLine()) != null){
                String[] data = line.split(";");
                String name = data[0];
                String surname = data[1];
                users.add(new User(name, surname));
            }

        }catch (IOException e){
            e.printStackTrace();
            System.exit(2);
        }

        return users;
    }
}
