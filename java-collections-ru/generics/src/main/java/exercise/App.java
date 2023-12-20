package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> parameters) {
        List<Map<String, String>> newBooks = new ArrayList<>();
        Map<String, String> isBook;
        var entries = parameters.entrySet();
        boolean coincident = false;

        for (var book : books) {
            isBook = book;

            for (var entry : entries) {
                if (!isBook.containsKey(entry.getKey()) || !isBook.containsValue(entry.getValue())) {
                    break;
                }
                coincident = true;
            }
            if (coincident) {
                newBooks.add(isBook);
            }
        }
        return newBooks;
    }
}
