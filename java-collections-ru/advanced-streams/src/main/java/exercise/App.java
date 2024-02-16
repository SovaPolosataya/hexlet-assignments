package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String conf) {

        String result = Arrays.stream(conf.split("\n"))
                .filter(x -> x.startsWith("environment="))
                .map(x -> x.replaceAll("environment=", ""))
                .map(x -> x.replaceAll("\"", ""))
                .map(x -> x.split(","))
                .flatMap(Arrays::stream)
                .filter(v -> v.startsWith("X_FORWARDED_"))
                .map(v -> v.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));

        return result;
    }
}
//END
