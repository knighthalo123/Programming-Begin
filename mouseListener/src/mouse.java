import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mouse {

  public static void main(String[] args) {
    JFrame aWindow = new JFrame();
    aWindow.setBounds(200, 200, 500, 500);
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container content = aWindow.getContentPane();
    content.add(new MouseMotionEvents());
    aWindow.setVisible(true);
  }
}

class MouseMotionEvents extends JPanel implements MouseListener,
   

MouseMotionListener {
  Point p;
  private Image dbImage;
  private Graphics dbGraphics;

  public MouseMotionEvents() {
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void mouseClicked(MouseEvent me) {
	  repaint();
  }

  public void mouseEntered(MouseEvent me) {
  }

  public void mouseExited(MouseEvent me) {
  }

  public void mousePressed(MouseEvent me) {
    p = me.getPoint();
    repaint();
  }

  public void mouseReleased(MouseEvent me) {
    p = null;
    repaint();
  }

  public void mouseDragged(MouseEvent me) {
    p = me.getPoint();
    repaint();
  }

  public void mouseMoved(MouseEvent me) {
  }


	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbGraphics = dbImage.getGraphics();
		paintComponent(dbGraphics);
		g.drawImage(dbImage, 0, 0, this);		
	}
	
  
  public void paintComponent(Graphics g) {
    if (p != null) {
      Dimension d = getSize();
      int xc = (int) p.getX() - 50;
      int yc = (int) p.getY() - 50;
     
      g.drawRect(200,200,50,50);
      
      g.setColor(Color.red);
      g.fillRect(xc, yc, 100, 100);
      
    }
  }
}