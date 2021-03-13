package com.tacoloco.tacolocobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping("/deliveries")
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deliveries")
    public void addDelivery(@RequestBody Delivery delivery) {
        deliveryService.addDelivery(delivery);
    }

    //PUT request to update delivery based on either customer name or address
    //This request checks for a successful update using the customer's name and attempts to update based on address otherwise
    @RequestMapping(method = RequestMethod.PUT, value = "/deliveries")
    public void updateDelivery(@RequestBody Delivery delivery) {
        deliveryService.updateDelivery(delivery);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deliveries")
    public void deleteDelivery(@RequestBody Delivery delivery) {
        deliveryService.deleteDelivery(delivery);
    }
}