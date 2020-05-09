package com.bis.asciiart.command;

import com.bis.asciiart.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class LineCommandParserTest {

    private final LineCommandParser commandParser = new LineCommandParser();

    @Test
    public void validateTest() {
        final String goodInputUnderTest = "l 10 16 10 18";
        assertTrue(commandParser.validate(goodInputUnderTest));

        assertFalse(commandParser.validate("l 10 "));
        assertFalse(commandParser.validate("l"));
        assertFalse(commandParser.validate("l 10 5 "));
        assertFalse(commandParser.validate("l 10 5 8"));
        assertTrue(commandParser.validate("l 10 16 22 18"));
    }

    @Test
    public void fetchCommandArgumentTest() {
        final Line lineUnderTest = new Line(10, 16, 10, 18);
        final String goodInputUnderTest = "l 10 16 10 18";

        Optional<Line> line = commandParser.fetchCommandArguments(goodInputUnderTest);
        if (line.isEmpty()) {
            fail("Cannot parse Canvas parameters!");
        }
        assertThat(line.get(), equalTo(lineUnderTest));
    }
}
