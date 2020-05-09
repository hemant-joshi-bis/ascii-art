package com.bis.asciiart.command;

import com.bis.asciiart.domain.Rectangle;

import java.util.Optional;

/**
 * Parses Rectangular command
 */
public class RectangleCommandParser implements CommandParser<Rectangle> {

    private final static String RECTANGLE_PARSER = "[R r]\\s(\\d+)\\s(\\d+)\\s(\\d+)\\s(\\d+)";

    /**
     * Fetches Rectangle parameters
     *
     * @param data Rectangle command
     * @return Rectangle
     */
    @Override
    public Optional<Rectangle> fetchCommandArguments(final String data
    ) {
        if (validate(data)) {
            String[] rectParameters = data.split(" ");

            Rectangle rectangle = new Rectangle(Integer.parseInt(rectParameters[1]),
                    Integer.parseInt(rectParameters[2]),
                    Integer.parseInt(rectParameters[3]),
                    Integer.parseInt(rectParameters[4])
            );
            return Optional.of(rectangle);
        }
        return Optional.empty();
    }

    /**
     * Validates Rectangle object
     *
     * @param data Rectangle command
     * @return whether rectangle command is valid.
     */
    @Override
    public Boolean validate(String data) {
        return data.matches(RECTANGLE_PARSER);
    }
}