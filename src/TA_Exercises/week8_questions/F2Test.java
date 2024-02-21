package TA_Exercises.week8_questions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static TA_Exercises.week8_questions.Main.isPer;
import static org.junit.jupiter.api.Assertions.*;

public class F2Test {
    @Test
    public void testF() {
        F2 poly = new F2(2, 3, 4);
        assertEquals(9, poly.f(1), "The function should return the correct value.");
    }

    @Test
    public void testAdd() {
        F2 poly1 = new F2(2, 3, 4);
        F2 poly2 = new F2(5, 6, 7);
        Parabula result = poly1.add(poly2);
        assertArrayEquals(new double[]{7, 9, 11}, result.get(), "The add method should return the correct parabula.");
    }

    @Test
    public void testGet() {
        F2 poly = new F2(2, 3, 4);
        assertArrayEquals(new double[]{2, 3, 4}, poly.get(), "The get method should return the correct coefficients.");
    }

    @Test
    public void testExtream() {
        F2 poly = new F2(2, 3, 4);
        assertEquals(-0.75, poly.extream(poly), "The extream method should return the correct value.");
    }

    @Test
    public void testNumberOfRealRoots() {
        F2 poly1 = new F2(1, -3, 2);  // Two real roots
        F2 poly2 = new F2(1, -2, 1);  // One real root
        F2 poly3 = new F2(1, 0, 1);   // No real roots
        assertEquals(2, F2.numberOfRealRoots(poly1), "The numberOfRealRoots method should return the correct number of real roots.");
        assertEquals(1, F2.numberOfRealRoots(poly2), "The numberOfRealRoots method should return the correct number of real roots.");
        assertEquals(0, F2.numberOfRealRoots(poly3), "The numberOfRealRoots method should return the correct number of real roots.");
    }

    @Test
    public void testSort() {
        ArrayList<Parabula> list = new ArrayList<>();
        F2 poly1 = new F2(4, 2, 4);
        F2 poly2 = new F2(5, 10, 7);
        list.add(poly1);
        list.add(poly2);
        F2.sort(list);
        assertEquals(poly2, list.get(0), "The sort method should correctly sort the list of parabulas.");
        assertEquals(poly1, list.get(1), "The sort method should correctly sort the list of parabulas.");
    }

    @Test
    public void testIsPer() {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        assertTrue(isPer(words, "cherry banana apple"), "The isPer method should return true when the line is a permutation of the words.");
        assertFalse(isPer(words, "apple banana"), "The isPer method should return false when the line is not a permutation of the words.");
    }
}
