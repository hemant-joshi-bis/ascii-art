package com.bis.asciiart.artpainter;

import com.bis.asciiart.ArtCanvas;
import com.bis.asciiart.domain.Line;

/**
 *  ASCII char based line painter
 *  Used as child of the ArtClass which prints ASCII art
 */
public class LinePainter implements Painter {

    private final Line line;

    public LinePainter(final Line line) {
        this.line = line;
    }

    /**
     * Paints a line
     * @param artCanvas Master canvas for building ASCII graph and printing
     */
    @Override
    public void paint(final ArtCanvas artCanvas) {

        /*
          Very simple assumption is made here
          probably need better algorithm to calculate points between x1,y1 and x2,y2
         */
        if (line.getX1().equals(line.getX2())) {
            artCanvas.drawVerticalLine(line.getX1(), line.getY1(), line.getY2());
        }

        if (line.getY1().equals(line.getY2())) {
            artCanvas.drawHorizontalLine(line.getY1(), line.getX1(), line.getX2());
        }
    }
}
