package health.ere.ps.event;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PDDocumentEventTest {

    @Test
    void testConstructor() throws IOException {
        PDDocument pdDocument = new PDDocument();
        PDDocumentEvent pdDocumentEvent = new PDDocumentEvent(pdDocument);
        Assertions.assertEquals(pdDocument, pdDocumentEvent.getPDDocument(), "PDDocument should be set correctly");
        pdDocument.close();
    }

    @Test
    void testGetPDDocument() throws IOException {
        PDDocument pdDocument = new PDDocument();
        PDDocumentEvent pdDocumentEvent = new PDDocumentEvent(pdDocument);
        Assertions.assertEquals(pdDocument, pdDocumentEvent.getPDDocument(), "PDDocument should be retrieved correctly");
        pdDocument.close();
    }
}