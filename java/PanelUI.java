package com.edx;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelUI extends JPanel {
	

	private static final long serialVersionUID = 1L;
	
	// attribute of my panel class: the height of the pyramid both as an integer once parsed and
	// as a string when I first get my hands on the user's input, and the Frame as well
	int h;
	String inpt;
	
	MarioUI parent;
	
	public PanelUI(MarioUI parent){
		super();//calls mother class
		this.parent = parent;
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel height = new JLabel("Enter a valid Height: ");
		JTextField input = new JTextField();
		JLabel message = new JLabel();
		message.setPreferredSize(new Dimension(150, 25));
		message.setForeground(Color.RED);
		message.setText("Not a valid input!");
		message.setVisible(false);
		input.setPreferredSize(new Dimension(50, 25));
		
		JButton ok = new JButton("OK");
		// everything that happens once the button ok is pressed is handled here: wrong type of input, etc...
		ok.addActionListener(new ActionListener() {
			
			// java overrride method needed to handle action events
			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				// add the outputPyramid  here (?)
				String action = ae.getActionCommand();
				if(action == "OK")
				{
					//outputPyramid
					try{
						message.setVisible(false);
						inpt = input.getText();
    	   				h = Integer.parseInt(inpt,10);
    	   			}
					catch(NumberFormatException num)
					{
						// output the error message in the console in case the Jwindow crashes
						System.err.println("not a valid input");
					}
					if(h < 0 || h > 17){ // not 20 not 23 since the size of the png is to big for a height > 19
						System.err.println("not a valid input");
						message.setVisible(true);
					}else{
						parent.computePyramid(h);
					}
				}
				
				// Again, in case of Frame/Panel issue, I can still see if the Button obj is working or not
				System.out.println("Button OK works\n"+"input: "+inpt);
				//refresh JFrame MarioUI to display the pyramid
				parent.repaint();
			}
		});
		
		// Once we've taken care of all the exceptions and events, we have to add to the panel the button
		// and the textfields etc.... Here all those object are located in the NORTH panel
		this.add(height);
		this.add(input);
		this.add(message);
		this.add(ok);
	}
}

class MarioAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// Auto-generated method stub when you really don't know where to start debugging. Not the best idea, 
		// works on a small project like this one, if you know what you're looking for
		System.out.println("Hello");
	}
}
