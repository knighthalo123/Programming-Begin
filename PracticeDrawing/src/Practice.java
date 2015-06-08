import java.awt.*;
import javax.swing.*;


public class Practice extends JFrame{
	JFrame frame;
	Drawing panel;
	public static void main(String[]args){
		Practice p = new Practice();
		p.Run();
	}
	
	public void Run(){
		frame = new JFrame("Practicing JFrames");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new Drawing();
		frame.add(panel,BorderLayout.CENTER);
		
		frame.setBackground(Color.white);
		frame.setSize(500,500);
		frame.setLocation(100,100);
		frame.setVisible(true);
	}
	
}

class Drawing extends JPanel{
	
	public static void main(String[]args){
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
	}
}
