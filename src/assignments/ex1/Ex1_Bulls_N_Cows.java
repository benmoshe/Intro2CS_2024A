package assignments.ex1;

/**
 * Ariel University, School of Computer Science, Intro2CS 2024A, Ex1
 * This interface represents the main actions (functionality) that the BULL-PGIAA game allows, see:
 * https://he.wikipedia.org/wiki/%D7%91%D7%95%D7%9C_%D7%A4%D7%92%D7%99%D7%A2%D7%94
 * Ex1 is defined here: https://docs.google.com/document/d/1C1BZmi_Qv6oRrL4T5oN9N2bBMFOHPzSI/edit?usp=sharing&ouid=113711744349547563645&rtpof=true&sd=true
 */

public interface Ex1_Bulls_N_Cows {
    /**
     * Starts a new B&P Game with your ID and a code with size digits [2-6]
     * @param id - the user ID (as a long natural number)
     * @param size - number of digits in the code [2-6] digits.
     * @return a String
     */
    public String startGame(long id, int size);

    /**
     * Play a round (with an array of digits)
     * @param guess an array of integers (array of digits).
     * @return an integer array of size 2: [0] Bulls, [1] Cows
     */
    public int[] play(int[] guess);
    public String getStatus();
   // public String endGame();
    public boolean isRunning();
    public int getNumOfDigits();
}
