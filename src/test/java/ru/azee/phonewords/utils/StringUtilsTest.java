package ru.azee.phonewords.utils;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.azee.phonewords.utils.StringUtils.normalize;

/**
 * Created by azee on 25.10.16.
 */
public class StringUtilsTest {

    @Test
    public void normalizeTest(){
        assertThat(normalize("aBcDe"), is("ABCDE"));
        assertThat(normalize("s"), is("S"));
        assertThat(normalize("K"), is("K"));
        assertThat(normalize("123"), is("123"));
        assertThat(normalize("123s7B"), is("123S7B"));
        assertThat(normalize("12.3-4_5 6\n7~8`9§0"), is("1234567890"));
        assertThat(normalize(""), is(""));
        assertThat(normalize(null), is(""));
    }
}
