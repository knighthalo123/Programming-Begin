import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Words extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea text;
	
	public static void main(String[]args){
		new Words().setVisible(true);
	}
	
	private Words() {
		super ("Words");
		setSize(600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initialize();
		
	}
	private void initialize (){
		text = new JTextArea();
		JScrollPane scroll = new JScrollPane(text);
		
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");

		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem saveas = new JMenuItem("Save as");
		JMenuItem exit = new JMenuItem("Exit");
		
		JMenuItem[] items = { open, save, saveas, exit };
		for(JMenuItem item : items) {
			item.addActionListener(this);
			
		}
	
		
		file.add(open);
		file.add(save);
		file.add(saveas);
		file.addSeparator();
		file.add(exit);
		
		
		bar.add(file);
		
		add (scroll);
		setJMenuBar(bar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Open")){
			open();
		} else if (e.getActionCommand().equals("Save")){
			save();
		} else if (e.getActionCommand().equals("Save as")){
			save();
		} else if (e.getActionCommand().equals("Exit")){
			System.exit(0);
		}
		
	}
	private void open() {
		try {
			BufferedReader br = new BufferedReader (new FileReader("file.txt"));
			
			String line;
			while ((line = br.readLine()) !=null){
				text.append(line + "\n");
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void save() {
		try {
		BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
			
		bw.write(text.getText());
		
		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}