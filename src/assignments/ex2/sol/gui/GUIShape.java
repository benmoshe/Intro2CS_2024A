package assignments.ex2.sol.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 * @author I2CS
 */

import assignments.ex2.sol.geo.*;

import java.awt.*;


public class GUIShape implements GUI_Shape{
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;
	
	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}
	public GUIShape(String s) {
		String[] ww = s.split(",");
		int co = Integer.parseInt(ww[1]);
		_color = new Color(co);
		_fill = Boolean.parseBoolean(ww[2]);
		_tag = Integer.parseInt(ww[3]);
		init(ww);
	}
	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		int co = _color.getBlue();
		co += _color.getGreen()*256;
		co += _color.getRed()*256*256;
		String ans = ""+this.getClass().getSimpleName()+","+co+","+_fill+","+_tag+","+this._g.getClass().getSimpleName()+","+_g.toString();
		return ans;
	}
	@Override
	public boolean equals(Object c)
	{
		if(c==null || !(c instanceof GUI_Shape)) {return false;}
		GUI_Shape c2 = (GUI_Shape) c;
		boolean b1 = c2.getTag()==this.getTag();
		b1 &= c2.getColor().equals(this.getColor());
		b1 &= c2.isFilled()==this.isFilled();
		return b1 & c2.getShape().equals(((GUI_Shape) c).getShape());
	}
	private void init(String[] ww) {
	//	if(ww[4].contentEquals("Point2D")) {_g = new Point2D(ww[5]+","+ww[6]);}
		if(ww[4].contentEquals("Circle_2D")) {
			Point_2D cen = new Point_2D(ww[5]+","+ww[6]);
			double r = Double.parseDouble(ww[7]);
			_g = new Circle_2D(cen,r);}
		if(ww[4].contentEquals("Rect_2D")) {
			Point_2D m1 = new Point_2D(ww[5]+","+ww[6]);
			Point_2D m2 = new Point_2D(ww[9]+","+ww[10]);
			_g = new Rect_2D(m1,m2);}
		if(ww[4].contentEquals("Triangle_2D")) {
			Point_2D p1 = new Point_2D(ww[5]+","+ww[6]);
			Point_2D p2 = new Point_2D(ww[7]+","+ww[8]);
			Point_2D p3 = new Point_2D(ww[9]+","+ww[10]);
			_g = new Triangle_2D(p1,p2,p3);}
		if(ww[4].contentEquals("Segment_2D")) {
			Point_2D m1 = new Point_2D(ww[5]+","+ww[6]);
			Point_2D m2 = new Point_2D(ww[7]+","+ww[8]);
			_g = new Segment_2D(m1,m2);}
		if(ww[4].contentEquals("Polygon_2D")) {
			Polygon_2D gg = new Polygon_2D();
			for(int i=5;i<ww.length;i+=2) {
				Point_2D p1 = new Point_2D(ww[i]+","+ww[i+1]);
				gg.add(p1);
			}
			_g = gg;
		}
	}
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}
}
