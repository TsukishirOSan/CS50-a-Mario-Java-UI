package com.edx;


// OK so I need here what here. 2 ints to be stored and returned in an object to be stored 
// in a list.
// Do I need any other class: Basically no.

public class MarioCoords{
// Allows me to create an object that holds a tuple, which here represents the x and y coords of a brick
// Reminder: Coords in CS ==> (0,0) is the top left corner
	
	private int x;
	private int y;
	
	// constructor		
	public MarioCoords(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	// especially written for the console to be able to check IRT if the coords are ok or not computed properly
	public String toString(){
		String tmp = this.getX()+"|"+this.getY();
		return tmp;
	}
}
