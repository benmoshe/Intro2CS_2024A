package assignments.ex2.sol.geo;
import assignments.ex2.sol.ex2.Ex2_Const;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: This implementation uses a straight forward approach - without extending from Polygon.
 * The Triangle area is computed using Heron's formula (as in: https://en.wikipedia.org/wiki/Heron%27s_formula)
 * The Triangle contains a point is implemented using a 3 sub-triangles area computation
 * Other mothods from GeoShape are implemented in a rather straight forward manner.
 * @author I2CS
 *
 */
public class Triangle_2D_simp implements GeoShape{
	private Point_2D[] _ps;
	public Triangle_2D_simp(Point_2D p1, Point_2D p2, Point_2D p3) {
		_ps = new Point_2D[3];
		_ps[0]=new Point_2D(p1);
		_ps[1]=new Point_2D(p2);
		_ps[2]=new Point_2D(p3);
	}
	public Triangle_2D_simp(Triangle_2D_simp t1) {
		this(t1._ps[0], t1._ps[1], t1._ps[2]);
	}

	/**
	 * This method is computing the PointInSide relation using the area method.
	 * Given a Point (ot) this triangle area is compared with the sum area of the 3 sub triangles (i.e., a,b,ot,  a,c,ot, b,c,ot),
	 * ot is within this triangle iff the sum area of the 3 sub triangles is lower than the area of this triangle + EPS.
	 * @param ot - a query 2D point
	 * @return
	 */
	@Override
	public boolean contains(Point_2D ot) {
		boolean ans = false;
		double area = this.area(), a1=0;
		for(int i=0;i<_ps.length;i=i+1) {
			int i1 = (i+1)%3;
			Triangle_2D_simp t = new Triangle_2D_simp(_ps[i], _ps[i1], ot);
			a1+=t.area();
		}
		double da = a1-area;
		ans = da<Ex2_Const.EPS; // ZZZZ should be a Constant class;
		return ans;
	}

	public Point_2D[] getAllPoints() {
		Point_2D[] ans  = new Point_2D[3];
		ans[0]=new Point_2D(_ps[0]);
		ans[1]=new Point_2D(_ps[1]);
		ans[2]=new Point_2D(_ps[2]);
		return ans;
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 */
	@Override
	public double area() {
		double d = this.perimeter()/2;
		double ans = d;
		for(int i=0;i<_ps.length;i=i+1) {
			int i1 = (i+1)%3;
			double abc = _ps[i].distance(_ps[i1]);
			ans *= (d-abc);
		}
		return Math.sqrt(ans);
	}

	@Override
	public double perimeter() {
		double ans = 0;
		for(int i=0;i<_ps.length;i=i+1) {
			int i1 = (i+1)%3;
			double d = _ps[i].distance(_ps[i1]);
			ans += d;
		}
		return ans;
	}

	@Override
	public void translate(Point_2D vec) {
		for(int i=0;i<_ps.length;i=i+1) {
			_ps[i].move(vec);
		}
	}

	@Override
	public GeoShape copy() {
		return new Triangle_2D_simp(_ps[0], _ps[1], _ps[2]);
	}


	@Override
	public String toString() {
		String ans = "";//
		for(int i=0;i<_ps.length;i=i+1) {
			ans += _ps[i].toString();
			if(i<2) {ans+=",";}
		}
		return ans;
	}
	@Override 
	public boolean equals(Object t) {
		if(t==null || !(t instanceof Triangle_2D_simp)) {return false;}
		Triangle_2D_simp ot = (Triangle_2D_simp)t;
		boolean ans = true;
		for(int i=0;i<3 & ans;i=i+1) {
			if(this.minNodeDist(ot._ps[i])>Ex2_Const.EPS) {
				ans = false;
			}
		}
		return ans;
	}
	private double minNodeDist(Point_2D p) {
		double ans = Double.MAX_VALUE;
		for(int i=0;i<3;i=i+1) {
			double d1 = this._ps[i].distance(p);
			if (d1<ans) {ans = d1;}
		}
		return ans;
	}
	@Override
	public void scale(Point_2D center, double ratio) {
		for(int i=0;i<this._ps.length;i++) {
			_ps[i].scale(center, ratio);
		}
		
	}
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		for(int i=0;i<this._ps.length;i++) {
			_ps[i].rotate(center, angleDegrees);
		}
	}
}
