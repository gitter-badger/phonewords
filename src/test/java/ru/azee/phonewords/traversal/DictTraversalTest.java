package ru.azee.phonewords.traversal;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by azee on 26.10.16.
 */
public class DictTraversalTest {

    @Test
    public void positiveExampleTest(){
        Map<String, Set<String>> result =  new DictTraversalMock(
                Arrays.asList("call", "me", "now"),
                Arrays.asList("2255.63")).getValues();

        validateNumberResult(result, 1, "2255.63");
        validateInvariants(result, "2255.63", 1, "CALL-ME");
    }

    @Test
    public void multipleInvariantsTest(){
        Map<String, Set<String>> result =  new DictTraversalMock(
                Arrays.asList("call", "me", "now", "ball"),
                Arrays.asList("2255.63")).getValues();

        validateNumberResult(result, 1, "2255.63");
        validateInvariants(result, "2255.63", 2, "CALL-ME", "BALL-ME");
    }

    @Test
    public void longInvariantsTest(){
        Map<String, Set<String>> result =  new DictTraversalMock(
                Arrays.asList("call", "me", "now", "baklof", "callof"),
                Arrays.asList("2255.63")).getValues();

        validateNumberResult(result, 1, "2255.63");
        validateInvariants(result, "2255.63", 3, "CALL-ME", "BAKLOF", "CALLOF");
    }

    @Test
    public void oneAsNumberAtTheBeginningTest(){
        Map<String, Set<String>> result =  new DictTraversalMock(
                Arrays.asList("call", "me", "now"),
                Arrays.asList("12255.63")).getValues();

        validateNumberResult(result, 1, "12255.63");
        validateInvariants(result, "12255.63", 1, "1-CALL-ME");
    }

    @Test
    public void oneAsNumberInTheMiddleTest(){
        Map<String, Set<String>> result =  new DictTraversalMock(
                Arrays.asList("call", "me", "now"),
                Arrays.asList("2255163")).getValues();

        validateNumberResult(result, 1, "2255163");
        validateInvariants(result, "2255163", 1, "CALL-1-ME");
    }

    @Test
    public void oneAsNumberAtTheEndTest(){
        Map<String, Set<String>> result =  new DictTraversalMock(
                Arrays.asList("call", "me", "now"),
                Arrays.asList("2255631")).getValues();

        validateNumberResult(result, 1, "2255631");
        validateInvariants(result, "2255631", 1, "CALL-ME-1");
    }

    @Test
    public void randomNumberInDifferentPlacesTheEndTest(){
        Map<String, Set<String>> result =  new DictTraversalMock(
                Arrays.asList("call", "me", "now"),
                Arrays.asList("722558639")).getValues();

        validateNumberResult(result, 1, "722558639");
        validateInvariants(result, "722558639", 1, "7-CALL-8-ME-9");
    }

    @Test
    public void oneAsNumberInDifferentPlacesTest(){
        Map<String, Set<String>> result =  new DictTraversalMock(
                Arrays.asList("call", "me", "now"),
                Arrays.asList("122551631")).getValues();

        validateNumberResult(result, 1, "122551631");
        validateInvariants(result, "122551631", 1, "1-CALL-1-ME-1");
    }

    @Test
    public void consequenceNumbersTest(){
        Map<String, Set<String>> result =  new DictTraversalMock(
                Arrays.asList("gL", "g", "L"),
                Arrays.asList("2345")).getValues();

        validateNumberResult(result, 0);
    }

    @Test
    public void multipleNumbersTest(){
        Map<String, Set<String>> result =  new DictTraversalMock(
                Arrays.asList("ad", "bf", "beg", "ceg"),
                Arrays.asList("123", "234")).getValues();

        validateNumberResult(result, 2, "123", "234");
        validateInvariants(result, "123", 2, "1-AD", "1-BF");
        validateInvariants(result, "234", 4, "BEG", "CEG", "AD-4", "BF-4");
    }

    @Test
    public void invalidSymbolsInNumbersTest(){
        final String number = "§±!@#$%4^&*()4_-+=7?/3_6-_3*&^><";
        Map<String, Set<String>> result =  new DictTraversalMock(
                Arrays.asList("h!i r\ne", "±§?.-'/m190-_=}{|:;.><,)(*&^%$#@!e"),
                Arrays.asList(number)).getValues();
        validateNumberResult(result, 1, number);
        validateInvariants(result, number, 1, "HIRE-ME");
    }

    private void validateNumberResult(Map<String, Set<String>> result, int size, String... keys){
        assertNotNull(result);
        assertThat(result.size(), is(size));
        assertThat(result.keySet(), containsInAnyOrder(keys));
    }

    private void validateInvariants(Map<String, Set<String>> result, String key, int size, String... values){
        Set<String> gotValues = result.get(key);
        assertNotNull(gotValues);
        assertThat(gotValues.size(), is(size));
        assertThat(gotValues, containsInAnyOrder(values));
    }
}
