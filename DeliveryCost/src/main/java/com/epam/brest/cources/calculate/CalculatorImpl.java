package com.epam.brest.cources.calculate;

import com.epam.brest.cources.data.DataItem;

import java.math.BigDecimal;

public class CalculatorImpl implements Calculator {

    @Override
    public BigDecimal calculate(DataItem dataItem) {
        return dataItem.getWeight().add(dataItem.getRange()).multiply(dataItem.getScale());
    }

    @Override
    public BigDecimal calculate(BigDecimal weight, BigDecimal range, BigDecimal scale) {
        return weight.add(range).multiply(scale);
    }
}
