package com.bis.asciiart.artpainter;

import com.bis.asciiart.ArtCanvas;
import com.bis.asciiart.domain.Rectangle;

/**
 * Paints as a child component inside Canvas
 */
public class RectanglePainter implements Painter {

    private final Rectangle rectangle;

    public RectanglePainter(final Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * Paint rectangle
     * @param artCanvas Canvas
     */
    @Override
    public void paint(final ArtCanvas artCanvas) {
        artCanvas.drawHorizontalLine(this.rectangle.getY1(),
                this.rectangle.getX1(), this.rectangle.getX2());

        artCanvas.drawHorizontalLine(this.rectangle.getY2(),
                this.rectangle.getX1(), this.rectangle.getX2());

        artCanvas.drawVerticalLine(this.rectangle.getX1(),
                this.rectangle.getY1(), this.rectangle.getY2());

        artCanvas.drawVerticalLine(this.rectangle.getX2(),
                this.rectangle.getY1(), this.rectangle.getY2());

    }
}
