package model.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventEquipmentList {
    private List<String> equipmentNames;
    private Map<String, Integer> equipmentDemand;
    private Map<String, Integer> equipmentDelivery;

    public EventEquipmentList() {
        equipmentNames = new ArrayList<>();
        equipmentDemand = new HashMap<>();
        equipmentDelivery = new HashMap<>();
    }

    public void addEquipmentDemand(String name, Integer demand){
        equipmentNames.add(name);
        equipmentDemand.put(name, demand);
    }
}
