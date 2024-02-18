package TA_Exercises.week7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    @Test
    public void testFractionConstructorInvalidGCD() {
        // This should throw an exception because the gcd is not 1
        assertThrows(RuntimeException.class, () -> {
            Fraction fraction = new Fraction(2, 0);
        });
    }

    @Test
    public void testFractionConstructorValidGCD() {
        // This should not throw an exception
        Fraction fraction = new Fraction(3, 4);
        assertEquals("3/4", fraction.toString());
    }

    @Test
    public void testFractionArithmeticOperations() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);

        // Test addition
        Fraction result = fraction1.plus(fraction2);
        assertEquals("5/6", result.toString());

        // Test subtraction
        result = fraction1.minus(fraction2);
        assertEquals("1/6", result.toString());

        // Test multiplication
        result = fraction1.mul(fraction2);
        assertEquals("1/6", result.toString());

        // Test division
        result = fraction1.div(fraction2);
        assertEquals("3/2", result.toString());
    }
}
