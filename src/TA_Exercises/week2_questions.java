package TA_Exercises;

import java.util.*;

public class week2_questions {
    public static void main(String[] args) {
        // Exercise 1
        // First option
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a natural number that is greater than 0: ");
        int num = sc.nextInt();
        int sum1 = (num * (1 + num)) / 2; // Sum of Arithmetic Series - סכום סדרה חשבונית
        System.out.println("This is the sum by Arithmetic Series: " + sum1);
//        // Second option
        int sum2 = 0;
        for (int i = 1; i <= num; ++i) {
            sum2 += i;
        }
        System.out.println("This is the sum by for loop: " + sum2);
//
//        // Exercise 2
        System.out.println("Please enter 4 numbers: ");
        System.out.println("First number: ");
        int first = sc.nextInt();
        System.out.println("Second number: ");
        int second = sc.nextInt();
        System.out.println("Third number: ");
        int third = sc.nextInt();
        System.out.println("Fourth number: ");
        int fourth = sc.nextInt();

        int[] arr = {first, second, third, fourth};
        double sum = 0; // why shouldn't we write: int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        double avg = sum / (arr.length);
        System.out.println("The average of the array is" + avg);
//
//        // Exercise 3
//        for (int i = 1; i < 11; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//        //Exercise 4
        System.out.println("Please enter a natural number: ");
        int N = sc.nextInt();
        int accumulator = 0;
        if(N == 0)
            accumulator = 1;
        while (N > 0) {
            if (N % 10 == 0)
                accumulator++;
            N = N / 10;
        }
        System.out.println("The amount of zeroes is: " + accumulator);
//
//        //Exercise 5
//        System.out.println("Please enter two natural numbers, n and m: ");
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int power = 1;
//        for (int i = 1; i <= n; i++)
//            power *= m;
//        System.out.println("The result of m^n is: " + power);
//
//        //Exercise 6
//        System.out.println("Please enter three natural numbers, r, t and y: ");
//        int r = sc.nextInt();
//        int t = sc.nextInt();
//        int y = sc.nextInt();
//        int max = r;
//        int min = r;
//        if (max < t) max = t;
//        if (max < y) max = y;
//        if (min > t) min = t;
//        if (min > y) min = y;
//        System.out.println("The largest is " + max + ", and the minimal is " + min);
//
//        //Exercise 7
//        System.out.println("Please enter three natural numbers, a, b and c: ");
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        double disc = b * b - 4 * a * c;
//        if (disc < 0) System.out.println("No solutions!");
//        else if (disc == 0) System.out.println("The single solution is " + (-b / (2 * a)));
//        else {
//            double x1 = (-b + Math.sqrt(disc)) / (2 * a);
//            double x2 = (-b - Math.sqrt(disc)) / (2 * a);
//            System.out.println("The solutions are " + x1 + " and " + x2);
//        }
//
//        //Exercise 8
//        System.out.println("Please enter a natural number: ");
//        int input = sc.nextInt();
//        int atzeret = 1;
//        for (int i = 1; i <= input; i++)
//            atzeret *= i;
//        System.out.println("The result of " + input + "! is " + atzeret);
//
//        //Exercise 9
//        System.out.println("Please enter a natural number as the array size: ");
//        int len = sc.nextInt();
//        int[] array = new int[len];
//        System.out.println("Please enter " + len + " numbers.");
//        max = Integer.MIN_VALUE;
//        for (int i = 0; i < len; i++) {
//            array[i] = sc.nextInt();
//            if (array[i] > max)
//                max = array[i];
//        }
//        System.out.println("The maximal number is: " + max);
//
//        //Exercise 10
//        System.out.println("Please enter a long enough string:");
//        String base = sc.next();
//        String pre = base.substring(1, 5);
//        String post = base.substring(8, 12);
//        if (pre.equals(post))
//            System.out.println("The two substrings are equal");
//        else System.out.println("The two substrings aren't equal");
        String str = "Hello there, I'm Avi";
        String sub = str.substring(0, 5);
        System.out.println(sub);
    }
}
