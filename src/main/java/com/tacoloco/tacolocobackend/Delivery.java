package com.tacoloco.tacolocobackend;

public class Delivery {
    private String customerName;
    private String customerAddress;

    public Delivery(String customerName, String customerAddress) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }


    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return this.customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

}
