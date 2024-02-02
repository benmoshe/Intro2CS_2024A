package assignments.ex2.gui;

import assignments.ex2.ex2.GUI_Shape_Collection;

/**
 * This interface represents a simple GUI drawer which uses StdDraw to draw a gui_shape_collection. 
 *  Ex2: you should NOT change this interface!
 * @author boaz.benmoshe
 */
public interface Ex2_GUI {
	/**
	 * Inits this object with the GUI_Shapes/
	 * @param g a GUI collection of shapes/
	 */
	public void init(GUI_Shape_Collection g);
	public GUI_Shape_Collection getShape_Collection();

	/**
	 * Draws the shapes in the GUI window
	 */
	public void show();
	/** return a String with all the info (the toStrings) of the selected shapes. */
	public String getInfo();
}
