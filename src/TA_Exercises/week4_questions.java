/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises for week 4.
 */
package TA_Exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class week4_questions {
    public static void main(String[] args) {
        // The main method tests the performance of three different implementations of the Catalan number calculation.
        int n = 5;  // Change this value to test with different inputs

        long startTime1 = System.nanoTime();
        recCatalan(n);
        long endTime1 = System.nanoTime();

        long startTime2 = System.nanoTime();
        Catalan(n);
        long endTime2 = System.nanoTime();

        long startTime3 = System.nanoTime();
        int Best = BetterCatalan(n);
        long endTime3 = System.nanoTime();


        long duration1 = (endTime1 - startTime1);  // Compute the elapsed time in nanoseconds
        long duration2 = (endTime2 - startTime2);
        long duration3 = (endTime3 - startTime3);

        System.out.println("The Catalan number for " + n + " is " + Best);
        System.out.println("Execution time in nanoseconds for the recursion function: " + duration1);
        System.out.println("Execution time in nanoseconds for the regular function: " + duration2);
        System.out.println("Execution time in nanoseconds for the Better function(Dynamic programming): " + duration3);
    }
    /**
     * This function checks if two strings are equal.
     * @param a The first string.
     * @param b The second string.
     * @return True if the strings are equal, false otherwise.
     */
    public static boolean isEqual(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    /**
     * This function checks if a string is symmetric.
     * @param str The input string.
     */
    public static boolean isSymmetric(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    /**
     * This function reverses a string.
     * @param str The input string.
     * @return The reversed string.
     */
    public static String reverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
    /**
     * This function counts the occurrences of the first character in a string.
     * @param str The input string.
     */
    public static int countFirstChar(String str) {
        if (str.isEmpty())
            return 0;
        char firstChar = str.charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == firstChar) {
                count++;
            }
        }
        return count;
    }
    /**
     * This function counts the number of words in a string.
     * @param str The input string.
     */
    public static int howManyWords(String str) {
        if (str.isEmpty())
            return 0;
        String[] words = str.split(" ");
        return words.length;
    }
    /**
     * This function sorts the characters in a string in ascending order.
     * @param str The input string.
     * @return A new string that contains the sorted characters of the input string.
     */
    public static String sort(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (chars[j] > chars[j+1]) {
                    // Swap chars[j+1] and chars[j]
                    char temp = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = temp;
                }
            }
        }
        return new String(chars);
    }
//   // Option 2
//    public static String sort(String str) {
//        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
//        return new String(chars);
//    }
    /**
     * This function finds the biggest digit in a number.
     * @param num The input number.
     * @return The biggest digit in the number.
     */
    public static int biggestDigit(int num) {
        int max = 0;
        while (num != 0) {
            int digit = num % 10;
            max = Math.max(max, digit);
            num /= 10;
        }
        return max;
    }
    /**
     * This function calculates the factorial of a number.
     * @param n The input number.
     * @return The factorial of the number.
     */
    public static int atzeret(int n) {
        if (n == 0) {
            return 1;
        }
        return n * atzeret(n - 1);

    }
    /**
     * This function calculates the sum of all numbers from 1 to n.
     * @param n The input number.
     * @return The sum of all numbers from 1 to n.
     */
    public static int sum(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sum(n - 1);
        }
    }
    /**
     * This function prints a line of stars of a given length.
     * @param num The length of the line.
     */
    public static void starLine(int num) {
        if (num == 0) {
            return;
        }
        System.out.print("*");
        starLine(num - 1);
    }
    /**
     * This function prints a right-angled triangle of stars of a given height.
     * @param num The height of the triangle.
     */
    public static void starTriangle(int num) {
        if (num == 0) {
            return;
        }
        starLine(num);
        System.out.println();
        starTriangle(num - 1);
    }
    /**
     * This function calculates the nth Fibonacci number.
     * @param n The position of the Fibonacci number in the sequence.
     * @return The nth Fibonacci number.
     */
    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
    /**
     * This function calculates the nth Catalan number using recursion.
     * @param n The position of the Catalan number in the sequence.
     * @return The nth Catalan number.
     */
    public static int recCatalan(int n) {
        if (n <= 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += recCatalan(i) * recCatalan(n - i - 1);
        }
        return res;
    }
    /**
     * This function calculates the nth Catalan number using the factorial formula.
     * @param n The position of the Catalan number in the sequence.
     * @return The nth Catalan number.
     */
    public static int Catalan(int n){
        return (atzeret(2*n)/(atzeret(n)*atzeret(n)*(n+1)));
    }
    /**
     * This function calculates the nth Catalan number using dynamic programming.
     * @param n The position of the Catalan number in the sequence.
     * @return The nth Catalan number.
     */
    public static int BetterCatalan(int n) {
        int[] catalan = new int[n + 2];
        catalan[0] = 1;
        catalan[1] = 1;

        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] = catalan[i] + (catalan[j] * (catalan[i-j-1]));
            }
        }

        return catalan[n];
    }
    /**
     * This function finds all prime numbers up to n.
     * @param n The upper limit for the prime numbers.
     * @return An ArrayList of all prime numbers up to n.
     */
    public static ArrayList<Integer> primes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
    @Test
    public void testIsEqual() {
        assertTrue(isEqual("hello", "hello"));
        assertFalse(isEqual("hello", "world"));
        assertFalse(isEqual("hello", "HELLO"));
        assertTrue(isEqual("", ""));
    }

    @Test
    public void testIsSymmetric() {
        assertTrue(isSymmetric("radar"));
        assertFalse(isSymmetric("hello"));
        assertTrue(isSymmetric("helloolleh"));
        assertFalse(isSymmetric("A man a plan a canal Panama"));
        assertFalse(isSymmetric("A man a plan a canal Panama."));
    }

    @Test
    public void testReverse() {
        assertEquals("olleh", reverse("hello"));
        assertEquals("dlrow", reverse("world"));
        assertEquals("", reverse(""));
        assertEquals("Able was I ere I saw Elba", reverse("ablE was I ere I saw elbA"));
    }

    @Test
    public void testCountFirstChar() {
        assertEquals(1, countFirstChar("hello"));
        assertEquals(2, countFirstChar("worldwide"));
        assertEquals(0, countFirstChar("")); // think what should you do to fix this
        assertEquals(1, countFirstChar("Able was I ere I saw Elba"));
        assertEquals(4, countFirstChar("able was I ere I saw Elba"));
    }

    @Test
    public void testHowManyWords() {
        assertEquals(1, howManyWords("hello"));
        assertEquals(2, howManyWords("hello world"));
        assertEquals(0, howManyWords(""));
        assertEquals(7, howManyWords("Able was I ere I saw Elba"));
    }

    @Test
    public void testSort() {
        assertEquals("ehllo", sort("hello"));
        assertEquals("dlorw", sort("world"));
        assertEquals("", sort(""));
        assertEquals("      AEIIaaabbeeellrssww", sort("Able was I ere I saw Elba"));
    }

    @Test
    public void testBiggestDigit() {
        assertEquals(9, biggestDigit(123456789));
        assertEquals(5, biggestDigit(54321));
        assertEquals(0, biggestDigit(0));
        assertEquals(8, biggestDigit(87654321));
    }

    @Test
    public void testAtzeret() {
        assertEquals(120, atzeret(5));
        assertEquals(720, atzeret(6));
        assertEquals(1, atzeret(0));
        assertEquals(5040, atzeret(7));
    }

    @Test
    public void testSum() {
        assertEquals(15, sum(5));
        assertEquals(21, sum(6));
        assertEquals(0, sum(0));
        assertEquals(28, sum(7));
    }
    @Test
    public void testFib() {
        assertEquals(1, fib(1));
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));
        assertEquals(3, fib(4));
        assertEquals(5, fib(5));
    }

    @Test
    public void testRecCatalan() {
        assertEquals(1, recCatalan(0));
        assertEquals(1, recCatalan(1));
        assertEquals(2, recCatalan(2));
        assertEquals(5, recCatalan(3));
        assertEquals(14, recCatalan(4));
    }

    @Test
    public void testCatalan() {
        assertEquals(1, Catalan(0));
        assertEquals(1, Catalan(1));
        assertEquals(2, Catalan(2));
        assertEquals(5, Catalan(3));
        assertEquals(14, Catalan(4));
    }

    @Test
    public void testBetterCatalan() {
        assertEquals(1, BetterCatalan(0));
        assertEquals(1, BetterCatalan(1));
        assertEquals(2, BetterCatalan(2));
        assertEquals(5, BetterCatalan(3));
        assertEquals(14, BetterCatalan(4));
    }

    @Test
    public void testPrimes() {
        assertEquals(Arrays.asList(2, 3, 5, 7), primes(10));
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29), primes(30));
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97), primes(100));
    }






    @Test
    public void check(){
        assertTrue(isSymmetric("radar"));
        assertFalse(isSymmetric("2234324"));
    }
}

