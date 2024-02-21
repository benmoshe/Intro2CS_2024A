package TA_Exercises.week8_questions;

import java.util.ArrayList;
import java.util.Arrays;

public class F2 implements Parabula {
    private double a, b, c;

    public F2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Evaluates the parabula at a given x-coordinate.
     *
     * @param x The x-coordinate.
     * @return The y-coordinate corresponding to the given x-coordinate.
     */
    @Override
    public double f(double x) {
        return a * Math.pow(x, 2) + b * x + c;
    }
    /**
     * Adds the coefficients of this parabula and another parabula.
     *
     * @param p The other parabula.
     * @return A new parabula that is the sum of this parabula and the other parabula.
     */
    @Override
    public Parabula add(Parabula p) {
        double[] coeffs = p.get();
        return new F2(coeffs[0] + a, coeffs[1] + b, coeffs[2] + c);
    }
    /**
     * Gets the coefficients of this parabula.
     *
     * @return An array containing the coefficients of this parabula.
     */
    @Override
    public double[] get() {
        return new double[]{a, b, c};
    }
    /**
     * Calculates the extreme point of this parabula.
     *
     * @param p The parabula.
     * @return The x-coordinate of the extreme point of this parabula.
     * @throws ArithmeticException If the coefficient a is zero.
     */
    @Override
    public double extream(Parabula p) throws ArithmeticException{
        if (a == 0) {
            throw new ArithmeticException("a is zero so, you can't divide by zero");
        }
        return (-b / (2 * a));
    }
    /**
     * Calculates the number of real roots of a parabula.
     *
     * @param p The parabula.
     * @return The number of real roots of the parabula.
     */
    public static int numberOfRealRoots(Parabula p){
        double [] coeffs = p.get();
        double a = coeffs[0];
        double b = coeffs[1];
        double c = coeffs[2];
        double discriminant = Math.pow(b, 2) - 4*a*c;
        if (discriminant > 0){
            return 2;
        } else if (discriminant == 0) {
            return 1;
        }
        else
            return 0;
    }
    /**
     * Sorts an ArrayList of parabulas in ascending order of their extreme points.
     *
     * @param a The ArrayList of parabulas.
     */
    public static void sort(ArrayList<Parabula> a) {
        int n = a.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (a.get(j).extream(a.get(j)) > a.get(j+1).extream(a.get(j+1))) {
                    // Swap a[j+1] and a[i]
                    Parabula temp = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, temp);
                }
            }
        }
    }
    @Override
    public String toString() {
        return "Parabula{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }


    public static void main(String[] args) {
        F2 poly1 = new F2(2, 4, 4);
        F2 poly2 = new F2(5, 6, 10);
        double extream = poly1.extream(poly1);
        Parabula add_poly = poly1.add(poly2);
        System.out.println(Arrays.toString(add_poly.get()));
        System.out.println(extream);
    }

}
