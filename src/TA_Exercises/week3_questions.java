package TA_Exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class week3_questions {
    public static void main(String[] args) {
        String[][] arr = {
                {"Silly", "Mango", "Art"},
                {"Rabbit", "Tiger"}
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j].charAt(0));
            }
        }

    }

    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static double arrayMean(int[] arr) {
        return (double) arraySum(arr) / (arr.length); // always reuse code if you can
    }

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

    public static int sum(int[][] array) {
        int total = 0;
        for (int[] row : array) {
            for (int element : row) {
                total += element;
            }
        }
        return total;
    }

    public static int[][] transpose(int[][] array) {
        int[][] result = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[j][i] = array[i][j];
            }
        }
        return result;
    }

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

    @Test
    public void testArraySum() {
        int[] arr = {1, 2, 3, 4, 5};
        int expectedSum = 15;
        int[] arr2 = {-1, 2, -3, 4, -5};
        int expectedSum2 = -3;
        Assertions.assertEquals(expectedSum2, week3_questions.arraySum(arr2));
        Assertions.assertEquals(expectedSum, week3_questions.arraySum(arr));
    }

    @Test
    public void testArrayMean() {
        int[] arr = {1, 2, 3, 4, 5};
        double expectedMean = 3.0;
        int[] arr2 = {-1, 2, -3, 4, -5};
        double expectedMean2 = -0.6;
        Assertions.assertEquals(expectedMean2, week3_questions.arrayMean(arr2), 0.0001);
        Assertions.assertEquals(expectedMean, week3_questions.arrayMean(arr), 0.0001);
    }

    @Test
    public void testEvenOddSort() {
        int[] arr = {1, 2, 3, 4, 5};
        evenOddSort(arr);
        int[] expectedArr = {2, 4, 3, 1, 5}; // Expected output after sorting
        Assertions.assertArrayEquals(expectedArr, arr);
    }
}
