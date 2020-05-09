package com.bis.asciiart.domain;

import java.util.Objects;

/**
 * Line component for rendering in Canvas
 */
public final class Line {

    private final Integer x1;

    private final Integer y1;

    private final Integer x2;

    private final Integer y2;

    public Line(final Integer x1, final Integer y1, final Integer x2, final Integer y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Integer getX1() {
        return x1;
    }

    public Integer getY1() {
        return y1;
    }

    public Integer getX2() {
        return x2;
    }

    public Integer getY2() {
        return y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(x1, line.x1) &&
                Objects.equals(y1, line.y1) &&
                Objects.equals(x2, line.x2) &&
                Objects.equals(y2, line.y2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }
}
