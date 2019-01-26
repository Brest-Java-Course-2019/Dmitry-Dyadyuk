package com.epam.brest.cources.calculate;

import com.epam.brest.cources.data.DataItem;

import java.math.BigDecimal;

public interface Calculator {
    BigDecimal calculate(DataItem dataItem);
    BigDecimal calculate(BigDecimal weight, BigDecimal range, BigDecimal scale);
}
