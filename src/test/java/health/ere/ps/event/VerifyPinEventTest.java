package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class VerifyPinEventTest {

    @Test
    void testDefaultConstructor() {
        VerifyPinEvent verifyPinEvent = new VerifyPinEvent();
        Assertions.assertNull(verifyPinEvent.getCardHandle(), "cardHandle should be null by default");
    }

    @Test
    void testJsonConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("payload", Json.createObjectBuilder()
                        .add("cardHandle", "testCardHandle"))
                .build();
        Session mockSession = Mockito.mock(Session.class);
        String id = "testId";

        VerifyPinEvent verifyPinEvent = new VerifyPinEvent(jsonObject, mockSession, id);

        Assertions.assertEquals("testCardHandle", verifyPinEvent.getCardHandle(), "cardHandle should be set correctly");
        Assertions.assertEquals(mockSession, verifyPinEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(id, verifyPinEvent.getId(), "Id should be set correctly");
    }

    @Test
    void testFieldConstructor() {
        VerifyPinEvent verifyPinEvent = new VerifyPinEvent("testCardHandle");
        Assertions.assertEquals("testCardHandle", verifyPinEvent.getCardHandle(), "cardHandle should be set correctly");
    }

    @Test
    void testSettersAndGetters() {
        VerifyPinEvent verifyPinEvent = new VerifyPinEvent();
        verifyPinEvent.setCardHandle("testCardHandle");

        Assertions.assertEquals("testCardHandle", verifyPinEvent.getCardHandle(), "cardHandle should be set and retrieved correctly");
    }

    @Test
    void testChainedSetter() {
        VerifyPinEvent verifyPinEvent = new VerifyPinEvent().cardHandle("testCardHandle");

        Assertions.assertEquals("testCardHandle", verifyPinEvent.getCardHandle(), "cardHandle should be set and retrieved correctly");
    }

    @Test
    void testToString() {
        VerifyPinEvent verifyPinEvent = new VerifyPinEvent("testCardHandle");
        String expected = "{ cardHandle='testCardHandle'}";
        Assertions.assertEquals(expected, verifyPinEvent.toString(), "toString output should match expected format");
    }

    @Test
    void testEqualsAndHashCode() {
        VerifyPinEvent verifyPinEvent1 = new VerifyPinEvent("testCardHandle");
        VerifyPinEvent verifyPinEvent2 = new VerifyPinEvent("testCardHandle");
        VerifyPinEvent verifyPinEvent3 = new VerifyPinEvent("differentCardHandle");

        Assertions.assertEquals(verifyPinEvent1, verifyPinEvent2, "Events with same fields should be equal");
        Assertions.assertNotEquals(verifyPinEvent1, verifyPinEvent3, "Events with different fields should not be equal");
        Assertions.assertEquals(verifyPinEvent1.hashCode(), verifyPinEvent2.hashCode(), "Hash codes should be equal for equal objects");
        Assertions.assertNotEquals(verifyPinEvent1.hashCode(), verifyPinEvent3.hashCode(), "Hash codes should be different for non-equal objects");
    }

}