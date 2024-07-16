package health.ere.ps.event;

import de.gematik.ws.conn.cardservicecommon.v2.PinResultEnum;
import de.gematik.ws.conn.connectorcommon.v5.Status;
import health.ere.ps.model.gematik.VerifyPinResponse;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

class VerifyPinResponseEventTest {

    @Test
    void testDefaultConstructor() {
        VerifyPinResponseEvent verifyPinResponseEvent = new VerifyPinResponseEvent();
        Assertions.assertNull(verifyPinResponseEvent.getVerifyPinResponse(), "verifyPinResponse should be null by default");
    }

    @Test
    void testFieldConstructor() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        VerifyPinResponse verifyPinResponse = new VerifyPinResponse(status, pinResultEnum, leftTries);
        VerifyPinResponseEvent verifyPinResponseEvent = new VerifyPinResponseEvent(verifyPinResponse, null, null);
        Assertions.assertEquals(verifyPinResponse, verifyPinResponseEvent.getVerifyPinResponse(), "verifyPinResponse should be set correctly");
    }

    @Test
    void testFullConstructor() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        VerifyPinResponse verifyPinResponse = new VerifyPinResponse(status, pinResultEnum, leftTries);
        Session mockSession = Mockito.mock(Session.class);
        String id = "testId";

        VerifyPinResponseEvent verifyPinResponseEvent = new VerifyPinResponseEvent(verifyPinResponse, mockSession, id);

        Assertions.assertEquals(verifyPinResponse, verifyPinResponseEvent.getVerifyPinResponse(), "verifyPinResponse should be set correctly");
        Assertions.assertEquals(mockSession, verifyPinResponseEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(id, verifyPinResponseEvent.getReplyToMessageId(), "Id should be set correctly");
    }

    @Test
    void testSettersAndGetters() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        VerifyPinResponse response = new VerifyPinResponse(status, pinResultEnum, leftTries);
        VerifyPinResponseEvent event = new VerifyPinResponseEvent();
        event.setVerifyPinResponse(response);

        Assertions.assertEquals(response, event.getVerifyPinResponse(), "verifyPinResponse should be set and retrieved correctly");
    }

    @Test
    void testChainedSetter() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        VerifyPinResponse verifyPinResponse = new VerifyPinResponse(status, pinResultEnum, leftTries);
        VerifyPinResponseEvent verifyPinResponseEvent = new VerifyPinResponseEvent().verifyPinResponse(verifyPinResponse);

        Assertions.assertEquals(verifyPinResponse, verifyPinResponseEvent.getVerifyPinResponse(), "verifyPinResponse should be set and retrieved correctly");
    }

    @Test
    void testToString() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        VerifyPinResponse verifyPinResponse = new VerifyPinResponse(status, pinResultEnum, leftTries);
        VerifyPinResponseEvent verifyPinResponseEvent = new VerifyPinResponseEvent(verifyPinResponse, null, null);
        String expected = "{ verifyPinResponse='" + verifyPinResponse + "'}";

        Assertions.assertEquals(expected, verifyPinResponseEvent.toString(), "toString output should match expected format");
    }

    @Test
    void testGetType() {
        VerifyPinResponseEvent verifyPinResponseEvent = new VerifyPinResponseEvent();
        Assertions.assertEquals("VerifyPinResponse", verifyPinResponseEvent.getType(), "Type should be 'VerifyPinResponse'");
    }

    @Test
    void testGetPayload() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;
        VerifyPinResponse verifyPinResponse = new VerifyPinResponse(status, pinResultEnum, leftTries);
        VerifyPinResponseEvent verifyPinResponseEvent = new VerifyPinResponseEvent(verifyPinResponse, null, null);
        Assertions.assertEquals(verifyPinResponse, verifyPinResponseEvent.getPayload(), "Payload should be the verifyPinResponse");
    }

    @Test
    void testEqualsAndHashCode() {
        Status status = new Status();
        PinResultEnum pinResultEnum = PinResultEnum.OK;
        BigInteger leftTries = BigInteger.TEN;

        VerifyPinResponse verifyPinResponse1 = new VerifyPinResponse(status, pinResultEnum, leftTries);
        VerifyPinResponse verifyPinResponse2 = new VerifyPinResponse(status, pinResultEnum, leftTries);
        VerifyPinResponse differentResponse = new VerifyPinResponse(new Status(), PinResultEnum.NOWBLOCKED, BigInteger.ONE);

        VerifyPinResponseEvent verifyPinResponseEvent1 = new VerifyPinResponseEvent(verifyPinResponse1, null, "id1");
        VerifyPinResponseEvent verifyPinResponseEvent2 = new VerifyPinResponseEvent(verifyPinResponse2, null, "id1");
        VerifyPinResponseEvent verifyPinResponseEvent3 = new VerifyPinResponseEvent(differentResponse, null, "id2");

        Assertions.assertEquals(verifyPinResponseEvent1, verifyPinResponseEvent2, "Events with same fields should be equal");
        Assertions.assertNotEquals(verifyPinResponseEvent1, verifyPinResponseEvent3, "Events with different fields should not be equal");
        Assertions.assertEquals(verifyPinResponseEvent1.hashCode(), verifyPinResponseEvent2.hashCode(), "Hash codes should be equal for equal objects");
        Assertions.assertNotEquals(verifyPinResponseEvent1.hashCode(), verifyPinResponseEvent3.hashCode(), "Hash codes should be different for non-equal objects");
    }
}