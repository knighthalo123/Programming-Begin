import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;

public class drawRandom extends JFrame{
	
	private JLabel myItem;
	
	public static void main(String[]args){
		
	}
	
	public drawRandom(Graphics g){
		super("First JFrame");
		setLayout(new FlowLayout());
		
		myItem = new JLabel("Hi");
		myItem.setToolTipText("Hi this is a cursor");
		add(myItem);		
		
		
		
		
		
	}
	

}