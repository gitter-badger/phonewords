package ru.azee.phonewords.dictionary;

import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by azee on 26.10.16.
 */
public class DictionaryProviderFactoryTest {

    @After
    public void tearDown(){
        System.setProperty(DictionaryProviderFactory.FILE_PATH_PROPERTY, "");
    }

    @Test
    public void dictionaryProviderGetTest(){
        DictionaryProvider provider = DictionaryProviderFactory.getProvider();
        assertNotNull(provider);
        assertThat(provider, instanceOf(DefaultDictionaryProvider.class));

        System.setProperty(DictionaryProviderFactory.FILE_PATH_PROPERTY, "path");
        provider = DictionaryProviderFactory.getProvider();
        assertNotNull(provider);
        assertThat(provider, instanceOf(FileDictionaryProvider.class));
    }


    @Test
    public void defaultDictionaryProviderTest(){
        DictionaryProvider provider = DictionaryProviderFactory.getProvider();
        List<String> dict = provider.provide();
        assertThat(dict.size(), is(2));
        assertThat(dict, containsInAnyOrder("call", "me"));
    }
}
