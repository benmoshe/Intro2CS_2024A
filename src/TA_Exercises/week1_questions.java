/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises from week 1.
 */
package TA_Exercises;

import classes.week3.MyConsole;

public class week1_questions {
    public static void main(String[] args) {

        // Section 1: Swapping two numbers
        // This section reads two integers from the user, swaps their values, and prints the result.
        int first = MyConsole.readInt("Enter num: ");
        int second = MyConsole.readInt("Enter num: ");
        System.out.println("Before swapping");
        System.out.println("First is " + first + " Second is " + second);

        int temp = first;
        first = second;
        second = temp;

        System.out.println("After swapping");
        System.out.println("First is " + first + " Second is " + second);

        // Section 2: Integer average
        // This section calculates the integer average of the two numbers and prints the result.
        System.out.println("The integer average is " + (first + second) / 2);

        // Section 3: Real number average
        // This section calculates the real number average of the two numbers and prints the result.
        System.out.println("The integer average is " + (first + second) / 2.0);

        // Section 4: Modulo operation
        // This section calculates the remainder of the first number divided by the second number and prints the result.
        System.out.println("First%Second=" + first%second);

        // Section 5: Digit separation
        // This section separates the digits of a four-digit number and prints them.
        int num = 1234;
        int a, b, c, d;
        a = num%10;
        num = num/10;
        b = num%10;
        num = num/10;
        c = num%10;
        d = num/10;

        System.out.println(a + " " + b + " " + c + " " + d);

        // Section 6: Celsius to Fahrenheit conversion
        // This section reads a temperature in Celsius from the user, converts it to Fahrenheit, and prints the result.
        int celsius = MyConsole.readInt("Enter celsius num: ");
        double farn = celsius*(9.0/5) + 32;
        System.out.println("The degrees in Fahrenheit is " + farn + "F");

        // Section 7: Time conversion
        // This section reads a number of seconds from the user, converts it to hours, minutes, and seconds, and prints the result.
        int bigSeconds = MyConsole.readInt("Enter the seconds num: ");
        int hours = bigSeconds / 3600;
        int minutes = (bigSeconds - (3600*hours) ) / 60;
        int seconds = (bigSeconds - 3600*hours) % 60;
        System.out.println("The hours is "+hours+" hours, "+minutes+" minutes, and "+seconds+ "seconds");

        // Section 8: Circle calculations
        // This section reads a radius from the user, calculates the area and perimeter of the corresponding circle, and prints the results.
        double radius = MyConsole.readDouble("Enter the radius: ");
        double area = radius*radius*3.14159;
        double Perimeter = radius * 2 * 3.14159;
        System.out.println("The circle area is "+area+", and the perimeter is "+Perimeter);

    }
}
