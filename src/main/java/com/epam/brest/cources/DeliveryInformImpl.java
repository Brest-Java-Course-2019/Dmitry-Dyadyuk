package com.epam.brest.cources;

import java.io.FileInputStream;
import java.util.Properties;
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
        if (weight <= 0 ){
            throw new IllegalArgumentException("The value can't be negative");
        }
    }

    public static float getDistanse() {
        return distance;
    }

    public static void setDistance(float distanse) {
        DeliveryInformImpl.distance = distanse;
        if (distanse <= 0 ){
            throw new IllegalArgumentException("The value can't be negative");
        }
    }

    public static float getCostOfProduct() {
        return costOfProduct;
    }

    public static void setCostOfProduct(float costOfProduct) {
        DeliveryInformImpl.costOfProduct = costOfProduct;
        if (costOfProduct <= 0 ){
            throw new IllegalArgumentException("The value can't be negative");
        }
    }


    public void setDeliveryParameters() {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream;
        Properties properties = new Properties();
       try {

           fileInputStream = new FileInputStream("/home/dd/IdeaProjects/DeliveryCost/src/main/resources/cost.properties");
           properties.load(fileInputStream);

           float minWeightPrice = Float.parseFloat(properties.getProperty("min.weight"));
           float normalWeightPrice = Float.parseFloat(properties.getProperty("normal.weight"));
           float maxWeightPrice = Float.parseFloat(properties.getProperty("max.weight"));


           System.out.println("Weight of your product(kg)");
           weight = Float.parseFloat(scanner.nextLine());
           if(weight <= 3){
               weight += minWeightPrice;
           } else if(weight >= 3 && weight <= 7) {
                weight += normalWeightPrice;
           } else if(weight >= 7){
               weight += maxWeightPrice;
           }

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
