package com.bis.asciiart.artpainter;

import com.bis.asciiart.ArtCanvas;
import com.bis.asciiart.BaseClassTest;
import com.bis.asciiart.command.CommandExecutor;
import com.bis.asciiart.command.CommandExecutorImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.bis.asciiart.domain.CommandType.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArtCanvasTest extends BaseClassTest {

    private final CommandExecutor commandExecutor = new CommandExecutorImpl();

    @Test
    public void paintTest() {
        commandExecutor.processCommand(CANVAS, CANVAS_TEST_STRING);
        ArtCanvas artCanvas = commandExecutor.getArtCanvas();
        assertNotNull(artCanvas);

        artCanvas.paint();
        artCanvas.print();

        assertEquals(artCanvas.getHeight().intValue(), 6);
        assertEquals(artCanvas.getWidth().intValue(), 22);

        Character[][] pixelArray = artCanvas.getPixelArray();

        assertNotNull(pixelArray);
        assertEquals(pixelArray.length, 8);
        assertEquals(pixelArray[0].length, 24);
    }

    @Test
    public void canvasEmptyTest() {
        Optional<ArtCanvas> canvas = commandExecutor.fetchCanvas(CANVAS_EMPTY_TEST_STRING);
        assertTrue(canvas.isEmpty());
    }
}
