package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AbortTaskEntryTest {

    @Test
    void testDefaultConstructor(){
        AbortTaskEntry abortTaskEntry = new AbortTaskEntry();
        Assertions.assertNull(abortTaskEntry.getAccessCode(), "Access code should be null by default");
        Assertions.assertNull(abortTaskEntry.getId(), "ID should be null by default");
    }

    @Test
    void testParameterizedConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("accessCode", "testAccessCode")
                .add("id", "testId")
                .build();

        AbortTaskEntry abortTaskEntry = new AbortTaskEntry(jsonObject);
        Assertions.assertEquals("testAccessCode", abortTaskEntry.getAccessCode(), "Access code should match the one provided in the JSON object");
        Assertions.assertEquals("testId", abortTaskEntry.getId(), "ID should match the one provided in the JSON object");
    }

    @Test
    void testSetAndGetAccessCode() {
        AbortTaskEntry abortTaskEntry = new AbortTaskEntry();
        abortTaskEntry.setAccessCode("newAccessCode");
        Assertions.assertEquals("newAccessCode", abortTaskEntry.getAccessCode(), "Access code should be set and retrieved correctly");
    }

    @Test
    void testSetAndGetId() {
        AbortTaskEntry abortTaskEntry = new AbortTaskEntry();
        abortTaskEntry.setId("newId");
        Assertions.assertEquals("newId", abortTaskEntry.getId(), "ID should be set and retrieved correctly");
    }
}