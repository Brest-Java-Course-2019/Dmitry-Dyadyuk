package com.epam.brest.cources;

import java.util.Scanner;

public class DeliveryInformImpl implements IDeliveryInform {
    private static float weight;
    private static float distance;
    private static float costOfProduct;

    public static float getWeight() {
        return weight;
    }

    public static void setWeight(float weight) {
        DeliveryInformImpl.weight = weight;
    }

    public static float getDistanse() {
        return distance;
    }

    public static void setDistanse(float distanse) {
        DeliveryInformImpl.distance = distanse;
    }

    public static float getCostOfProduct() {
        return costOfProduct;
    }

    public static void setCostOfProduct(float costOfProduct) {
        DeliveryInformImpl.costOfProduct = costOfProduct;
    }


    public void setDeliveryParameters() {
        Scanner scanner = new Scanner(System.in);
       try {
           System.out.println("Weight of your product(kg)");
           weight = Float.parseFloat(scanner.nextLine());

           System.out.println("Distance to your location(km)");
           distance = Float.parseFloat(scanner.nextLine());

           System.out.println("Cost of your product($)");
           costOfProduct = Float.parseFloat(scanner.nextLine());
       }
       catch (Exception e) {
           System.out.println("There is some problems with your delivery information. Try again.");
       }

    }


    public void totalPrice() {
        System.out.println("Total price is: " + (weight + distance + costOfProduct) );
    }
}
