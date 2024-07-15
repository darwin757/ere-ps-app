package health.ere.ps.event;

import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import health.ere.ps.model.gematik.ChangePinResponse;

class ChangePinResponseEventTest {

    @Test
    void testDefaultConstructor() {
        ChangePinResponseEvent changePinResponseEvent = new ChangePinResponseEvent();
        Assertions.assertNull(changePinResponseEvent.getChangePinResponse(), "Default changePinResponse should be null");
    }

    @Test
    void testFieldConstructor() {
        ChangePinResponse changePinResponse = new ChangePinResponse();
        ChangePinResponseEvent changePinResponseEvent = new ChangePinResponseEvent(changePinResponse);
        Assertions.assertEquals(changePinResponse, changePinResponseEvent.getChangePinResponse(), "changePinResponse should be set correctly");
    }

    @Test
    void testFullConstructor() {
        ChangePinResponse changePinResponse = new ChangePinResponse();
        Session mockSession = Mockito.mock(Session.class);
        ChangePinResponseEvent changePinResponseEvent = new ChangePinResponseEvent(changePinResponse, mockSession, "testId");

        Assertions.assertEquals(changePinResponse, changePinResponseEvent.getChangePinResponse(), "changePinResponse should be set correctly");
        Assertions.assertEquals(mockSession, changePinResponseEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals("testId", changePinResponseEvent.getReplyToMessageId(), "Id should be set correctly");
    }

    @Test
    void testSettersAndGetters() {
        ChangePinResponse changePinResponse = new ChangePinResponse();
        ChangePinResponseEvent changePinResponseEvent = new ChangePinResponseEvent();
        changePinResponseEvent.setChangePinResponse(changePinResponse);

        Assertions.assertEquals(changePinResponse, changePinResponseEvent.getChangePinResponse(), "changePinResponse should be set and retrieved correctly");
    }

    @Test
    void testChainedSetter() {
        ChangePinResponse changePinResponse = new ChangePinResponse();
        ChangePinResponseEvent changePinResponseEvent = new ChangePinResponseEvent().changePinResponse(changePinResponse);

        Assertions.assertEquals(changePinResponse, changePinResponseEvent.getChangePinResponse(), "changePinResponse should be set and retrieved correctly");
    }

    @Test
    void testToString() {
        ChangePinResponse changePinResponse = new ChangePinResponse();
        ChangePinResponseEvent changePinResponseEvent = new ChangePinResponseEvent(changePinResponse);
        String expected = "{ changePinResponse='" + changePinResponse + "'}";
        Assertions.assertEquals(expected, changePinResponseEvent.toString(), "ToString output should match expected format");
    }

    @Test
    void testGetType() {
        ChangePinResponseEvent changePinResponseEvent = new ChangePinResponseEvent();
        Assertions.assertEquals("ChangePinResponse", changePinResponseEvent.getType(), "Type should be 'ChangePinResponse'");
    }

    @Test
    void testGetPayload() {
        ChangePinResponse changePinResponse = new ChangePinResponse();
        ChangePinResponseEvent changePinResponseEvent = new ChangePinResponseEvent(changePinResponse);
        Assertions.assertEquals(changePinResponse, changePinResponseEvent.getPayload(), "Payload should be the changePinResponse");
    }
}
