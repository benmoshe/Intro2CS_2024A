package assignments.ex2.sol.geo;

import assignments.ex2.sol.ex2.Ex2_Const;
/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Segment_2D implements GeoShape{
	private Point_2D _p1, _p2;
	public Segment_2D(Point_2D a, Point_2D b) {
		_p1=new Point_2D(a);
		_p2=new Point_2D(b);
	}
	public Segment_2D(Segment_2D t1) {
		this(t1._p1, t1._p2);
	}

	public Point_2D get_p1() {
		return new Point_2D(_p1);
	}
	public Point_2D get_p2() {
		return new Point_2D(_p2);
	}
	@Override
	public boolean contains(Point_2D ot) {
		boolean ans = false;
		double d12 = _p1.distance(_p2);
		double dd = _p1.distance(ot)+ot.distance(_p2);
		ans = d12 + Ex2_Const.EPS>= dd;
		return ans;
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 */
	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		double ans = _p1.distance(_p2);
		return ans*2;
	}

	@Override
	public void translate(Point_2D vec) {
		_p1.move(vec);
		_p2.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Segment_2D(_p1,_p2);
	}

	@Override
	public String toString() {
		String ans = _p1.toString()+","+_p2.toString();//
		return ans;
	}
	@Override 
	public boolean equals(Object t) {
		if(t==null || !(t instanceof Segment_2D)) {return false;}
		Segment_2D ot = (Segment_2D)t;
		double d11 = this._p1.distance(ot._p1);
		double d22 = this._p2.distance(ot._p2);
		double d12 = this._p1.distance(ot._p2);
		double d21 = this._p2.distance(ot._p1);
		
		boolean ans = (d11<Ex2_Const.EPS && d22<Ex2_Const.EPS) | (d12<Ex2_Const.EPS && d21<Ex2_Const.EPS);
		return ans;
	}
	public double dx() {return _p2.x()-_p1.x();}
	public double dy() {return _p2.y()-_p1.y();}
	public boolean isVertical() {return dx()<Ex2_Const.EPS;}
	public boolean isHorizontal() {return dy()<Ex2_Const.EPS;}
	public boolean isPoint() {return Math.abs(dx()) + Math.abs(dy())<Ex2_Const.EPS;}
	public Point_2D intersect(Segment_2D s) {
		Point_2D ans = null;
		if(s!=null) {
			Point_2D p = lineLineIntersection(_p1, _p2, s._p1, s._p2);
			if(s.contains(p) && this.contains(p)) {ans = p;}
		}
		return ans;
	}
	@Override
	public void scale(Point_2D center, double ratio) {
		_p1.scale(center, ratio);
		_p2.scale(center, ratio);
	}
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_p1.rotate(center, angleDegrees);
		_p2.rotate(center, angleDegrees);
	}
	///////////////// Private ///////////////////
	// https://stackoverflow.com/questions/31506740/java-find-intersection-of-two-lines
	// https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
	//Given three collinear points p, q, r, the function checks if
	//point q lies on line segment 'pr'

	// Java Implementation. To find the point of
	// intersection of two lines
	 
	// Class used to  used to store the X and Y
	// coordinates of a point respectively
	
	    static Point_2D lineLineIntersection(Point_2D A, Point_2D B, Point_2D C, Point_2D D)
	    {
	        // Line AB represented as a1x + b1y = c1
	        double a1 = B.y() - A.y();
	        double b1 = A.x() - B.x();
	        double c1 = a1*(A.x()) + b1*(A.y());
	      
	        // Line CD represented as a2x + b2y = c2
	        double a2 = D.y() - C.y();
	        double b2 = C.x() - D.x();
	        double c2 = a2*(C.x())+ b2*(C.y());
	      
	        double determinant = a1*b2 - a2*b1;
	      
	        if (determinant == 0)
	        {
	            // The lines are parallel. This is simplified
	            // by returning a pair of FLT_MAX
	            return null;//new Point2D(Double.MAX_VALUE, Double.MAX_VALUE);
	        }
	        else
	        {
	            double x = (b2*c1 - b1*c2)/determinant;
	            double y = (a1*c2 - a2*c1)/determinant;
	            return new Point_2D(x, y);
	        }
	    }
}