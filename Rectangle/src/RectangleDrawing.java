import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectangleDrawing extends JApplet {
	public void init() {
		DisplayBox display = new DisplayBox();
		setContentPane(display);
	}
}

class DisplayBox extends JPanel {
	DisplayBox() {
		setBackground(Color.red);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
           	g.setColor(Color.green);
           	g.fillRect (10,130, 80, 140);
           	g.setColor(Color.black);
           	g.drawString("Java is Fun", 15 , 85);
	}
}
