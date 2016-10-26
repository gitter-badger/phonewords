package ru.azee.phonewords.dictionary;

import java.util.List;

/**
 * Created by azee on 24.10.16.
 */
public interface DictionaryProvider {
    /**
     * Provide a list of words from the dictionary.
     * @return - list of words
     */
    public List<String> provide();
}
