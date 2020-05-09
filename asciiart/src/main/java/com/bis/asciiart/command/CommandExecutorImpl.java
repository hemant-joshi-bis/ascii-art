package com.bis.asciiart.command;

import com.bis.asciiart.ArtCanvas;
import com.bis.asciiart.artpainter.LinePainter;
import com.bis.asciiart.artpainter.RectanglePainter;
import com.bis.asciiart.domain.CommandType;
import com.bis.asciiart.domain.Line;
import com.bis.asciiart.domain.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Command executioner for Canvas, Line and Rectangle
 */
public class CommandExecutorImpl implements CommandExecutor {

    private final static Logger logger = LoggerFactory.getLogger(CommandExecutorImpl.class);

    /**
     * Canvas for rendering components
     */
    private ArtCanvas artCanvas = null;

    /**
     * Fectches command type
     *
     * @param data command type data
     * @return command type
     */
    @Override
    public CommandType fetchCommandType(final String data) {
        logger.debug("Command Type Data : " + data);
        CommandParser<ArtCanvas> commandParser = new CanvasCommandParser();
        LineCommandParser lineCommandParser = new LineCommandParser();
        RectangleCommandParser rectAngleCommandParser = new RectangleCommandParser();
        if (commandParser.validate(data)) {
            return CommandType.CANVAS;
        } else if (lineCommandParser.validate(data)) {
            return CommandType.LINE;
        } else if (rectAngleCommandParser.validate(data)) {
            return CommandType.RECT;
        } else {
            return CommandType.UNKNOWN;
        }
    }

    /**
     * fetches Canvas
     *
     * @param data Canvas command
     * @return ArtCanvas
     */
    @Override
    public Optional<ArtCanvas> fetchCanvas(final String data) {
        CommandParser<ArtCanvas> commandParser = new CanvasCommandParser();
        Optional<ArtCanvas> artCanvas = commandParser.fetchCommandArguments(data);
        if (commandParser.fetchCommandArguments(data).isEmpty()) {
            return Optional.empty();
        } else {
            return artCanvas;
        }
    }

    /**
     * fteches line
     *
     * @param data Line
     * @return line
     */
    @Override
    public Optional<Line> fetchLine(final String data) {
        CommandParser<Line> commandParser = new LineCommandParser();
        Optional<Line> line = commandParser.fetchCommandArguments(data);
        if (commandParser.fetchCommandArguments(data).isEmpty()) {
            return Optional.empty();
        } else {
            return line;
        }
    }

    /**
     * fetches Rectangle
     *
     * @param data rectangle command
     * @return Rectangle
     */
    @Override
    public Optional<Rectangle> fetchRectangle(final String data) {
        CommandParser<Rectangle> commandParser = new RectangleCommandParser();
        Optional<Rectangle> rectangle = commandParser.fetchCommandArguments(data);
        if (commandParser.fetchCommandArguments(data).isEmpty()) {
            return Optional.empty();
        } else {
            return rectangle;
        }
    }

    /**
     * @param commandType command
     * @param input       string
     * @return if command is found and valid
     */
    @Override
    public Boolean processCommand(final CommandType commandType,
                                  final String input) {
        var success = false;
        switch (commandType) {
            case CANVAS:
                Optional<ArtCanvas> optionalArtCanvas = fetchCanvas(input);
                if (optionalArtCanvas.isEmpty()) {
                    System.out.println("Canvas error, can not be created");
                } else {
                    artCanvas = optionalArtCanvas.get();
                    success = true;
                }
                break;
            case LINE:
                final Optional<Line> optionalLine = fetchLine(input);
                if (optionalLine.isEmpty() || artCanvas == null) {
                    logger.error("Line cannot be created, either Canvas not created or line creation error");
                } else {
                    final Line line = optionalLine.get();
                    if (artCanvas.checkHorizontalCoordinates(line.getX1(), line.getX2())
                            && artCanvas.checkVerticalCoordinates(line.getY1(), line.getY2())) {
                        artCanvas.addComponent(new LinePainter(line));
                        success = true;
                    } else {
                        logger.error("Line cannot be added to canvas, either Canvas not created or line creation error");
                    }
                }
                break;
            case RECT:
                final Optional<Rectangle> optionalRectangle = fetchRectangle(input);
                if (optionalRectangle.isEmpty() || artCanvas == null) {
                    logger.error("Rectangle cannot be created, either Canvas not created or rectangle creation error");
                } else {
                    final Rectangle rectangle = optionalRectangle.get();
                    if (artCanvas.checkHorizontalCoordinates(rectangle.getX1(), rectangle.getX2())
                            && artCanvas.checkVerticalCoordinates(rectangle.getY1(), rectangle.getY2())) {
                        artCanvas.addComponent(new RectanglePainter(optionalRectangle.get()));
                        success = true;
                    } else {
                        logger.error("Rectangle cannot be created, either Canvas not created or rectangle creation error");
                    }
                }
                break;
        }

        render();

        return success;
    }

    private void render() {
        if (null != artCanvas) {
            artCanvas.paint();
            artCanvas.print();
        }
    }

    @Override
    public ArtCanvas getArtCanvas() {
        return this.artCanvas;
    }
}
