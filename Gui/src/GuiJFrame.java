import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiJFrame extends JFrame {
	private JLabel item1;
	
	public static void main(String[]args){		
		
	}
	
	public GuiJFrame(){
		super("Practice JFrame");
		setLayout(new FlowLayout());
		
		item1 = new JLabel("My first JLabel");
		item1.setToolTipText("Where is this going to be?");
		add(item1);
	}
	
}
