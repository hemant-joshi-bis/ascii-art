package com.bis.asciiart.io;

import java.util.Scanner;

/**
 * Simple console input reader
 */
public class ScannerDataReaderImpl implements DataReader {

    private final Scanner scanner;

    public ScannerDataReaderImpl(final Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Reads line from scanner
     *
     * @return command text
     */
    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
