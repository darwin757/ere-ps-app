package health.ere.ps.event;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Session;
import org.hl7.fhir.r4.model.Bundle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

class SignAndUploadBundlesEventTest {

    @Test
    void testJsonObjectConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("flowtype", "170")
                .add("toKimAddress", "test@kim.de")
                .add("noteToPharmacy", "Test note")
                .add("kimConfig", Json.createObjectBuilder()
                        .add("configKey", "configValue"))
                .add("payload", Json.createArrayBuilder()
                        .add(Json.createArrayBuilder()
                                .add(Json.createObjectBuilder()
                                        .add("resourceType", "Bundle"))))
                .build();

        SignAndUploadBundlesEvent signAndUploadBundlesEvent = new SignAndUploadBundlesEvent(jsonObject);

        Assertions.assertEquals("170", signAndUploadBundlesEvent.getFlowtype(), "Flowtype should be set correctly");
        Assertions.assertEquals("test@kim.de", signAndUploadBundlesEvent.getToKimAddress(), "ToKimAddress should be set correctly");
        Assertions.assertEquals("Test note", signAndUploadBundlesEvent.getNoteToPharmacy(), "NoteToPharmacy should be set correctly");
        Assertions.assertEquals("configValue", signAndUploadBundlesEvent.getKimConfigMap().get("configKey"), "KimConfigMap should contain the correct entry");

        List<List<Bundle>> bundles = signAndUploadBundlesEvent.getListOfListOfBundles();
        Assertions.assertEquals(1, bundles.size(), "List of bundles should contain one list");
        Assertions.assertEquals(1, bundles.get(0).size(), "Inner list of bundles should contain one bundle");
    }

    @Test
    void testFullConstructor() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("flowtype", "170")
                .add("toKimAddress", "test@kim.de")
                .add("noteToPharmacy", "Test note")
                .add("kimConfig", Json.createObjectBuilder()
                        .add("configKey", "configValue"))
                .add("payload", Json.createArrayBuilder()
                        .add(Json.createArrayBuilder()
                                .add(Json.createObjectBuilder()
                                        .add("resourceType", "Bundle"))))
                .build();
        Session mockSession = Mockito.mock(Session.class);
        String id = "testId";

        SignAndUploadBundlesEvent signAndUploadBundlesEvent = new SignAndUploadBundlesEvent(jsonObject, mockSession, id);

        Assertions.assertEquals("170", signAndUploadBundlesEvent.getFlowtype(), "Flowtype should be set correctly");
        Assertions.assertEquals("test@kim.de", signAndUploadBundlesEvent.getToKimAddress(), "ToKimAddress should be set correctly");
        Assertions.assertEquals("Test note", signAndUploadBundlesEvent.getNoteToPharmacy(), "NoteToPharmacy should be set correctly");
        Assertions.assertEquals("configValue", signAndUploadBundlesEvent.getKimConfigMap().get("configKey"), "KimConfigMap should contain the correct entry");
        Assertions.assertEquals(mockSession, signAndUploadBundlesEvent.getReplyTo(), "ReplyTo session should be set correctly");
        Assertions.assertEquals(id, signAndUploadBundlesEvent.getId(), "Id should be set correctly");

        List<List<Bundle>> bundles = signAndUploadBundlesEvent.getListOfListOfBundles();
        Assertions.assertEquals(1, bundles.size(), "List of bundles should contain one list");
        Assertions.assertEquals(1, bundles.get(0).size(), "Inner list of bundles should contain one bundle");
    }

    @Test
    void testBundlesConstructor() {
        List<Bundle> bundles = Collections.singletonList(new Bundle());
        SignAndUploadBundlesEvent signAndUploadBundlesEvent = new SignAndUploadBundlesEvent(bundles);
        Assertions.assertEquals(bundles, signAndUploadBundlesEvent.getListOfListOfBundles().get(0), "Bundles should be set correctly");
    }

    @Test
    void testGetListOfListOfBundles() {
        List<Bundle> bundles = Collections.singletonList(new Bundle());
        SignAndUploadBundlesEvent signAndUploadBundlesEvent = new SignAndUploadBundlesEvent(bundles);
        Assertions.assertEquals(bundles, signAndUploadBundlesEvent.getListOfListOfBundles().get(0), "ListOfListOfBundles should return the correct bundles");
    }

    @Test
    void testSetListOfListOfBundles() {
        List<List<Bundle>> listOfListOfBundles = new ArrayList<>();
        listOfListOfBundles.add(Collections.singletonList(new Bundle()));
        SignAndUploadBundlesEvent signAndUploadBundlesEvent = new SignAndUploadBundlesEvent(listOfListOfBundles.get(0));
        signAndUploadBundlesEvent.setListOfListOfBundles(listOfListOfBundles);
        Assertions.assertEquals(listOfListOfBundles, signAndUploadBundlesEvent.getListOfListOfBundles(), "ListOfListOfBundles should be set correctly");
    }

    @Test
    void testGetAndSetFlowtype() {
        SignAndUploadBundlesEvent signAndUploadBundlesEvent = new SignAndUploadBundlesEvent(Collections.singletonList(new Bundle()));
        signAndUploadBundlesEvent.setFlowtype("170");
        Assertions.assertEquals("170", signAndUploadBundlesEvent.getFlowtype(), "Flowtype should be set and retrieved correctly");
    }

    @Test
    void testGetAndSetToKimAddress() {
        SignAndUploadBundlesEvent signAndUploadBundlesEvent = new SignAndUploadBundlesEvent(Collections.singletonList(new Bundle()));
        signAndUploadBundlesEvent.setToKimAddress("test@kim.de");
        Assertions.assertEquals("test@kim.de", signAndUploadBundlesEvent.getToKimAddress(), "ToKimAddress should be set and retrieved correctly");
    }

    @Test
    void testGetAndSetNoteToPharmacy() {
        SignAndUploadBundlesEvent signAndUploadBundlesEvent = new SignAndUploadBundlesEvent(Collections.singletonList(new Bundle()));
        signAndUploadBundlesEvent.setNoteToPharmacy("Test note");
        Assertions.assertEquals("Test note", signAndUploadBundlesEvent.getNoteToPharmacy(), "NoteToPharmacy should be set and retrieved correctly");
    }

    @Test
    void testGetAndSetKimConfigMap() {
        SignAndUploadBundlesEvent signAndUploadBundlesEvent = new SignAndUploadBundlesEvent(Collections.singletonList(new Bundle()));
        Map<String, String> kimConfigMap = new HashMap<>();
        kimConfigMap.put("configKey", "configValue");
        signAndUploadBundlesEvent.setKimConfigMap(kimConfigMap);
        Assertions.assertEquals(kimConfigMap, signAndUploadBundlesEvent.getKimConfigMap(), "KimConfigMap should be set and retrieved correctly");
    }

}