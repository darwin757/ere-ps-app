package health.ere.ps.event.erixa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import health.ere.ps.model.erixa.PrescriptionTransferEntry;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SendToPharmacyEventTest {

    @Test
    void testConstructor() throws JsonProcessingException {
        JsonObject detailsJson = Json.createObjectBuilder()
                .add("firstName", "John")
                .add("lastName", "Doe")
                .add("salutation", "Mr.")
                .add("birthday", "1980-01-01")
                .add("street", "123 Main St")
                .add("postcode", "12345")
                .add("city", "Anytown")
                .add("emailAddress", "john.doe@example.com")
                .add("insuranceType", "Private")
                .add("healthInsurance", "Health Inc.")
                .add("healthInsuranceNumber", "123456789")
                .add("pzn", "987654321")
                .add("autIdem", true)
                .add("dosage", "2 pills")
                .add("medicineDescription", "Painkiller")
                .add("extraPaymentNecessary", false)
                .add("creationDateTime", "2022-01-01T12:00:00Z")
                .add("surgeryDate", "2022-01-15")
                .build();

        JsonObject payload = Json.createObjectBuilder()
                .add("document", "testDocument")
                .add("details", detailsJson)
                .build();

        SendToPharmacyEvent sendToPharmacyEvent = new SendToPharmacyEvent(payload);

        Assertions.assertEquals("testDocument", sendToPharmacyEvent.getDocument(), "Document should be set correctly");

        ObjectMapper mapper = new ObjectMapper();
        PrescriptionTransferEntry expectedDetails = mapper.readValue(detailsJson.toString(), PrescriptionTransferEntry.class);
        Assertions.assertEquals(expectedDetails.getFirstName(), sendToPharmacyEvent.getDetails().getFirstName(), "Details should be set correctly");
        Assertions.assertEquals(expectedDetails.getLastName(), sendToPharmacyEvent.getDetails().getLastName(), "LastName should be set correctly");
        Assertions.assertEquals(expectedDetails.getSalutation(), sendToPharmacyEvent.getDetails().getSalutation(), "Salutation should be set correctly");
        Assertions.assertEquals(expectedDetails.getBirthday(), sendToPharmacyEvent.getDetails().getBirthday(), "Birthday should be set correctly");
        Assertions.assertEquals(expectedDetails.getStreet(), sendToPharmacyEvent.getDetails().getStreet(), "Street should be set correctly");
        Assertions.assertEquals(expectedDetails.getPostcode(), sendToPharmacyEvent.getDetails().getPostcode(), "Postcode should be set correctly");
        Assertions.assertEquals(expectedDetails.getCity(), sendToPharmacyEvent.getDetails().getCity(), "City should be set correctly");
        Assertions.assertEquals(expectedDetails.getEmailAddress(), sendToPharmacyEvent.getDetails().getEmailAddress(), "EmailAddress should be set correctly");
        Assertions.assertEquals(expectedDetails.getInsuranceType(), sendToPharmacyEvent.getDetails().getInsuranceType(), "InsuranceType should be set correctly");
        Assertions.assertEquals(expectedDetails.getHealthInsurance(), sendToPharmacyEvent.getDetails().getHealthInsurance(), "HealthInsurance should be set correctly");
        Assertions.assertEquals(expectedDetails.getHealthInsuranceNumber(), sendToPharmacyEvent.getDetails().getHealthInsuranceNumber(), "HealthInsuranceNumber should be set correctly");
        Assertions.assertEquals(expectedDetails.getPzn(), sendToPharmacyEvent.getDetails().getPzn(), "PZN should be set correctly");
        Assertions.assertEquals(expectedDetails.isAutIdem(), sendToPharmacyEvent.getDetails().isAutIdem(), "AutIdem should be set correctly");
        Assertions.assertEquals(expectedDetails.getDosage(), sendToPharmacyEvent.getDetails().getDosage(), "Dosage should be set correctly");
        Assertions.assertEquals(expectedDetails.getMedicineDescription(), sendToPharmacyEvent.getDetails().getMedicineDescription(), "MedicineDescription should be set correctly");
        Assertions.assertEquals(expectedDetails.isExtraPaymentNecessary(), sendToPharmacyEvent.getDetails().isExtraPaymentNecessary(), "ExtraPaymentNecessary should be set correctly");
        Assertions.assertEquals(expectedDetails.getCreationDateTime(), sendToPharmacyEvent.getDetails().getCreationDateTime(), "CreationDateTime should be set correctly");
        Assertions.assertEquals(expectedDetails.getSurgeryDate(), sendToPharmacyEvent.getDetails().getSurgeryDate(), "SurgeryDate should be set correctly");

    }

    @Test
    void testFullConstructor() throws JsonProcessingException {
        JsonObject detailsJson = Json.createObjectBuilder()
                .add("firstName", "John")
                .add("lastName", "Doe")
                .add("salutation", "Mr.")
                .add("birthday", "1980-01-01")
                .add("street", "123 Main St")
                .add("postcode", "12345")
                .add("city", "Anytown")
                .add("emailAddress", "john.doe@example.com")
                .add("insuranceType", "Private")
                .add("healthInsurance", "Health Inc.")
                .add("healthInsuranceNumber", "123456789")
                .add("pzn", "987654321")
                .add("autIdem", true)
                .add("dosage", "2 pills")
                .add("medicineDescription", "Painkiller")
                .add("extraPaymentNecessary", false)
                .add("creationDateTime", "2022-01-01T12:00:00Z")
                .add("surgeryDate", "2022-01-15")
                .build();

        JsonObject payload = Json.createObjectBuilder()
                .add("document", "testDocument")
                .add("details", detailsJson)
                .build();

        Session mockSession = Mockito.mock(Session.class);
        String replyToMessageId = "testReplyToMessageId";

        SendToPharmacyEvent sendToPharmacyEvent = new SendToPharmacyEvent(payload, mockSession, replyToMessageId);

        Assertions.assertEquals("testDocument", sendToPharmacyEvent.getDocument(), "Document should be set correctly");

        ObjectMapper mapper = new ObjectMapper();
        PrescriptionTransferEntry expectedDetails = mapper.readValue(detailsJson.toString(), PrescriptionTransferEntry.class);
        Assertions.assertEquals(expectedDetails.getFirstName(), sendToPharmacyEvent.getDetails().getFirstName(), "Details should be set correctly");
        Assertions.assertEquals(expectedDetails.getLastName(), sendToPharmacyEvent.getDetails().getLastName(), "LastName should be set correctly");
        Assertions.assertEquals(expectedDetails.getSalutation(), sendToPharmacyEvent.getDetails().getSalutation(), "Salutation should be set correctly");
        Assertions.assertEquals(expectedDetails.getBirthday(), sendToPharmacyEvent.getDetails().getBirthday(), "Birthday should be set correctly");
        Assertions.assertEquals(expectedDetails.getStreet(), sendToPharmacyEvent.getDetails().getStreet(), "Street should be set correctly");
        Assertions.assertEquals(expectedDetails.getPostcode(), sendToPharmacyEvent.getDetails().getPostcode(), "Postcode should be set correctly");
        Assertions.assertEquals(expectedDetails.getCity(), sendToPharmacyEvent.getDetails().getCity(), "City should be set correctly");
        Assertions.assertEquals(expectedDetails.getEmailAddress(), sendToPharmacyEvent.getDetails().getEmailAddress(), "EmailAddress should be set correctly");
        Assertions.assertEquals(expectedDetails.getInsuranceType(), sendToPharmacyEvent.getDetails().getInsuranceType(), "InsuranceType should be set correctly");
        Assertions.assertEquals(expectedDetails.getHealthInsurance(), sendToPharmacyEvent.getDetails().getHealthInsurance(), "HealthInsurance should be set correctly");
        Assertions.assertEquals(expectedDetails.getHealthInsuranceNumber(), sendToPharmacyEvent.getDetails().getHealthInsuranceNumber(), "HealthInsuranceNumber should be set correctly");
        Assertions.assertEquals(expectedDetails.getPzn(), sendToPharmacyEvent.getDetails().getPzn(), "PZN should be set correctly");
        Assertions.assertEquals(expectedDetails.isAutIdem(), sendToPharmacyEvent.getDetails().isAutIdem(), "AutIdem should be set correctly");
        Assertions.assertEquals(expectedDetails.getDosage(), sendToPharmacyEvent.getDetails().getDosage(), "Dosage should be set correctly");
        Assertions.assertEquals(expectedDetails.getMedicineDescription(), sendToPharmacyEvent.getDetails().getMedicineDescription(), "MedicineDescription should be set correctly");
        Assertions.assertEquals(expectedDetails.isExtraPaymentNecessary(), sendToPharmacyEvent.getDetails().isExtraPaymentNecessary(), "ExtraPaymentNecessary should be set correctly");
        Assertions.assertEquals(expectedDetails.getCreationDateTime(), sendToPharmacyEvent.getDetails().getCreationDateTime(), "CreationDateTime should be set correctly");
        Assertions.assertEquals(expectedDetails.getSurgeryDate(), sendToPharmacyEvent.getDetails().getSurgeryDate(), "SurgeryDate should be set correctly");


        Assertions.assertEquals(mockSession, sendToPharmacyEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(replyToMessageId, sendToPharmacyEvent.getReplyToMessageId(), "ReplyToMessageId should be set correctly");
    }

}