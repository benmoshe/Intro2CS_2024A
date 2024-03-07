package assignments.ex2.sol.geo;

public class Triangle_2D extends Polygon_2D implements GeoShape{
    public Triangle_2D(Point_2D a, Point_2D b, Point_2D c) {
        super();
        super.add(a);
        super.add(b);
        super.add(c);
        super.setNotEditable();
    }
    public Triangle_2D(Triangle_2D t) {
        this(t.getAllPoints()[0], t.getAllPoints()[1], t.getAllPoints()[2]);
    }
}
