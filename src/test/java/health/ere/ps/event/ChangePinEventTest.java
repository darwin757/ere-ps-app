package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangePinEventTest {

    @Test
    void testDefaultConstructor() {
        ChangePinEvent changePinEvent = new ChangePinEvent();
        Assertions.assertNull(changePinEvent.getCardHandle(), "Default cardHandle should be null");
        Assertions.assertNull(changePinEvent.getPinType(), "Default pinType should be null");
    }

    @Test
    void testJsonConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("payload", Json.createObjectBuilder()
                        .add("cardHandle", "testCardHandle")
                        .add("pinType", "testPinType"))
                .build();
        Session mockSession = Mockito.mock(Session.class);
        ChangePinEvent changePinEvent = new ChangePinEvent(jsonObject, mockSession, "testId");

        Assertions.assertEquals("testCardHandle", changePinEvent.getCardHandle(), "CardHandle should be set correctly");
        Assertions.assertEquals("testPinType", changePinEvent.getPinType(), "PinType should be set correctly");
        Assertions.assertEquals(mockSession, changePinEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals("testId", changePinEvent.getId(), "Id should be set correctly");
    }

    @Test
    void testFieldConstructor() {
        ChangePinEvent changePinEvent = new ChangePinEvent("testCardHandle", "testPinType");
        Assertions.assertEquals("testCardHandle", changePinEvent.getCardHandle(), "CardHandle should be set correctly");
        Assertions.assertEquals("testPinType", changePinEvent.getPinType(), "PinType should be set correctly");
    }

    @Test
    void testSettersAndGetters() {
        ChangePinEvent changePinEvent = new ChangePinEvent();
        changePinEvent.setCardHandle("testCardHandle");
        changePinEvent.setPinType("testPinType");

        Assertions.assertEquals("testCardHandle", changePinEvent.getCardHandle(), "CardHandle should be set and retrieved correctly");
        Assertions.assertEquals("testPinType", changePinEvent.getPinType(), "PinType should be set and retrieved correctly");
    }

    @Test
    void testChainedSetters() {
        ChangePinEvent changePinEvent = new ChangePinEvent()
                .cardHandle("testCardHandle")
                .pinType("testPinType");

        Assertions.assertEquals("testCardHandle", changePinEvent.getCardHandle(), "CardHandle should be set and retrieved correctly");
        Assertions.assertEquals("testPinType", changePinEvent.getPinType(), "PinType should be set and retrieved correctly");
    }

    @Test
    void testEqualsAndHashCode() {
        ChangePinEvent changePinEvent1 = new ChangePinEvent("testCardHandle", "testPinType");
        ChangePinEvent changePinEvent2 = new ChangePinEvent("testCardHandle", "testPinType");
        ChangePinEvent changePinEvent3 = new ChangePinEvent("differentCardHandle", "differentPinType");

        Assertions.assertEquals(changePinEvent1, changePinEvent2, "Events with same fields should be equal");
        Assertions.assertNotEquals(changePinEvent1, changePinEvent3, "Events with different fields should not be equal");
        Assertions.assertEquals(changePinEvent1.hashCode(), changePinEvent2.hashCode(), "Hash codes should be equal for equal objects");
        Assertions.assertNotEquals(changePinEvent1.hashCode(), changePinEvent3.hashCode(), "Hash codes should be different for non-equal objects");
    }

    @Test
    void testToString() {
        ChangePinEvent changePinEvent = new ChangePinEvent("testCardHandle", "testPinType");
        String expected = "{ cardHandle='testCardHandle', pinType='testPinType'}";
        Assertions.assertEquals(expected, changePinEvent.toString(), "ToString output should match expected format");
    }
}
