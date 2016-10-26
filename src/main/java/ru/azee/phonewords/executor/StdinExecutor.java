package ru.azee.phonewords.executor;

import java.util.Scanner;
import static java.util.Collections.singletonList;

/**
 * Created by azee on 26.10.16.
 */
public class StdinExecutor extends Executor{

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Enter a phone number: ");
            String number = scanner.nextLine();

            if ("quit".equals(number) || "exit".equals(number)) {
                break;
            }
            printValues(traversal.getValues(singletonList(number)));
        }
        scanner.close();
    }
}
