package health.ere.ps.event.config;

import health.ere.ps.model.config.UserConfigurations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserConfigurationsUpdateEventTest {

    @Test
    void testConstructorAndGetter() {
        UserConfigurations configurations = new UserConfigurations();

        UserConfigurationsUpdateEvent userConfigurationsUpdateEvent = new UserConfigurationsUpdateEvent(configurations);

        Assertions.assertEquals(configurations, userConfigurationsUpdateEvent.getConfigurations(), "Configurations should be set correctly");
    }
}