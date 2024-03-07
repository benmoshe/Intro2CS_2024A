package assignments.ex2.sol.geo;

/**
 * This class represents a 2D axis parallel rectangle.
 * It was implemented using inheritance, thus, the rotation "changes" it to be a Polygon (after performing a copy).
 * @author I2CS
 *
 */
public class Rect_2D extends Polygon_2D implements GeoShape {
	private boolean is_asix_parallel;
	public Rect_2D(Point_2D p1, Point_2D p2) {
		super();
		double x0 = Math.min(p1.x(), p2.x());
		double y0 = Math.min(p1.y(), p2.y());
		double x1 = Math.max(p1.x(), p2.x());
		double y1 = Math.max(p1.y(), p2.y());
		super.add(new Point_2D(x0,y0));
		super.add(new Point_2D(x1,y0));
		super.add(new Point_2D(x1,y1));
		super.add(new Point_2D(x0,y1));
		super.setNotEditable();
		is_asix_parallel = true;
	}
	public Rect_2D(Rect_2D t1) {
		super();
		Point_2D[] ps = t1.getAllPoints();
		for(int i=0;i< ps.length;i++) {
			super.add(new Point_2D(ps[i]));
		}
		super.setNotEditable();
		is_asix_parallel = t1.is_asix_parallel;
	}
	public double width() {return getAllPoints()[0].distance(getAllPoints()[3]);}
	public double height() {return getAllPoints()[0].distance(getAllPoints()[1]);}
	
	public boolean isIs_asix_parallel() {return is_asix_parallel;}

	@Override
	public GeoShape copy() {
		if(isIs_asix_parallel()) {return new Rect_2D(this);}
		else return super.copy();
	}
	@Override
	public void add(Point_2D p) {

	}
	// This is an old implementation -
 /*@Override
	public boolean contains(Point_2D ot) {
		return super.contains(ot);
	}
	@Override
	public double area() {
		double ans = width() * height();
		return ans;
	}
	
	@Override
	public double perimeter() {
		double ans = width() + height();
		return ans*2;
	}

	@Override
	public void translate(Point_2D vec) {
		_min.move(vec);
	}
	@Override
	public GeoShape copy() {
		return new Rect2D(this);
	}

	@Override
	public Point2D[] getPoints() {
		return _mm.getPoints();
	}

	@Override 
	public boolean equals(Object t) {
		if(t==null || !(t instanceof Rect_2D)) {return false;}
		Rect_2D ot = (Rect_2D)t;
		boolean ans = this._min.equals(ot._min);
		ans &= this._max.equals(ot._max);
		return ans;
	}
	@Override
	public void scale(Point_2D center, double ratio) {
		_min.scale(center, ratio);
		_max.scale(center, ratio);
		
	}

  */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		is_asix_parallel = false;
		super.rotate(center, angleDegrees);
	}

}
