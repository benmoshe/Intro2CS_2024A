package assignments.ex1.solution;
import assignments.ex1.BP_Server;

import java.util.Scanner;
/**
 * Introduction to Computer Science, Ariel University, Ex1 (manual Example + a Template for your solution)
 * See: https://docs.google.com/document/d/1C1BZmi_Qv6oRrL4T5oN9N2bBMFOHPzSI/edit?usp=sharing&ouid=113711744349547563645&rtpof=true&sd=true
 *
 * Ex1 Bulls & Cows - Automatic solution.
 * **** Add a general readme text here ****
 * Add your explanation here:
 * The general Bulls & Cows Solution is define as follows:
 * 1. in
 *
 *
 * **** General Solution (algorithm) ****
 * Add your explanation here:
 *
 *
 *
 * **** Results ****
 * Make sure to state the average required guesses
 * for 2,3,4,5,6 digit code:
 *
 * Average required guesses 2: 5.69
 * Average required guesses 3: 5.81
 * Average required guesses 4: 6.45
 * Average required guesses 5: 6.91
 * Average required guesses 6: 7.03
 Average all: 6.378
 */
public class Ex1 {
    public static final String Title = "Ex1 demo: manual Bulls & Cows game";
    public static void main(String[] args) {
        BP_Server game = new BP_Server();   // Starting the "game-server"
        long myID = 123456789L;             // Your ID should be written here
        int numOfDigits = 6;                // Number of digits [2,6]
        game.startGame(myID, numOfDigits);  // Starting a game
        System.out.println(Title+" with code of "+numOfDigits+" digits");
       // manualEx1Game(game);
        autoEx1Game(game); // you should implement this function )and any additional required functions).
    }
    public static void manualEx1Game(BP_Server game) {
        Scanner sc = new Scanner(System.in);
        int ind=1;      // Index of the guess
        int numOfDigits = game.getNumOfDigits();
        double max = Math.pow(10,numOfDigits);
        while(game.isRunning()) {           // While the game is running (the code has not been found yet
            System.out.println(ind+") enter a guess: ");
            int g = sc.nextInt();
            if(g>=0 && g<max) {
                int[] guess = toArray(g, numOfDigits); // int to digit array
                int[] res = game.play(guess); // Playing a round and getting the B,C
                if (game.isRunning()) {     // While the game is running
                    System.out.println(ind + ") B: " + res[0] + ",  C: " + res[1]); // Prints the Bulls [0], and the Cows [1]
                    ind += 1;               // Increasing the index
                }
            }
            else {
                System.out.println("ERR: wrong input, try again");
            }
        }
        System.out.println(game.getStatus());
    }


    /**
     * Simple parsing function that gets an int and returns an array of digits
     * @param a - a natural number (as a guess)
     * @param size  - number of digits (to handle the 00 case).
     * @return an array of digits
     */
    private static int[] toArray(int a, int size){
        int[] c = new int[size];
        for(int j=0;j<c.length;j+=1) {
            c[j] = a%10;
            a=a/10;
        }
        return c;
    }
/////////////////////////////// Rx1 Suggested solution starts here/////////////////////
    /**
     * This function solves the Bulls & Cows game automatically.
     * You should implement
     * **** Add a specific explanation for each function ****
     *
     */
    public static void autoEx1Game(BP_Server game) {
        int ind=0;      // Index of the guess
        int numOfDigits = game.getNumOfDigits();    // gets the number of digits in the code
        initData(numOfDigits);                      // init the 2D array in ints representing all possible guesses
        while(game.isRunning()) {                   // While the game is running (the code has not been found yet
            int[] guess = nextGeuss(numOfDigits);   // This is the main algorithm!
            int[] res = game.play(guess);           // Playing a round and getting the B,C
            play(guess,res);
            ind += 1;               // Increasing the index
        }
        if(debugFlag) {System.out.println(game.getStatus());}
    }
    ////////////////////////////////////////////////////////////////////
    private static boolean[] _options;    // private static data member representing all possible codes/
    public static boolean debugFlag = false;
    /**
     * Compute the next guess based on the last guess and its related results bulls & cows).
     * @param guess - the lase guess
     * @param res - the Bulls & Cows results of the last guess.
     * @return - an index of the next valid guess.
     */
    public static void play(int[] guess, int[] res) {
        eliminate(_options, guess, res[0], res[1]);
    }

    /**
     * Init the all option array (2D) to represent all the options of guess with the given length.
     * @param size - the length of the code.
     */
    public static void initData(int size) {
        _options = allOptions(size);
    }
    public static int[] nextGeuss(int size) {
        int a = randomIndex();
        int[] ans = toArray(a, size);
        return ans;
    }
//////////////////////////////////////////////////////
    private static void eliminate(boolean[] all, int[] guess, int b, int c) {
        int ans = -1, cc=0;
        int len = guess.length;
        for(int i=0;i<all.length;i=i+1) {
            int[] curr =toArray(i, len);
            if(curr!=null) {
                int[] bc = testBullsNCows(curr, guess);
                if(bc[0]!=b || bc[1]!=c) {
                    all[i]=false;
                }
                else {cc+=1;}
            }
        }
        if(b<guess.length) {
            int ind = 0;
            for(int i=guess.length-1; i>=0;i=i-1) {
                ind=ind*10;
                ind=ind+guess[i];
            }
            all[ind]=false;// ind is not the solution
        }
    }
    private static boolean[] allOptions(int size) {
        int dim = (int)(Math.pow(10,size));
        boolean[] ans = new boolean[dim];
        for(int i=0;i<ans.length;i=i+1) {
            ans[i] = true;
        }
        return ans;
    }
    private static int randomIndex() {
        int ans = -1, count=0;
        int len = _options.length;
        int ind = (int)(Math.random()*len);
        while(ans==-1 && count<len/2) {
            int i1 = ind+count;
            int i2 = ind-count;
            if(i1>=len) {i1=(ind+count)%len;}
            if(i2<0) {i2=len+(ind-count);}
            if(_options[i1]) {ans=i1;}
            if(ans==-1 && _options[i2]) {ans=i2;}
            count+=1;
        }
        return ans;
    }

    /**
     * This is the main low-level logic function for computing the number of Bulls and Cows between two int-arrays:
     * Here is the main logoc:
     * 1. The function assumes the two arraya:
     * 1.1 are not null.
     * 1.2 have the same length
     *
     * 2. The algorithm is doing the folliwing:
     * 2.1 Allocates two int-arrays with the same length as the input arrays (say a1, b1)
     * 2.2 The algorithm first search all the Bulls (and mak each Bull index both in a1 and b1.
     * 2.3 The algorithm traverce any pair between a and b it is not marked (not a Bull or a Cow) ant it has
     * the same value (in a,b) it counts it is a "Cow" and mark the correponding indexes in a1, b1/
     * 2.4 The number of Bulls and Cows is returned as an int array (Bulls [0], Cows[1]).
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] testBullsNCows(int[] a, int[] b) {
        int[] ans = new int[2];
        int len = a.length;
        int[] a1 = new int[len];
        int[] b1 = new int[len];
        // counting the Bulls (when ever a pair is found it is marked).
        for(int i=0;i<len;i++) {
            if (a[i] == b[i]) {
                a1[i] = 1;
                b1[i] = 1;
                ans[0] += 1;
            }
        }
        // counting the Cows (when ever a pair is found it is marked).
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j=j+1) {
                if(b1[j]==0 && a1[i]==0 && a[i]==b[j]) {
                    b1[j]=2;
                    a1[i]=2;
                    ans[1]+=1;
                }
            }
        }
        return ans;
    }
    /**
     *  b_p({1,2,3}, {1,3,4}) --> {1,1}
     *  *     b_p({9,9,9,9}, {9,7,1,9} --> {2,0}
     *  *     b_p(2,2,3,8}, {4,7,2,9} --> {0,1}
     *  *     b_p({4,7,2,9} ,{2,2,3,8} --> {0,1}
     *

    public static int[] b_p(int[] c1, int[] g1) {
        int[] c = new int[c1.length], g = new int[c1.length];
        for(int i=0;i<c1.length;i=i+1) {
            c[i] = c1[i];
            g[i] = g1[i];
        }
        int[] ans = new int[2];
        for(int i=0;i<c.length;i=i+1) {
            if(g[i] == c[i]) {
                ans[0] +=1;
                g[i] =-1;
                c[i]=-2;
            }
        }
        /////////// Pgiaa ////////////
        for(int i=0;i<c.length;i=i+1) {
            int ind = foundInd(g, c[i]);
            if(ind>=0) {
                c[i] = -5;
                g[ind] = -6;
                ans[1] +=1;
            }
        }
        return ans;
    }*/
    private static int foundInd(int[] g, int v) {
        int ans = -1;
        for(int i=0;i<g.length && ans==-1;i=i+1) {
            if(g[i] == v) {
                ans = i;
            }
        }
        return ans;
    }
    private static String toString(int[] arr){
        String ans = "";
        for(int j=0;j<arr.length-1;j+=1) {
            ans+=arr[j]+",";
        }
        ans+=arr[arr.length-1];
        return ans;
    }
}
