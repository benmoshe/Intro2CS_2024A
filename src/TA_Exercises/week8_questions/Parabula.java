package TA_Exercises.week8_questions;


public interface Parabula {
    double f(double x); // computes the value of this Parabula at x.

    Parabula add(Parabula p); // computes a new Parabula = p + “this”.

    double[] get(); // returns an array of doubles {a,b,c}: ax^2+bx+c=0;

    double extream(Parabula p); //returns the x value of the extrema point (min or max), if none throws an Exception.
}
