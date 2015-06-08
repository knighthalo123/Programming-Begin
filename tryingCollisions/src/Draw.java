import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;

	
public class Draw extends JFrame{
	private Image dbImage;
	private Graphics dbGraphics;
	static int var1;
	static int var2;
	int x, y;
	// up here so we can update it
		public class AL extends KeyAdapter{
			public void keyPressed(KeyEvent e){
				int keyCode = e.getKeyCode();
				// whenever user presses key, it automatically runs this method
				// then it gets the key that the user pressed
				
				if(keyCode == e.VK_LEFT)
				// VK_key is a key code.
				{
					if(x<= 0 || x==var1){
						x = 20;
					}
					else
					x+= -5;
				}

				if(keyCode == e.VK_RIGHT){
					if(x>=500 || x==var1){
						x = 450;
					}
					else
						
					x+= 5;
				}

				if(keyCode == e.VK_UP){
					if(y<=0 || y==var2){
						y = 20;
					}else
					
					y+= -5;
				}

				if(keyCode == e.VK_DOWN){
					if(y>=500 || y == var2){
						y = 450;
					}else
					y+= 5;
				}
				
			}
			
			public void keyReleased(KeyEvent e){
				
			}
		}
	
	
	public Draw(){
		addKeyListener(new AL());
		// adds the class we created
		
		setTitle("Trying to make a game");
		// makes title
		setSize(500,500);
		// makes size
		setResizable(false);
		// set if the window is resizeable
		setVisible(true);
		// sets the window so that it is visible 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		x = 150;
		y= 150;
		
	}
	
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbGraphics = dbImage.getGraphics();
		paintComponent(dbGraphics);
		g.drawImage(dbImage, 0, 0, this);		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		
		g.drawOval(x,y,20,20);
		
		Random rar1 = new Random();
		var1 = rar1.nextInt(100);
		Random rar2 = new Random();
		var2 = rar2.nextInt(100);
		
		g.drawRect(var1, var2, 100,100);
		
		
		
		repaint();
	}
	
	
	public static void main(String[]args){
		new Draw();
		
	}

}