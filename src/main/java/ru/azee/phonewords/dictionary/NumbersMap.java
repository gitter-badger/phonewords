package ru.azee.phonewords.dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * Created by azee on 24.10.16.
 */
public class NumbersMap {
    private Map<Character, Set<Character>> dict = new HashMap<>();

    public NumbersMap() {
        dict.put('2', Stream.of('A', 'B', 'C').collect(toSet()));
        dict.put('3', Stream.of('D', 'E', 'F').collect(toSet()));
        dict.put('4', Stream.of('G', 'H', 'I').collect(toSet()));
        dict.put('5', Stream.of('J', 'K', 'L').collect(toSet()));
        dict.put('6', Stream.of('M', 'N', 'O').collect(toSet()));
        dict.put('7', Stream.of('P', 'Q', 'R', 'S').collect(toSet()));
        dict.put('8', Stream.of('T', 'U', 'V').collect(toSet()));
        dict.put('9', Stream.of('W', 'X', 'Y', 'Z').collect(toSet()));
    }

    public Map<Character, Set<Character>> getDict() {
        return dict;
    }
}
