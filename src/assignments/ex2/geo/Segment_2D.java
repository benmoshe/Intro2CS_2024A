package assignments.ex2.geo;

import static classes.week6.Point2D.EPS;

/**
 * This class represents a 2D segment on the plane,
 * Ex2: you should implement this class!
 *
 * @author I2CS
 */
public class Segment_2D implements GeoShape {
    private Point_2D p1, p2;

    public Segment_2D(Point_2D a, Point_2D b) {
        ////// add your code here //////
        p1 = new Point_2D(a);
        p2 = new Point_2D(b);
        ////////////////////////////////
    }

    public Segment_2D(Segment_2D t1) {
        ////// add your code here //////
        this(t1.p1, t1.p2);
        ////////////////////////////////
    }

    public Point_2D get_p1() {
        ////// add your code here //////

        return p1;
        ////////////////////////////////
    }

    public Point_2D get_p2() {
        ////// add your code here //////

        return p2;
        ////////////////////////////////
    }

    @Override
    public boolean contains(Point_2D ot) {
        double dist = p1.distance(p2);
        double d1 = p1.distance(ot);
        double d2 = ot.distance(p2);
        return dist + EPS > d1 + d2;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return p1.distance(p2) * 2;
    }

    @Override
    public void translate(Point_2D vec) {

    }

    @Override
    public GeoShape copy() {
        return null;
    }

    @Override
    public void scale(Point_2D center, double ratio) {

    }

    @Override
    public void rotate(Point_2D center, double angleDegrees) {

    }

    public boolean isVertical() {
        double dx = Math.abs(p1.x() - p2.x());
        return dx < EPS;
    }

    public boolean isIntersect(Segment_2D ot) {
        boolean ans = false;
        if (!ot.isVertical() || !this.isVertical()) {
            //	if(this.isVertical()) {
            //		return ot.isIntersect(this):
            //	}
            //	else {
            LinearFunction f1 = new LinearFunction(p1, p2);
            LinearFunction f2 = new LinearFunction(ot.p1, ot.p2);
            Point_2D intersect = f1.intersect(f2);
            if (intersect != null) {
                if (this.contains(intersect)) {
                    if (ot.contains(intersect)) {
                        ans = true;
                    }
                }
            }

            //	}
        }
        return ans;
    }
}