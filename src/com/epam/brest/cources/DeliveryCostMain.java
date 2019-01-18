package com.epam.brest.cources;

public class DeliveryCostMain {
    public static void main(String[] args) {
        IDeliveryInform deliveryInform = new DeliveryInformImpl();
        deliveryInform.setDeliveryParameters();
        deliveryInform.totalPrice();
    }
}
