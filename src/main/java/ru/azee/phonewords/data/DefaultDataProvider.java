package ru.azee.phonewords.data;


import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by azee on 24.10.16.
 */
public class DefaultDataProvider implements DataProvider {
    @Override
    public List<String> provide() {
//        return Stream.of("225563", "2255.63").collect(toList());
//        return Stream.of("225563").collect(toList());
        return Stream.of("225563").collect(toList());
    }
}
