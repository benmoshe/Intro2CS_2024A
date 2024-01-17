package assignments.ex1;

/**
 * This is a simple example for using static variables as a class data members.
 * In simple words: a static variables (such as counter (int, and array (int[]).
 * Output:
 * =======
 * counter=0
 * counter=2
 * ,1,2,3
 * the sum of array: 6
 * the sum of array: 19
 * the sum of array: 0
 */
public class TestStaticVars {
    static int counter = 0;  // this is an efficient way to have a "global" variable that has a scope of all the class.
    static int[] array = {1,2,3};  // this is an efficient way to have a "global" variable that has a scope of all the class.
    public static void main(String[] ar) {
        System.out.println("counter="+counter);
        counter += 2;
        System.out.println("counter="+counter);
        printArr(array);
        System.out.println("the sum of array: "+sum());
        array[1]=15;
        System.out.println("the sum of array: "+sum());
        array = new int[2];
        System.out.println("the sum of array: "+sum());
    }

    /**
     * Print the array in a single line (e.g.,1,2,3)
     * @param arr
     */
    public static void printArr(int[] arr) {
        for(int i=0;i<arr.length;i=i+1) {
            System.out.print(","+arr[i]);
        }
        System.out.println();
    }

    /** A very simple function that sums all the values in the array variable
     * @return the sum of all the entries in the array.
     */
    public static int sum(){
        int s = 0;
        for(int i=0;i<array.length;i=i+1) {
           s = s + array[i];
        }
        return s;
    }
}
