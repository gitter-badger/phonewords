package ru.azee.phonewords;
import ru.azee.phonewords.executor.ExecutorFactory;

/**
 * Created by azee on 24.10.16.
 */
public class Main {

    public static void main(String... args){
        ExecutorFactory.getExecutor().execute();
    }

}
