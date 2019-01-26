package com.epam.brest.cources.console;

import com.epam.brest.cources.calculate.Calculator;
import com.epam.brest.cources.calculate.CalculatorImpl;
import com.epam.brest.cources.data.DataItem;
import com.epam.brest.cources.fileReader.PropertyReader;
import com.epam.brest.cources.fileReader.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class ConsoleInnput {
    private Scanner scanner;
    private DataItem dataItem;
    private Reader reader;
    private Calculator calculator;

    private static Logger LOGGER = LogManager.getLogger();
    private static String[] MESSAGES = {"Enter the weight in kg" , "Enter the distance in km"};
    private static String ERROR_MESSAGE = "Error was detected  {}";

    public ConsoleInnput() {
        this.scanner = new Scanner(System.in);
        this.dataItem = new DataItem();
        this.reader = new PropertyReader();
        this.calculator = new CalculatorImpl();
    }


    public void run(){
        DataItem data = new DataItem();
        data = getData();
        BigDecimal calculate = calc(data);
    }

    private BigDecimal calc(DataItem dataItem){
        LOGGER.info("Calculation process");
        BigDecimal calcResult = calculator.calculate(dataItem);
        System.out.println("The total price is " + calcResult);
        return  calcResult;
    }

    private DataItem getData(){
        BigDecimal weight  = getInform(MESSAGES[0]);
        dataItem.setWeight(weight);
        BigDecimal range = getInform(MESSAGES[1]);
        dataItem.setRange(range);
        BigDecimal scale = null;
        try {
            scale = receiveScale(reader.getMap("cost.properties"), weight);
        } catch (IOException e) {
            LOGGER.error(ERROR_MESSAGE, e);
        }
        dataItem.setScale(scale);
        LOGGER.info("Received data is {}", dataItem);
        return dataItem;
    }

    private BigDecimal getInform(String message){
        System.out.println(message);
        try{
         return scanner.nextBigDecimal();
    }
        catch (IllegalArgumentException | NullPointerException err){
            LOGGER.error(ERROR_MESSAGE, err );
        }
        return null;
    }

    private BigDecimal receiveScale(Map<String,BigDecimal> map , BigDecimal weight){
       try{
           if(weight.floatValue() <= 5){
               return  map.get("min.weight");
           } else if(weight.floatValue() > 5 && weight.floatValue() <= 10 ){
               return  map.get("normal.value");
           } else {
               return map.get("max.value");
           }
       }
       catch (NullPointerException err){
           LOGGER.error(ERROR_MESSAGE, err);
       }
       return null;
    }

}
