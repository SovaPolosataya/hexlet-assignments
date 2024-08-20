package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc

// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }

    // BEGIN

    public Task testTask() {
        Task testTask = new Task();
        testTask = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
        taskRepository.save(testTask);

        return testTask;
    }

    @Test
    public void testShow() throws Exception {
        Task testTask = testTask();

        var result = mockMvc.perform(get("/tasks/{id}", testTask.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json(om.writeValueAsString(testTask)));

        taskRepository.deleteById(testTask.getId());
    }

    @Test
    public void testCreate() throws Exception {
        Task testTask = testTask();

        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(testTask));

        mockMvc.perform(request)
                .andExpect(status().isCreated());

        taskRepository.deleteById(testTask.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        Task testTask = testTask();

        var data = new HashMap<>();
        data.put("title", "Other");
        data.put("description", "bbbsssddd");

        var request = put("/tasks/" + testTask.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request)
                .andExpect(status().isOk());

        testTask = taskRepository.findById(testTask.getId()).get();
        assertThatJson(testTask).and(
                a -> a.node("title").isEqualTo("Other"),
                a -> a.node("description").isEqualTo("bbbsssddd")
        );

        assertThat(testTask.getTitle()).isEqualTo(("Other"));
        assertThat(testTask.getDescription()).isEqualTo(("bbbsssddd"));

        taskRepository.deleteById(testTask.getId());
    }

    @Test
    public void testDelete() throws Exception {
        Task testTask1 = testTask();
        Task testTask2 = testTask();

        mockMvc.perform(delete("/tasks/{id}", testTask1.getId()))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/tasks/{id}", testTask2.getId()))
                .andExpect(status().isOk());

        assertThat(taskRepository.findAll()).isEmpty();
    }

    // END
}
