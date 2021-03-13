package com.tacoloco.tacolocobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
    @RequestMapping(method = RequestMethod.PUT, value = "/deliveries/{customerName}")
    public void updateDeliveryByName(@RequestBody Delivery delivery, @PathVariable String customerUpdateParam) {
        if(deliveryService.updateDeliveryByName(delivery, customerUpdateParam) != "update success"){
            deliveryService.updateDeliveryByName(delivery, customerUpdateParam);
        };
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/deliveries/{customerAddress}")
    public void updateDeliveryByAddress(@RequestBody Delivery delivery, @PathVariable String customerAddress) {
        deliveryService.updateDeliveryByAddress(delivery, customerAddress);
    }
}