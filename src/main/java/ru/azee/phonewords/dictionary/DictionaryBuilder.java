package ru.azee.phonewords.dictionary;

import java.util.List;

/**
 * Created by azee on 24.10.16.
 */
public class DictionaryBuilder {

    public static Node build(List<String> words){
        Node head = new Node();
        words.forEach(word -> addToTree(word, head));
        return head;
    }

    private static void addToTree(String word, Node head) {
        for (char character : word.toCharArray()){
            head = head.initChild(character);
        }
        head.setWord(word);
    }
}
