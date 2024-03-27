package assignments.ex3;

import classes.week4.StdDraw;


public class Ex3_GUI_Example {
    public static void main(String[] a) {
        int[][] mat = {{1,1,1,1,1}, {1,0,1,0,1}, {1,0,0,0,1},  {1,0,1,0,1},  {1,1,1,1,1}, {1,0,1,0,1}};
        mat = new int[30][30];
        mat[5][9] =1;
        drawMat(mat);

    }
    public static void drawMat(int[][] mat) {
        StdDraw.setScale(0, 1);
        StdDraw.clear();
        for(int y=0;y<mat.length;y++) {
            for(double x=0;x<mat[0].length;x++) {
                int v = mat[y][(int)x];
                if(v==0) {StdDraw.setPenColor(StdDraw.BLACK);}
                else {StdDraw.setPenColor(StdDraw.BOOK_RED);}
                double r = 1.0/(3*mat.length);
                double x1 = x/mat.length;
                double y1 = (0.1+2.2*r*y);
                StdDraw.filledCircle(x1,y1,r);
            }
        }
        StdDraw.show();
        StdDraw.pause(2);
    }
}
