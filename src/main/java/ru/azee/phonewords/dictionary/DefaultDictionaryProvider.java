package ru.azee.phonewords.dictionary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by azee on 24.10.16.
 */
public class DefaultDictionaryProvider implements DictionaryProvider {
    @Override
    public List<String> provide() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/dictionary.txt")));
            return reader.lines().collect(toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }
}
