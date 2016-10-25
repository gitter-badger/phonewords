package ru.azee.phonewords.utils;

/**
 * Created by azee on 25.10.16.
 */
public class StringUtils {
    public static String normalize(String str){
        str = str == null ? "" : str;
        str = str.toUpperCase().replaceAll("[^a-zA-Z0-9]+","");
        return str;
    }
}
