package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {

        MaxThread thread1 = new MaxThread(numbers);
        MinThread thread2 = new MinThread(numbers);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread2.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        return Map.of("min", thread2.getMin(), "max", thread1.getMax());
    }
    // END
}
