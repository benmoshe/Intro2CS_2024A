package assignments.ex2.geo;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect_2D implements GeoShape {
	private Point_2D _min, _max;
	public Rect_2D(Point_2D p1, Point_2D p2) {
		////// add your code here //////
		_min = new Point_2D(Math.min(p1.x(), p2.x()), Math.min(p1.y(), p2.y()));
		_max = new Point_2D(Math.max(p1.x(), p2.x()), Math.max(p1.y(), p2.y()));
		////////////////////////////////
	}
	public Rect_2D(Rect_2D t1) {
		////// add your code here //////

		////////////////////////////////
	}

	@Override
	public boolean contains(Point_2D ot) {
		return false;
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		return 0;
	}

	@Override
	public void translate(Point_2D vec) {

	}
	@Override
	public GeoShape copy() {
		return new Rect_2D(new Point_2D(_min), new Point_2D(_max));
	}

	@Override
	public void scale(Point_2D center, double ratio) {

	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {

	}
	public Point_2D min() {return _min;}
	public Point_2D max() {return _max;}
}
