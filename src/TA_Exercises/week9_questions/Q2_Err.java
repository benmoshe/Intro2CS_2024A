/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises for week 4.
 */
package TA_Exercises.week9_questions;

import java.util.Random;

public class Q2_Err implements Game {
    private int cubic1 = 0;
    private int cubic2 = 0;
    public Q2_Err() {
        this.roll();
    }
    /**
     * Roll the dice and set the value of the last roll.
     */
    @Override
    public void roll() {
        Random rand = new Random();
        cubic1 = biasedRoll(rand);
        cubic2 = biasedRoll(rand);
    }

    /**
     * Returns a biased roll of a cubic.
     * @param rand The random number generator to use.
     * @return the larger of two random numbers between 1 and 6.
     */
    private int biasedRoll(Random rand) {
        // Generate two random numbers between 1 and 6
        int num1 = rand.nextInt(6) + 1;
        int num2 = rand.nextInt(6) + 1;

        // Return the larger of the two numbers
        return Math.max(num1, num2);
    }
    /**
     * @return the sum of the two cubics.
     */
    @Override
    public int getVal() {
        if (cubic1 == 0 || cubic2 == 0) {
            return 0;
        }
        return cubic1 + cubic2; // it's a little bit unclear what the question is asking for, but I assume it's the sum of the two cubics.
    }
}

