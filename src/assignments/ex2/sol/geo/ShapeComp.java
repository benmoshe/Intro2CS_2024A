package assignments.ex2.sol.geo;

import assignments.ex2.sol.ex2.Ex2_Const;
import assignments.ex2.sol.gui.GUI_Shape;

import java.util.Comparator;


/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeComp implements Comparator<GUI_Shape>{
	public static final Comparator<GUI_Shape> CompByArea = new ShapeComp(Ex2_Const.Sort_By_Area);
	public static final Comparator<GUI_Shape> CompByAntiArea = new ShapeComp(Ex2_Const.Sort_By_Anti_Area);
	public static final Comparator<GUI_Shape> CompByPerimeter = new ShapeComp(Ex2_Const.Sort_By_Perimeter);
	public static final Comparator<GUI_Shape> CompByAntiPerimeter = new ShapeComp(Ex2_Const.Sort_By_Anti_Perimeter);
	public static final Comparator<GUI_Shape> CompByToString = new ShapeComp(Ex2_Const.Sort_By_toString);
	public static final Comparator<GUI_Shape> CompByAntiToString = new ShapeComp(Ex2_Const.Sort_By_Anti_toString);
	public static final Comparator<GUI_Shape> CompByTag = new ShapeComp(Ex2_Const.Sort_By_Tag);
	public static final Comparator<GUI_Shape> CompByAntiTag = new ShapeComp(Ex2_Const.Sort_By_Anti_Tag);
	
	
	private int _flag;
	public ShapeComp(int flag) {
		_flag = flag;
		
	}
	@Override
	public int compare(GUI_Shape o1, GUI_Shape o2) {
		double a1=-1, a2 = -1;
		GeoShape s1 = o1.getShape(), s2 = o2.getShape();
		int ans =0;
		if(_flag == Ex2_Const.Sort_By_Area) {
			a1 = s1.area();
			a2 = s2.area();
		}
		if(_flag == Ex2_Const.Sort_By_Anti_Area) {
			a2 = s1.area();
			a1 = s2.area();
		}
		if(_flag == Ex2_Const.Sort_By_Perimeter) {
			a1 = s1.perimeter();
			a2 = s2.perimeter();
		}
		if(_flag == Ex2_Const.Sort_By_Anti_Perimeter) {
			a2 = s1.perimeter();
			a1 = s2.perimeter();
		}
		if(_flag == Ex2_Const.Sort_By_Tag) {
			a1 = o1.getTag();
			a2 = o2.getTag();
		}
		if(_flag == Ex2_Const.Sort_By_Anti_Tag) {
			a2 = o1.getTag();
			a1 = o2.getTag();
		}
		if(a1>a2) {ans=1;}
		if(a1<a2) {ans=-1;}
		
		if(_flag == Ex2_Const.Sort_By_toString) {
			ans = o1.toString().compareTo(o2.toString());
		}
		if(_flag == Ex2_Const.Sort_By_Anti_toString) {
			ans = -o1.toString().compareTo(o2.toString());
		}
		return ans;
	}

}
