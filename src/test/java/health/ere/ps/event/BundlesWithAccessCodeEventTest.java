package health.ere.ps.event;

import health.ere.ps.model.gematik.BundleWithAccessCodeOrThrowable;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BundlesWithAccessCodeEventTest {

    @Test
    void testConstructorWithBundles() {
        List<BundleWithAccessCodeOrThrowable> bundleList1 = Arrays.asList(new BundleWithAccessCodeOrThrowable(), new BundleWithAccessCodeOrThrowable());
        List<BundleWithAccessCodeOrThrowable> bundleList2 = Arrays.asList(new BundleWithAccessCodeOrThrowable(), new BundleWithAccessCodeOrThrowable());
        List<List<BundleWithAccessCodeOrThrowable>> bundles = Arrays.asList(bundleList1, bundleList2);

        BundlesWithAccessCodeEvent bundlesWithAccessCodeEvent = new BundlesWithAccessCodeEvent(bundles);

        Assertions.assertEquals(bundles, bundlesWithAccessCodeEvent.getBundleWithAccessCodeOrThrowable(), "Bundles should be set correctly");
    }

    @Test
    void testConstructorWithBundlesSessionAndId() {
        List<BundleWithAccessCodeOrThrowable> bundleList1 = Arrays.asList(new BundleWithAccessCodeOrThrowable(), new BundleWithAccessCodeOrThrowable());
        List<BundleWithAccessCodeOrThrowable> bundleList2 = Arrays.asList(new BundleWithAccessCodeOrThrowable(), new BundleWithAccessCodeOrThrowable());
        List<List<BundleWithAccessCodeOrThrowable>> bundles = Arrays.asList(bundleList1, bundleList2);
        Session mockSession = Mockito.mock(Session.class);

        BundlesWithAccessCodeEvent bundlesWithAccessCodeEvent = new BundlesWithAccessCodeEvent(bundles, mockSession, "testId");

        Assertions.assertEquals(bundles, bundlesWithAccessCodeEvent.getBundleWithAccessCodeOrThrowable(), "Bundles should be set correctly");
        Assertions.assertEquals(mockSession, bundlesWithAccessCodeEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals("testId", bundlesWithAccessCodeEvent.getReplyToMessageId(), "Id should be set correctly");
    }

    @Test
    void testGetAndSetFlowtype() {
        BundlesWithAccessCodeEvent bundlesWithAccessCodeEvent = new BundlesWithAccessCodeEvent(null);
        bundlesWithAccessCodeEvent.setFlowtype("170");

        Assertions.assertEquals("170", bundlesWithAccessCodeEvent.getFlowtype(), "Flowtype should be set and retrieved correctly");
    }

    @Test
    void testGetAndSetToKimAddress() {
        BundlesWithAccessCodeEvent bundlesWithAccessCodeEvent = new BundlesWithAccessCodeEvent(null);
        bundlesWithAccessCodeEvent.setToKimAddress("kim@example.com");

        Assertions.assertEquals("kim@example.com", bundlesWithAccessCodeEvent.getToKimAddress(), "ToKimAddress should be set and retrieved correctly");
    }

    @Test
    void testGetAndSetNoteToPharmacy() {
        BundlesWithAccessCodeEvent bundlesWithAccessCodeEvent = new BundlesWithAccessCodeEvent(null);
        bundlesWithAccessCodeEvent.setNoteToPharmacy("Note to pharmacy");

        Assertions.assertEquals("Note to pharmacy", bundlesWithAccessCodeEvent.getNoteToPharmacy(), "NoteToPharmacy should be set and retrieved correctly");
    }

    @Test
    void testGetAndSetKimConfigMap() {
        BundlesWithAccessCodeEvent bundlesWithAccessCodeEvent = new BundlesWithAccessCodeEvent(null);
        Map<String, String> kimConfigMap = new HashMap<>();
        kimConfigMap.put("key1", "value1");
        bundlesWithAccessCodeEvent.setKimConfigMap(kimConfigMap);

        Assertions.assertEquals(kimConfigMap, bundlesWithAccessCodeEvent.getKimConfigMap(), "KimConfigMap should be set and retrieved correctly");
    }

}