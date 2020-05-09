package com.bis.asciiart.command;

import com.bis.asciiart.domain.Rectangle;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleCommandTest {

    private final static String goodInputUnderTest = "r 10 16 10 18";

    private final RectangleCommandParser commandParser = new RectangleCommandParser();

    @Test
    public void validateTest() {

        assertTrue(commandParser.validate(goodInputUnderTest));

        assertFalse(commandParser.validate("r 10 "));
        assertFalse(commandParser.validate("r"));
        assertFalse(commandParser.validate("r 10 5 "));
        assertFalse(commandParser.validate("r 10 5 8"));
        assertTrue(commandParser.validate("R 10 16 22 18"));
    }

    @Test
    public void fetchCommandArgumentTest() {
        final Rectangle rectangleUnderTest = new Rectangle(10, 16, 10, 18);
        Optional<Rectangle> rectangle = commandParser.fetchCommandArguments(goodInputUnderTest);
        if (rectangle.isEmpty()) {
            fail("Cannot parse Rectangle  parameters!");
        }
        assertThat(rectangle.get(), equalTo(rectangleUnderTest));
    }
}
