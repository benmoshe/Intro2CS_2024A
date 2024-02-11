/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises from week 5.
 */
package TA_Exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class week5_questions {
    /**
     * Q.1
     * Checks if an array is sorted in ascending order.
     *
     * @param arr The array to check.
     * @return True if the array is sorted, false otherwise.
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Q.2
     * Checks if all rows in a matrix are sorted in ascending order using for each.
     *
     * @param mat The matrix to check.
     * @return True if all rows are sorted, false otherwise.
     */
    public static boolean rowsSorted(int[][] mat) {
        for (int[] row : mat) {
            if (!isSorted(row)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Q.2 Version 2
     * Checks if all rows in a matrix are sorted in ascending order using regular for.
     *
     * @param mat The matrix to check.
     * @return True if all rows are sorted, false otherwise.
     */
    public static boolean rowsSorted2(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (!isSorted(mat[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Q.3
     * Returns the greatest common divisor (GCD) of two numbers.
     *
     * @param p The first number.
     * @param q The second number.
     * @return The GCD of p and q.
     */
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        // Think what will happen if I switch between p and q e.g. instead of sending gdc(3, 2) I send gcd(2, 3)
        return gcd(q, p % q);
    }

    /**
     * Q.4
     * Merges two sorted arrays into one sorted array.
     *
     * @param arr1 The first sorted array.
     * @param arr2 The second sorted array.
     * @return The merged sorted array.
     */
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        // run on the two arrays(stop when the small one reached to the end)
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k] = arr1[i]; //this line and the one below can be replaced by this: merged[k++] = arr1[i++];
                i++;
            } else {
                merged[k] = arr2[j]; // merged[k++] = arr2[j++];
                j++;
            }
            k++;
        }
        // maybe arr2 reached to the end before arr1, so we run only on arr1
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        // maybe arr1 reached to the end before arr2, so we run only on arr2
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }
        return merged;
    }

    /**
     * Q.5
     * Rounds a real number to the nearest integer.
     *
     * @param d The real number to round.
     * @return The rounded integer.
     */
    public static long round(double d) {
        return (long) (d + 0.5);
    }


    /**
     * Q.6
     * Checks if a part of an array is sorted in ascending order.
     *
     * @param arr   The array to check.
     * @param start The start index of the range.
     * @param end   The end index of the range.
     * @return True if the part of the array is sorted, false otherwise.
     */
    public static boolean isSortedUp(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Q.7
     * Checks if most elements in an array are non-negative.
     *
     * @param arr The array to check.
     * @return True if most elements are non-negative, false otherwise.
     */
    public static boolean mostPositive(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num >= 0) {
                count++;
            }
        }
        return count > arr.length / 2;
    }

    /**
     * Q.8
     * Returns the second-largest element in an array.
     *
     * @param arr The array to check.
     * @return The second-largest element in the array.
     */
    public static int biggest2(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return max2;
    }

    /**
     * Q.9
     * Checks if all columns in a matrix are sorted in ascending order.
     *
     * @param mat The matrix to check.
     * @return True if all columns are sorted, false otherwise.
     */
    public static boolean colsSorted(int[][] mat) {
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length - 1; i++) {
                if (mat[i][j] > mat[i + 1][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Q.9 Version 2
     * Checks if all columns in a matrix are sorted in ascending order using transpose function
     * we already implemented in week 3.
     *
     * @param mat The matrix to check.
     * @return True if all columns are sorted, false otherwise.
     */
    public static boolean colsSortedUsingTranspose(int[][] mat) {
        int[][] transposed_mat = week3_questions.transpose(mat);
        return rowsSorted(transposed_mat);
    }
}

class MainTest {

    @Test
    void isSorted() {
        assertTrue(week5_questions.isSorted(new int[]{1, 2, 3, 4, 5}));
        assertFalse(week5_questions.isSorted(new int[]{1, 3, 2, 5, 4}));
    }

    @Test
    void rowsSorted() {
        assertTrue(week5_questions.rowsSorted(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        assertFalse(week5_questions.rowsSorted(new int[][]{{1, 3, 2}, {4, 6, 5}, {7, 9, 8}}));
    }

    @Test
    void rowsSorted2() {
        assertTrue(week5_questions.rowsSorted2(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        assertFalse(week5_questions.rowsSorted2(new int[][]{{1, 3, 2}, {4, 6, 5}, {7, 9, 8}}));
    }

    @Test
    void gcd() {
        assertEquals(6, week5_questions.gcd(48, 18));
        assertEquals(14, week5_questions.gcd(42, 56));
    }

    @Test
    void mergeArrays() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, week5_questions.mergeArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, week5_questions.mergeArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6}));
    }

    @Test
    void round() {
        assertEquals(5, week5_questions.round(4.6));
        assertEquals(4, week5_questions.round(4.4));
    }

    @Test
    void isSortedUp() {
        assertTrue(week5_questions.isSortedUp(new int[]{1, 2, 3, 4, 5}, 0, 4));
        assertFalse(week5_questions.isSortedUp(new int[]{1, 3, 2, 5, 4}, 0, 4));
    }

    @Test
    void mostPositive() {
        assertTrue(week5_questions.mostPositive(new int[]{1, -1, 2, -2, 3}));
        assertFalse(week5_questions.mostPositive(new int[]{-1, -1, 2, -2, 3}));
    }
}
    

