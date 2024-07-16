package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PrefillBundleEventTest {

    @Test
    void testDefaultConstructor() {
        PrefillBundleEvent event = new PrefillBundleEvent();
        Assertions.assertNull(event.getReplyTo(), "ReplyTo session should be null by default");
        Assertions.assertNull(event.getId(), "ID should be null by default");
        Assertions.assertNull(event.getRuntimeConfig(), "RuntimeConfig should be null by default");
    }

    @Test
    void testJsonConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("runtimeConfig", Json.createObjectBuilder().add("key", "value"))
                .build();
        Session mockSession = Mockito.mock(Session.class);
        String id = "testId";

        PrefillBundleEvent event = new PrefillBundleEvent(jsonObject, mockSession, id);

        Assertions.assertEquals(mockSession, event.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(id, event.getId(), "ID should be set correctly");
        Assertions.assertNotNull(event.getRuntimeConfig(), "RuntimeConfig should be set correctly");
    }
}