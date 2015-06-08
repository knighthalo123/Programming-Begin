// Stephen Hung
// February 26, 2013
// Trail.java
// This program will create a trail of (5x5) black squares using
// user input and will lighten the color each time the trail moves.

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class Trail extends JFrame{

	public static void main (String args[]) {		
		Trail t = new Trail();
		t.Run();
	}
	
	public void Run(){
		JFrame frame = new JFrame("Trail.java"); // creates JFrame
		MyPanel panel = new MyPanel(); // creates JPanel
		frame.setLocation(500,200);
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panel); // adds JPanel to JFrame
		frame.addKeyListener(panel); // adds KeyListener to JPanel
	}
}

class MyPanel extends JPanel implements KeyListener{
	
	int h,w; // height and width of JPanel divided by 2
	int r,l,b; // red green blue integers used for Color selecting
	int ArrayCounter; // a counter used to put points in the array
	int [][]array = new int[2][51]; //an array used to hold points
	boolean correcter;
	
	public MyPanel(){
		r = l = b = 255; 
		h = w = 231;
		array[0][0] = h;
		array[1][0] = w;
		ArrayCounter = 1;
	}
		
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		setBackground(Color.white);
		r = l = b = 0;
		for(int a = 0; a < 51; a++){ // draws rectangles with their respective colors
			g.setColor(new Color(r,l,b));
			g.fillRect(array[0][a],array[1][a],5,5);
			
			r = l = b+=5;
		}
		
		if(ArrayCounter == 51){ // once the counter reaches 51 change it to 0 to reset it.
			ArrayCounter = 0;
		}
	}
	
	public void keyPressed(KeyEvent e){

		char c = e.getKeyChar(); // gets keypressed
		correcter = true;
			switch(c){
				case 'w' : 
					w-=5; // move up 5 pixels
					array[0][ArrayCounter] = h;
					array[1][ArrayCounter] = w;
					repaint();
				break;
				
				case 'x' : 
					w+=5;
					array[0][ArrayCounter] = h;
					array[1][ArrayCounter] = w;
					repaint();
				break;
				
				case 'q' : 
					w-=5;
					h-=5;
					array[0][ArrayCounter] = h;
					array[1][ArrayCounter] = w;
					repaint();
				break;
				
				case 'e' : 
					w-=5;
					h+=5;
					array[0][ArrayCounter] = h;
					array[1][ArrayCounter] = w;
					repaint();
				break;
				
				case 'z' :
					 w+=5;
					 h-=5;
					 array[0][ArrayCounter] = h;
					array[1][ArrayCounter] = w;
					repaint();
				break;
				
				case 'c' :
					w+=5;
					h+=5;
					array[0][ArrayCounter] = h;
					array[1][ArrayCounter] = w;
					repaint();
				break;
				
				case 'a' : 
					h-=5;
					array[0][ArrayCounter] = h;
					array[1][ArrayCounter] = w;
					repaint();
				break;
				
				case 'd' :
					h+=5;
					array[0][ArrayCounter] = h;
					array[1][ArrayCounter] = w;
					repaint();
				break;
				default: 
					correcter = false;
					break;
			}
	
	}
	
	public void keyReleased(KeyEvent e){
		
		if(correcter){
			ArrayCounter++; // increments ArrayCounter by 1
		}
		repaint(); // calls paintComponent
	}
	
	public void keyTyped(KeyEvent e){
	}
}