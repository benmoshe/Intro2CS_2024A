package assignments.ex2.sol.geo;

import static assignments.ex2.sol.ex2.Ex2_Const.EPS;

/**
 * This class represents a 2D circle in the plane. 
 * Please make sure you update it according to the GeoShape interface.
 * Ex2: you should update this class!
 * @author boaz.benmoshe
 *
 */
public class Circle_2D implements GeoShape{
	private Point_2D _center;
	private double _radius;
	
	public Circle_2D(Point_2D cen, double rad) {
		this._center = new Point_2D(cen);
		this._radius = rad;
	}
	public Circle_2D(Circle_2D c) {
		this(c.getCenter(), c.getRadius());
	}

	public Circle_2D(String s) {
		try {
			String[] a = s.split(",");
			_center = new Point_2D(s);
			_radius = Double.parseDouble(a[2]);
		}
		catch(IllegalArgumentException e) {
			System.err.println("ERR: got wrong format string for Circle_2D init, got:"+s+"  should be of format: x,y,r");
			throw(e);
		}
	}
	@Override
	public boolean equals(Object c)
	{
		if(c==null || !(c instanceof Circle_2D)) {return false;}
		Circle_2D c2 = (Circle_2D) c;
		return c2.getCenter().equals(this.getCenter()) && c2.getRadius()==this.getRadius();
	}
	public boolean close2Equals(Object c)
	{
		if(c==null || !(c instanceof Circle_2D)) {return false;}
		Circle_2D c2 = (Circle_2D) c;
		double dist = c2.getRadius()-this.getRadius();
		return c2.getCenter().close2equals(this.getCenter()) && Math.abs(dist)<EPS;
	}
	public double getRadius() {return this._radius;}
	public Point_2D getCenter(){ return _center;}
	 @Override
	    public String toString()
	    { return _center.toString()+", "+_radius;}
	@Override
	public boolean contains(Point_2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
	}
	
	@Override
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}
	@Override
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}
	@Override
	public void translate(Point_2D vec) {
		_center.move(vec);
	}
	@Override
	public GeoShape copy() {
		return new Circle_2D(_center, _radius);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		this._center.scale(center, ratio);
		this._radius *=ratio;
	}
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this._center.rotate(center, angleDegrees);
	}

}
