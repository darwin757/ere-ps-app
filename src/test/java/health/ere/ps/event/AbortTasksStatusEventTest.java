package health.ere.ps.event;

import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class AbortTasksStatusEventTest {

    @Test
    void testConstructorAndGetters() {
        List<AbortTaskStatus> taskStatusList = new ArrayList<>();
        Session mockSession = Mockito.mock(Session.class);
        String replyToMessageId = "testMessageId";

        AbortTasksStatusEvent abortTasksStatusEvent = new AbortTasksStatusEvent(taskStatusList, mockSession, replyToMessageId);

        Assertions.assertEquals(taskStatusList, abortTasksStatusEvent.getTasks(), "Tasks should be set and retrieved correctly");
        Assertions.assertEquals(mockSession, abortTasksStatusEvent.getReplyTo(), "ReplyTo session should be set and retrieved correctly");
        Assertions.assertEquals(replyToMessageId, abortTasksStatusEvent.getReplyToMessageId(), "ReplyToMessageId should be set and retrieved correctly");
    }

    @Test
    void testSetAndGetTasks() {
        List<AbortTaskStatus> taskStatusList = new ArrayList<>();
        AbortTasksStatusEvent abortTasksStatusEvent = new AbortTasksStatusEvent(taskStatusList, null, null);

        List<AbortTaskStatus> newTasksList = new ArrayList<>();
        abortTasksStatusEvent.setTasks(newTasksList);

        Assertions.assertEquals(newTasksList, abortTasksStatusEvent.getTasks(), "Tasks should be set and retrieved correctly");
    }
}