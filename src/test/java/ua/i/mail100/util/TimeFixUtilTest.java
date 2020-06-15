package ua.i.mail100.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeFixUtilTest {
    public static final Integer TEST_DURATION_MILLI = 3;
    public static final Integer TEST_DURATION_DELTA = 10;

    @Test
    public void elapsedTime(){
        TimeFixUtil timeFixUtil = new TimeFixUtil();

        try {
            Thread.sleep(TEST_DURATION_MILLI);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Double milli = timeFixUtil.elapsedTime();

        assertEquals(TEST_DURATION_MILLI, milli, TEST_DURATION_DELTA);
    }
}