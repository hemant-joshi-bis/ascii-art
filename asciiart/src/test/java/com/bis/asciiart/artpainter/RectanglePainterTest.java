package com.bis.asciiart.artpainter;

import com.bis.asciiart.ArtCanvas;
import com.bis.asciiart.BaseClassTest;
import com.bis.asciiart.command.CommandExecutor;
import com.bis.asciiart.command.CommandExecutorImpl;
import com.bis.asciiart.domain.Rectangle;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.bis.asciiart.domain.CommandType.CANVAS;
import static com.bis.asciiart.domain.CommandType.RECT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectanglePainterTest extends BaseClassTest {

    private final CommandExecutor commandExecutor = new CommandExecutorImpl();

    @Test
    public void paintTest() {
        commandExecutor.processCommand(CANVAS, CANVAS_TEST_STRING);
        commandExecutor.processCommand(RECT, LINE_TEST_STRING);
        ArtCanvas artCanvas = commandExecutor.getArtCanvas();

        artCanvas.paint();
        artCanvas.print();
        // TODO Need to test RECT
        assertEquals(artCanvas.getHeight().intValue(), 6);
        assertEquals(artCanvas.getWidth().intValue(), 22);
    }

    @Test
    public void rectEmptyTest() {
        Optional<Rectangle> rectangle = commandExecutor.fetchRectangle(RECT_EMPTY_TEST_STRING);
        assertTrue(rectangle.isEmpty());
    }

    @Test
    public void rectTest() {
        Optional<Rectangle> rect = commandExecutor.fetchRectangle(RECT_TEST_STRING);
        assertTrue(rect.isPresent());
    }
}
