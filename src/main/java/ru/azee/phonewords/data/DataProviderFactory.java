package ru.azee.phonewords.data;

/**
 * Created by azee on 24.10.16.
 */
public class DataProviderFactory {
    private final static String FILE_PATH_PROPERTY = "data";

    public static DataProvider getDataProvider(){
        String path = System.getProperty(FILE_PATH_PROPERTY);
        return path == null ? new DefaultDataProvider() : new FileDataProvider(path);
    }
}
