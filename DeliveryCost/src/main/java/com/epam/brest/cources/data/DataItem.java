package com.epam.brest.cources.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class DataItem {

    private static Logger LOGGER = LogManager.getLogger();
    private static String ERROR_INFO = "There is cont be negative values!";

    private BigDecimal weight;
    private BigDecimal range;
    private BigDecimal scale;


    public DataItem(BigDecimal weight, BigDecimal range, BigDecimal scale) {
        if (weight.signum() <= 0 && range.signum() <= 0 && scale.signum() <= 0) LOGGER.error(ERROR_INFO);
        this.weight = weight;
        this.range = range;
        this.scale = scale;
    }

    public DataItem() {

    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getRange() {
        return range;
    }

    public void setRange(BigDecimal range) {
        this.range = range;
    }

    public BigDecimal getScale() {
        return scale;
    }

    public void setScale(BigDecimal scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "weight=" + weight +
                ", range=" + range +
                ", scale=" + scale +
                '}';
    }
}
