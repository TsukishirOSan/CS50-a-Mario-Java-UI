package com.edx;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

// Everything that happens within tmy panel is being taken care of here
public class MarioImage extends JPanel{
    
    /**
	 * 
	 */
	 
	private static final long serialVersionUID = 1L;
	
	// I need my Mario Frame where my panels are  
    private MarioUI imario;
    // Need my image
	private BufferedImage image;
	// personalization of the background color of the South Panel
	private Color SKY = new Color(129,218,245);
    
	// Constructor inherits MarioUI aka JFrame(nothing unusal: Panels are "inside" the frame") 
	public MarioImage(MarioUI parent) {
		// call to the parent class
       	super();
       	this.imario = parent;
    	this.setBackground(SKY);
    	this.setPreferredSize(new Dimension(1000,700));
        // try/catch block handles getting the jpg file as well as its potential going wrong situations
    	try {             
    	   File image2 = Tools.getFileFromResource("mario_brick.png");
    	   
    	   if(image2 == null){
    		   System.out.println("Image not found");
    	   }
    	   image = ImageIO.read(image2);
    	   //width if my image = 33
    	   //height of my image = 35 ==> No specific need apart from me deciding the margins left
    	   // around the pyramid
    	   
		} catch (IOException ex) {
            // handle exception
    	   System.err.println("image not found or not displayed");
		}
    }
 
    // getting SOUTH Panel width and height and the .png width and height to implement 
	// the list of coordinates as for where to "draw" the brick

	private void drawPyramid(Graphics g){
		// -70 not to get stuck to the borders
		int pmax_width = this.getWidth() - 70;
		int pmax_height = this.getHeight() - 70;
		// getting the png width and height
		int brick_w = image.getWidth(null);
		int brick_h = image.getHeight(null);
		// to store the actual coordinates to display each .png accordingly
		int real_x, real_y; 
		// get the abstract coords and put them in the MarioImage List to avoid NullPointerEx
		List<MarioCoords>mc = this.imario.getGenCoordList();
		
		if(null != mc){
			for (MarioCoords marioCoords : mc) {
				//(0,0) being top left corner, computing the actual coords in the JPanel
				real_y = pmax_height - brick_h - (marioCoords.getY() * brick_h);
				real_x = pmax_width - brick_w - (marioCoords.getX() * brick_w);
				// apply the compututation to the image, draw it within the panel
				g.drawImage(image, real_x, real_y, null);
			}
		}
	}
	
	// Java specificity requires to call this override method to be able to use Graphic object and methods
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPyramid(g);
    }
}
