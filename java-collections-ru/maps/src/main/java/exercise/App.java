package exercise;

import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;

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

        StringBuilder dictionaryText = new StringBuilder();

        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            dictionaryText.append("  ").append(entry.getKey()).append(": ")
                    .append(entry.getValue()).appand("\n");
        }
        String fullLine = "{\n" + dictionaryText + "}";

        return fullLine;
    }
}
