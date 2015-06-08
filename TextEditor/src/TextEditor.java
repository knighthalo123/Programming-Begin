import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor {
	JFrame newWindow;
	JTextArea output;
	
	public static void main(String[]args){
		TextEditor te = new TextEditor();
		te.run();
	}
	
	
	public void run(){
		createWindow();
	}

	public void createWindow(){
		int windowHeight = 400;
		int windowLength = 400;
		newWindow = new JFrame("Notepad");
		newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TextEditor tee = new TextEditor();
		newWindow.setJMenuBar(tee.addBar());
		newWindow.setContentPane(tee.createContentPane());
		
		newWindow.setBounds(100,100,windowLength,windowHeight);
		newWindow.setVisible(true);
	}
	
	public JMenuBar addBar(){
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem item = new JMenuItem("Save", KeyEvent.VK_T);
		
		menu.add(item);
		menuBar.add(menu);
		
		return menuBar;
	}
	
	public Container createContentPane() {
		JPanel contentPane = new JPanel(new BorderLayout());
		
		
		
		output = new JTextArea(5,10);
		output.setEditable(true);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		contentPane.setOpaque(true);
		
		JButton button = new JButton("Calculate Price");
		button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                //
	                // Get the contents of the JTextArea component.
	                //
	                String contents = output.getText();
	                double temp = Double.parseDouble(contents);
	                temp = calculateProfit(temp);
	                output.setText(Double.toString(temp));
	            }
	        });

		contentPane.add(output,BorderLayout.CENTER);
		contentPane.add(button,BorderLayout.SOUTH);
		
		return contentPane;
	}
	
	
	
	
	
	public double calculateProfit(double one){
		double initialprice = one;
		
		initialprice *= .85;
		initialprice -= 2.5;
		
		return initialprice;
	}
	
	
}
