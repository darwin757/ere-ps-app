package health.ere.ps.event;

import de.gematik.ws.conn.eventservice.v7.GetCardsResponse;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GetCardsResponseEventTest {

    @Test
    void testConstructorAndGetters() {
        GetCardsResponse getCardsResponse = Mockito.mock(GetCardsResponse.class);
        Session mockSession = Mockito.mock(Session.class);
        String replyToMessageId = "testId";

        GetCardsResponseEvent event = new GetCardsResponseEvent(getCardsResponse, mockSession, replyToMessageId);

        Assertions.assertEquals(getCardsResponse, event.getGetCardsResponse(), "GetCardsResponse should match the provided response");
        Assertions.assertEquals(mockSession, event.getReplyTo(), "ReplyTo session should match the provided session");
        Assertions.assertEquals(replyToMessageId, event.getReplyToMessageId(), "ReplyToMessageId should match the provided id");
    }

    @Test
    void testSetGetCardsResponse() {
        GetCardsResponse getCardsResponse = Mockito.mock(GetCardsResponse.class);
        GetCardsResponseEvent event = new GetCardsResponseEvent(null, null, null);

        event.setGetCardsResponse(getCardsResponse);
        Assertions.assertEquals(getCardsResponse, event.getGetCardsResponse(), "GetCardsResponse should be set and retrieved correctly");
    }
}