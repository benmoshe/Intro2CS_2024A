/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises for week 4.
 */
package TA_Exercises.week9_questions;

import assignments.ex2.geo.*;

import java.util.Random;

public class test_questions {
    public static void main(String[] args) {
        double[] arr = {1, 2, 3, 4, 5};
        shuffle(arr);
        for (double d : arr) {
            System.out.print(d + " ");
        }
        System.out.println();
        GeoShape[] shapes = new GeoShape[5];
        Point_2D p = new Point_2D(3, 5);
        Point_2D p2 = new Point_2D(1, 10);
        shapes[0] = new Circle_2D(p, 5);
        shapes[1] = new Polygon_2D();
        shapes[2] = new Segment_2D(p, p2);
        shapes[3] = new Rect_2D(p, p2);
        shapes[4] = new Circle_2D(p, 12);
        System.out.println(numOfClasses(shapes));


    }
    // Q.1

    /**
     * Returns the index of the first occurrence of the target in the array.
     * @param arr The array to search.
     */
    public static void shuffle(double[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            double a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }
    // Q.2.1

    /**
     * Returns true if the two shapes are of the same class.
     * @param s1 The first shape.
     * @param s2 The second shape.
     * @return True if the two shapes are of the same class and not null.
     */
    public static boolean sameClass(GeoShape s1, GeoShape s2) {
        return s1 != null && s2 != null && s1.getClass().equals(s2.getClass());
    }
    // Q.2.2

    /**
     * Returns the number of different classes in the array.
     * @param shapes The array of shapes.
     * @return The number of different classes in the array.
     */
    public static int numOfClasses(GeoShape[] shapes) {
        int count = 0;
        for (int i = 0; i < shapes.length; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (sameClass(shapes[i], shapes[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                count++;
            }
        }
        return count;
    }


}
