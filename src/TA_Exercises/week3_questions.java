/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises from week 3.
 */
package TA_Exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class week3_questions {
    public static void main(String[] args) {
//        String[][] arr = {
//                {"Silly", "Mango", "Art"},
//                {"Rabbit", "Tiger"}
//        };
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j].charAt(0));
//            }
//        }
        int[] arr = {100, 200, -50, 30, 2, 10};
        reverse(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * This function calculates the sum of all elements in an array.
     *
     * @param arr The input array.
     * @return The sum of all elements in the array.
     */
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    /**
     * This function calculates the mean of all elements in an array.
     *
     * @param arr The input array.
     * @return The mean of all elements in the array.
     */
    public static double arrayMean(int[] arr) {
        return (double) arraySum(arr) / (arr.length);
    }

    /**
     * This function reverses the order of elements in an array.
     *
     * @param arr The input array.
     */
    public static void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    /*
    // another way to write the reverse function
    public static void reverse(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
     */

    /**
     * This function calculates the sum of all elements in a 2D array.
     *
     * @param array The input 2D array.
     * @return The sum of all elements in the 2D array.
     */
    public static int sum(int[][] array) {
        int total = 0;
        for (int[] row : array) {
            for (int element : row) {
                total += element;
            }
        }
        return total;
    }

    /**
     * This function transposes a 2D array.
     *
     * @param array The input 2D array.
     * @return The transposed 2D array.
     */
    public static int[][] transpose(int[][] array) {
        int[][] result = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[j][i] = array[i][j];
            }
        }
        return result;
    }

    /**
     * This function sorts an array such that all even numbers come before all odd numbers.
     *
     * @param arr The input array.
     */
    public static void evenOddSort(int[] arr) {
        int i = -1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] % 2 == 0) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    /**
     * This function tests the arraySum function.
     */
    @Test
    public void testArraySum() {
        int[] arr = {1, 2, 3, 4, 5};
        int expectedSum = 15;
        int[] arr2 = {-1, 2, -3, 4, -5};
        int expectedSum2 = -3;
        Assertions.assertEquals(expectedSum2, arraySum(arr2));
        Assertions.assertEquals(expectedSum, arraySum(arr));
    }

    /**
     * This function tests the arrayMean function.
     */
    @Test
    public void testArrayMean() {
        int[] arr = {1, 2, 3, 4, 5};
        double expectedMean = 3.0;
        int[] arr2 = {-1, 2, -3, 4, -5};
        double expectedMean2 = -0.6;
        Assertions.assertEquals(expectedMean2, week3_questions.arrayMean(arr2), 0.0001);
        Assertions.assertEquals(expectedMean, week3_questions.arrayMean(arr), 0.0001);
    }

    /**
     * This function tests the evenOddSort function.
     */
    @Test
    public void testEvenOddSort() {
        int[] arr = {1, 2, 3, 4, 5};
        evenOddSort(arr);
        int[] expectedArr = {2, 4, 3, 1, 5}; // Expected output after sorting
        Assertions.assertArrayEquals(expectedArr, arr);
    }
}
