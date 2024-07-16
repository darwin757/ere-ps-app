package health.ere.ps.event;

import health.ere.ps.model.gematik.BundleWithAccessCodeOrThrowable;
import health.ere.ps.model.pdf.ERezeptDocument;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

class ERezeptWithDocumentsEventTest {

    @Test
    void testDefaultConstructor() {
        List<BundleWithAccessCodeOrThrowable> bundleWithAccessCodeOrThrowableList = Collections.emptyList();
        byte[] pdfDocument = new byte[0];

        ERezeptDocument eRezeptDocument1 = new ERezeptDocument(bundleWithAccessCodeOrThrowableList, pdfDocument);
        ERezeptDocument eRezeptDocument2 = new ERezeptDocument(bundleWithAccessCodeOrThrowableList, pdfDocument);
        List<ERezeptDocument> eRezeptDocumentList = List.of(eRezeptDocument1, eRezeptDocument2);

        ERezeptWithDocumentsEvent eRezeptWithDocumentsEvent = new ERezeptWithDocumentsEvent(eRezeptDocumentList);
        Assertions.assertEquals(eRezeptDocumentList, eRezeptWithDocumentsEvent.getERezeptWithDocuments(), "The documents list should match the provided list");
    }

    @Test
    void testFullConstructor() {
        List<BundleWithAccessCodeOrThrowable> bundleWithAccessCodeOrThrowables = Collections.emptyList();
        byte[] pdfDocument = new byte[0];

        ERezeptDocument eRezeptDocument1 = new ERezeptDocument(bundleWithAccessCodeOrThrowables, pdfDocument);
        ERezeptDocument eRezeptDocument2 = new ERezeptDocument(bundleWithAccessCodeOrThrowables, pdfDocument);
        List<ERezeptDocument> eRezeptDocumentList = List.of(eRezeptDocument1, eRezeptDocument2);

        Session mockSession = Mockito.mock(Session.class);
        String replyToMessageId = "testReplyToMessageId";

        ERezeptWithDocumentsEvent eRezeptWithDocumentsEvent = new ERezeptWithDocumentsEvent(eRezeptDocumentList, mockSession, replyToMessageId);

        Assertions.assertEquals(eRezeptDocumentList, eRezeptWithDocumentsEvent.getERezeptWithDocuments(), "The documents list should match the provided list");
        Assertions.assertEquals(mockSession, eRezeptWithDocumentsEvent.getReplyTo(), "ReplyTo session should match the provided session");
        Assertions.assertEquals(replyToMessageId, eRezeptWithDocumentsEvent.getReplyToMessageId(), "ReplyToMessageId should match the provided id");
    }
}