package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {

    public static List<String> buildApartmentsList(List<Home> houses, int n) {
        List<String> result = houses.stream()
                .sorted((o1, o2) -> Double.compare(o1.getArea(), o2.getArea()))
                .limit(n)
                .map(v -> v.toString())
                .toList();
        return result;
    }
}
// END
