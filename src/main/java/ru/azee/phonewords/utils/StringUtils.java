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
        return str == null ? "" : str.toUpperCase();
    }

    /**
     * Remove all but letters and make all uppercase
     * @param str - input string
     * @return - normalized string
     */
    public static String normalizeWords(String str){
        return normalize(str).replaceAll("[^a-zA-Z]+","");
    }

    /**
     * Remove all but numbers
     * @param str - input string
     * @return - normalized string
     */
    public static String normalizeNumbers(String str){
        return normalize(str).replaceAll("[^0-9]+","");
    }
}
