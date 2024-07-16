package health.ere.ps.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EreLogNotificationEventTest {

    @Test
    void testDefaultConstructor() {
        EreLogNotificationEvent ereLogNotificationEvent = new EreLogNotificationEvent();

        Assertions.assertNull(ereLogNotificationEvent.getSystemContextList(), "System context list should be null by default");
        Assertions.assertNull(ereLogNotificationEvent.getSimpleLogMessage(), "Simple log message should be null by default");
        Assertions.assertNull(ereLogNotificationEvent.getStatus(), "Status should be null by default");
        Assertions.assertNull(ereLogNotificationEvent.getLogMessage(), "Log message should be null by default");
        Assertions.assertNull(ereLogNotificationEvent.getLogMessageDetails(), "Log message details should be null by default");
        Assertions.assertNull(ereLogNotificationEvent.getBundleInfo(), "Bundle info should be null by default");
    }

    @Test
    void testParameterizedConstructor() {

        List<String> systemContextList = Arrays.asList("context1", "context2");
        String simpleLogMessage = "Simple log message";
        String status = "OK";
        String logMessage = "Detailed log message";
        List<String> logMessageDetails = Arrays.asList("detail1", "detail2");
        Map<String, String> bundleInfo = new HashMap<>();

        bundleInfo.put("key1", "value1");

        EreLogNotificationEvent ereLogNotificationEvent = getEreLogNotificationEvent();

        Assertions.assertEquals(systemContextList, ereLogNotificationEvent.getSystemContextList(), "System context list should match the one provided");
        Assertions.assertEquals(simpleLogMessage, ereLogNotificationEvent.getSimpleLogMessage(), "Simple log message should match the one provided");
        Assertions.assertEquals(status, ereLogNotificationEvent.getStatus(), "Status should match the one provided");
        Assertions.assertEquals(logMessage, ereLogNotificationEvent.getLogMessage(), "Log message should match the one provided");
        Assertions.assertEquals(logMessageDetails, ereLogNotificationEvent.getLogMessageDetails(), "Log message details should match the ones provided");
        Assertions.assertEquals(bundleInfo, ereLogNotificationEvent.getBundleInfo(), "Bundle info should match the one provided");
    }

    @Test
    void testToString() {
        EreLogNotificationEvent ereLogNotificationEvent = getEreLogNotificationEvent();

        ObjectMapper mapper = new ObjectMapper();
        String expectedJson = "{}";
        try {
            expectedJson = mapper.writeValueAsString(ereLogNotificationEvent);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(expectedJson, ereLogNotificationEvent.toString(), "The JSON representation should match the expected JSON string");
    }

    private static @NotNull EreLogNotificationEvent getEreLogNotificationEvent() {
        List<String> systemContextList = Arrays.asList("context1", "context2");
        String simpleLogMessage = "Simple log message";
        String status = "OK";
        String logMessage = "Detailed log message";
        List<String> logMessageDetails = Arrays.asList("detail1", "detail2");
        Map<String, String> bundleInfo = new HashMap<>();
        bundleInfo.put("key1", "value1");

        EreLogNotificationEvent ereLogNotificationEvent = new EreLogNotificationEvent(systemContextList, simpleLogMessage, status, logMessage, logMessageDetails, bundleInfo);
        return ereLogNotificationEvent;
    }
}