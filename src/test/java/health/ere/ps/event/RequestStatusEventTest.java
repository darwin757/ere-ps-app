package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RequestStatusEventTest {

    @Test
    void testJsonConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("runtimeConfig", Json.createObjectBuilder()
                        .add("someConfigKey", "someConfigValue"))
                .build();

        RequestStatusEvent requestStatusEvent = new RequestStatusEvent(jsonObject);

        Assertions.assertNotNull(requestStatusEvent.getRuntimeConfig(), "RuntimeConfig should be parsed and set correctly");
    }

    @Test
    void testFullConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("runtimeConfig", Json.createObjectBuilder()
                        .add("someConfigKey", "someConfigValue"))
                .build();

        Session mockSession = Mockito.mock(Session.class);
        String id = "testId";

        RequestStatusEvent requestStatusEvent = new RequestStatusEvent(jsonObject, mockSession, id);

        Assertions.assertNotNull(requestStatusEvent.getRuntimeConfig(), "RuntimeConfig should be parsed and set correctly");
        Assertions.assertEquals(mockSession, requestStatusEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(id, requestStatusEvent.getId(), "Id should be set correctly");
    }

    @Test
    void testSetAndGetReplyTo() {
        RequestStatusEvent requestStatusEvent = new RequestStatusEvent(Json.createObjectBuilder().build());
        Session mockSession = Mockito.mock(Session.class);
        requestStatusEvent.setReplyTo(mockSession);

        Assertions.assertEquals(mockSession, requestStatusEvent.getReplyTo(), "ReplyTo session should be set and retrieved correctly");
    }

    @Test
    void testSetAndGetId() {
        RequestStatusEvent requestStatusEvent = new RequestStatusEvent(Json.createObjectBuilder().build());
        String id = "testId";
        requestStatusEvent.setId(id);

        Assertions.assertEquals(id, requestStatusEvent.getId(), "Id should be set and retrieved correctly");
    }
}