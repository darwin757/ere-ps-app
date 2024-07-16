package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UnblockPinEventTest {

    @Test
    void testDefaultConstructor() {
        UnblockPinEvent unblockPinEvent = new UnblockPinEvent();
        Assertions.assertNull(unblockPinEvent.getCardHandle(), "CardHandle should be null by default");
        Assertions.assertNull(unblockPinEvent.getPinType(), "PinType should be null by default");
        Assertions.assertNull(unblockPinEvent.isSetNewPin(), "setNewPin should be null by default");
    }

    @Test
    void testJsonConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("payload", Json.createObjectBuilder()
                        .add("cardHandle", "testCardHandle")
                        .add("pinType", "testPinType")
                        .add("setNewPin", true))
                .build();
        Session mockSession = Mockito.mock(Session.class);
        UnblockPinEvent unblockPinEvent = new UnblockPinEvent(jsonObject, mockSession, "testId");

        Assertions.assertEquals("testCardHandle", unblockPinEvent.getCardHandle(), "CardHandle should be set correctly");
        Assertions.assertEquals("testPinType", unblockPinEvent.getPinType(), "PinType should be set correctly");
        Assertions.assertTrue(unblockPinEvent.isSetNewPin(), "setNewPin should be set correctly");
        Assertions.assertEquals(mockSession, unblockPinEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals("testId", unblockPinEvent.getId(), "Id should be set correctly");
    }

    @Test
    void testFieldConstructor() {
        UnblockPinEvent unblockPinEvent = new UnblockPinEvent("testCardHandle", "testPinType", true);
        Assertions.assertEquals("testCardHandle", unblockPinEvent.getCardHandle(), "CardHandle should be set correctly");
        Assertions.assertEquals("testPinType", unblockPinEvent.getPinType(), "PinType should be set correctly");
        Assertions.assertTrue(unblockPinEvent.isSetNewPin(), "setNewPin should be set correctly");
    }

    @Test
    void testSettersAndGetters() {
        UnblockPinEvent unblockPinEvent = new UnblockPinEvent();
        unblockPinEvent.setCardHandle("testCardHandle");
        unblockPinEvent.setPinType("testPinType");
        unblockPinEvent.setSetNewPin(true);

        Assertions.assertEquals("testCardHandle", unblockPinEvent.getCardHandle(), "CardHandle should be set and retrieved correctly");
        Assertions.assertEquals("testPinType", unblockPinEvent.getPinType(), "PinType should be set and retrieved correctly");
        Assertions.assertTrue(unblockPinEvent.isSetNewPin(), "setNewPin should be set and retrieved correctly");
    }

    @Test
    void testChainedSetters() {
        UnblockPinEvent unblockPinEvent = new UnblockPinEvent()
                .cardHandle("testCardHandle")
                .pinType("testPinType")
                .setNewPin(true);

        Assertions.assertEquals("testCardHandle", unblockPinEvent.getCardHandle(), "CardHandle should be set and retrieved correctly");
        Assertions.assertEquals("testPinType", unblockPinEvent.getPinType(), "PinType should be set and retrieved correctly");
        Assertions.assertTrue(unblockPinEvent.isSetNewPin(), "setNewPin should be set and retrieved correctly");
    }

    @Test
    void testEqualsAndHashCode() {
        UnblockPinEvent unblockPinEvent1 = new UnblockPinEvent("testCardHandle", "testPinType", true);
        UnblockPinEvent unblockPinEvent2 = new UnblockPinEvent("testCardHandle", "testPinType", true);
        UnblockPinEvent unblockPinEvent3 = new UnblockPinEvent("differentCardHandle", "differentPinType", false);

        Assertions.assertEquals(unblockPinEvent1, unblockPinEvent2, "Events with same fields should be equal");
        Assertions.assertNotEquals(unblockPinEvent1, unblockPinEvent3, "Events with different fields should not be equal");
        Assertions.assertEquals(unblockPinEvent1.hashCode(), unblockPinEvent2.hashCode(), "Hash codes should be equal for equal objects");
        Assertions.assertNotEquals(unblockPinEvent1.hashCode(), unblockPinEvent3.hashCode(), "Hash codes should be different for non-equal objects");
    }

    @Test
    void testToString() {
        UnblockPinEvent unblockPinEvent = new UnblockPinEvent("testCardHandle", "testPinType", true);
        String expected = "{ cardHandle='testCardHandle', pinType='testPinType', setNewPin='true'}";
        Assertions.assertEquals(expected, unblockPinEvent.toString(), "ToString output should match expected format");
    }

}