package model.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventEquipmentList {
    private final Map<String, Integer> equipmentDemand;
    private final Map<String, Integer> equipmentDelivery;
    private final List<List<String>> equipmentOffers;
    private int preparationPercentage;

    public EventEquipmentList() {
        equipmentDemand = new HashMap<>();
        equipmentDelivery = new HashMap<>();
        equipmentOffers = new ArrayList<>();
    }

    public void addEquipmentDemand(String name, Integer demand){
        equipmentDemand.put(name, demand);
        equipmentDelivery.put(name, 0);
        calculatePreparationPercentage();
    }

    public void addEquipmentOffer(List<String> offer){
        equipmentOffers.add(offer);
    }

    public void acceptEquipmentOffer(String name, int amount){
        int initialValue = equipmentDelivery.get(name);
        equipmentDelivery.replace(name, initialValue+amount);
        calculatePreparationPercentage();
    }

    private void calculatePreparationPercentage() {
        if (equipmentDemand.keySet().size() == 0){
            preparationPercentage = 0;
            return;
        }

        double demandsAmount = 0;
        double deliveriesAmount = 0;

        for (Integer value : equipmentDemand.values()) {
            demandsAmount+=value;
        }
        for (Integer value : equipmentDelivery.values()) {
            deliveriesAmount+=value;
        }

        double value = 100*(deliveriesAmount/demandsAmount);
        preparationPercentage = (int) value;
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

    public int getPreparationPercentage() {
        calculatePreparationPercentage();
        return preparationPercentage;
    }
}
