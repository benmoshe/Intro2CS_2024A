/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises from week 6.
 */
package TA_Exercises.week6_questions;

/**
 * This class represents an interval on the number line.
 */
public class Interval {
    private double _left;
    private double _right;

    /**
     * Constructs a new Interval.
     *
     * @param x The left endpoint of the interval.
     * @param y The right endpoint of the interval.
     */
    public Interval(double x, double y) {
        this._left = Math.min(x, y);
        this._right = Math.max(x, y);
    }

    /**
     * Checks if a number is contained within this interval.
     *
     * @param x The number to check.
     * @return true if x is within this interval, false otherwise.
     */
    public boolean contains(double x) {
        return x >= _left && x <= _right;
    }

    /**
     * Checks if this interval intersects with another interval.
     *
     * @param b The other interval.
     * @return true if this interval intersects with b, false otherwise.
     */
    public boolean intersection(Interval b) {
        return this._left <= b._right && this._right >= b._left;
    }

    @Override
    public String toString() {
        return "[" + _left + ", " + _right + "]";
    }

    /**
     * Calculates the distance between the midpoints of this interval and another interval.
     *
     * @param b The other interval.
     * @return The distance between the midpoints of this interval and b.
     */
    public double distBetweenMidPoints(Interval b) {
        double mid1 = (_left + _right) / 2;
        double mid2 = (b._left + b._right) / 2;
        return Math.abs(mid1 - mid2);
    }


    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 5);
        Interval interval2 = new Interval(4, 6);
        System.out.println("Interval 1: " + interval1);
        System.out.println("Interval 2: " + interval2);
        System.out.println("Does interval 1 contain 3? " + interval1.contains(3));
        System.out.println("Do interval 1 and interval 2 intersect? " + interval1.intersection(interval2));
        System.out.println("Distance between midpoints: " + interval1.distBetweenMidPoints(interval2));
    }
}

