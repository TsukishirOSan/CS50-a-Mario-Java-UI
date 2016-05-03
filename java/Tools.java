package com.edx;
import java.io.File;


// Constructor. Nothing much to say here, as it is only and only written to get the image to display and return
// it without issues
public class Tools {
	public static File getFileFromResource(String fileName){
    	ClassLoader classLoader = Tools.class.getClassLoader();
    	System.out.println(classLoader.getResource("mario_brick.png").getFile());
    	return new File(classLoader.getResource("mario_brick.png").getFile());
    }
}
