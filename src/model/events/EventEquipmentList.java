package model.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventEquipmentList {
    private final Map<String, Integer> equipmentDemand;
    private final Map<String, Integer> equipmentDelivery;
    private final List<List<String>> equipmentOffers;

    public EventEquipmentList() {
        equipmentDemand = new HashMap<>();
        equipmentDelivery = new HashMap<>();
        equipmentOffers = new ArrayList<>();
    }

    public void addEquipmentDemand(String name, Integer demand){
        equipmentDemand.put(name, demand);
        equipmentDelivery.put(name, 0);
    }

    public void addEquipmentOffer(List<String> offer){
        equipmentOffers.add(offer);
    }

    public void acceptEquipmentOffer(String name, int amount){
        int initialValue = equipmentDelivery.get(name);
        equipmentDelivery.replace(name, initialValue+amount);
    }

    public Map<String, Integer> getEquipmentDemand() {
        return equipmentDemand;
    }

    public Map<String, Integer> getEquipmentDelivery() {
        return equipmentDelivery;
    }

    public List<List<String>> getEquipmentOffers() {
        return equipmentOffers;
    }
}
