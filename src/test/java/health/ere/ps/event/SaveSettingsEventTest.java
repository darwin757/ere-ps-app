package health.ere.ps.event;

import health.ere.ps.model.config.UserConfigurations;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SaveSettingsEventTest {

    @Test
    void testDefaultConstructor() {
        SaveSettingsEvent saveSettingsEvent = new SaveSettingsEvent();
        Assertions.assertNull(saveSettingsEvent.getUserConfigurations(), "UserConfigurations should be null by default");
    }

    @Test
    void testUserConfigurationsConstructor() {
        UserConfigurations userConfigurations = new UserConfigurations();
        SaveSettingsEvent saveSettingsEvent = new SaveSettingsEvent(userConfigurations);
        Assertions.assertEquals(userConfigurations, saveSettingsEvent.getUserConfigurations(), "UserConfigurations should be set correctly");
    }

    @Test
    void testFullConstructor() {
        UserConfigurations userConfigurations = new UserConfigurations();
        Session mockSession = Mockito.mock(Session.class);
        String messageId = "testMessageId";

        SaveSettingsEvent saveSettingsEvent = new SaveSettingsEvent(userConfigurations, mockSession, messageId);

        Assertions.assertEquals(userConfigurations, saveSettingsEvent.getUserConfigurations(), "UserConfigurations should be set correctly");
        Assertions.assertEquals(mockSession, saveSettingsEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(messageId, saveSettingsEvent.getId(), "MessageId should be set correctly");
    }

    @Test
    void testSetAndGetUserConfigurations() {
        UserConfigurations userConfigurations = new UserConfigurations();
        SaveSettingsEvent saveSettingsEvent = new SaveSettingsEvent();
        saveSettingsEvent.setUserConfigurations(userConfigurations);

        Assertions.assertEquals(userConfigurations, saveSettingsEvent.getUserConfigurations(), "UserConfigurations should be set and retrieved correctly");
    }

    @Test
    void testSetAndGetReplyTo() {
        SaveSettingsEvent saveSettingsEvent = new SaveSettingsEvent();
        Session mockSession = Mockito.mock(Session.class);
        saveSettingsEvent.setReplyTo(mockSession);

        Assertions.assertEquals(mockSession, saveSettingsEvent.getReplyTo(), "ReplyTo session should be set and retrieved correctly");
    }

    @Test
    void testSetAndGetId() {
        SaveSettingsEvent saveSettingsEvent = new SaveSettingsEvent();
        String id = "testId";
        saveSettingsEvent.setId(id);

        Assertions.assertEquals(id, saveSettingsEvent.getId(), "Id should be set and retrieved correctly");
    }
}