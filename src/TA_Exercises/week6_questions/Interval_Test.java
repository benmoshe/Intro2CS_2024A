package TA_Exercises.week6_questions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Interval_Test {
    @Test
    public void testInterval() {
        Interval interval1 = new Interval(1, 5);
        Interval interval2 = new Interval(4, 6);
        assertTrue(interval1.contains(3));
        assertTrue(interval1.intersection(interval2));
        assertEquals(2, interval1.distBetweenMidPoints(interval2), 0.01);
    }
}

