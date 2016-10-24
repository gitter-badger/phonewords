package ru.azee.phonewords.traversal;

import ru.azee.phonewords.data.DataProviderFactory;
import ru.azee.phonewords.dictionary.DictionaryBuilder;
import ru.azee.phonewords.dictionary.DictionaryProviderFactory;
import ru.azee.phonewords.dictionary.Node;
import ru.azee.phonewords.dictionary.NumbersMap;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

/**
 * Created by azee on 24.10.16.
 */
public class DictTraversal {
    private Node dictionary;
    private List<String> numbers;
    private NumbersMap numbersMap;

    public DictTraversal() {
        dictionary = DictionaryBuilder.build(DictionaryProviderFactory.getProvider().provide());
        numbers = DataProviderFactory.getDataProvider().provide();
        numbersMap = new NumbersMap();
    }

    public Map<String, Set<String>> getValues() {
        return numbers.stream().collect(toMap(numb -> numb, numb -> getWords(numb)));

    }

    private Set<String> getWords(String numb) {
        Set<String> values = new HashSet<>();
        getWords(numb, dictionary, new StringBuilder(), values);
        return values;
    }

    private void getWords(String numb, Node head, StringBuilder sb, Set<String> values) {
        //ToDo : do something with 1
//        numbersMap.getDict().get(numb.charAt(0)).stream().forEach(character ->
//                getWords(numb, head, head.getChildren().get(character), dictionary, sb, values, numbersMap)
//        );
        if (numb.length() == 0){
            if (sb.length() > 0){
                values.add(sb.toString());
            }
            return;
        }
        for (Character character : numbersMap.getDict().get(numb.charAt(0))){
            getWords(numb, head, head.getChildren().get(character), new StringBuilder(sb), values);
        }
    }

    private void getWords(String numb, Node head, Node child, StringBuilder sb, Set<String> values) {
//        if (numb.length() == 0){
//            values.add(sb.toString());
//            return;
//        }
        if (child == null){ //ToDo : disallow 2 digits
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-'){
                return;
            }

            if (sb.length() > 0){
                sb.append("-");
            }
            sb.append(numb.charAt(0));
            if (numb.length() > 1){
                sb.append("-");
            }
            head = dictionary;
        } else {
            head = child;
            //GetMore words if possible even if hit the target word
            //getWords(numb.substring(1, numb.length()), head, dictionary, new StringBuilder(sb), values, numbersMap);

            if (child.getWord() != null){
                sb.append(child.getWord());
                head = dictionary;
                if (numb.length() > 1){
                    sb.append("-");
                }
            }
        }
        getWords(numb.substring(1, numb.length()), head, sb, values);
    }

}
