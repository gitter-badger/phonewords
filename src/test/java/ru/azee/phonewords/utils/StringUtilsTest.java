package ru.azee.phonewords.utils;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.azee.phonewords.utils.StringUtils.normalize;
import static ru.azee.phonewords.utils.StringUtils.normalizeNumbers;
import static ru.azee.phonewords.utils.StringUtils.normalizeWords;

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
        assertThat(normalize(""), is(""));
        assertThat(normalize(null), is(""));
    }

    @Test
    public void normalizeWordTest(){
        assertThat(normalizeWords("1a2B345c6D7!@#$^%&*e"), is("ABCDE"));
        assertThat(normalizeWords(""), is(""));
        assertThat(normalizeWords(null), is(""));
    }

    @Test
    public void normalizeNumbersTest(){
        assertThat(normalizeNumbers("K"), is(""));
        assertThat(normalizeNumbers("123"), is("123"));
        assertThat(normalizeNumbers("123s7B"), is("1237"));
        assertThat(normalizeNumbers("12.3-4_5 6\n7~8`9§0"), is("1234567890"));
        assertThat(normalizeNumbers(""), is(""));
        assertThat(normalizeNumbers(null), is(""));
    }
}
