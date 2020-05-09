package com.bis.asciiart.artpainter;

/**
 * Generic interface for printing
 */
public interface Printable {

    char FILL_CHAR = '-';

    char BORDER_CHAR = '|';

    char BLANK_CHAR = ' ';

    char LINE_CHAR = 'x';

    void print();
}
