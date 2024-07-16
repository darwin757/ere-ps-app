package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class VZDSearchEventTest {

    @Test
    void testJsonConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("search", "testSearch")
                .build();

        VZDSearchEvent vzdSearchEvent = new VZDSearchEvent(jsonObject);

        Assertions.assertEquals("testSearch", vzdSearchEvent.getSearch(), "Search should be set correctly from JSON");
    }

    @Test
    void testFullConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("search", "testSearch")
                .build();
        Session mockSession = Mockito.mock(Session.class);
        String id = "testId";

        VZDSearchEvent vzdSearchEvent = new VZDSearchEvent(jsonObject, mockSession, id);

        Assertions.assertEquals("testSearch", vzdSearchEvent.getSearch(), "Search should be set correctly from JSON");
        Assertions.assertEquals(mockSession, vzdSearchEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(id, vzdSearchEvent.getId(), "Id should be set correctly");
    }

    @Test
    void testSettersAndGetters() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("search", "testSearch")
                .build();

        VZDSearchEvent vzdSearchEvent = new VZDSearchEvent(jsonObject);
        vzdSearchEvent.setSearch("newSearch");

        Assertions.assertEquals("newSearch", vzdSearchEvent.getSearch(), "Search should be set and retrieved correctly");
    }
}