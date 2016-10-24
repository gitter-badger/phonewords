package ru.azee.phonewords.dictionary;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by azee on 24.10.16.
 */
public class DefaultDictionaryProvider implements DictionaryProvider {
    @Override
    public List<String> provide() {
        return Stream.of("CALL", "ME", "AAJJMD", "AA", "A").collect(toList());
    }
}
