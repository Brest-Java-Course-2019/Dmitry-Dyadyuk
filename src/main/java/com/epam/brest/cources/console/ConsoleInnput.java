package com.epam.brest.cources.console;

import com.epam.brest.cources.calculate.Calculator;
import com.epam.brest.cources.calculate.CalculatorImpl;
import com.epam.brest.cources.data.DataItem;
import com.epam.brest.cources.fileReader.PropertyReader;
import com.epam.brest.cources.fileReader.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class ConsoleInnput {
    private static Logger LOGGER = LogManager.getLogger();
    private static String[] MESSAGES = {"Enter the weight in kg", "Enter the distance in km"};
    private static String ERROR_MESSAGE = "Error was detected  {}";
    private Scanner scanner;
    private DataItem dataItem;
    private Reader reader;
    private Calculator calculator;
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("conf.xml");

    public ConsoleInnput() {
        this.scanner = new Scanner(System.in, "UTF-8");
        this.dataItem = new DataItem();
        this.reader = (PropertyReader) applicationContext.getBean("propertyReader");
        this.calculator = (CalculatorImpl) applicationContext.getBean("calculator");
    }


    public void run() {
        DataItem data;
        data = getData();
        calc(data);
    }

    public BigDecimal calc(DataItem dataItem) {
        LOGGER.info("Calculation process");
        BigDecimal calcResult = calculator.calculate(dataItem);
        System.out.println("The total price is " + calcResult);
        return calcResult;
    }

    private DataItem getData() {
        BigDecimal weight = getInform(MESSAGES[0]);
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

    public BigDecimal getInform(String message) {
        System.out.println(message);
        try {
            return scanner.nextBigDecimal();
        } catch (IllegalArgumentException | NullPointerException err) {
            LOGGER.error(ERROR_MESSAGE, err);
        }
        return null;
    }

    private BigDecimal receiveScale(Map<String, BigDecimal> map, BigDecimal weight) {
        try {
            if (weight.floatValue() <= 5) {
                return map.get("min.weight");
            } else if (weight.floatValue() > 5 && weight.floatValue() <= 10) {
                return map.get("normal.weight");
            } else {
                return map.get("max.weight");
            }
        } catch (NullPointerException err) {
            LOGGER.error(ERROR_MESSAGE, err);
        }
        return null;
    }

}
