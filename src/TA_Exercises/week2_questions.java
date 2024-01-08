package TA_Exercises;
import java.util.*;
public class week2_questions {
    public static void main(String[] args) {
        // Exercise 1
        // First option
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a natural number that is greater than 0: ");
        int num = sc.nextInt();
        int sum1 = (num*(1+num))/2; // Sum of Arithmetic Series - סכום סדרה חשבונית
        System.out.println("This is the sum by Arithmetic Series: " + sum1);
        // Second option
        int sum2 = 0;
        for (int i = 1; i<= num; ++i){
            sum2+=i;
        }
        System.out.println("This is the sum by for loop: " + sum2);

        // Exercise 2
        System.out.println("Please enter 4 numbers: ");
        System.out.println("First number: ");
        int a = sc.nextInt();
        System.out.println("Second number: ");
        int b = sc.nextInt();
        System.out.println("Third number: ");
        int c= sc.nextInt();
        System.out.println("Fourth number: ");
        int d = sc.nextInt();

        int [] arr = {a, b, c, d};
        double sum = 0; // why do we shouldn't write: int sum = 0;
        for (int k : arr) { // how it's called?
            sum += k;
        }
        double avg = sum/(arr.length);
        System.out.println("The average of the array is" + avg);

        // Exercise 3
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
