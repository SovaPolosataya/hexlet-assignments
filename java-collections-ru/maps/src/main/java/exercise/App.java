package exercise;

import java.util.Map;
import java.util.HashMap;

public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        String[] individualWords = sentence.toLowerCase().split(" ");
        Map<String, Integer> dictionary = new HashMap<>();

        if (sentence.isEmpty()) {
            return dictionary;
        }

        for (String word : individualWords) {
            Integer counter = dictionary.getOrDefault(word, 0);
            dictionary.put(word, counter + 1);
        }
        return dictionary;
    }

    public static String toString(Map<String, Integer> dictionary) {
        String emptyLine = "{}";

        if (dictionary.isEmpty()) {
            return emptyLine;
        }

        String dictionaryText = "";

        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            dictionaryText = dictionaryText + "  " + entry.getKey() + ": " + entry.getValue() + "\n";
        }
        String fullLine = "{\n" + dictionaryText + "}";

        return fullLine;
    }
}
