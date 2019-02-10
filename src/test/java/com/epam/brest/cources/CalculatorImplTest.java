package com.epam.brest.cources;

import com.epam.brest.cources.calculate.Calculator;
import com.epam.brest.cources.calculate.CalculatorImpl;
import com.epam.brest.cources.data.DataItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

public class CalculatorImplTest {
    private static final BigDecimal WEIGHT = BigDecimal.valueOf(4);
    private static final BigDecimal RANGE = BigDecimal.valueOf(20);
    private static final BigDecimal SCALE = BigDecimal.valueOf(1.0);
    private DataItem dataItem = new DataItem(WEIGHT, RANGE, SCALE);
    private static Logger LOGGER = LogManager.getLogger();

    @BeforeEach


    @Test
    public void calculateWithMultipleParametersTest (){
        Calculator calculator = new CalculatorImpl();

        BigDecimal cost = calculator.calculate(WEIGHT, RANGE, SCALE);

        Assertions.assertEquals(BigDecimal.valueOf(24.0),cost);
    }

    @Test
    public void calculateWithDataItemTest(){

        Calculator calcDataItem = new CalculatorImpl();
      BigDecimal result =  calcDataItem.calculate(dataItem);
        Assertions.assertEquals(BigDecimal.valueOf(24.0), result);
    }
}
