package health.ere.ps.event;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AbortTaskStatusTest {

    @Test
    void testDefaultConstructor() {
        AbortTaskStatus abortTaskStatus = new AbortTaskStatus();

        Assertions.assertNull(abortTaskStatus.getAbortTaskEntry(), "AbortTaskEntry should be null by default");
        Assertions.assertNull(abortTaskStatus.getStatus(), "Status should be null by default");
        Assertions.assertNull(abortTaskStatus.getThrowable(), "Throwable should be null by default");
    }

    @Test
    void testParameterizedConstructor() {
        AbortTaskEntry abortTaskEntry = new AbortTaskEntry();
        AbortTaskStatus abortTaskStatus = new AbortTaskStatus(abortTaskEntry);

        Assertions.assertEquals(abortTaskEntry, abortTaskStatus.getAbortTaskEntry(), "AbortTaskEntry should be set correctly");
        Assertions.assertNull(abortTaskStatus.getStatus(), "Status should be null by default");
        Assertions.assertNull(abortTaskStatus.getThrowable(), "Throwable should be null by default");
    }

    @Test
    void testSetAndGetAbortTaskEntry() {
        AbortTaskEntry abortTaskEntry = new AbortTaskEntry();
        AbortTaskStatus abortTaskStatus = new AbortTaskStatus();

        abortTaskStatus.setAbortTaskEntry(abortTaskEntry);

        Assertions.assertEquals(abortTaskEntry, abortTaskStatus.getAbortTaskEntry(), "AbortTaskEntry should be set and retrieved correctly");
    }

    @Test
    void testSetAndGetStatus() {
        AbortTaskStatus abortTaskStatus = new AbortTaskStatus();

        abortTaskStatus.setStatus(AbortTaskStatus.Status.OK);

        Assertions.assertEquals(AbortTaskStatus.Status.OK, abortTaskStatus.getStatus(), "Status should be set and retrieved correctly");
    }

    @Test
    void testSetAndGetThrowable() {
        Throwable throwable = new Throwable("Test throwable");
        AbortTaskStatus abortTaskStatus = new AbortTaskStatus();

        abortTaskStatus.setThrowable(throwable);

        Assertions.assertEquals(throwable, abortTaskStatus.getThrowable(), "Throwable should be set and retrieved correctly");
    }
}