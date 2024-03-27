package assignments.ex3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a 2D map as a "screen" or a raster matrix or maze over integers.
 * @author boaz.benmoshe
 *
 */
public class Map implements Map2D, Serializable{
	private int[][] _map;
	private boolean _cyclicFlag = true;
	public static final int init1 = -1, init2 = -2;
	
	/**
	 * Constructs a w*h 2D raster map with an init value v.
	 * @param w
	 * @param h
	 * @param v
	 */
	public Map(int w, int h, int v) {init(w,h, v);}
	/**
	 * Constructs a square map (size*size).
	 * @param size
	 */
	public Map(int size) {this(size,size, 0);}
	
	/**
	 * Constructs a map from a given 2D array.
	 * @param data
	 */
	public Map(int[][] data) {
		init(data);
	}
	@Override
	public void init(int w, int h, int v) {
		// add you code here

		////////////////////
	}
	@Override
	public void init(int[][] arr) {
		// add you code here

		////////////////////
	}
	@Override
	public int[][] getMap() {
		int[][] ans = null;
		// add you code here

		////////////////////
		return ans;
	}
	@Override
	public int getWidth() {return _map.length;}
	@Override
	public int getHeight() {return _map[0].length;}
	@Override
	public int getPixel(int x, int y) { return _map[x][y];}
	@Override
	public int getPixel(Pixel2D p) {
		return this.getPixel(p.getX(),p.getY());
	}
	@Override
	public void setPixel(int x, int y, int v) {_map[x][y] = v;}
	@Override
	public void setPixel(Pixel2D p, int v) {
		setPixel(p.getX(), p.getY(), v);
	}


	@Override
	/** 
	 * Fills this map with the new color (new_v) starting from p.
	 * https://en.wikipedia.org/wiki/Flood_fill
	 */
	public int fill(Pixel2D xy, int new_v) {
		int ans = -1;
		// add you code here

		////////////////////
		return ans;
	}


	/**
	 * Computes the distance of the shortest path (minimal number of consecutive neighbors) from p1 to p2.
	 * Notes: the distance is using computing the shortest path and returns its length-1, as the distance fro  a point
	 * to itself is 0, while the path contains a single point.
	 
	 */
	public int shortestPathDist(Pixel2D p1, Pixel2D p2, int obsColor) {
		int ans = -1;
		// add you code here

		////////////////////
		return ans;
	}
	@Override
	/**
	 * BFS like shortest the computation based on iterative raster implementation of BFS, see:
	 * https://en.wikipedia.org/wiki/Breadth-first_search
	 */
	public Pixel2D[] shortestPath(Pixel2D p1, Pixel2D p2, int obsColor) {
		Pixel2D[] ans = null;  // the result.
		// add you code here

		////////////////////
		return ans;
	}

	@Override
	public Pixel2D[] shortestPath(Pixel2D[] points, int obsColor) {
		Pixel2D[] ans = null;
		// add you code here

		////////////////////
		return ans;
	}

	@Override
	public boolean isInside(Pixel2D p) {
		return isInside(p.getX(),p.getY());
	}

	@Override
	public boolean isCyclic() {
		return _cyclicFlag;
	}

	@Override
	public void setCyclic(boolean cy) {
		_cyclicFlag = cy;
	}

	private boolean isInside(int x, int y) {
		return x>=0 && y>=0 && x<this.getWidth() && y<this.getHeight();
	}
	@Override
	public Map2D allDistance(Pixel2D start, int obsColor) {
		Map2D ans = null;
		// add you code here
		ans = new Map(this.getMap());
		ans.init(this.getWidth(), this.getHeight(), init1);
		if(this.getPixel(start)!=obsColor) {
			ans.setPixel(start,0);
			allDistance(ans, 0, obsColor);
		}
		////////////////////
		return ans;
	}
	private void allDistance(Map2D map, int rad, int obs) {
		boolean cont = true;
		while(cont) {
			cont = false;
			for(int y=0;y<map.getHeight();y=y+1) {
				for(int x=0;y<map.getWidth();x=x+1) {
					if(map.getPixel(x,y)==rad) {
						Pixel2D up = new Index2D(x,y+1);
						if(map.isCyclic()) {
							up = new Index2D(x,(y+1)%map.getHeight() );
						}
						if(map.isInside(up) && map.getPixel(up)==init1) {
							map.setPixel(up, rad+1);
							cont = true;
						}
					}
				}
			}
			rad +=1;
		}
	}
	@Override
	public int numberOfConnectedComponents(int obsColor) {
		int ans = -1;
		// add you code here

		////////////////////
		return ans;
	}

	@Override
	public boolean equals(Object ob) {
		boolean ans = false;
		// add you code here

		////////////////////
		return ans;
	}
	////////////////////// Private Methods ///////////////////////
	// add you code here

	////////////////////

}
