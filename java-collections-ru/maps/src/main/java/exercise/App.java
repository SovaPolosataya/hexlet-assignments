package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        String[] individualWords = sentence.toLowerCase().split(" ");
        Map<String, Integer> dictionary = new HashMap<>();
        if (individualWords.length(0)) {
            return dictionary;
        }

        for (String word : individualWords) {
            Integer counter = dictionary.getOrDefault(word, 0);
            dictionary.put(word, counter + 1);
        }

        return dictionary;
    }

        public static String toString(Map<String, Integer> catalog) {
        if (catalog.isEmpty()) {
            return "\\{\\}";
        }
        String catalogText = "";

        for (Map.Entry<String, Integer> entry : catalog.entrySet()) {
           catalogText += ("  " + entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return "\\{\n" + catalogText + "\\}";
    }
}
//END
