package TA_Exercises;

import classes.week3.MyConsole;

public class week1_questions {
    public static void main(String[] args) {

        //1
        int first = MyConsole.readInt("Enter num: ");
        int second = MyConsole.readInt("Enter num: ");
        System.out.println("Before swapping");
        System.out.println("First is " + first + " Second is " + second);

        int temp = first;
        first = second;
        second = temp;

        System.out.println("After swapping");
        System.out.println("First is " + first + " Second is " + second);



        //2
        System.out.println("The integer average is " + (first + second) / 2);


        //3
        System.out.println("The integer average is " + (first + second) / 2.0);



        //4
        System.out.println("First%Second=" + first%second);



        //5
        int num = 1234;
        int a, b, c, d;
        a = num%10;
        num = num/10;
        b = num%10;
        num = num/10;
        c = num%10;
        d = num/10;

        System.out.println(a + " " + b + " " + c + " " + d);

        //6
        int celsius = MyConsole.readInt("Enter celsius num: ");
        double farn = celsius*(9.0/5) + 32;
        System.out.println("The degrees in Fahrenheit is " + farn + "F");

        //7
        int bigSeconds = MyConsole.readInt("Enter the seconds num: ");
        int hours = bigSeconds / 3600;
        int minutes = (bigSeconds - (3600*hours) ) / 60;
        int seconds = (bigSeconds - 3600*hours) % 60;
        System.out.println("The hours is "+hours+" hours, "+minutes+" minutes, and "+seconds+ "seconds");

        //8
        double radius = MyConsole.readDouble("Enter the radius: ");
        double area = radius*radius*3.14159;
        double Perimeter = radius * 2 * 3.14159;
        System.out.println("The circle area is "+area+", and the perimeter is "+Perimeter);
        
    }
}
