package com.bis.asciiart.command;

import com.bis.asciiart.ArtCanvas;

import java.util.Optional;

/**
 * Canvas Command Parser and Validator
 */
public class CanvasCommandParser implements CommandParser<ArtCanvas> {

    private final static String CANVAS_PARSER = "[Cc]\\s(\\d+)\\s(\\d+)";

    private final static String CANVAS_SPLITTER = "\\s";

    private final static Integer MIN_VALUE_CHECK = 4;

    private final static Integer MAX_VALUE_CHECK = 100;

    /**
     * fetches Canvas
     * @param data Canvas command
     * @return ArtCanvas
     */
    @Override
    public Optional<ArtCanvas> fetchCommandArguments(String data) {

        if (validate(data)) {
            String[] canvasParameters = data.split(CANVAS_SPLITTER);
            return Optional.of(new ArtCanvas(Integer.parseInt(canvasParameters[1]), Integer.parseInt(canvasParameters[2])));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Validates ArtCanvas
     * @param data Cnvas command
     * @return validation result
     */
    @Override
    public Boolean validate(String data) {
        if (data.matches(CANVAS_PARSER)) {
            String[] canvasParameters = data.split(CANVAS_SPLITTER);
            Boolean canvasHeightCheck = Integer.parseInt(canvasParameters[1]) >= MIN_VALUE_CHECK && Integer.parseInt(canvasParameters[1]) <= MAX_VALUE_CHECK;
            Boolean canvasWidthCheck = Integer.parseInt(canvasParameters[2]) >= MIN_VALUE_CHECK && Integer.parseInt(canvasParameters[2]) <= MAX_VALUE_CHECK;
            return canvasHeightCheck && canvasWidthCheck;
        }
        return false;
    }
}
