package ru.azee.phonewords.traversal;

import ru.azee.phonewords.data.DataProviderFactory;
import ru.azee.phonewords.dictionary.DictionaryBuilder;
import ru.azee.phonewords.dictionary.DictionaryProviderFactory;
import ru.azee.phonewords.dictionary.NumbersMap;

/**
 * Created by azee on 24.10.16.
 */
public class DictTraversal extends DictTraversalBase{

    public DictTraversal() {
        dictionary = DictionaryBuilder.build(DictionaryProviderFactory.getProvider().provide());
        numbers = DataProviderFactory.getDataProvider().provide();
        numbersMap = new NumbersMap();
    }
}
