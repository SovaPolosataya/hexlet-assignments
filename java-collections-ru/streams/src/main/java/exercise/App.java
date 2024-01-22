package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        var freeMail = emails.stream()
                .filter((email) -> email.contains("@yandex.ru") || email.contains("@gmail.com")
                        || email.contains("@hotmail.com"))
                .count();
        return freeMail;
    }
}
// END
