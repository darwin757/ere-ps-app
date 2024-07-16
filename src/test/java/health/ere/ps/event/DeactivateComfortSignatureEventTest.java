package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DeactivateComfortSignatureEventTest {

    @Test
    void testConstructorWithJsonObject() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("runtimeConfig", Json.createObjectBuilder()
                        .add("someConfigKey", "someConfigValue"))
                .build();

        DeactivateComfortSignatureEvent event = new DeactivateComfortSignatureEvent(jsonObject);
        Assertions.assertNotNull(event.getRuntimeConfig(), "RuntimeConfig should be parsed and set correctly");
    }

    @Test
    void testConstructorWithJsonObjectSessionAndId() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("runtimeConfig", Json.createObjectBuilder()
                        .add("someConfigKey", "someConfigValue"))
                .build();
        Session mockSession = Mockito.mock(Session.class);

        DeactivateComfortSignatureEvent event = new DeactivateComfortSignatureEvent(jsonObject, mockSession, "testId");
        Assertions.assertNotNull(event.getRuntimeConfig(), "RuntimeConfig should be parsed and set correctly");
        Assertions.assertEquals(mockSession, event.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals("testId", event.getId(), "Id should be set correctly");
    }
}