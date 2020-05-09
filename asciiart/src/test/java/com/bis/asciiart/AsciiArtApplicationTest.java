package com.bis.asciiart;

import com.bis.asciiart.command.CommandExecutor;
import com.bis.asciiart.command.CommandExecutorImpl;
import com.bis.asciiart.domain.CommandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AsciiArtApplicationTest extends BaseClassTest {

    private final CommandExecutor commandExecutor = new CommandExecutorImpl();

    @Test
    public void processCommandTest() {
        assertTrue(commandExecutor.processCommand(CommandType.CANVAS, CANVAS_TEST_STRING));
        assertTrue(commandExecutor.processCommand(CommandType.LINE, LINE_TEST_STRING));
        assertTrue(commandExecutor.processCommand(CommandType.RECT, RECT_TEST_STRING));

        assertFalse(commandExecutor.processCommand(CommandType.CANVAS, "C"));
        assertFalse(commandExecutor.processCommand(CommandType.LINE, "L"));
        assertFalse(commandExecutor.processCommand(CommandType.RECT, "R"));

        assertFalse(commandExecutor.processCommand(CommandType.LINE, BAD_LINE_TEST_X_STRING));
        assertFalse(commandExecutor.processCommand(CommandType.LINE, BAD_LINE_TEST_Y_STRING));

        assertFalse(commandExecutor.processCommand(CommandType.RECT, BAD_RECT_TEST_X_STRING));
        assertFalse(commandExecutor.processCommand(CommandType.RECT, BAD_RECT_TEST_Y_STRING));
    }
}
