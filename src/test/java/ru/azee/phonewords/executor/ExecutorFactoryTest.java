package ru.azee.phonewords.executor;

import org.junit.After;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;


/**
 * Created by azee on 27.10.16.
 */
public class ExecutorFactoryTest {

    @After
    public void tearDown(){
        System.setProperty(ExecutorFactory.FILE_PATH_PROPERTY, "");
    }

    @Test
    public void executorFactoryGetTest(){
        Executor executor = ExecutorFactory.getExecutor();
        assertNotNull(executor);
        assertThat(executor, instanceOf(StdinExecutor.class));

        System.setProperty(ExecutorFactory.FILE_PATH_PROPERTY, "path");
        executor = ExecutorFactory.getExecutor();
        assertNotNull(executor);
        assertThat(executor, instanceOf(FileExecutor.class));
    }
}
