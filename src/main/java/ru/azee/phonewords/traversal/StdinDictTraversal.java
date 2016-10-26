package ru.azee.phonewords.traversal;

import ru.azee.phonewords.dictionary.DictionaryBuilder;
import ru.azee.phonewords.dictionary.DictionaryProviderFactory;
import ru.azee.phonewords.dictionary.NumbersMap;

import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.singletonList;

/**
 * Created by azee on 24.10.16.
 */
public class StdinDictTraversal extends DictTraversalBase{

    public StdinDictTraversal() {
        dictionary = DictionaryBuilder.build(DictionaryProviderFactory.getProvider().provide());
        numbers = new ArrayList<>();
        numbersMap = new NumbersMap();
    }

    @Override
    public void printValues() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print("Enter a phone number: ");
            String number = scanner.nextLine();

            if ("quit".equals(number) || "exit".equals(number)) {
                break;
            }
            numbers = singletonList(number);
            printValues(getValues());
        }
        scanner.close();
    }
}
