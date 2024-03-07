package assignments.ex2.sol.gui;

import assignments.ex2.sol.ex2.GUI_Shape_Collection;

/**
 * This interface represents a simple GUI drawer which uses StdDraw to draw a gui_shape_collection. 
 *  Ex2: you should NOT change this interface!
 * @author boaz.benmoshe
 */
public interface Ex2_GUI {
	public void init(GUI_Shape_Collection g);
	public GUI_Shape_Collection getShape_Collection();
	public void show();
	public String getInfo();
}
