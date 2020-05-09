package com.bis.asciiart.artpainter;

/**
 * ArtCanvas drawing rules
 */
public interface Drawable {

    void clear();

    void paint();

    void drawHorizontalLine(final Integer y, final Integer x1, final Integer x2);

    void drawVerticalLine(final Integer x, final Integer y1, final Integer y2);

    void drawLine(final Integer x1, final Integer y1);

    void drawBorder(final Integer startHeight, final Integer endHeight, final Integer x);
}
