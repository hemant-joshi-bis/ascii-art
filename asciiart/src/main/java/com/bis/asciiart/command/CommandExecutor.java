package com.bis.asciiart.command;

import com.bis.asciiart.ArtCanvas;
import com.bis.asciiart.domain.CommandType;
import com.bis.asciiart.domain.Line;
import com.bis.asciiart.domain.Rectangle;

import java.util.Optional;

public interface CommandExecutor {

    CommandType fetchCommandType(final String input);

    Optional<ArtCanvas> fetchCanvas(final String input);

    Optional<Line> fetchLine(final String data);

    Optional<Rectangle> fetchRectangle(final String data);

    ArtCanvas getArtCanvas();

    Boolean processCommand(final CommandType commandType,
                           final String input);
}
