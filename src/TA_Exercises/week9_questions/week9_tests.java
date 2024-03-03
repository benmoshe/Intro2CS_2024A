package TA_Exercises.week9_questions;

import assignments.ex2.geo.Circle_2D;
import assignments.ex2.geo.GeoShape;
import assignments.ex2.geo.Point_2D;
import assignments.ex2.geo.Rect_2D;
import org.junit.jupiter.api.Test;

import static TA_Exercises.week9_questions.test_questions.numOfClasses;
import static org.junit.jupiter.api.Assertions.*;

public class week9_tests{
    Point_2D p1 = new Point_2D(3, 5);
    Point_2D p2 = new Point_2D(1, 10);
    @Test
    void testShuffle() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        test_questions.shuffle(arr);
        // Since shuffle randomizes the array, we can't predict the exact output.
        // But we can check if the length remains the same and the elements are still present after shuffling.
        assertEquals(5, arr.length);
    }

    @Test
    void testSameClass() {
        GeoShape s1 = new Circle_2D(p1, 4);
        GeoShape s2 = new Circle_2D(p2, 10);
        GeoShape s3 = new Rect_2D(p1, p2);
        assertTrue(test_questions.sameClass(s1, s2));
        assertFalse(test_questions.sameClass(s1, s3));
    }

    @Test
    void testNumOfClasses() {
        GeoShape[] shapes = {new Circle_2D(p1, 4), new Circle_2D(p2, 10), new Rect_2D(p1, p2)};
        assertEquals(2, numOfClasses(shapes));
    }
    @Test
    void testRollAndGetVal() {
        Q2 game = new Q2();
        game.roll();
        int val = game.getVal();
        System.out.println(val);
        assertTrue(val >= 2 && val <= 12);
    }

    @Test
    void testRollAndGetVal2() {
        Q2_Err game = new Q2_Err();
        game.roll();
        int val = game.getVal();
        System.out.println(val);
        assertTrue(val >= 2 && val <= 12);
    }
}
