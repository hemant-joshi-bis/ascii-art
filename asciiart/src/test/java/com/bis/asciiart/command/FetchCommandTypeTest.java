package com.bis.asciiart.command;

import com.bis.asciiart.BaseClassTest;
import com.bis.asciiart.domain.CommandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FetchCommandTypeTest extends BaseClassTest {

    private final CommandExecutor commandExecutor = new CommandExecutorImpl();

    @Test
    public void fetchCommandLineTest() {
        assertEquals(commandExecutor.fetchCommandType(CANVAS_TEST_STRING), CommandType.CANVAS);
        assertEquals(commandExecutor.fetchCommandType(LINE_TEST_STRING), CommandType.LINE);
        assertEquals(commandExecutor.fetchCommandType(RECT_TEST_STRING), CommandType.RECT);
        assertEquals(commandExecutor.fetchCommandType(UNKNOWN_TEST_STRING), CommandType.UNKNOWN);
    }

}
