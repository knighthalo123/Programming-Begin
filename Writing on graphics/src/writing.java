import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;




public class writing extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public writing (){
		
		setTitle("Hello World");
		setSize(200,100);
		setResizable(false);
		setVisible(true);
	}
		
		
		public void paint (Graphics g){
			
			g.clearRect(0, 0, getWidth(), getHeight());
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.blue);
			g.drawString("Hello World", 50, 50);
			
					
		
	
	
	
}
		public static void main(String[]args){
			new writing();
			
		}

}
