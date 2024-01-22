package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers = new ArrayList<>();
        List<Integer> testNumbers = new ArrayList<>();

        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(testNumbers).isEqualTo(App.take(numbers, 0));

        testNumbers.addAll(Arrays.asList(1, 2, 3));
        assertThat(testNumbers).isEqualTo(App.take(numbers, 3));

        assertThat(numbers).isEqualTo(App.take(numbers, 10));
        // END
    }
}
