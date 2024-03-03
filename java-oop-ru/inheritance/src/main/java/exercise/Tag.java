package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    String tagName;
    Map<String, String> tagAtt;

    public Tag(String tagName, Map tagAtt) {
        this.tagName = tagName;
        this.tagAtt = tagAtt;
    }

    public String toString() {
        String tagAttToString = tagAtt.entrySet().stream()
                .map((entry) -> " " + entry.getKey() + "=" + "\"" + entry.getValue() + "\"")
                .collect(Collectors.joining());

        return String.format("<%s%s>", tagName, tagAttToString);
    }
}
// END
