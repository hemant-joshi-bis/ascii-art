package com.bis.asciiart.artpainter;

import com.bis.asciiart.ArtCanvas;
import com.bis.asciiart.BaseClassTest;
import com.bis.asciiart.command.CommandExecutor;
import com.bis.asciiart.command.CommandExecutorImpl;
import com.bis.asciiart.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.bis.asciiart.domain.CommandType.CANVAS;
import static com.bis.asciiart.domain.CommandType.LINE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinePainterTest extends BaseClassTest {

    private final CommandExecutor commandExecutor = new CommandExecutorImpl();

    @Test
    public void paintTest() {
        commandExecutor.processCommand(CANVAS, CANVAS_TEST_STRING);
        commandExecutor.processCommand(LINE, LINE_TEST_STRING);
        ArtCanvas artCanvas = commandExecutor.getArtCanvas();

        // TODO Need to test LINE
        artCanvas.paint();
        artCanvas.print();

        assertEquals(artCanvas.getHeight().intValue(), 6);
        assertEquals(artCanvas.getWidth().intValue(), 22);

        commandExecutor.processCommand(LINE, LINE_X1_X2_STRING);

        commandExecutor.processCommand(LINE, "L 8 4 2 4");

        // TODO Need to test LINE
        artCanvas.paint();
        artCanvas.print();
    }

    @Test
    public void lineTest() {
        Optional<Line> line = commandExecutor.fetchLine(LINE_TEST_STRING);
        assertTrue(line.isPresent());
    }

    @Test
    public void lineEmptyTest() {
        Optional<Line> line = commandExecutor.fetchLine(LINE_EMPTY_TEST_STRING);
        assertTrue(line.isEmpty());
    }
}
