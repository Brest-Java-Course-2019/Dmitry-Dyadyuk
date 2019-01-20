package com.epam.brest.cources;

import org.junit.Test;

public class DeliveryInformImplTest {

    @Test(expected = IllegalArgumentException.class)
    public void negativeWeightTest(){
        DeliveryInformImpl deliveryInform = new DeliveryInformImpl();
        deliveryInform.setWeight(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeDistanceTest(){
        DeliveryInformImpl deliveryInform = new DeliveryInformImpl();
        deliveryInform.setDistance(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativePriceTest(){
        DeliveryInformImpl deliveryInform = new DeliveryInformImpl();
        deliveryInform.setCostOfProduct(-3);
    }


}
