import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.KeyStroke;

import javax.swing.*;

public class tryingAnimation extends JPanel implements ActionListener{
	// extend jpanel, because jpanel has more things than jframe
	
	
	// action listener is an interface, which is why we use implement, extend is
	// for classes.
	
	// timer method is gui version of sleep method
	
	Timer tm = new Timer(5, this);
	// 5 = 5 milliseconds, this referres to action listener
	
	//int x represents position horizontally, velX represents speed of moving 
	// rectangle
	int x = 0, velX = 2;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		//sets color of rectangle
		g.fillRect(x, 30, 50, 50);
		// u can use fillRect instead of drawRect then fillRect, to make 
		// a rectangle
		
		//(x,y,a,b)
		// x and y is the position of the rectangle
		// a and b is the size of the rectangle
		
		tm.start();
		// tm.start starts the timer
	}
	
	public static void main(String[]args){
		tryingAnimation try1 = new tryingAnimation();
		// creates an object called try1 of the class tryingAnimation
		
		JFrame jf = new JFrame();
		// makes object for JFrame, because we extended it.
		
		jf.setTitle("Practicing for Animation");
		// set Title sets title.
		jf.setSize(600,400);
		// sets size of x of 600 and y of 400
		jf.setVisible(true);
		// sets frame visible
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// exits program when closing
		jf.add(try1);
		// adds jpanel class onto frame
		
		
	}

	public void actionPerformed(ActionEvent e) {
		
		
		// action event e is a variable called e, that is an action event.
		x = x + velX;
		// since x is 0, the x + 2(speed) means 2, meaning it moves the x to 2.
		// which moves the rectangle to x of 2.(moves right)
		if(x<500){
			repaint();
		}
		else{
			
		}
		//repaints rectangle every 5 milliseconds.
		
	}
}
