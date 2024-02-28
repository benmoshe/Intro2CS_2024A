/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises for week 4.
 */
package TA_Exercises.week9_questions;

import java.util.Random;

public class Q2 implements Game {
    private int cubic1 = 0;
    private int cubic2 = 0;

    public Q2() {
        this.roll();
    }

    /**
     * Roll the dice and set the value of the last roll.
     */
    @Override
    public void roll() {
        Random rand = new Random();
        cubic1 = rand.nextInt(6) + 1; // Generates a random number between 1 and 6 for the first cubic
        cubic2 = rand.nextInt(6) + 1; // Generates a random number between 1 and 6 for the second cubic
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
