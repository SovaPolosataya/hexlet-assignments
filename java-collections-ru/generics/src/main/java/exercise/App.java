package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> parameters) {
        List<Map<String, String>> newBooks = new ArrayList<>();
        Map<String, String> isBook;

        for (var book : books) {
            isBook = book;
            boolean coincident = true;

            for (Map.Entry<String, String> parameter : parameters.entrySet()) {
                if (!isBook.containsKey(parameter.getKey()) || !isBook.containsValue(parameter.getValue())) {
                    coincident = false;
                    break;
                }
            }
            if (coincident) {
                newBooks.add(isBook);
            }
        }
        return newBooks;
    }
}
