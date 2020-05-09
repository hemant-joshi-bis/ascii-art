package com.bis.asciiart.command;

import com.bis.asciiart.domain.Line;

import java.util.Optional;

/**
 * Parses Line command
 */
public class LineCommandParser implements CommandParser<Line> {

    private final static String LINE_PARSER = "[Ll]\\s(\\d+)\\s(\\d+)\\s(\\d+)\\s(\\d+)";

    /**
     * Fetches Line parameters
     *
     * @param data Line command
     * @return Line
     */
    @Override
    public Optional<Line> fetchCommandArguments(final String data) {

        if (validate(data)) {
            String[] lineParameters = data.split(" ");

            Line line = new Line(Integer.parseInt(lineParameters[1]),
                    Integer.parseInt(lineParameters[2]),
                    Integer.parseInt(lineParameters[3]),
                    Integer.parseInt(lineParameters[4])
            );
            return Optional.of(line);
        }
        return Optional.empty();
    }

    /**
     * Validates Line object
     *
     * @param data Line command
     * @return whether line command is valid.
     */
    @Override
    public Boolean validate(final String data) {
        return data.matches(LINE_PARSER);
    }
}
