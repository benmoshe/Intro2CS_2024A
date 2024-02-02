package classes.week3;

/**
 * This class contains several simple examples for static functions and
 * basic testing using JUnit.
 *
 * @author boaz.ben-moshe
 */
public class SimpleFunctions {
    public static boolean isPrime(int n) {
        boolean ans = true;
        for (int i = 2; i * i <= n && ans; i = i + 1) {
            if (n % i == 0) {
                ans = false;
            }
        }
        return ans;
    }

    public static double random(double min, double max) {
        double r = Math.random(); // [0,1)
        double dx = max - min;
        r = r * dx; // [0,dx) = [0,max-min)
        r = r + min; //[min,max)
        return r;
    }

    public static void printArr(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i = i + 1) {
            System.out.print("," + arr[i]);
        }
    }
    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i = i + 1) {
            printArr(arr[i]);
        }
    }

    public static void main(String[] a) {
        int[][] a2 = new int[3][4];
        a2[1][3] = 5;
        printArr(a2);
        a2[1] = new int[2];
        for (int i = 0; i < a2.length; i = i + 1) {
            printArr(a2[i]);
        }
    }
}
