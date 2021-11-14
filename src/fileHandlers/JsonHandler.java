package fileHandlers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.events.Event;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {
    private final static Type eventListType = new TypeToken<ArrayList<Event>>(){}.getType();
    private final static Gson gson = new Gson();

    public static List<Event> readEventList(){
        List<Event> eventList = null;
        try {
            eventList = gson.fromJson(new FileReader("eventList.json"), eventListType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public static void writeEventList(List<Event> eventList){
        String json = gson.toJson(eventList);

        try{
            FileWriter fileWriter = new FileWriter("eventList.json");
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
