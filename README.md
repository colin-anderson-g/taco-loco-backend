Taco Loco Delivery Management Service

This backend service can be started by running TacoLocoBackendApplication.java (taco-loco-backend/src/main/java/com/tacoloco/tacolocobackend/) 

This will start an Apache Tomcat service on http://localhost::8080

The following requests can be made to the URL http://localhost::8080/deliveries

I used Postman to for testing, but curl can be used to make requests as well

JSON inputs must be formatted as follows:

{
  
  "customerName": "Example Name",
  
  "customerAddress": "Example Address"

}

A GET request will return all current deliveries as a JSON file with a customer name and address for each delivery.

A POST request takes a JSON file containing a customer's name and address and adds a new delivery to the list wit that information.

A PUT request takes a JSON file to update any delivery's with a matching name and/or address with the new information.

A DELETE request takes a JSON file to delete any deliveries with a matching customer name and/or address.

Delivery.java is the delivery class that creates new delivery objects to add, update, or alter in the DeliveryService.
DeliveryController.java contains API endpoints that call functions in DeliveryService.java depending on the endpoint.

Delivery Service Functions:

getAllDeliveries()  - Returns the list of all deliveries as JSON object. This function is called from the GET endpoint.

addDelivery()       - Takes a Delivery object as input and adds the delivery to the list of all deliveries. This function is called from the POST endpoint.

updateDelivery()    - Takes a Delivery object as input and first compares the delivery address to existing deliveries, if there is a match then the existing delivery is                        updated. If there is not a match for the delivery address then the customer name on the delivery is compared to each existing delivery and updates on a match. This function is called from the PUT endpoint.

deleteDelivery()    - Takes a Delivery object and compares the customer name to existing deliveries and uses the ArrayList method removeIf() to remove deliveries that have matching customer names and/or matching addresses. The function is called from the DELETE endpoint.


