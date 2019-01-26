package com.epam.brest.cources.fileReader;

import java.io.IOException;
import java.util.Map;

public interface Reader<K,V>  {
    Map<K,V> getMap(String path) throws IOException;
}
