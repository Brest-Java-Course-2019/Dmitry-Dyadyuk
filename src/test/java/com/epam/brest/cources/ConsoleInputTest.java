package com.epam.brest.cources;

import com.epam.brest.cources.console.ConsoleInnput;
import com.epam.brest.cources.data.DataItem;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class ConsoleInputTest {
    private static final String MESSAGE = "Test Message";
    private static final BigDecimal WEIGHT = BigDecimal.valueOf(4);
    private static final BigDecimal RANGE = BigDecimal.valueOf(20);
    private static final BigDecimal SCALE = BigDecimal.valueOf(1.0);
    private DataItem dataItem = new DataItem(WEIGHT, RANGE, SCALE);
    private ConsoleInnput consoleInnput;

    @Test
    public void calcTest(){
        consoleInnput = new ConsoleInnput();
        BigDecimal calcResult = consoleInnput.calc(dataItem);
        Assertions.assertEquals(BigDecimal.valueOf(24.0), calcResult);
    }



}
