package health.ere.ps.event;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class SVGExtractorResultEventTest {

    @Test
    void testConstructorAndGetter() {
        Map<String, String> svgExtractionResult = new HashMap<>();
        svgExtractionResult.put("key1", "value1");
        svgExtractionResult.put("key2", "value2");

        SVGExtractorResultEvent svgExtractorResultEvent = new SVGExtractorResultEvent(svgExtractionResult);

        Assertions.assertEquals(svgExtractionResult, svgExtractorResultEvent.getSvgExtractionResult(), "SVG extraction result should be set correctly");
    }

    @Test
    void testEmptyConstructorAndGetter() {
        Map<String, String> svgExtractionResult = new HashMap<>();

        SVGExtractorResultEvent svgExtractorResultEvent = new SVGExtractorResultEvent(svgExtractionResult);

        Assertions.assertTrue(svgExtractorResultEvent.getSvgExtractionResult().isEmpty(), "SVG extraction result should be empty");
    }
}