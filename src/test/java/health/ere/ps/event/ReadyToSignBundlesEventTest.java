package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.hl7.fhir.r4.model.Bundle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

class ReadyToSignBundlesEventTest {

    @Test
    void testJsonConstructor() {
        JsonArray innerArray = Json.createArrayBuilder()
                .add(Json.createObjectBuilder().add("resourceType", "Bundle"))
                .add(Json.createObjectBuilder().add("resourceType", "Bundle"))
                .build();

        JsonArray outerArray = Json.createArrayBuilder()
                .add(innerArray)
                .build();

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("payload", outerArray)
                .build();

        ReadyToSignBundlesEvent readyToSignBundlesEvent = new ReadyToSignBundlesEvent(jsonObject);

        Assertions.assertEquals(1, readyToSignBundlesEvent.listOfListOfBundles.size(), "The outer list should have one element");
        Assertions.assertEquals(2, readyToSignBundlesEvent.listOfListOfBundles.get(0).size(), "The inner list should have two elements");
        Assertions.assertTrue(readyToSignBundlesEvent.listOfListOfBundles.get(0).get(0) instanceof Bundle, "The first element should be a Bundle");
        Assertions.assertTrue(readyToSignBundlesEvent.listOfListOfBundles.get(0).get(1) instanceof Bundle, "The second element should be a Bundle");
    }

    @Test
    void testBundlesConstructor() {
        Bundle bundle1 = new Bundle();
        Bundle bundle2 = new Bundle();
        List<Bundle> bundles = Arrays.asList(bundle1, bundle2);

        ReadyToSignBundlesEvent readyToSignBundlesEvent = new ReadyToSignBundlesEvent(bundles);

        Assertions.assertEquals(1, readyToSignBundlesEvent.listOfListOfBundles.size(), "The outer list should have one element");
        Assertions.assertEquals(2, readyToSignBundlesEvent.listOfListOfBundles.get(0).size(), "The inner list should have two elements");
        Assertions.assertEquals(bundle1, readyToSignBundlesEvent.listOfListOfBundles.get(0).get(0), "The first element should match the first bundle");
        Assertions.assertEquals(bundle2, readyToSignBundlesEvent.listOfListOfBundles.get(0).get(1), "The second element should match the second bundle");
    }

    @Test
    void testBundlesConstructorWithSessionAndMessageId() {
        Bundle bundle1 = new Bundle();
        Bundle bundle2 = new Bundle();
        List<Bundle> bundles = Arrays.asList(bundle1, bundle2);

        Session mockSession = Mockito.mock(Session.class);
        String messageId = "testMessageId";

        ReadyToSignBundlesEvent readyToSignBundlesEvent = new ReadyToSignBundlesEvent(bundles, mockSession, messageId);

        Assertions.assertEquals(1, readyToSignBundlesEvent.listOfListOfBundles.size(), "The outer list should have one element");
        Assertions.assertEquals(2, readyToSignBundlesEvent.listOfListOfBundles.get(0).size(), "The inner list should have two elements");
        Assertions.assertEquals(bundle1, readyToSignBundlesEvent.listOfListOfBundles.get(0).get(0), "The first element should match the first bundle");
        Assertions.assertEquals(bundle2, readyToSignBundlesEvent.listOfListOfBundles.get(0).get(1), "The second element should match the second bundle");
        Assertions.assertEquals(mockSession, readyToSignBundlesEvent.getReplyTo(), "ReplyTo session should match the provided session");
        Assertions.assertEquals(messageId, readyToSignBundlesEvent.getReplyToMessageId(), "ReplyToMessageId should match the provided id");
    }

    @Test
    void testJsonConstructorWithSessionAndMessageId() {
        JsonArray innerArray = Json.createArrayBuilder()
                .add(Json.createObjectBuilder().add("resourceType", "Bundle"))
                .add(Json.createObjectBuilder().add("resourceType", "Bundle"))
                .build();

        JsonArray outerArray = Json.createArrayBuilder()
                .add(innerArray)
                .build();

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("payload", outerArray)
                .build();

        Session mockSession = Mockito.mock(Session.class);
        String messageId = "testMessageId";

        ReadyToSignBundlesEvent readyToSignBundlesEvent = new ReadyToSignBundlesEvent(jsonObject, mockSession, messageId);

        Assertions.assertEquals(1, readyToSignBundlesEvent.listOfListOfBundles.size(), "The outer list should have one element");
        Assertions.assertEquals(2, readyToSignBundlesEvent.listOfListOfBundles.get(0).size(), "The inner list should have two elements");
        Assertions.assertTrue(readyToSignBundlesEvent.listOfListOfBundles.get(0).get(0) instanceof Bundle, "The first element should be a Bundle");
        Assertions.assertTrue(readyToSignBundlesEvent.listOfListOfBundles.get(0).get(1) instanceof Bundle, "The second element should be a Bundle");
        Assertions.assertEquals(mockSession, readyToSignBundlesEvent.getReplyTo(), "ReplyTo session should match the provided session");
        Assertions.assertEquals(messageId, readyToSignBundlesEvent.getReplyToMessageId(), "ReplyToMessageId should match the provided id");
    }
}