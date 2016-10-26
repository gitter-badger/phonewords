package ru.azee.phonewords.executor;

import ru.azee.phonewords.dictionary.DictionaryBuilder;
import ru.azee.phonewords.dictionary.DictionaryProviderFactory;
import ru.azee.phonewords.traversal.DictTraversal;

import java.util.Map;
import java.util.Set;

/**
 * Created by azee on 26.10.16.
 *
 * Executor is used to perform actions
 * As we may want to interact with user live or we may want to use files
 * we have to use different types of execution - interact or run-once.
 *
 * It is possible to implement async or queued executors as well.
 *
 * This abstraction allows to implement different types of interactions.
 */
public abstract class Executor {

    final protected DictTraversal traversal = new DictTraversal(
            DictionaryBuilder.build(DictionaryProviderFactory.getProvider().provide())
    );

    public abstract void execute();

    protected void printValues(Map<String, Set<String>> values) {
        values.entrySet().forEach(entry -> {
            System.out.println(String.format("%s: ", entry.getKey()));
            entry.getValue().forEach(System.out::println);
            System.out.println();
        });
    }
}
