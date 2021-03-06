package ru.azee.phonewords.executor;

/**
 * Created by azee on 26.10.16.
 */
public class ExecutorFactory {
    public final static String FILE_PATH_PROPERTY = "data";

    /**
     * Provide an executor depending on system environment
     * @return - an executor implementation
     */
    public static Executor getExecutor(){
        String dataFilePath = System.getProperty(FILE_PATH_PROPERTY);
        return dataFilePath == null || "".equals(dataFilePath) ?
                new StdinExecutor() : new FileExecutor(dataFilePath);
    }
}
