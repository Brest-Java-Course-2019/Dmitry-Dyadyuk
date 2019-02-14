package com.epam.brest.cources.fileReader;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class PropertyReader implements Reader<String, BigDecimal> {
    @Override
    public Map<String, BigDecimal> getMap(String path) throws IOException {
        InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(path);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.entrySet().stream().collect(
                Collectors.toMap(e -> String.valueOf(e.getKey()),
                        e -> new BigDecimal(e.getValue().toString())));
    }
}
