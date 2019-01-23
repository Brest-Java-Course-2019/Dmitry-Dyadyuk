package com.epam.brest.cources;

public class DeliveryCostMain {
    public static void main(String[] args) {
        DeliveryInform deliveryInform = new DeliveryInformImpl();
        deliveryInform.setDeliveryParameters();

        deliveryInform.totalPrice();
    }
}
