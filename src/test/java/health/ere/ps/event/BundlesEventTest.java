package health.ere.ps.event;

import jakarta.websocket.Session;
import org.hl7.fhir.r4.model.Bundle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

class BundlesEventTest {

    @Test
    void testConstructorWithBundles() {
        Bundle bundle1 = new Bundle();
        Bundle bundle2 = new Bundle();
        List<Bundle> bundles = Arrays.asList(bundle1, bundle2);

        BundlesEvent bundlesEvent = new BundlesEvent(bundles);

        Assertions.assertEquals(bundles, bundlesEvent.getBundles(), "Bundles should be set correctly");
    }

    @Test
    void testConstructorWithBundlesSessionAndId() {
        Bundle bundle1 = new Bundle();
        Bundle bundle2 = new Bundle();
        List<Bundle> bundles = Arrays.asList(bundle1, bundle2);
        Session mockSession = Mockito.mock(Session.class);

        BundlesEvent bundlesEvent = new BundlesEvent(bundles, mockSession, "testId");

        Assertions.assertEquals(bundles, bundlesEvent.getBundles(), "Bundles should be set correctly");
        Assertions.assertEquals(mockSession, bundlesEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals("testId", bundlesEvent.getId(), "Id should be set correctly");
    }
}