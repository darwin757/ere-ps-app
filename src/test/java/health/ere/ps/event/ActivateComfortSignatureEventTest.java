package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ActivateComfortSignatureEventTest {

    @Test
    void testConstructorWithJsonObject() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("runtimeConfig", Json.createObjectBuilder()
                        .add("someConfigKey", "someConfigValue"))
                .build();

        ActivateComfortSignatureEvent activateComfortSignatureEvent = new ActivateComfortSignatureEvent(jsonObject);

        Assertions.assertNotNull(activateComfortSignatureEvent.getRuntimeConfig(), "RuntimeConfig should be parsed and set correctly");
    }

    @Test
    void testConstructorWithJsonObjectSessionAndId() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("runtimeConfig", Json.createObjectBuilder()
                        .add("someConfigKey", "someConfigValue"))
                .build();
        Session mockSession = Mockito.mock(Session.class);

        ActivateComfortSignatureEvent activateComfortSignatureEvent = new ActivateComfortSignatureEvent(jsonObject, mockSession, "testId");

        Assertions.assertNotNull(activateComfortSignatureEvent.getRuntimeConfig(), "RuntimeConfig should be parsed and set correctly");
        Assertions.assertEquals(mockSession, activateComfortSignatureEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals("testId", activateComfortSignatureEvent.getId(), "Id should be set correctly");
    }
}