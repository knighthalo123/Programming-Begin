import java.awt.Graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;



public class tryingKey extends JFrame{

	int x, y;
		


	
	public void tryingKey(){
		
		addKeyListener(new AL());

		setTitle("Trying key events");
		setSize(500,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void paint(Graphics g){
		g.drawRect(x,y,100,100);

		repaint();
	}
	
	
	public static void main(String[]args){
		new tryingKey();
				
	}
	
	public class AL extends KeyAdapter{		
		public void keyPressed(KeyEvent e){
		
				int keyCode = e.getKeyCode();
				
				if(keyCode == e.VK_A){
					x--;
					}
				
				if(keyCode == e.VK_D){
					x++;
				}	
		}
		
		public void keyReleased(KeyEvent e){
			
			}
		}
	
	
}
