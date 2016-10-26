package ru.azee.phonewords.dictionary;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by azee on 26.10.16.
 */
public class NodeTest {

    @Test
    public void initNodeTest(){
        Node head = new Node();
        Map<Character, Node> children = head.getChildren();
        assertNotNull(children);
        assertThat(children.size(), is(0));

        head.initChild('A');
        assertThat(children.size(), is(1));
        assertNotNull(children.get('A'));
        assertNotNull(children.get('A').getChildren());
        assertThat(children.get('A').getChildren().size(), is(0));
    }


}
