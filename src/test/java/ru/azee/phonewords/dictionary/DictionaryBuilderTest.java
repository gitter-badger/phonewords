package ru.azee.phonewords.dictionary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by azee on 25.10.16.
 */
public class DictionaryBuilderTest {

    @Test
    public void buildTrieTreeTest(){
        Node head = DictionaryBuilder.build(
                Arrays.asList("fat", "not", "fit")
        );

        assertNotNull(head);
        assertNull(head.getWord());
        Map<Character, Node> children = head.getChildren();
        assertThat(children.size(), is(2));
        assertThat(children.keySet(), containsInAnyOrder('F', 'N'));

        Node child = children.get('F');
        assertNotNull(child);
        assertNull(child.getWord());
        children = child.getChildren();
        assertThat(children.size(), is(2));
        assertThat(children.keySet(), containsInAnyOrder('A', 'I'));

        child = children.get('I');
        assertNotNull(child);
        assertNull(child.getWord());
        children = child.getChildren();
        assertThat(children.size(), is(1));
        assertThat(children.keySet(), containsInAnyOrder('T'));

        child = children.get('T');
        assertNotNull(child);
        assertThat(child.getWord(), is("FIT"));
        assertThat(child.getChildren().size(), is(0));
    }

    @Test
    public void buildEmptyTree(){
        Node head = DictionaryBuilder.build(new ArrayList<>());
        assertNotNull(head);
        assertNull(head.getWord());
        assertThat(head.getChildren().size(), is(0));
    }

    @Test
    public void buildTrieTreeWithDuplicate(){
        Node head = DictionaryBuilder.build(
                Arrays.asList("fin", "final", "fin")
        );

        assertNotNull(head);
        assertNull(head.getWord());
        assertThat(head.getChildren().size(), is(1));
        assertThat(head.getChildren().keySet(), containsInAnyOrder('F'));

        head = head.getChildren().get('F');
        assertNotNull(head);
        assertNull(head.getWord());
        assertThat(head.getChildren().size(), is(1));
        assertThat(head.getChildren().keySet(), containsInAnyOrder('I'));

        head = head.getChildren().get('I');
        assertNotNull(head);
        assertNull(head.getWord());
        assertThat(head.getChildren().size(), is(1));
        assertThat(head.getChildren().keySet(), containsInAnyOrder('N'));

        head = head.getChildren().get('N');
        assertNotNull(head);
        assertThat(head.getWord(), is("FIN"));
        assertThat(head.getChildren().size(), is(1));
        assertThat(head.getChildren().keySet(), containsInAnyOrder('A'));

        head = head.getChildren().get('A');
        assertNotNull(head);
        assertNull(head.getWord());
        assertThat(head.getChildren().size(), is(1));
        assertThat(head.getChildren().keySet(), containsInAnyOrder('L'));

        head = head.getChildren().get('L');
        assertNotNull(head);
        assertThat(head.getWord(), is("FINAL"));
        assertThat(head.getChildren().size(), is(0));
    }

}
