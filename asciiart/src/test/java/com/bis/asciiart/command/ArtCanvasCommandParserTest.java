package com.bis.asciiart.command;

import com.bis.asciiart.ArtCanvas;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class ArtCanvasCommandParserTest {

    private final CanvasCommandParser commandParser = new CanvasCommandParser();

    @Test
    public void validateTest() {
        final String goodInputUnderTest = "c 10 20";
        assertTrue(commandParser.validate(goodInputUnderTest));

        assertFalse(commandParser.validate("c 10 "));
        assertFalse(commandParser.validate("c"));
        assertFalse(commandParser.validate("k 10 "));
    }

    @Test
    public void fetchCommandArgumentTest() {
        final ArtCanvas artCanvasUnderTest = new ArtCanvas(10, 50);
        final String goodInputUnderTest = "c 10 50";

        Optional<ArtCanvas> artCanvas = commandParser.fetchCommandArguments(goodInputUnderTest);
        if (artCanvas.isEmpty()) {
            fail("Cannot parse Canvas parameters!");
        }
        assertThat(artCanvas.get(), equalTo(artCanvasUnderTest));
    }
}
