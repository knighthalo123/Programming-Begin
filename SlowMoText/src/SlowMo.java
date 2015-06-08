
import java.awt.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.File;
import java.awt.event.*;

import javax.swing.*;

public class SlowMo {
	File ifile = new File("text.txt");
	Scanner input;
	int str;
	typing t = new typing();
	Timer time = new Timer(10,t);
	
	private class typing implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("hi");
			try{
				input =  new Scanner(ifile);
			}catch(IOException a){
				System.out.println("Error: text.txt could not be found.");
				System.exit(1);
			}
			
			while(input.hasNext()){
				str = input.nextInt();
				System.out.println(str);
			}
		}
		
	}
	public static void main(String[]args){
		SlowMo sm = new SlowMo();
		sm.Run();
	}
	
	public void Run(){
		time.start();
	}
	
}
