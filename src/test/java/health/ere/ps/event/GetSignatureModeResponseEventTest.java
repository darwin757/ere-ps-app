package health.ere.ps.event;

import de.gematik.ws.conn.connectorcommon.v5.Status;
import de.gematik.ws.conn.signatureservice.v7_5_5.ComfortSignatureStatusEnum;
import de.gematik.ws.conn.signatureservice.v7_5_5.SessionInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

class GetSignatureModeResponseEventTest {

    @Test
    void testConstructorAndGetters() throws Exception {
        Status status = new Status();
        ComfortSignatureStatusEnum comfortSignatureStatus = ComfortSignatureStatusEnum.ENABLED;
        Integer comfortSignatureMax = 5;
        Duration comfortSignatureTimer = DatatypeFactory.newInstance().newDuration(60000);
        SessionInfo sessionInfo = new SessionInfo();

        GetSignatureModeResponseEvent event = new GetSignatureModeResponseEvent(status, comfortSignatureStatus, comfortSignatureMax, comfortSignatureTimer, sessionInfo);

        Assertions.assertEquals(status, event.getStatus(), "Status should be set correctly");
        Assertions.assertEquals(comfortSignatureStatus, event.getComfortSignatureStatus(), "ComfortSignatureStatus should be set correctly");
        Assertions.assertEquals(comfortSignatureMax, event.getComfortSignatureMax(), "ComfortSignatureMax should be set correctly");
        Assertions.assertEquals(comfortSignatureTimer, event.getComfortSignatureTimer(), "ComfortSignatureTimer should be set correctly");
        Assertions.assertEquals(sessionInfo, event.getSessionInfo(), "SessionInfo should be set correctly");
    }

    @Test
    void testSettersAndGetters() throws Exception {
        GetSignatureModeResponseEvent getSignatureModeResponseEvent = new GetSignatureModeResponseEvent(null, null, null, null, null);

        Status status = new Status();
        getSignatureModeResponseEvent.setStatus(status);
        Assertions.assertEquals(status, getSignatureModeResponseEvent.getStatus(), "Status should be set correctly");

        ComfortSignatureStatusEnum comfortSignatureStatus = ComfortSignatureStatusEnum.ENABLED;
        getSignatureModeResponseEvent.setComfortSignatureStatus(comfortSignatureStatus);
        Assertions.assertEquals(comfortSignatureStatus, getSignatureModeResponseEvent.getComfortSignatureStatus(), "ComfortSignatureStatus should be set correctly");

        Integer comfortSignatureMax = 5;
        getSignatureModeResponseEvent.setComfortSignatureMax(comfortSignatureMax);
        Assertions.assertEquals(comfortSignatureMax, getSignatureModeResponseEvent.getComfortSignatureMax(), "ComfortSignatureMax should be set correctly");

        Duration comfortSignatureTimer = DatatypeFactory.newInstance().newDuration(60000);
        getSignatureModeResponseEvent.setComfortSignatureTimer(comfortSignatureTimer);
        Assertions.assertEquals(comfortSignatureTimer, getSignatureModeResponseEvent.getComfortSignatureTimer(), "ComfortSignatureTimer should be set correctly");

        SessionInfo sessionInfo = new SessionInfo();
        getSignatureModeResponseEvent.setSessionInfo(sessionInfo);
        Assertions.assertEquals(sessionInfo, getSignatureModeResponseEvent.getSessionInfo(), "SessionInfo should be set correctly");

        boolean answertToActivateComfortSignature = true;
        getSignatureModeResponseEvent.setAnswertToActivateComfortSignature(answertToActivateComfortSignature);
        Assertions.assertTrue(getSignatureModeResponseEvent.isAnswertToActivateComfortSignature(), "AnswertToActivateComfortSignature should be set correctly");

        String userId = "testUserId";
        getSignatureModeResponseEvent.setUserId(userId);
        Assertions.assertEquals(userId, getSignatureModeResponseEvent.getUserId(), "UserId should be set correctly");
    }

    @Test
    void testBooleanGetter() {
        GetSignatureModeResponseEvent getSignatureModeResponseEvent = new GetSignatureModeResponseEvent(null, null, null, null, null);
        getSignatureModeResponseEvent.setAnswertToActivateComfortSignature(true);
        Assertions.assertTrue(getSignatureModeResponseEvent.getAnswertToActivateComfortSignature(), "getAnswertToActivateComfortSignature should return the correct value");
    }
}