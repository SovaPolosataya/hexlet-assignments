package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {

    public static KeyValueStorage swapKeyValue(KeyValueStorage keyValue) {
        Map<String, String> newKeyValue = keyValue.toMap();

        for (Map.Entry<String, String> entry : newKeyValue.entrySet()) {
            String value = entry.getKey();
            String key = entry.getValue();
            keyValue.set(key, value);
            keyValue.unset(value);
        }

        return keyValue;
    }
}
// END
