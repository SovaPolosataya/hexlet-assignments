package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String str;

    public ReversedSequence(String str) {
        this.str = str;
    }

    public String reverse() {
        char[] chars = str.toCharArray();
        String result = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            result += chars[i];
        }
        return result;
    }

    public int length() {
        return str.length();
    }

    public char charAt(int index) {
        return reverse().charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return reverse().subSequence(start, end);
    }

    public String toString() {
        return reverse();
    }
}
// END
