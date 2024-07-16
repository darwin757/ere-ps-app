package health.ere.ps.event.erixa;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ErixaEventTest {

    @Test
    void testConstructor() {
        JsonObject payload = Json.createObjectBuilder()
                .add("key", "value")
                .build();
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("payload", payload)
                .add("processType", "testProcess")
                .build();

        ErixaEvent erixaEvent = new ErixaEvent(jsonObject);

        Assertions.assertEquals(payload, erixaEvent.payload, "Payload should be set correctly");
        Assertions.assertEquals("testProcess", erixaEvent.processType, "ProcessType should be set correctly");
    }

    @Test
    void testFullConstructor() {
        JsonObject payload = Json.createObjectBuilder()
                .add("key", "value")
                .build();
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("payload", payload)
                .add("processType", "testProcess")
                .build();

        Session mockSession = Mockito.mock(Session.class);
        String replyToMessageId = "testReplyToMessageId";

        ErixaEvent erixaEvent = new ErixaEvent(jsonObject, mockSession, replyToMessageId);

        Assertions.assertEquals(payload, erixaEvent.payload, "Payload should be set correctly");
        Assertions.assertEquals("testProcess", erixaEvent.processType, "ProcessType should be set correctly");
        Assertions.assertEquals(mockSession, erixaEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(replyToMessageId, erixaEvent.getReplyToMessageId(), "ReplyToMessageId should be set correctly");
    }
}