package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        if (sentence.length == 0) {
            return (new HashMap<String, Integer>(0));

        String[] individualWords = sentence.toLowerCase().split(" ");
        Map<String, Integer> dictionary = new HashMap<>();

        for (String word : individualWords) {
            Integer counter = dictionary.getOrDefault(word, 0);
            dictionary.put(word, counter + 1);
        }

        return dictionary;
    }

    public static String toString(Map<String, Integer> catalog) {
        String emptyLine = "\\{\\}";
        if (catalog.isEmpty()) {
            return emptyLine.substring(1, emptyLine.length() - 1);
        }
        String catalogText = "";

        for (Map.Entry<String, Integer> entry : catalog.entrySet()) {
            catalogText += ("  " + entry.getKey() + ": " + entry.getValue() + "\n");
        }
        String fullLine = "\\{\n" + catalogText + "\\}";

        return fullLine.substring(1, fullLine.length() - 1);
    }
}
//END
