package com.tacoloco.tacolocobackend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    
    private List<Delivery> deliveries = new ArrayList<>(Arrays.asList(
        new Delivery("Alice Eiri", "1234 Cereal Experiments Lane"),
        new Delivery("Goku Vegeta", "9001 Nappa Drive"),
        new Delivery("Richard Johnson", "9060 Longview Court")
    ));

    public List<Delivery> getAllDeliveries() {
        return deliveries;
    }

    public void addDelivery(Delivery delivery) {
        deliveries.add(delivery);
    }

    //Check each delivery for matching customer name and update delivery information if found
    public void updateDelivery(Delivery delivery) {
        for (int i = 0; i < deliveries.size(); i++){
            Delivery d = deliveries.get(i);
            if(d.getCustomerAddress().equals(delivery.getCustomerAddress())){
                deliveries.set(i, delivery);
            }
        }
        for (int i = 0; i < deliveries.size(); i++){
            Delivery d = deliveries.get(i);
            if(d.getCustomerName().equals(delivery.getCustomerName())){
                deliveries.set(i, delivery);
            }
        }
    }

    public void deleteDelivery(Delivery delivery) {
        deliveries.removeIf(d -> d.getCustomerName().equals(delivery.getCustomerName()));
        deliveries.removeIf(d -> d.getCustomerAddress().equals(delivery.getCustomerAddress()));
    }

}
