package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void fileKVTest() {
        String path = filepath.toString();

        FileKV storage = new FileKV(path, new HashMap<>());
        storage.set("key1", "value1");
        storage.set("key2", "value2");

        assertThat(storage.get("key1", null)).isEqualTo("value1");
        assertThat(storage.get("key2", null)).isEqualTo("value2");

        storage.unset("key2");

        assertThat(storage.get("key1", null)).isEqualTo("value1");
        assertThat(storage.get("key2", null)).isNull();

        HashMap<String, String> newStorage = new HashMap<>();
        newStorage.put("key1", "value1");
        newStorage.put("key2", "value2");

        FileKV fileKV = new FileKV(path, newStorage);

        assertThat(fileKV.toMap()).isEqualTo(newStorage);

    }
    // END
}
