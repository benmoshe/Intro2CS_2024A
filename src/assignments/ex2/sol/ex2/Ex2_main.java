package assignments.ex2.sol.ex2;

import assignments.ex2.sol.geo.Circle_2D;
import assignments.ex2.sol.geo.Point_2D;
import assignments.ex2.sol.geo.Rect_2D;
import assignments.ex2.sol.gui.Ex2;
import assignments.ex2.sol.gui.GUIShape;
import assignments.ex2.sol.gui.GUI_Shape;

import java.awt.*;

public class Ex2_main {

	public static void main(String[] args) {
		simpleShapes();
	}

	// Two simple GeoShapes
	public static void simpleShapes() {
		Ex2 ex2 = Ex2.getInstance();
		GUI_Shape_Collection shapes = ex2.getShape_Collection();
		Point_2D p1 = new Point_2D(3,4);
		Point_2D p2 = new Point_2D(6,8);
		Circle_2D c1 = new Circle_2D(p1,2);
		Rect_2D c2 = new Rect_2D(p2,p1);
		GUI_Shape gs1 = new GUIShape(c1, true, Color.black, 1);
		GUI_Shape gs2 = new GUIShape(c2, true, Color.yellow, 2);
		shapes.add(gs1);
		shapes.add(gs2);
		String file = "a0.txt"; //make sure the file is your working directory.
		shapes.save(file);
		shapes.removeAll();
		shapes.load(file);
		ex2.init(shapes);
		ex2.show();
	}
}
