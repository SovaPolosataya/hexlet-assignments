package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {

        String[][] result = Arrays.stream(image)
                .map(x -> Arrays.stream(x)
                .flatMap(element -> Arrays.stream(new String[] {element, element}))
                .toArray(String[]::new))
                .flatMap(line -> Arrays.stream(new String[][] {line, line}))
                .toArray(String[][]::new);

        return result;
    }
}
// END
