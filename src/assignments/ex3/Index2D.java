package assignments.ex3;

import java.io.Serializable;

public class Index2D implements Pixel2D, Serializable{
    private int _x, _y;
    public Index2D() {this(0,0);}
    public Index2D(int x, int y) {_x=x;_y=y;}
    public Index2D(Pixel2D t) {this(t.getX(), t.getY());}

    public Index2D(String pos) {
        // add you code here

        ////////////////////
    }

    @Override
    public int getX() {
        return _x;
    }

    @Override
    public int getY() {
        return _y;
    }
    public double distance2D(Pixel2D t) {
        double ans = -1;
        // add you code here

        ////////////////////
        return ans;
    }
    @Override
    public String toString() {
        String ans = "";
        // add you code here

        ////////////////////
        return ans;
    }
    @Override
    public boolean equals(Object t) {
        boolean ans = false;
        // add you code here

        ////////////////////
        return ans;
    }
}
