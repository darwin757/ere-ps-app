package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GetPinStatusEventTest {

    @Test
    void testDefaultConstructor() {
        GetPinStatusEvent getPinStatusEvent = new GetPinStatusEvent();
        Assertions.assertNull(getPinStatusEvent.getCardHandle(), "CardHandle should be null by default");
        Assertions.assertNull(getPinStatusEvent.getPinType(), "PinType should be null by default");
    }

    @Test
    void testJsonConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("payload", Json.createObjectBuilder()
                        .add("cardHandle", "testCardHandle")
                        .add("pinType", "testPinType"))
                .build();
        Session mockSession = Mockito.mock(Session.class);
        GetPinStatusEvent getPinStatusEvent = new GetPinStatusEvent(jsonObject, mockSession, "testId");

        Assertions.assertEquals("testCardHandle", getPinStatusEvent.getCardHandle(), "CardHandle should be set correctly");
        Assertions.assertEquals("testPinType", getPinStatusEvent.getPinType(), "PinType should be set correctly");
        Assertions.assertEquals(mockSession, getPinStatusEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals("testId", getPinStatusEvent.getId(), "Id should be set correctly");
    }

    @Test
    void testFieldConstructor() {
        GetPinStatusEvent getPinStatusEvent = new GetPinStatusEvent("testCardHandle", "testPinType");
        Assertions.assertEquals("testCardHandle", getPinStatusEvent.getCardHandle(), "CardHandle should be set correctly");
        Assertions.assertEquals("testPinType", getPinStatusEvent.getPinType(), "PinType should be set correctly");
    }

    @Test
    void testSettersAndGetters() {
        GetPinStatusEvent getPinStatusEvent = new GetPinStatusEvent();
        getPinStatusEvent.setCardHandle("testCardHandle");
        getPinStatusEvent.setPinType("testPinType");

        Assertions.assertEquals("testCardHandle", getPinStatusEvent.getCardHandle(), "CardHandle should be set and retrieved correctly");
        Assertions.assertEquals("testPinType", getPinStatusEvent.getPinType(), "PinType should be set and retrieved correctly");
    }

    @Test
    void testChainedSetters() {
        GetPinStatusEvent getPinStatusEvent = new GetPinStatusEvent()
                .cardHandle("testCardHandle")
                .pinType("testPinType");

        Assertions.assertEquals("testCardHandle", getPinStatusEvent.getCardHandle(), "CardHandle should be set and retrieved correctly");
        Assertions.assertEquals("testPinType", getPinStatusEvent.getPinType(), "PinType should be set and retrieved correctly");
    }

    @Test
    void testEqualsAndHashCode() {
        GetPinStatusEvent getPinStatusEvent1 = new GetPinStatusEvent("testCardHandle", "testPinType");
        GetPinStatusEvent getPinStatusEvent2 = new GetPinStatusEvent("testCardHandle", "testPinType");
        GetPinStatusEvent getPinStatusEvent3 = new GetPinStatusEvent("differentCardHandle", "differentPinType");

        Assertions.assertEquals(getPinStatusEvent1, getPinStatusEvent2, "Events with same fields should be equal");
        Assertions.assertNotEquals(getPinStatusEvent1, getPinStatusEvent3, "Events with different fields should not be equal");
        Assertions.assertEquals(getPinStatusEvent1.hashCode(), getPinStatusEvent2.hashCode(), "Hash codes should be equal for equal objects");
        Assertions.assertNotEquals(getPinStatusEvent1.hashCode(), getPinStatusEvent3.hashCode(), "Hash codes should be different for non-equal objects");
    }

    @Test
    void testToString() {
        GetPinStatusEvent getPinStatusEvent = new GetPinStatusEvent("testCardHandle", "testPinType");
        String expected = "{ cardHandle='testCardHandle', pinType='testPinType'}";
        Assertions.assertEquals(expected, getPinStatusEvent.toString(), "ToString output should match expected format");
    }
}