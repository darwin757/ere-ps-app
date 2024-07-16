package health.ere.ps.event;

import health.ere.ps.model.config.UserConfigurations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckSettingsEventTest {

    @Test
    void testDefaultConstructor() {
        CheckSettingsEvent checkSettingsEvent = new CheckSettingsEvent();
        Assertions.assertNull(checkSettingsEvent.getUserConfigurations(), "UserConfigurations should be null by default");
    }

    @Test
    void testParameterizedConstructor() {
        UserConfigurations userConfigurations = new UserConfigurations();
        CheckSettingsEvent checkSettingsEvent = new CheckSettingsEvent(userConfigurations);

        Assertions.assertEquals(userConfigurations, checkSettingsEvent.getUserConfigurations(), "UserConfigurations should match the one provided in the constructor");
    }

    @Test
    void testSetAndGetUserConfigurations() {
        UserConfigurations userConfigurations = new UserConfigurations();
        CheckSettingsEvent checkSettingsEvent = new CheckSettingsEvent();
        checkSettingsEvent.setUserConfigurations(userConfigurations);

        Assertions.assertEquals(userConfigurations, checkSettingsEvent.getUserConfigurations(), "UserConfigurations should be set and retrieved correctly");
    }

}