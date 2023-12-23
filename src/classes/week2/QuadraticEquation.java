package classes.week2;
import java.util.Scanner;
/**
 * A very simple example of solving a Quadratic Equation of the form:
 * x^2+bx+c=0 (note that for simplicity we have assumed that a=1).
 * @author boaz.ben-moshe
 * 
 * 
 * 
 * MCD(16,24,9): 
MCD(16,24): 
gcd1(16,24)
gcd1(24,16)
gcd1(16,8)
gcd1(16,8) = 8
MCD(16,24) = 48
MCD(48,9): 
gcd1(48,9)
gcd1(9,3)
gcd1(9,3) = 3
MCD(48,9) = 144
The MCD(16,24,9) = 144
The runtime took: 360.209 micro seconds.

 *
 */
public class QuadraticEquation {
	public static void main(String[] args) {
		double b=0,c=0;
		if(args.length<2 ) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("x^2 + bx + c = 0");
			System.out.print("Please insert b: ");		
			b = scanner.nextDouble();
			System.out.print("Please insert c: ");
			c = scanner.nextDouble();
		}
		else {
			b = Double.parseDouble(args[0]);
			c = Double.parseDouble(args[1]);
		}
		double disciminant = b*b - 4.0*c;
		System.out.println("x^2 +"+b+"x+"+c+" = 0");
		if(disciminant>=0) {
			double d = Math.sqrt(disciminant);
			double root1 = (-b + d) / 2.0;
			double root2 = (-b - d) / 2.0;
			System.out.println("first solution: "+root1);
			System.out.println("second solution: "+root2);
		}
		else {
			System.out.println("There is no (real) solution, as the disciminant is negative ("+disciminant+")");
		}
	}
}
