package assignments.ex2.sol.ex2;

import assignments.ex2.sol.geo.*;
import assignments.ex2.sol.gui.GUIShape;
import assignments.ex2.sol.gui.GUI_Shape;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Shape_Collection implements GUI_Shape_Collection {
	private ArrayList<GUI_Shape> _shapes;
	
	public Shape_Collection() {
		_shapes = new ArrayList<GUI_Shape>();
	}
	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		return _shapes.remove(i);
	}

	@Override
	public void addAt(GUI_Shape s, int i) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(i, s);
		}
	}
	@Override
	public void add(GUI_Shape s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}
	@Override
	public GUI_Shape_Collection copy() {
		GUI_Shape_Collection ans = new Shape_Collection();
		for(int i=0;i<this.size();i++) {
			GUI_Shape s = this.get(i).copy();
			ans.addAt(s, i);
		}
		return ans;
	}

	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		_shapes.sort(comp);
	}

	@Override
	public void removeAll() {
		_shapes.clear();
	}

	@Override
	public void save(String file) {
		 try {
		      FileWriter myWriter = new FileWriter(file);
		      for(int i=0;i<size();i=i+1) {
		    	  GUI_Shape g = get(i);
				  GeoShape g0 = g.getShape();
				  if(g0 instanceof Rect_2D && !((Rect_2D)g0).isIs_asix_parallel()) {
					  g.setShape(g0.copy());
				  }
		    	  myWriter.write(g.toString()+"\n");
		      }
		      myWriter.close();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
	 }		
	}

	@Override
	public void load(String file) {
		try {
		     File myObj = new File(file);
		      Scanner myReader = new Scanner(myObj);
		      this._shapes.clear();
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        GUI_Shape g = new GUIShape(data);
		        this._shapes.add(g);
		      }
		      myReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}
	@Override
	public boolean equals(Object p) {
		if (p == null || !(p instanceof Shape_Collection)) {
			return false;
		}
		Shape_Collection p2 = (Shape_Collection) p;
		return (this.contains(p2) && p2.contains(this));
	}

	/**
	 * This Polygon contains another Polygon (p) iff, every point in p is containd with in
	 *
	 * @param p
	 * @return
	 */
	public boolean contains(GUI_Shape_Collection p) {
		boolean ans = true;
		if (p == null || size() != p.size()) {
			ans = false;
		} else {
			for (int i = 0; i < p.size(); i = i + 1) {
				ans &= this.contains(p.get(i));
			}
		}
		return ans;
	}

	private boolean contains(GUI_Shape guiShape) {
		return this._shapes.contains(guiShape);
	}

}
