/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises from week 2.
 */
package TA_Exercises;

import java.util.*;

public class week2_questions {
    public static void main(String[] args) {
        // Exercise 1
        // First option
        Scanner sc = new Scanner(System.in);

        // Exercise 1: Sum of natural numbers
        // This section reads a natural number from the user, calculates the sum of all numbers up to that number in two ways, and prints the results.
        System.out.println("Please enter a natural number that is greater than 0: ");
        int num = sc.nextInt();
        int sum1 = (num * (1 + num)) / 2; // Sum of Arithmetic Series
        System.out.println("This is the sum by Arithmetic Series: " + sum1);
        int sum2 = 0;
        for (int i = 1; i <= num; ++i) {
            sum2 += i;
        }
        System.out.println("This is the sum by for loop: " + sum2);

        // Exercise 2: Average of four numbers
        // This section reads four numbers from the user, calculates their average, and prints the result.
        System.out.println("Please enter 4 numbers: ");
        int first = sc.nextInt();
        int second = sc.nextInt();
        int third = sc.nextInt();
        int fourth = sc.nextInt();
        int[] arr = {first, second, third, fourth};
        double sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        double avg = sum / (arr.length);
        System.out.println("The average of the array is " + avg);

        // Exercise 3: Print a triangle of asterisks
        // This section prints a right-angled triangle of asterisks.
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Exercise 4: Count the number of zeros in a number
        // This section reads a natural number from the user, counts the number of zeros in it, and prints the result.
        System.out.println("Please enter a natural number: ");
        int N = sc.nextInt();
        int accumulator = 0;
        if (N == 0)
            accumulator = 1;
        while (N > 0) {
            if (N % 10 == 0)
                accumulator++;
            N = N / 10;
        }
        System.out.println("The amount of zeroes is: " + accumulator);

        // Exercise 5: Calculate the power of a number
        // This section reads two natural numbers from the user, calculates the first number raised to the power of the second number, and prints the result.
        System.out.println("Please enter two natural numbers, n and m: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int power = 1;
        for (int i = 1; i <= n; i++)
            power *= m;
        System.out.println("The result of m^n is: " + power);

        // Exercise 6: Find the maximum and minimum of three numbers
        // This section reads three natural numbers from the user, finds the maximum and minimum among them, and prints the results.
        System.out.println("Please enter three natural numbers, r, t and y: ");
        int r = sc.nextInt();
        int t = sc.nextInt();
        int y = sc.nextInt();
        int max = r;
        int min = r;
        if (max < t) max = t;
        if (max < y) max = y;
        if (min > t) min = t;
        if (min > y) min = y;
        System.out.println("The largest is " + max + ", and the minimal is " + min);

        // Exercise 7: Solve a quadratic equation
        // This section reads the coefficients of a quadratic equation from the user, solves the equation, and prints the solutions.
        System.out.println("Please enter three natural numbers, a, b and c: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        double disc = b * b - 4 * a * c;
        if (disc < 0) System.out.println("No solutions!");
        else if (disc == 0) System.out.println("The single solution is " + (-b / (2 * a)));
        else {
            double x1 = (-b + Math.sqrt(disc)) / (2 * a);
            double x2 = (-b - Math.sqrt(disc)) / (2 * a);
            System.out.println("The solutions are " + x1 + " and " + x2);
        }

        // Exercise 8: Calculate the factorial of a number
        // This section reads a natural number from the user, calculates its factorial, and prints the result.
        System.out.println("Please enter a natural number: ");
        int input = sc.nextInt();
        int atzeret = 1;
        for (int i = 1; i <= input; i++)
            atzeret *= i;
        System.out.println("The result of " + input + "! is " + atzeret);

        // Exercise 9: Find the maximum number in an array
        // This section reads a number of elements and the elements of an array from the user, finds the maximum element, and prints the result.
        System.out.println("Please enter a natural number as the array size: ");
        int len = sc.nextInt();
        int[] array = new int[len];
        System.out.println("Please enter " + len + " numbers.");
        max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
            if (array[i] > max)
                max = array[i];
        }
        System.out.println("The maximal number is: " + max);

        // Exercise 10: Compare substrings of a string
        // This section reads a string from the user, extracts two substrings, compares them, and prints whether they are equal.
        System.out.println("Please enter a long enough string:");
        String base = sc.next();
        String pre = base.substring(1, 5);
        String post = base.substring(8, 12);
        if (pre.equals(post))
            System.out.println("The two substrings are equal");
        else System.out.println("The two substrings aren't equal");
        String str = "Hello there, I'm Avi";
        String sub = str.substring(0, 5);
        System.out.println(sub);
    }
}
