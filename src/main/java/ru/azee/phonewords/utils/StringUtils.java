package ru.azee.phonewords.utils;

/**
 * Created by azee on 25.10.16.
 */
public class StringUtils {
    /**
     * Remove all but numbers and letters and make all uppercase
     * @param str - input string
     * @return - normalized string
     */
    public static String normalize(String str){
        str = str == null ? "" : str;
        str = str.toUpperCase().replaceAll("[^a-zA-Z0-9]+","");
        return str;
    }

    /**
     * Remove all but letters and make all uppercase
     * @param str - input string
     * @return - normalized string
     */
    public static String normalizeWords(String str){
        str = normalize(str);
        return str.replaceAll("[^a-zA-Z]+","");
    }
}
