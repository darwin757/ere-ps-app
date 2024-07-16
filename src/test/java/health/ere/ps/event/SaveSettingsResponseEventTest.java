package health.ere.ps.event;

import health.ere.ps.model.config.UserConfigurations;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SaveSettingsResponseEventTest {

    @Test
    void testDefaultConstructor() {
        SaveSettingsResponseEvent saveSettingsResponseEvent = new SaveSettingsResponseEvent();
        Assertions.assertNull(saveSettingsResponseEvent.getUserConfigurations(), "UserConfigurations should be null by default");
    }

    @Test
    void testUserConfigurationsConstructor() {
        UserConfigurations userConfigurations = new UserConfigurations();
        SaveSettingsResponseEvent event = new SaveSettingsResponseEvent(userConfigurations);
        Assertions.assertEquals(userConfigurations, event.getUserConfigurations(), "UserConfigurations should be set correctly");
    }

    @Test
    void testSetAndGetUserConfigurations() {
        UserConfigurations userConfigurations = new UserConfigurations();
        SaveSettingsResponseEvent saveSettingsResponseEvent = new SaveSettingsResponseEvent();
        saveSettingsResponseEvent.setUserConfigurations(userConfigurations);

        Assertions.assertEquals(userConfigurations, saveSettingsResponseEvent.getUserConfigurations(), "UserConfigurations should be set and retrieved correctly");
    }

    @Test
    void testSetAndGetReplyTo() {
        SaveSettingsResponseEvent saveSettingsResponseEvent = new SaveSettingsResponseEvent();
        Session mockSession = Mockito.mock(Session.class);
        saveSettingsResponseEvent.setReplyTo(mockSession);

        Assertions.assertEquals(mockSession, saveSettingsResponseEvent.getReplyTo(), "ReplyTo session should be set and retrieved correctly");
    }

    @Test
    void testSetAndGetId() {
        SaveSettingsResponseEvent saveSettingsResponseEvent = new SaveSettingsResponseEvent();
        String id = "testId";
        saveSettingsResponseEvent.setId(id);

        Assertions.assertEquals(id, saveSettingsResponseEvent.getId(), "Id should be set and retrieved correctly");
    }
}