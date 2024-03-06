package TA_Exercises;

import java.util.Scanner;

import static TA_Exercises.week5_questions.gcd;

public class week10_questions {
    public static void main(String[] args) {
        System.out.println(coPrimeNumbers());
        System.out.println(coPrimeNumbersIterative());
    }
    static Scanner sc = new Scanner(System.in);
    public static int coPrimeNumbers(){
        System.out.println("Enter two numbers: ");
        int first = sc.nextInt();
        int second = sc.nextInt();
        if (gcd(first, second) == 1){
            return 1;
        }
        System.out.println("Wrong numbers, the numbers aren't co-primes, try again:");
        return 1 + coPrimeNumbers();
    }

    public static int coPrimeNumbersIterative(){
        System.out.println("Enter two numbers: ");
        int first = sc.nextInt();
        int second = sc.nextInt();
        while (gcd(first, second) != 1){
            System.out.println("Wrong numbers, the numbers aren't co-primes, try again:");
            System.out.println("Enter two numbers: ");
            first = sc.nextInt();
            second = sc.nextInt();
        }
        return 1;
    }
}
