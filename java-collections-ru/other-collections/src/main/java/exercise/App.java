package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> dict1, Map<String, Object> dict2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        Set<String> allKeys = new TreeSet<>(dict1.keySet());
        allKeys.addAll(dict2.keySet());

        for (var key : allKeys) {
            if (!dict1.containsKey(key)) {
                result.put(key, "added");
            } else if (!dict2.containsKey(key)) {
                result.put(key, "deleted");
            } else if (dict1.get(key).equals(dict2.get(key))) {
                result.put(key, "unchanged");
            } else {
                result.put(key, "changed");
            }
        }
        return result;
    }
}
