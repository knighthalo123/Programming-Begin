import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;



public class Shooter extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Shooter() {
		
		setTitle("2d Shooter game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(600,400);
		
		
		setVisible(true);
	}
	
	public void paint (Graphics g){
		g.clearRect(0, 0, getWidth(), getHeight());
		
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.white);
		g.drawString("Tutorial", 50, 50);
		g.drawString("Hi my name is Stephen", 100, 100);
		g.drawRect(100, 100, 200, 200);
		g.fillRect(100, 100, 100, 50);

	}
	
	
	public static void main(String[]args){
		
		
		new Shooter();
	}
	
	
	
	
		
		
}