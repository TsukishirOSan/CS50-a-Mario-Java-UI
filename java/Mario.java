package com.edx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author faiza harbi
 * @since February 2016
 * @version 1.2
 *
 */

public class Mario{
	
	@SuppressWarnings("unused")
	public static void main(String args[]) throws IOException {
		// Instantiation of the Mario frame
		MarioUI mmario = new MarioUI(new Mario());
		// initialization the height of the pyramid		
	    int h = 0;
	}

	// A method designed to compute a list of abstract coordinates(tuple of ints) returned, 
	// that can be used and reused regardless the display system.
	// coordinates would look like: (0,0) (0,1) (1,0) (1,1)...etc that will be replaced by
	// the actual UI coordinates
	public List<MarioCoords> computePyramid(int h){
	    // instanciate an ArayList containing the abcstract coords of each block of the pyramid
		// List made of objects of type MarioCoords(2 integers)
		List<MarioCoords>mc = new ArrayList<MarioCoords>();
		// looping through the y-axis
		for(int y = 0; y < h; y++)
	    {
			// looping through the x-axis coords
			//EDIT: needed to change to not get an upside down pyramid
			for(int x = 0; x < (h - y) + 1; x++)   
			{
				// adding those computed coords of MarioCoords objects in the ArrayList
				MarioCoords coords = new MarioCoords(x, y);
				mc.add(coords);
			}
	    }
		
		// This part allows to check in the console if the coords tuples are logical or if something is off
		for (MarioCoords marioCoord : mc) {
			System.out.println(marioCoord);
		}
		// this methods returns the array of tuple of abstract coords meaning there are not related
		// to the size of my frame, which is the purpose of abstraction here.
		return mc;
	}
}
