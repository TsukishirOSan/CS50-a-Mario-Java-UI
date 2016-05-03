package com.edx;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarioUI extends JFrame {

	private static final long serialVersionUID = 1L;

	// ADDENTUM: abstract pyramid's coords' List 
	// so that the drawing method(s) can use that list regardless how
	// the UI is built ==> this is the generic list that will be used here to create a 
	// specific list(spec to this UI) fyi like the methods not created to implement the
	// UI's code (Note to self)
	
	// my attributes aka list of abstract coords, the frame and the panel(s)
	private List<MarioCoords> abstractPyramid = null;
	MarioImage imario;
	// instantiation of my controller, where the abstraction and the instantiation of the frame take place
	Mario m;
	
	// constructor. Inheritance of mother class Mario aka controller
	// the enumeration made in the comments were for me to not lose myself between classes. Bookmarks of sorts
	public MarioUI(Mario mario){
		// window aka Frame
		super();// calls same method in mother class
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Itsa Mario");
		this.m = mario;
		JPanel marioPanel = (JPanel) this.getContentPane();
		marioPanel.setLayout(new BorderLayout());
		// try/catch block to handle the validity of the user's input for the pyramid's height aka type, non neg, etc..	
		try{
			// writing it here became useless the moment I decided to use an abstraction way to compute the pyramid
			//this.setSize(1300,750);
		}catch(NullPointerException npe){
			System.err.println("not a valid input");
		}
		PanelUI myPanel = new PanelUI(this);
		// all the input and message errors are shown in and taken from the North panel
		marioPanel.add(myPanel, BorderLayout.NORTH);
		
		// this is where I output the computed pyramid as well as the specs of ths South Frame like the color i.e.
		imario = new MarioImage(this);
		marioPanel.add(imario, BorderLayout.SOUTH);
		//4. Size the frame.
		this.pack();
		//5. Show it.
		this.setVisible(true);
		// Again for debugging purposes, to be shown in the console to see if everything is still ok wrt the output
		System.out.println("south p h: "+marioPanel.getHeight()+"|w: "+ marioPanel.getWidth());
		//output pyramid
	}
	
	//fetches the coordinates' generic List
	public void computePyramid(int h){
		// m : object of type Mario , computePyramid: generic computation of the coords' List
		this.abstractPyramid = this.m.computePyramid(h);
	}
	// just a getter for the attribute abst pyr above.
	public List<MarioCoords> getGenCoordList() {
		//System.out.println(mc); Uncomment if you want to see the abstract coords
    	return this.abstractPyramid;
	}
}
