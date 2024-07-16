package health.ere.ps.event;

import de.gematik.ws.conn.cardservice.v8.PinStatusEnum;
import de.gematik.ws.conn.connectorcommon.v5.Status;
import health.ere.ps.model.gematik.GetPinStatusResponse;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

class GetPinStatusResponseEventTest {

    @Test
    void testDefaultConstructor() {
        GetPinStatusResponseEvent getPinStatusResponseEvent = new GetPinStatusResponseEvent();
        Assertions.assertNull(getPinStatusResponseEvent.getGetPinStatusResponse(), "getPinStatus should be null by default");
    }

    @Test
    void testFieldConstructor() {
        Status status = new Status();
        PinStatusEnum pinStatusEnum = PinStatusEnum.VERIFIED;
        BigInteger leftTries = BigInteger.TEN;

        GetPinStatusResponse getPinStatusResponse = new GetPinStatusResponse(status, pinStatusEnum, leftTries);
        GetPinStatusResponseEvent getPinStatusResponseEvent = new GetPinStatusResponseEvent(getPinStatusResponse);
        Assertions.assertEquals(getPinStatusResponse, getPinStatusResponseEvent.getGetPinStatusResponse(), "getPinStatus should be set correctly");
    }

    @Test
    void testFullConstructor() {
        Status status = new Status();
        PinStatusEnum pinStatusEnum = PinStatusEnum.VERIFIED;
        BigInteger leftTries = BigInteger.TEN;

        GetPinStatusResponse getPinStatusResponse = new GetPinStatusResponse(status, pinStatusEnum, leftTries);
        Session mockSession = Mockito.mock(Session.class);
        String id = "testId";

        GetPinStatusResponseEvent getPinStatusResponseEvent = new GetPinStatusResponseEvent(getPinStatusResponse, mockSession, id);

        Assertions.assertEquals(getPinStatusResponse, getPinStatusResponseEvent.getGetPinStatusResponse(), "getPinStatus should be set correctly");
        Assertions.assertEquals(mockSession, getPinStatusResponseEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(id, getPinStatusResponseEvent.getReplyToMessageId(), "Id should be set correctly");
    }

    @Test
    void testSettersAndGetters() {
        Status status = new Status();
        PinStatusEnum pinStatusEnum = PinStatusEnum.VERIFIED;
        BigInteger leftTries = BigInteger.TEN;

        GetPinStatusResponse getPinStatusResponse = new GetPinStatusResponse(status, pinStatusEnum, leftTries);
        GetPinStatusResponseEvent getPinStatusResponseEvent = new GetPinStatusResponseEvent();
        getPinStatusResponseEvent.setGetPinStatusResponse(getPinStatusResponse);

        Assertions.assertEquals(getPinStatusResponse, getPinStatusResponseEvent.getGetPinStatusResponse(), "getPinStatus should be set and retrieved correctly");
    }

    @Test
    void testChainedSetter() {
        Status status = new Status();
        PinStatusEnum pinStatusEnum = PinStatusEnum.VERIFIED;
        BigInteger leftTries = BigInteger.TEN;

        GetPinStatusResponse getPinStatusResponse = new GetPinStatusResponse(status, pinStatusEnum, leftTries);
        GetPinStatusResponseEvent getPinStatusResponseEvent = new GetPinStatusResponseEvent().getPinStatus(getPinStatusResponse);

        Assertions.assertEquals(getPinStatusResponse, getPinStatusResponseEvent.getGetPinStatusResponse(), "getPinStatus should be set and retrieved correctly");
    }

    @Test
    void testToString() {
        Status status = new Status();
        PinStatusEnum pinStatusEnum = PinStatusEnum.VERIFIED;
        BigInteger leftTries = BigInteger.TEN;

        GetPinStatusResponse getPinStatusResponse = new GetPinStatusResponse(status, pinStatusEnum, leftTries);
        GetPinStatusResponseEvent getPinStatusResponseEvent = new GetPinStatusResponseEvent(getPinStatusResponse);
        String expected = "{ getPinStatus='" + getPinStatusResponse + "'}";

        Assertions.assertEquals(expected, getPinStatusResponseEvent.toString(), "toString output should match expected format");
    }

    @Test
    void testGetType() {
        GetPinStatusResponseEvent getPinStatusResponseEvent = new GetPinStatusResponseEvent();
        Assertions.assertEquals("GetPinStatusResponse", getPinStatusResponseEvent.getType(), "Type should be 'GetPinStatusResponse'");
    }

    @Test
    void testGetPayload() {
        Status status = new Status();
        PinStatusEnum pinStatusEnum = PinStatusEnum.VERIFIED;
        BigInteger leftTries = BigInteger.TEN;

        GetPinStatusResponse getPinStatusResponse = new GetPinStatusResponse(status, pinStatusEnum, leftTries);
        GetPinStatusResponseEvent getPinStatusResponseEvent = new GetPinStatusResponseEvent(getPinStatusResponse);
        Assertions.assertEquals(getPinStatusResponse, getPinStatusResponseEvent.getPayload(), "Payload should be the getPinStatus");
    }
}