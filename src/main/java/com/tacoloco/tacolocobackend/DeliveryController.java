package com.tacoloco.tacolocobackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {
    
    private static final String nameOut= "Customer: %s";
    private static final String deliveryOut= "Address: %s";

    @GetMapping("/delivery")
    Delivery delivery(@RequestParam String customerName,@RequestParam String customerAddress) {
        return new Delivery(String.format(nameOut, customerName), String.format(deliveryOut, customerAddress));
    }
}