import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;



public class selfTrying extends JPanel implements ActionListener{
	static int counter = 0;
	static Random rar1 = new Random();
	static int var1 = rar1.nextInt(10);
	
	static Random rar2 = new Random();
	static int var2 = rar2.nextInt(5);
	

	Timer timer1 = new Timer(5, this); 

	static int x = 0, velX = var1;
	static int y = 0, velY = var2;
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 20, 20);
		
		g.setColor(Color.RED);
		g.fillRect(x+x, y+y, 10, 10);
		
		timer1.start();
		
	}
	
	
	public static void main(String[]args){
		selfTrying try1 = new selfTrying();
	
		JFrame jf = new JFrame();
	
		jf.setTitle("First Animation");
		jf.setSize(400, 200);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(try1);
		jf.setResizable(false);
	}


	public void actionPerformed(ActionEvent e) {
		Random rar3 = new Random();
		int var3 = rar3.nextInt(300);
		Random rar4 = new Random();
		int var4 = rar4.nextInt(180);
		
		
		x = var3;
		y = var4;
		counter++;
		if(x == 100){
			System.out.println("hi");
			System.out.println(counter);
			
		}
		
		repaint();
		
		// TODO Auto-generated method stub
		
	}


	
	
}
