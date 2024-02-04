package assignments.ex1.solution;
import assignments.ex1.BP_Server;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a JUnit class to test the main logic (functionality) of Ex1 (the Bulls & Cows game).
 */
class Ex1Test {

    @Test
    void main() {
        long start = System.currentTimeMillis();
        Ex1.main(null);
        long end = System.currentTimeMillis();
        double dt = (end-start)/1000.0;
        boolean fastEnough = dt<1;
        assertTrue(fastEnough);
    }

    /** This is the main performance testing JUnit function,
     * It runs the game 100 times for each code size [2-6],
     * The average number of guesses requires for each code size
     * is define as following:
     * code of 2 digits: less than 6 guesses (on average).
     * code of 3 digits: less than 6.5 guesses (on average).
     * code of 4 digits: less than 7 guesses (on average).
     * code of 5 digits: less than 7.5 guesses (on average).
     * code of 6 digits: less than 8 guesses (on average).
     *
     * Tested:
     * 2) 5.92
     * 3) 6.09
     * 4) 6.54
     * 5) 6.49
     * 6) 7.31
     */
    @Test
    void autoEx1Game() {
        double[] max = {0,0,6,6.5,7,7.5,8};
        double sumAll = 0;
        int count = 0;
        int size =100;
        double[] sum = new double[7];
        for(int i=0;i<size;i=i+1) {
            for(int j=2;j<7;j=j+1) {
                int v = playOnce(j);;
                sum[j]+= v;
                sumAll += v;
                count +=1;
            }
        }
        for(int j=2;j<7;j=j+1) {
            sum[j]/= size;
            System.out.println(j+") "+sum[j]);
            boolean a2 = sum[j]<max[j];
            assertTrue(a2);
        }
        System.out.println("Average all: "+(sumAll/count));
    }

    /**
     * This is the main lowlevel logec tester for the Bulls & Cows computation between two int arrays
     */
    @Test
    void testBullsNCows() {
        int[] g1111 = {1,1,1,1};
        int[] g2222 = {2,2,2,2};
        int[] g1234 = {1,2,3,4};
        int[] g4321 = {4,3,2,1};
        int[] g1231 = {1,2,3,1};
        int[] g2110 = {2,1,1,1};

        int[] a = Ex1.testBullsNCows(g1111,g1111);
        assertEquals(a[0],g1111.length);
        assertEquals(a[1],0);

        a = Ex1.testBullsNCows(g1111,g2222);
        assertEquals(a[0],0);
        assertEquals(a[1],0);

        a = Ex1.testBullsNCows(g1111,g1234);
        assertEquals(a[0],1);
        assertEquals(a[1],0);

        a = Ex1.testBullsNCows(g1231,g2110);
        assertEquals(a[0],1);
        assertEquals(a[1],2);
    }

    /**
     * Testing the fine details of the "cows"
     */
    @Test
    void testBullsNCows2() {
        int[] g123 = {1,2,3};
        int[] g134 = {1,3,4};
        int[] g1123 = {1,1,2,3};
        int[] g4516 = {4,5,1,6};

        int[] a = Ex1.testBullsNCows(g123,g134);
        int[] a1 = Ex1.testBullsNCows(g134,g123);
        assertEquals(a[0],1);
        assertEquals(a[1],1);
        assertEquals(a[0],a1[0]);
        assertEquals(a[1],a1[1]);

        a = Ex1.testBullsNCows(g1123,g4516);
        a1 = Ex1.testBullsNCows(g4516,g1123);
        assertEquals(a[0],0);
        assertEquals(a[1],1);
        assertEquals(a[0],a1[0]);
        assertEquals(a[1],a1[1]);
    }
    /**
     * This function is NOT a JUnit tester, but a helper testing method - that
     * runs the game once and return the number of guesses needed for finding the code.
     * @param numOfDigits - the number of digits in the code.
     * @return
     */
    private static int playOnce(int numOfDigits) {
        BP_Server game = new BP_Server();   // Starting the "game-server"
        long myID = 123456789L;             // Your ID should be written here
        game.startGame(myID, numOfDigits);
        Ex1.autoEx1Game(game);
        String sen = game.getStatus();
        String[] words = sen.split(" ");
        int res_ind = words.length-10;
        int ans = Integer.parseInt(words[res_ind]);
        return ans;
    }
}