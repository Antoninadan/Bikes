package ua.i.mail100.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideUtilTest {

    @Test
    void getIndexesPerParts() {
        int[][] expected1 = {{0, 2}, {3, 5}, {6, 9}};
        int[][] actual1 = DivideUtil.getIndexesPerParts(10, 3);
        assertArrayEquals(expected1, actual1);

        int[][] expected2 = {{0, 2}, {3, 5}, {6, 10}};
        int[][] actual2 = DivideUtil.getIndexesPerParts(11, 3);
        assertArrayEquals(expected2, actual2);

        int[][] expected3 = {{0, 4}};
        int[][] actual3 = DivideUtil.getIndexesPerParts(5, 1);
        assertArrayEquals(expected3, actual3);
    }
}