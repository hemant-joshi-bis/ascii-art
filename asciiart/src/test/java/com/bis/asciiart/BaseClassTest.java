package com.bis.asciiart;

public abstract class BaseClassTest {

    public static final String CANVAS_TEST_STRING = "c 20 4";

    public static final String CANVAS_EMPTY_TEST_STRING = "c 20";

    public static final String LINE_TEST_STRING = "l 1 3 7 3";

    public static final String LINE_X1_X2_STRING = "L 3 4 3 2";

    public static final String LINE_EMPTY_TEST_STRING = "l 1 3 ";

    public static final String RECT_TEST_STRING = "r 15 2 20 4";

    public static final String RECT_EMPTY_TEST_STRING = "r 15 2 ";

    public static final String UNKNOWN_TEST_STRING = "K 15 2 20 5";

    public static final String BAD_LINE_TEST_X_STRING = "l 1 4 26 3";

    public static final String BAD_LINE_TEST_Y_STRING = "l 1 22 3 3";

    public static final String BAD_RECT_TEST_X_STRING = "r 22 2 20 4";

    public static final String BAD_RECT_TEST_Y_STRING = "r 22 6 20 4";
}
