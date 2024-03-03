package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String tagBody;
    List<Tag> child;

    public PairedTag(String tagName, Map<String, String> tagAtt, String tagBody, List child) {
        super(tagName, tagAtt);
        this.tagBody = tagBody;
        this.child = child;
    }

    public String toString() {
        String childToString = child.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());

        return String.format("%s%s%s</%s>", super.toString(), tagBody, childToString, tagName);
    }
}
// END
