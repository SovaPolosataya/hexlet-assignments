package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    Map<String, String> map;

    public InMemoryKV(Map<String, String> map) {
        this.map = new HashMap<>(map);
    }

    public void set(String key, String value) {
        map.put(key, value);
    }

    public void unset(String key) {
        map.remove(key);
    }

    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        Map<String, String> newMap = new HashMap<String, String>(this.map);
        return newMap;
    }
}
// END
