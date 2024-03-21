package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) throws Exception {
        String carJson = car.serialize();
        Files.writeString(path, carJson, StandardOpenOption.WRITE);
    }

    public static Car extract(Path path) throws Exception {
        String carJson = Files.readString(path);

        return Car.unserialize(carJson);
    }
}
// END
