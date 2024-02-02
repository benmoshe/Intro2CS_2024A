package assignments.ex2.ex2;

import assignments.ex2.geo.Circle_2D;
import assignments.ex2.geo.Point_2D;
import assignments.ex2.gui.Ex2;
import assignments.ex2.gui.GUIShape;
import assignments.ex2.gui.GUI_Shape;

import java.awt.*;

/**
 * This class is a very simple main for starting with Ex2
 * You may update this file, but do noteL your Ex2 will be run using our own "main" class
 * Make sure you test the loadDemo(); function once you have implemented it (do test the "save" as well)
 */
public class Ex2_main {

	public static void main(String[] args) {
		simpleShapes();
	//	loadDemo();
	}

	// Two simple GeoShapes
	public static void simpleShapes() {
		Ex2 ex2 = Ex2.getInstance();
		GUI_Shape_Collection shapes = ex2.getShape_Collection();
		Point_2D p1 = new Point_2D(3,4);
		Point_2D p2 = new Point_2D(6,8);
		Circle_2D c1 = new Circle_2D(p1,2);
		Circle_2D c2 = new Circle_2D(p2,3.4);
		GUI_Shape gs1 = new GUIShape(c1, true, Color.black, 1);
		GUI_Shape gs2 = new GUIShape(c2, true, Color.yellow, 2);
		shapes.add(gs1);
		shapes.add(gs2);
		ex2.init(shapes);
		ex2.show();
	}

	// Loads a file from file a1.txt.
	public static void loadDemo() {
		Ex2 ex2 = Ex2.getInstance();
		GUI_Shape_Collection shapes = ex2.getShape_Collection();
		String file = "a1.txt"; //make sure the file is your working directory.
		shapes.load(file);
		ex2.init(shapes);
		ex2.show();
	}

}
