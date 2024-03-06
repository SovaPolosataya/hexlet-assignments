package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String stringTag;
    private TagInterface tag;

    public LabelTag(String stringTag, TagInterface tag) {
        this.stringTag = stringTag;
        this.tag = tag;
    }

    public String render() {
        return "<label>" + stringTag + tag.render() + "</label>";
    }
}
// END
