package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import health.ere.ps.config.RuntimeConfig;

class AbstractEventTest {

    // A concrete subclass of AbstractEvent for testing purposes
    static class ConcreteEvent extends AbstractEvent {}

    @Test
    void testId() {
        ConcreteEvent concreteEvent = new ConcreteEvent();
        concreteEvent.setId("testId");
        Assertions.assertEquals("testId", concreteEvent.getId(), "ID should be set and retrieved correctly");
    }

    @Test
    void testReplyTo() {
        ConcreteEvent concreteEvent = new ConcreteEvent();
        Session mockSession = Mockito.mock(Session.class);
        concreteEvent.setReplyTo(mockSession);
        Assertions.assertEquals(mockSession, concreteEvent.getReplyTo(), "ReplyTo session should be set and retrieved correctly");
    }

    @Test
    void testReplyToMessageId() {
        ConcreteEvent concreteEvent = new ConcreteEvent();
        concreteEvent.setReplyToMessageId("testMessageId");
        Assertions.assertEquals("testMessageId", concreteEvent.getReplyToMessageId(), "ReplyToMessageId should be set and retrieved correctly");
    }

    @Test
    void testRuntimeConfig() {
        ConcreteEvent concreteEvent = new ConcreteEvent();
        RuntimeConfig runtimeConfig = new RuntimeConfig();
        concreteEvent.setRuntimeConfig(runtimeConfig);
        Assertions.assertEquals(runtimeConfig, concreteEvent.getRuntimeConfig(), "RuntimeConfig should be set and retrieved correctly");
    }

    @Test
    void testParseRuntimeConfig() {
        ConcreteEvent concreteEvent = new ConcreteEvent();
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("runtimeConfig", Json.createObjectBuilder()
                        .add("someConfigKey", "someConfigValue"))
                .build();
        concreteEvent.parseRuntimeConfig(jsonObject);
        Assertions.assertNotNull(concreteEvent.getRuntimeConfig(), "RuntimeConfig should be parsed and set correctly");
    }
}
