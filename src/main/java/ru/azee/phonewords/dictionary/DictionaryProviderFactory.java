package ru.azee.phonewords.dictionary;

/**
 * Created by azee on 24.10.16.
 */
public class DictionaryProviderFactory {
    public final static String FILE_PATH_PROPERTY = "dictionary";

    /**
     * Get a provider depending on parameters
     * @return - DictionaryProvider implementation
     */
    public static DictionaryProvider getProvider(){
        String path = System.getProperty(FILE_PATH_PROPERTY);
        return path == null || "".equals(path) ?
                new DefaultDictionaryProvider() : new FileDictionaryProvider(path);
    }
}
