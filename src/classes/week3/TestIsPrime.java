package classes.week3;

/**
 * This is a very simple example for none-JUnit testing.
 * Do try to convert this code to
 */

public class TestIsPrime {
    public static void main(String[] a) {
        int[] primes = {2,3,5,33331, 2*3*5*7+1};
        int[] notPrims = {4,18, 3331*3331};
        int errs = 0;
        long start = System.currentTimeMillis();
        for(int i=0;i<primes.length;i=i+1) {
            int p = primes[i];
            boolean isP = GCD_Functions.isPrime(primes[i]);
            if(isP==false) {
                errs+=1;
                System.err.println("Err "+primes[i]+" should be a prime");
            }
        }
        for(int i=0;i<notPrims.length;i=i+1) {
            int pp = notPrims[i];
            boolean isP = GCD_Functions.isPrime(notPrims[i]);
            if(isP) {
                errs+=1;
                System.err.println("Err "+notPrims[i]+" should NOT be a prime");
            }
        }
        int i;
        i=0;
        int[] aa = null;

        System.out.println("Done with "+errs+" Errors");
        long end = System.currentTimeMillis();
        double dt = end - start;
        double dt_sec = dt/1000.0;
        System.out.println("Done with "+errs+" Errors, in "+dt_sec+" seconds");
    }
}
