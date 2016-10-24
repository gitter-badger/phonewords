package ru.azee.phonewords.dictionary;


import java.util.*;

/**
 * Created by azee on 24.10.16.
 */
public class Node {
    private String word;
    private Map<Character, Node> children;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Node withWord(String word){
        setWord(word);
        return this;
    }

    public Map<Character, Node> getChildren() {
        if (children == null){
            children = new HashMap<>();
        }
        return children;
    }

    public Node initChild(Character character) {
        Node child = getChildren().get(character);
        if (child == null){
            child = new Node();
            getChildren().put(character, child);
        }
        return child;
    }
}
