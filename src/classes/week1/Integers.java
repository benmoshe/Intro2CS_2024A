package classes.week1;
/**
 * This is a simple documentation between programmers
 * This example demonstrates a simple integer (int) initialization, and basic mathematical 
 * operation over integers.
 * output:a=04, b=5, c=4, d=5, e=100, f=11, g=3

 * @author boaz.benmoshe
 *
 */
public class Integers {
	public static void main(String[] arg) {
		int a = 0;
		int b = 1;
		int c = 2+2;	//
		int d = b+c; 	//
		int e = c*d*d; 	//
		int f = e/(c+d);//  an integer)
		int g = f%c;	//
		System.out.println("a="+a+4+", b="+(b+4)+", c="+c+", d="+d+", e="+e+", f="+f+", g="+g);
	}
} 
