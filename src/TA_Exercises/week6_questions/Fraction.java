/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises from week 6.
 */
package TA_Exercises.week6_questions;

/**
 * This class represents a fraction with a nominator and a denominator.
 */
public class Fraction {
    private int _nominator;
    private int _denominator;

    /**
     * Constructs a new Fraction with nominator 0 and denominator 1.
     */
    public Fraction() {
        this._nominator = 0;
        this._denominator = 1;
    }

    /**
     * Constructs a new Fraction.
     *
     * @param nominator   The nominator of the fraction.
     * @param denominator The denominator of the fraction.
     */
    public Fraction(int nominator, int denominator) {
        this._nominator = nominator;
        this._denominator = denominator;
        simplify(); // to simplify the fraction to the base fraction as required
    }

    /**
     * Constructs a new Fraction that is a copy of another Fraction.
     *
     * @param other The Fraction to copy.
     */
    public Fraction(Fraction other) {
        this._nominator = other._nominator;
        this._denominator = other._denominator;
    }

    /**
     * Calculates the greatest common divisor (gcd) of two integers.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The gcd of a and b.
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Simplifies the fraction by dividing the nominator and denominator by their gcd.
     */
    private void simplify() {
        int gcd = gcd(_nominator, _denominator);
        _nominator /= gcd;
        _denominator /= gcd;
    }

    /**
     * Adds this fraction to another fraction.
     *
     * @param f The other fraction.
     * @return A new Fraction that is the sum of this fraction and f.
     */
    public Fraction plus(Fraction f) {
        int nominator = _nominator * f._denominator + f._nominator * _denominator;
        int denominator = _denominator * f._denominator;
        return new Fraction(nominator, denominator);
    }

    /**
     * Subtracts another fraction from this fraction.
     *
     * @param f The other fraction.
     * @return A new Fraction that is the difference of this fraction and f.
     */
    public Fraction minus(Fraction f) {
        int nominator = _nominator * f._denominator - f._nominator * _denominator;
        int denominator = _denominator * f._denominator;
        return new Fraction(nominator, denominator);
    }

    /**
     * Multiplies this fraction by another fraction.
     *
     * @param f The other fraction.
     * @return A new Fraction that is the product of this fraction and f.
     */
    public Fraction mul(Fraction f) {
        int nominator = _nominator * f._nominator;
        int denominator = _denominator * f._denominator;
        return new Fraction(nominator, denominator);
    }

    /**
     * Divides this fraction by another fraction.
     *
     * @param f The other fraction.
     * @return A new Fraction that is the quotient of this fraction and f.
     */
    public Fraction div(Fraction f) {
        int nominator = _nominator * f._denominator;
        int denominator = _denominator * f._nominator;
        return new Fraction(nominator, denominator);
    }


    @Override
    public String toString() {
        return _nominator + "/" + _denominator;
    }
}
