package ru.azee.phonewords.traversal;

import ru.azee.phonewords.dictionary.DictionaryBuilder;
import ru.azee.phonewords.dictionary.NumbersMap;

import java.util.List;

/**
 * Created by azee on 26.10.16.
 */
public class DictTraversalMock extends DictTraversalBase {
    public DictTraversalMock(List<String> dictionary, List<String> numbers) {
        this.dictionary = DictionaryBuilder.build(dictionary);
        this.numbers = numbers;
        numbersMap = new NumbersMap();
    }
}
