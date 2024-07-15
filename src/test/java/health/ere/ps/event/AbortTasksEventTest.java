package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


class AbortTasksEventTest {

    @Test
    void testDefaultConstructor(){
        AbortTasksEvent abortTasksEvent = new AbortTasksEvent();
        Assertions.assertNotNull(abortTasksEvent.getTasks(), "Tasks list should not be null");
        Assertions.assertTrue(abortTasksEvent.getTasks().isEmpty(), "Tasks list should be empty by default");
    }

    @Test
    void testConstructorWithJsonArray() {
        JsonArray jsonArray = Json.createArrayBuilder()
                .add(Json.createObjectBuilder().add("accessCode", "code1").add("id", "id1"))
                .add(Json.createObjectBuilder().add("accessCode", "code2").add("id", "id2"))
                .build();

        AbortTasksEvent abortTasksEvent = new AbortTasksEvent(jsonArray);

        Assertions.assertEquals(2, abortTasksEvent.getTasks().size(), "Tasks list should contain two entries");
        Assertions.assertEquals("code1", abortTasksEvent.getTasks().get(0).getAccessCode(), "First entry access code should match");
        Assertions.assertEquals("id2", abortTasksEvent.getTasks().get(1).getId(), "Second entry ID should match");
    }

    @Test
    void testConstructorWithJsonObject() {
        JsonArray jsonArray = Json.createArrayBuilder()
                .add(Json.createObjectBuilder().add("accessCode", "code1").add("id", "id1"))
                .add(Json.createObjectBuilder().add("accessCode", "code2").add("id", "id2"))
                .build();

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("payload", jsonArray)
                .build();

        Session mockSession = Mockito.mock(Session.class);

        AbortTasksEvent abortTasksEvent = new AbortTasksEvent(jsonObject, mockSession, "testId");
        Assertions.assertEquals(2, abortTasksEvent.getTasks().size(), "Tasks list should contain two entries");
        Assertions.assertEquals("code1", abortTasksEvent.getTasks().get(0).getAccessCode(), "First entry access code should match");
        Assertions.assertEquals("id2", abortTasksEvent.getTasks().get(1).getId(), "Second entry ID should match");
        Assertions.assertEquals(mockSession, abortTasksEvent.replyTo, "ReplyTo session should match");
        Assertions.assertEquals("testId", abortTasksEvent.id, "ID should match");
    }

    @Test
    void testSetAndGetTasks() {
        List<AbortTaskEntry> tasks = new ArrayList<>();
        JsonObject AccessCodeIdOne = Json.createObjectBuilder().add("accessCode", "code1").add("id", "id1").build();
        JsonObject AccessCodeIdTwo = Json.createObjectBuilder().add("accessCode", "code2").add("id", "id2").build();

        tasks.add(new AbortTaskEntry(AccessCodeIdOne));
        tasks.add(new AbortTaskEntry(AccessCodeIdTwo));

        AbortTasksEvent event = new AbortTasksEvent();
        event.setTasks(tasks);

        Assertions.assertEquals(2, event.getTasks().size(), "Tasks list should contain two entries");
        Assertions.assertEquals("code1", event.getTasks().get(0).getAccessCode(), "First entry access code should match");
        Assertions.assertEquals("id2", event.getTasks().get(1).getId(), "Second entry ID should match");
    }

    @Test
    void testAddAbortTaskEntry() {
        AbortTaskEntry abortTaskEntry = new AbortTaskEntry();
        abortTaskEntry.setAccessCode("accessCode");
        abortTaskEntry.setId("id");

        AbortTasksEvent abortTasksEvent = new AbortTasksEvent();
        abortTasksEvent.addAbortTaskEntry(abortTaskEntry);

        Assertions.assertEquals(1, abortTasksEvent.getTasks().size(), "Tasks list should contain one entry");
        Assertions.assertEquals("accessCode", abortTasksEvent.getTasks().get(0).getAccessCode(), "Entry access code should match");
        Assertions.assertEquals("id", abortTasksEvent.getTasks().get(0).getId(), "Entry ID should match");
    }
}