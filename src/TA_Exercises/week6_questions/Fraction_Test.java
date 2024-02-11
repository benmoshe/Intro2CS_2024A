package TA_Exercises.week6_questions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Fraction_Test {
    @Test
    public void testFraction() {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(3, 4);
        assertEquals("1/2", new Fraction(3, 6).toString());
        assertEquals("3/2", fraction1.plus(fraction2).toString());
        assertEquals("0/1", fraction1.minus(fraction2).toString());
        assertEquals("9/16", fraction1.mul(fraction2).toString());
        assertEquals("1/1", fraction1.div(fraction2).toString());
    }
}

