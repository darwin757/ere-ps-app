package health.ere.ps.event;

import de.gematik.ws.conn.cardservicecommon.v2.PinResultEnum;
import de.gematik.ws.conn.connectorcommon.v5.Status;
import health.ere.ps.model.gematik.UnblockPinResponse;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

class UnblockPinResponseEventTest {

    @Test
    void testDefaultConstructor() {
        UnblockPinResponseEvent unblockPinResponseEvent = new UnblockPinResponseEvent();
        Assertions.assertNull(unblockPinResponseEvent.getUnblockPinResponse(), "unblockPinResponse should be null by default");
    }

    @Test
    void testFieldConstructor() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        UnblockPinResponse unblockPinResponse = new UnblockPinResponse(status, pinResultEnum, leftTries);

        UnblockPinResponseEvent unblockPinResponseEvent = new UnblockPinResponseEvent(unblockPinResponse, null, "testId");
        Assertions.assertEquals(unblockPinResponse, unblockPinResponseEvent.getUnblockPinResponse(), "unblockPinResponse should be set correctly");
    }

    @Test
    void testFullConstructor() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        UnblockPinResponse unblockPinResponse = new UnblockPinResponse(status, pinResultEnum, leftTries);

        Session mockSession = Mockito.mock(Session.class);
        String id = "testId";

        UnblockPinResponseEvent unblockPinResponseEvent = new UnblockPinResponseEvent(unblockPinResponse, mockSession, id);

        Assertions.assertEquals(unblockPinResponse, unblockPinResponseEvent.getUnblockPinResponse(), "unblockPinResponse should be set correctly");
        Assertions.assertEquals(mockSession, unblockPinResponseEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(id, unblockPinResponseEvent.getReplyToMessageId(), "Id should be set correctly");
    }

    @Test
    void testSettersAndGetters() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        UnblockPinResponse unblockPinResponse = new UnblockPinResponse(status, pinResultEnum, leftTries);

        UnblockPinResponseEvent unblockPinResponseEvent = new UnblockPinResponseEvent();
        unblockPinResponseEvent.setUnblockPinResponse(unblockPinResponse);

        Assertions.assertEquals(unblockPinResponse, unblockPinResponseEvent.getUnblockPinResponse(), "unblockPinResponse should be set and retrieved correctly");
    }

    @Test
    void testChainedSetter() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        UnblockPinResponse unblockPinResponse = new UnblockPinResponse(status, pinResultEnum, leftTries);

        UnblockPinResponseEvent unblockPinResponseEvent = new UnblockPinResponseEvent().unblockPinResponse(unblockPinResponse);

        Assertions.assertEquals(unblockPinResponse, unblockPinResponseEvent.getUnblockPinResponse(), "unblockPinResponse should be set and retrieved correctly");
    }

    @Test
    void testEqualsAndHashCode() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;

        UnblockPinResponse unblockPinResponse1 = new UnblockPinResponse(status, pinResultEnum, leftTries);
        UnblockPinResponse unblockPinResponse2 = new UnblockPinResponse(status, pinResultEnum, leftTries);
        UnblockPinResponse differentResponse = new UnblockPinResponse(new Status(), PinResultEnum.NOWBLOCKED, BigInteger.ONE);

        UnblockPinResponseEvent unblockPinResponseEvent1 = new UnblockPinResponseEvent(unblockPinResponse1, null, "id1");
        UnblockPinResponseEvent unblockPinResponseEvent2 = new UnblockPinResponseEvent(unblockPinResponse2, null, "id1");
        UnblockPinResponseEvent unblockPinResponseEvent3 = new UnblockPinResponseEvent(differentResponse, null, "id2");

        Assertions.assertEquals(unblockPinResponseEvent1, unblockPinResponseEvent2, "Events with same fields should be equal");
        Assertions.assertNotEquals(unblockPinResponseEvent1, unblockPinResponseEvent3, "Events with different fields should not be equal");
        Assertions.assertEquals(unblockPinResponseEvent1.hashCode(), unblockPinResponseEvent2.hashCode(), "Hash codes should be equal for equal objects");
        Assertions.assertNotEquals(unblockPinResponseEvent1.hashCode(), unblockPinResponseEvent3.hashCode(), "Hash codes should be different for non-equal objects");
    }

    @Test
    void testToString() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        UnblockPinResponse unblockPinResponse = new UnblockPinResponse(status, pinResultEnum, leftTries);

        UnblockPinResponseEvent unblockPinResponseEvent = new UnblockPinResponseEvent(unblockPinResponse, null, "id");
        String expected = "{ unblockPinResponse='" + unblockPinResponse + "'}";
        Assertions.assertEquals(expected, unblockPinResponseEvent.toString(), "ToString output should match expected format");
    }

    @Test
    void testGetType() {
        UnblockPinResponseEvent unblockPinResponseEvent = new UnblockPinResponseEvent();
        Assertions.assertEquals("UnblockPinResponse", unblockPinResponseEvent.getType(), "Type should be 'UnblockPinResponse'");
    }

    @Test
    void testGetPayload() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        UnblockPinResponse unblockPinResponse = new UnblockPinResponse(status, pinResultEnum, leftTries);

        UnblockPinResponseEvent unblockPinResponseEvent = new UnblockPinResponseEvent(unblockPinResponse, null, "id");
        Assertions.assertEquals(unblockPinResponse, unblockPinResponseEvent.getPayload(), "Payload should be the unblockPinResponse");
    }
}