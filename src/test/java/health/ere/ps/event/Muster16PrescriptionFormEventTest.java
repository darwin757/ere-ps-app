package health.ere.ps.event;

import health.ere.ps.model.muster16.Muster16PrescriptionForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Muster16PrescriptionFormEventTest {

    @Test
    void testConstructor() {
        Muster16PrescriptionForm muster16PrescriptionForm = new Muster16PrescriptionForm();
        Muster16PrescriptionFormEvent muster16PrescriptionFormEvent = new Muster16PrescriptionFormEvent(muster16PrescriptionForm);

        Assertions.assertNotNull(muster16PrescriptionFormEvent, "Muster16PrescriptionFormEvent should be created successfully");
    }

    @Test
    void testGetMuster16PrescriptionForm() {
        Muster16PrescriptionForm muster16PrescriptionForm = new Muster16PrescriptionForm();
        Muster16PrescriptionFormEvent muster16PrescriptionFormEvent = new Muster16PrescriptionFormEvent(muster16PrescriptionForm);

        Assertions.assertEquals(muster16PrescriptionForm, muster16PrescriptionFormEvent.getMuster16PrescriptionForm(), "Muster16PrescriptionForm should be set correctly");
    }
}