package com.bis.asciiart;

import com.bis.asciiart.artpainter.Drawable;
import com.bis.asciiart.artpainter.Painter;
import com.bis.asciiart.artpainter.Printable;

import java.util.*;

public class ArtCanvas implements Drawable, Printable {

    private final Integer width;

    private final Integer height;

    private final Character[][] pixelArray;

    private final List<Painter> painterList = new ArrayList<>();

    public ArtCanvas(final Integer width, final Integer height) {
        this.width = width + 2;
        this.height = height + 2;
        this.pixelArray = new Character[this.height + 2][this.width + 2];
        clear();
    }

    /**
     * Clears Canvas
     */
    @Override
    public void clear() {
        for (int h = 0; h < this.height; h++) {
            for (int w = 0; w < this.width; w++) {
                pixelArray[h][w] = BLANK_CHAR;
            }
        }
    }

    /**
     * Draws horizontal line
     * @param y1 start of y position
     * @param x1 start of x position
     * @param x2 end of x position
     */
    @Override
    public void drawHorizontalLine(Integer y1, Integer x1, Integer x2) {
        if (x1 > x2) {
            Integer temp = x1;
            x2 = x1;
            x1 = temp;
        }

        for (Integer w = x1; w <= x2; w++) {
            pixelArray[y1][w] = LINE_CHAR;
        }
    }

    /**
     * Draws vertical line
     * @param x1 start of horizontal position
     * @param y1 start of y position
     * @param y2 end of y position
     */
    @Override
    public void drawVerticalLine(Integer x1, Integer y1, Integer y2) {
        if (y1 > y2) {
            Integer temp = y1;
            y2 = y1;
            y1 = temp;
        }

        for (int h = y1; h <= y2; h++) {
            pixelArray[h][x1] = LINE_CHAR;
        }
    }


    /**
     * Draws a simple line at a fixed y position
     * @param x width of the line
     * @param y y position of the line
     */
    @Override
    public void drawLine(final Integer x, final Integer y) {
        for (int w = 0; w < x; w++) {
            pixelArray[y][w] = FILL_CHAR;
        }
    }

    /**
     * Draws edges of a Box
     * @param startHeight start y position
     * @param endHeight end y position
     * @param x width of the box
     */
    @Override
    public void drawBorder(final Integer startHeight, final Integer endHeight, final Integer x) {
        for (int h = startHeight; h < endHeight; h++) {
            pixelArray[h][x] = BORDER_CHAR;
        }
    }

    /**
     * Default print to a console
     */
    @Override
    public void print() {
        final StringBuilder sb = new StringBuilder();
        for (int h = 0; h < this.height; h++) {
            for (int w = 0; w < this.width; w++) {
                sb.append(pixelArray[h][w]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    /**
     * Default paint for building canvas pixels
     */
    @Override
    public void paint() {
        clear();
        drawLine(this.width, 0);
        drawLine(this.width, this.height - 1);
        drawBorder(1, this.height - 1, 0);
        drawBorder(1, this.height - 1, this.width - 1);

        painterList.forEach(p -> p.paint(this));
    }

    /**
     * Add paint component
     * @param painter Line, Rectangle painter
     */
    public void addComponent(Painter painter) {
        painterList.add(painter);
    }

    /**
     *
     * @return pixel array for rendering
     */
    public Character[][] getPixelArray() {
        return pixelArray;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Boolean checkHorizontalCoordinates(final Integer x1, final Integer x2) {
        return (x1 <= this.width -2) && (x2 <= this.width -2);
    }

    public Boolean checkVerticalCoordinates(final Integer y1, final Integer y2) {
        return (y1 <= this.height -2) && (y2 <= this.height -2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtCanvas artCanvas = (ArtCanvas) o;
        return Objects.equals(width, artCanvas.width) &&
                Objects.equals(height, artCanvas.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
