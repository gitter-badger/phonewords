package ru.azee.phonewords.dictionary;

/**
 * Created by azee on 24.10.16.
 */
public class DictionaryProviderFactory {
    public static DictionaryProvider getProvider(){
        return new DefaultDictionaryProvider();
    }
}
