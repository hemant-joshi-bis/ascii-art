package com.bis.asciiart;

import com.bis.asciiart.command.CommandExecutor;
import com.bis.asciiart.command.CommandExecutorImpl;
import com.bis.asciiart.io.DataReader;
import com.bis.asciiart.io.ScannerDataReaderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Main Java class to run AsciiArt application
 * Simple console reader is used for input commands
 * Simple Console output is  used for rendering Ascii art
 */
public class AsciiArtApplication {

    private static final String QUIT = "Q";

    private static final String SPACE = " ";

    /**
     * Logging messages
     */
    private final static Logger logger = LoggerFactory.getLogger(AsciiArtApplication.class);

    /**
     * Simple console data reader
     */
    private final DataReader dataReader;

    /**
     * Provides rendering commands
     */
    private final CommandExecutor commandExecutor;

    public AsciiArtApplication(final DataReader dataReader,
                               final CommandExecutor commandExecutor) {
        this.dataReader = dataReader;
        this.commandExecutor = commandExecutor;
    }

    /**
     * interactive command executioner
     */
    private void appRunner() {
        while (true) {
            System.out.print("enter command: ");
            String data = dataReader.readLine();
            boolean appContinue = Stream.of(data.split(SPACE)).findFirst().filter(s -> s.equalsIgnoreCase(QUIT)).isEmpty();

            if (!appContinue) {
                System.exit(0);
            }
            commandExecutor.processCommand(commandExecutor.fetchCommandType(data), data);
        }
    }

    /**
     * entry point for an application
     *
     * @param args for future setting min and max Canvas
     */
    public static void main(String... args) {
        logger.debug("Application ascii srt started");
        new AsciiArtApplication(new ScannerDataReaderImpl(new Scanner(System.in)),
                new CommandExecutorImpl()).appRunner();
    }

}
