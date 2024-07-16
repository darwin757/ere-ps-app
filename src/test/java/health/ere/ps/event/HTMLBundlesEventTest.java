package health.ere.ps.event;

import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

class HTMLBundlesEventTest {

    @Test
    void testConstructorWithBundlesOnly() {
        List<String> bundles = Arrays.asList("bundle1", "bundle2", "bundle3");

        HTMLBundlesEvent htmlBundlesEvent = new HTMLBundlesEvent(bundles);

        Assertions.assertEquals(bundles, htmlBundlesEvent.getBundles(), "The bundles list should match the provided list");
    }

    @Test
    void testConstructorWithBundlesAndSession() {
        List<String> bundles = Arrays.asList("bundle1", "bundle2", "bundle3");

        Session mockSession = Mockito.mock(Session.class);
        String replyToMessageId = "testReplyToMessageId";

        HTMLBundlesEvent htmlBundlesEvent = new HTMLBundlesEvent(bundles, mockSession, replyToMessageId);

        Assertions.assertEquals(bundles, htmlBundlesEvent.getBundles(), "The bundles list should match the provided list");
        Assertions.assertEquals(mockSession, htmlBundlesEvent.getReplyTo(), "The replyTo session should match the provided session");
        Assertions.assertEquals(replyToMessageId, htmlBundlesEvent.getReplyToMessageId(), "The replyToMessageId should match the provided ID");
    }
}