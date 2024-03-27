package assignments.ex2.geo;

import java.util.ArrayList;

public class Polygon_2D implements GeoShape {
    ////// add your code here //////
    private ArrayList<Point_2D> _points = null;

    ////////////////////////////////
    public Polygon_2D() {
        _points = new ArrayList<Point_2D>();
        ////// add your code here //////

        ////////////////////////////////
    }

    public Polygon_2D(Polygon_2D po) {
        ////// add your code here //////
        this();
        Point_2D[] ps = po.getAllPoints();
        for (int i = 0; i < ps.length; i = i + 1) {
            this.add(new Point_2D(ps[i]));
        }

        ////////////////////////////////
    }
    public Polygon_2D(String s) {
        ////// add your code here //////
        this();
        String[] ps = s.split(",");
        for (int i = 0; i < ps.length; i = i + 2) {
            String p = ps[i]+","+ps[i+1];
            Point_2D pp = new Point_2D(p);
            this.add(pp);
        }

        ////////////////////////////////
    }
    public Point_2D[] getAllPoints() {
        ////// add your code here //////
        Point_2D[] ans = new Point_2D[_points.size()];
        _points.toArray(ans);
        return ans;
        ////////////////////////////////
    }

    public void add(Point_2D p) {
        ////// add your code here //////
        this._points.add(new Point_2D(p));
        ////////////////////////////////
    }

    @Override
    public String toString() {
        ////// add your code here //////
        String ans = "";
		int i=0;
		for(i=0;i<_points.size()-1;i=i+1) {
			ans = ans + _points.get(i).toString()+",";
		}
		ans += _points.get(i);
        return ans;
        ////////////////////////////////
    }

    @Override
    public boolean contains(Point_2D ot) {
        ////// add your code here //////

        return false;
        ////////////////////////////////
    }

    @Override
    public double area() {
        ////// add your code here //////
        double area = 0;
        int len = _points.size();
        for(int i=0;i<len;i=i+1) {
            int i2 = (i+1)%len;
            Point_2D pi = _points.get(i);
            Point_2D pi_1 = _points.get(i2);
            double dx = pi_1.x() - pi.x();
            double ym = (pi_1.y() + pi.y())/2;
            double a = dx*ym;
            area += a;
        }
        return Math.abs(area);
        ////////////////////////////////
    }

    @Override
    public double perimeter() {
        ////// add your code here //////
		double ans = 0;
		int len = _points.size();
		for(int i=0;i<len;i=i+1) {
			int i2 = (i+1)%len;
			ans += _points.get(i).distance(_points.get(i2));
		}
        return ans;
        ////////////////////////////////
    }

    @Override
    public void translate(Point_2D vec) {
        ////// add your code here //////

        ////////////////////////////////
    }

    @Override
    public GeoShape copy() {
        ////// add your code here //////

        return new Polygon_2D(this);
        ////////////////////////////////
    }

    @Override
    public void scale(Point_2D center, double ratio) {
        ////// add your code here //////

        ////////////////////////////////
    }

    @Override
    public void rotate(Point_2D center, double angleDegrees) {
        ////// add your code here //////

        ////////////////////////////////
    }

}
