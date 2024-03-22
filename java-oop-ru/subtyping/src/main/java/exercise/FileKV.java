package exercise;

// BEGIN
import java.util.Map;
import java.util.HashMap;

public class FileKV implements KeyValueStorage {
    String path;
    Map<String, String> map;

    public FileKV(String path, Map map) {
        this.path = path;
        this.map = new HashMap<>(map);
    }

    public void set(String key, String value) {
        Map<String, String> map1 = new HashMap<>(Utils.unserialize(Utils.readFile(path)));
        map.putAll(map1);
        map.put(key, value);
        Utils.writeFile(path, Utils.serialize(map));
    }

    public void unset(String key) {
        Map<String, String> map1 = new HashMap<>(Utils.unserialize(Utils.readFile(path)));
        map.putAll(map1);
        map.remove(key);
        Utils.writeFile(path, Utils.serialize(map));
    }

    public String get(String key, String defaultValue) {
        Map<String, String> map1 = new HashMap<>(Utils.unserialize(Utils.readFile(path)));
        map.putAll(map1);
        Utils.writeFile(path, Utils.serialize(map));
        return map.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        Map<String, String> newMap = new HashMap<String, String>(this.map);
        Map<String, String> map1 = new HashMap<>(Utils.unserialize(Utils.readFile(path)));
        newMap.putAll(map1);
        Utils.writeFile(path, Utils.serialize(map));
        return newMap;
    }
}
// END
