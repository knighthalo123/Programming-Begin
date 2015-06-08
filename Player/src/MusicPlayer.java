import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class MusicPlayer extends JFrame{
	private JFrame musicFrame;
	private playOptions play = new playOptions();
	
	public static void main(String[]args){
		MusicPlayer mp = new MusicPlayer();
		mp.createFrame();
	}
	
	public void createFrame(){
		musicFrame = new JFrame("Music Player v.1");
		musicFrame.setLocation(100,50);
		musicFrame.setSize(500,500);
		
		musicFrame.add(play);		
		musicFrame.setVisible(true);
	}	
	
}


class playOptions extends JPanel implements ActionListener{
	
	private JButton play,stop,pause;
	
	public void getFiles(){
		File folder = new File("/folder");
		File[] listOfFiles = folder.listFiles();
		
		for(File a : listOfFiles){
			if(a.isFile()){
				System.out.println(a.getName());
			}
		}
		
	}
	
	public playOptions(){
		play = new JButton("Play");
		stop = new JButton("Stop");
		pause = new JButton("Pause");
		
		play.addActionListener(this);
		stop.addActionListener(this);
		pause.addActionListener(this);
		
		add(play);
		add(stop);
		add(pause);
		getFiles();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		play.setBounds(0,getHeight()-getHeight()/3,getWidth()/3,getHeight()/3);
		stop.setBounds(getWidth()/3,getHeight()-getHeight()/3,getWidth()/3,getHeight()/3);
		pause.setBounds(getWidth()/3*2,getHeight()-getHeight()/3,getWidth()/3,getHeight()/3);
	}
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == play){
			
		}else if(e.getSource() == stop){
			
		}else if(e.getSource() == pause){
			
		}
	}
	
	
}
