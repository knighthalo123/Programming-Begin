import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class box extends JPanel{
	private Image dbImage;
	private Graphics dbGraphics;
	int x = 0,y = 0;
	
	/*public void box(){
		setTitle("Its a Box");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		
		
	}
	*/
	
/*
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbGraphics = dbImage.getGraphics();
		paintComponent(dbGraphics);
		g.drawImage(dbImage, 0, 0, this);		
	}
	
	*/
	public void paintComponent(Graphics g){
		
		super.paintComponents(g);
		
		Random object = new Random();
		x = object.nextInt(400);
		
		y = object.nextInt(400);
		
		g.setColor(Color.blue);
		g.fillRect(x,y,20,10);
		
		
		x = 50 + object.nextInt(400);
		y = 100 +object.nextInt(400);
		g.setColor(Color.red);
		g.fillRect(x,y,20,10);
		
		
		
		repaint();
	}
	
	public static void main(String[]args){
		JFrame jf = new JFrame();
		box draw = new box();
		
		
		jf.setTitle("Its a box");
		jf.setSize(500,500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.add(draw);
		
		
	}
}
