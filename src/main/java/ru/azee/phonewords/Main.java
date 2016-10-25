package ru.azee.phonewords;
import ru.azee.phonewords.traversal.DictTraversal;

import java.util.Map;
import java.util.Set;

/**
 * Created by azee on 24.10.16.
 */
public class Main {

    public static void main(String... args){
        Map<String, Set<String>> values = new DictTraversal().getValues();
        printResults(values);
    }

    private static void printResults(Map<String, Set<String>> values) {
        values.entrySet().forEach(entry -> {
            System.out.println(String.format("%s: ", entry.getKey()));
            entry.getValue().forEach(System.out::println);
            System.out.println();
        });
    }

}
