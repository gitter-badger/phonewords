package ru.azee.phonewords.data;

import javax.xml.crypto.Data;

/**
 * Created by azee on 24.10.16.
 */
public class DataProviderFactory {
    public static DataProvider getDataProvider(){
        return new DefaultDataProvider();
    }
}
