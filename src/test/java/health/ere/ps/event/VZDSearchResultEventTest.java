package health.ere.ps.event;

import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

class VZDSearchResultEventTest {

    @Test
    void testConstructorAndGetters() {
        Map<String, Object> result1 = new HashMap<>();
        result1.put("key1", "value1");
        Map<String, Object> result2 = new HashMap<>();
        result2.put("key2", "value2");
        List<Map<String, Object>> results = Arrays.asList(result1, result2);

        VZDSearchResultEvent vzdSearchResultEvent = new VZDSearchResultEvent(results);

        Assertions.assertEquals(results, vzdSearchResultEvent.getResults(), "Results should be set correctly");
    }

    @Test
    void testFullConstructor() {
        Map<String, Object> result1 = new HashMap<>();
        result1.put("key1", "value1");
        Map<String, Object> result2 = new HashMap<>();
        result2.put("key2", "value2");
        List<Map<String, Object>> results = Arrays.asList(result1, result2);

        Session mockSession = Mockito.mock(Session.class);
        String replyToMessageId = "testReplyToMessageId";

        VZDSearchResultEvent vzdSearchResultEvent = new VZDSearchResultEvent(results, mockSession, replyToMessageId);

        Assertions.assertEquals(results, vzdSearchResultEvent.getResults(), "Results should be set correctly");
        Assertions.assertEquals(mockSession, vzdSearchResultEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(replyToMessageId, vzdSearchResultEvent.getReplyToMessageId(), "ReplyToMessageId should be set correctly");
    }

    @Test
    void testSettersAndGetters() {
        VZDSearchResultEvent vzdSearchResultEvent = new VZDSearchResultEvent(new ArrayList<>());

        Map<String, Object> result = new HashMap<>();
        result.put("key", "value");
        List<Map<String, Object>> results = Collections.singletonList(result);

        vzdSearchResultEvent.setResults(results);

        Assertions.assertEquals(results, vzdSearchResultEvent.getResults(), "Results should be set and retrieved correctly");
    }

    @Test
    void testGetType() {
        VZDSearchResultEvent vzdSearchResultEvent = new VZDSearchResultEvent(new ArrayList<>());
        Assertions.assertEquals("VZDSearchResult", vzdSearchResultEvent.getType(), "Type should be 'VZDSearchResult'");
    }

    @Test
    void testGetPayload() {
        Map<String, Object> result = new HashMap<>();
        result.put("key", "value");
        List<Map<String, Object>> results = Collections.singletonList(result);

        VZDSearchResultEvent vzdSearchResultEvent = new VZDSearchResultEvent(results);
        Assertions.assertEquals(results, vzdSearchResultEvent.getPayload(), "Payload should be the results");
    }
}