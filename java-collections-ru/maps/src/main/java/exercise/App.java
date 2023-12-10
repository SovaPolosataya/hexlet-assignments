package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        if (sentence.length == 0) {
            return (new HashMap<String, Integer>());

        String[] individualWords = sentence.toLowerCase().split(" ");
        Map<String, Integer> dictionary = new HashMap<>();

        for (String word : individualWords) {
            Integer counter = dictionary.getOrDefault(word, 0);
            dictionary.put(word, counter + 1);
        }

        return dictionary;
    }

    public static String toString(Map<String, Integer> dictionary) {
        String emptyLine = "\\{\\}";
        
        if (dictionary.isEmpty()) {
            return emptyLine;
        }
        String dictionaryText = "";

        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            dictionaryText += ("  " + entry.getKey() + ": " + entry.getValue() + "\n");
        }
        String fullLine = "\\{\n" + dictionaryText + "\\}";

        return fullLine;
    }
}
//END
