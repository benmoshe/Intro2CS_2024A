package assignments.ex2.sol.geo;

import java.util.ArrayList;

/**
 * This class represents a 2D (Simple) Polygon in the plane.
 * With the following functionality: area, perimeter, pointInside (contains), rotate, scale, translate.
 *
 * @author I2CS
 */
public class Polygon_2D implements GeoShape {
    private ArrayList<Point_2D> _ps;
    private boolean editable;

    public Polygon_2D() {
        _ps = new ArrayList<Point_2D>();
        editable = true;
    }

    public Polygon_2D(Polygon_2D po) {
        this();
        for (int i = 0; i < po._ps.size(); i++) {
            Point_2D p = po._ps.get(i);
            this.add(new Point_2D(p));
        }
        editable = true;
    }

    /**
     * Return a deep copy of the points in the Polygon in the insert order.
     *
     * @return a new (deep copy) array of the points of this Polygon.
     */
    public Point_2D[] getAllPoints() {
        Point_2D[] ans = new Point_2D[_ps.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new Point_2D(_ps.get(i));
        }
        return ans;
    }

    /**
     * Locks this Polygon to be unchangeable (mainly applicable for inheritance (such as triangle)
     */
    public void setNotEditable() {
        this.editable = false;
    }

    /**
     * Add a point to this Polygon iff the point is not null and this Polygon is editable.
     *
     * @param p
     */
    public void add(Point_2D p) {
        if (editable && p != null) {
            if (!_ps.contains(p)) {
                _ps.add(new Point_2D(p));
            }
        }
    }

    /**
     * This method computed the relation between this polygon and a query point (ot),
     * it returns true iff ot falls within this simple polygon (close-set).
     * The algorithm implemented here uses the well known "Ray casting algorithm" (formally: https://en.wikipedia.org/wiki/Jordan_curve_theorem).
     * The implementation first construct a point (p-out) outside the polygon, and then construct a segment (ot-->p-out), and computes the number
     * of intersections between the segment and all the segments of this polygon. return true iff this number is an odd one.
     *
     * @param ot - a query 2D point
     * @return ture - ot falls within this simple polygon.
     */
    @Override
    public boolean contains(Point_2D ot) {
        boolean ans = false;
        ans = _ps.contains(ot);
        if (!ans) {
            try {
                if (ot != null) {
                    Point_2D m = outOfPolygon(ot); // a point outside this polygon with none-rational coordinate - in order to coop with "general-position" cases.
                    int size = _ps.size();
                    Segment_2D sg = new Segment_2D(ot, m);
                    int c = 0;
                    for (int i = 0; i < size; i++) {
                        Point_2D p1 = _ps.get(i);
                        int d = (i + 1) % size;
                        Point_2D p2 = _ps.get(d);
                        Segment_2D g = new Segment_2D(p1, p2);
                        Point_2D in = g.intersect(sg);
                        if (in != null) {
                            c++;
                        }
                    }
                    if (c % 2 == 1) {
                        ans = true;
                    }
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        return ans;
    }

    @Override
    public double area() {
        double ans = 0;
        int size = _ps.size();
        for (int i = 0; i < size; i++) {
            Point_2D p1 = _ps.get(i);
            int d = (i + 1) % size;
            Point_2D p2 = _ps.get(d);
            double dx = p2.x() - p1.x();
            double y = (p2.y() + p1.y()) / 2;
            double di = dx * y;
            ans += di;
        }
        return Math.abs(ans);
    }

    @Override
    public double perimeter() {
        double ans = 0;
        int size = _ps.size();
        for (int i = 0; i < size; i++) {
            Point_2D p1 = _ps.get(i);
            int d = (i + 1) % size;
            Point_2D p2 = _ps.get(d);
            double di = p1.distance(p2);
            ans += di;
        }
        return ans;
    }

    @Override
    public void translate(Point_2D vec) {
        for (int i = 0; i < _ps.size(); i++) {
            _ps.get(i).move(vec);
        }
    }

    /**
     * @return a deep copy of this polygon.
     */
    @Override
    public GeoShape copy() {
        return new Polygon_2D(this);
    }

    @Override
    public void scale(Point_2D center, double ratio) {
        for (int i = 0; i < _ps.size(); i++) {
            _ps.get(i).scale(center, ratio);
        }

    }

    @Override
    public void rotate(Point_2D center, double angleDegrees) {
        for (int i = 0; i < _ps.size(); i++) {
            _ps.get(i).rotate(center, angleDegrees);
        }
    }

    /**
     * Compute a String with all the Polygons points devided by ","
     *
     * @return
     */
    @Override
    public String toString() {
        String ans = "";//
        for (int i = 0; i < _ps.size(); i = i + 1) {
            ans += _ps.get(i).toString();
            if (i < _ps.size() - 1) {
                ans += ",";
            }
        }

        return ans;
    }

    /**
     * A Object p equals to this polygon iff: p is not null, p is instance of Polygon_2D,
     * and there is a mutual contains (overlapping) between p & this Polygon.
     *
     * @param p
     * @return
     */
    @Override
    public boolean equals(Object p) {
        if (p == null || !(p instanceof Polygon_2D)) {
            return false;
        }
        Polygon_2D p2 = (Polygon_2D) p;
        return (this.containsPoints(p2) && p2.containsPoints(this));
    }

    /**
     * This Polygon contains another Polygon (p) iff, every point in p is containd with in
     *
     * @param p
     * @return
     */
    public boolean containsPoints(Polygon_2D p) {
        boolean ans = true;
        if (p == null || size() != p.size()) {
            ans = false;
        } else {
            for (int i = 0; i < p._ps.size(); i = i + 1) {
                ans &= this.contains2(p._ps.get(i));
            }
        }
        return ans;
    }

    /**
     * Test if this Polygon intersects the p Polygon.
     * The algorithm simply traverse over all the Segments in p and test if any of them is intersecting (see method below) this Polygon
     * @param p another polygon
     * @return
     */
    public boolean intersect(Polygon_2D p) {
        boolean ans = false;
        if (p != null) {
            for (int i = 0; i < p.size(); i = i + 1) {
                int i2 = (i+1)%size();
                Segment_2D s = new Segment_2D(p._ps.get(i), p._ps.get(i2));
                ans |= this.intersect(s);
            }
        }
        return ans;
    }

    /**
     * Test if this Polygon intersect the Segment s1.
     * Simply go over all the Segments of this Polygon and test if each and any of them is intersecting s, is so return true.
     * @param s1
     * @return
     */
    private boolean intersect(Segment_2D s1) {
        boolean ans = false;
        for (int i = 0; i < size(); i = i + 1) {
            int i2 = (i+1)%size();
            Segment_2D s2 = new Segment_2D(_ps.get(i), _ps.get(i2));
            Point_2D in = s1.intersect(s2);
            ans |= in != null;
        }
        return ans;
    }

    public boolean contains2(Point_2D p) {
        boolean ans = false;
        for (int i = 0; i < size() & !ans; i++) {
            ans = p.close2equals(_ps.get(i));
        }
        return ans;
    }

    public int size() {
        return _ps.size();
    }

    /**
     * Computes a point outside (below and to the left) of this polygon, the coordinates modified
     * to try to coop with simple cases of "None General Position".
     *
     * @param ot
     * @return
     */
    private Point_2D outOfPolygon(Point_2D ot) {
        int size = _ps.size();
        double x0 = _ps.get(0).x();
        double y0 = _ps.get(0).y();
        for (int i = 1; i < size; i++) {
            double x = _ps.get(i).x();
            double y = _ps.get(i).y();
            if (x < x0) {
                x0 = x;
            }
            if (y < y0) {
                y0 = y;
            }
        }
        Point_2D ans = new Point_2D(x0 - Math.PI, y0 - Math.E);
        return ans;
    }
}
