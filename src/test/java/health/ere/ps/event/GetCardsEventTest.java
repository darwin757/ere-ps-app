package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GetCardsEventTest {

    @Test
    void testJsonConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("runtimeConfig", Json.createObjectBuilder()
                        .add("someKey", "someValue"))
                .build();

        GetCardsEvent getCardsEvent = new GetCardsEvent(jsonObject);
        Assertions.assertNotNull(getCardsEvent.getRuntimeConfig(), "RuntimeConfig should be parsed and set correctly");
    }

    @Test
    void testFullConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("runtimeConfig", Json.createObjectBuilder()
                        .add("someKey", "someValue"))
                .build();

        Session mockSession = Mockito.mock(Session.class);
        String replyToMessageId = "testId";

        GetCardsEvent getCardsEvent = new GetCardsEvent(jsonObject, mockSession, replyToMessageId);

        Assertions.assertNotNull(getCardsEvent.getRuntimeConfig(), "RuntimeConfig should be parsed and set correctly");
        Assertions.assertEquals(mockSession, getCardsEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(replyToMessageId, getCardsEvent.getId(), "Id should be set correctly");
    }
}