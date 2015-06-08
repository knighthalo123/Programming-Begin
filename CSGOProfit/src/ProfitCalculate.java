import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProfitCalculate {
	JFrame newWindow;
	JTextArea output,keys;
	
	public static void main(String[]args) throws IOException{
		ProfitCalculate te = new ProfitCalculate();
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
		
		ProfitCalculate tee = new ProfitCalculate();
		newWindow.setContentPane(tee.createContentPane());
		
		newWindow.setBounds(100,100,windowLength,windowHeight);
		newWindow.setVisible(true);
	}
	
	public Container createContentPane() {
		BorderLayout bl = new BorderLayout();
		JPanel contentPane = new JPanel(bl);
		
		keys = new JTextArea(5,10);
		output = new JTextArea(5,10);
		output.setText("Enter price");
		output.setEditable(true);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		keys.setText("Enter # of keys");
		keys.setEditable(true);
		keys.setLineWrap(true);
		keys.setWrapStyleWord(true);
		contentPane.setOpaque(true);
		
		JButton button = new JButton("Calculate Price");
		button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                //
	                // Get the contents of the JTextArea component.
	                //
	                String contents = output.getText();
	                String key = keys.getText();
	                double tempKey = Double.parseDouble(key);
	                double temp = Double.parseDouble(contents);
	                temp = calculateProfit(temp,tempKey);
	                output.setText(Double.toString(temp));
	            }
	        });

		contentPane.add(output,bl.CENTER);
		contentPane.add(keys,bl.NORTH);
		contentPane.add(button,bl.SOUTH);
		bl.setVgap(5);
		
		return contentPane;
	}
	
	public void grabSite() throws IOException{ // Grabs URL of each website.
	
		String url = "http://www.reddit.com/r/GlobalOffensiveTrade/search?sort=new&restrict_sr=on&q=flair%3AStore";
		print("Fetching links from %s....",url);
		
        Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("a[href]");
		print("\nLinks: (%d)", links.size());
        for (Element link : links) {
        	if(link.text().contains("[")){
        		String outerHtml = link.outerHtml(); // gets link's outerHtml
        		String firstPart = outerHtml.substring(outerHtml.indexOf("href")+6); // finds first part of url
        		int secondIndex = firstPart.indexOf('"',1)+1; // indexs of url's end.
        		String finalUrl = firstPart.substring(0,secondIndex); //url of each [store]
        		printSite(finalUrl); // pass URL to print out the site.
        	}
        }
	}
	
	public void printSite(String url) throws IOException{ // ??? Do something to get reddit submitted text
		Document doc = Jsoup.connect("http://www.reddit.com" + url).get();
		Elements links = doc.select("p");
		String fullText = links.text();
		
		
	}
	
	
    private static void print(String msg, Object... args) {
		System.out.println(String.format(msg,args));
	}
	
	
	public double calculateProfit(double one, double key){
		double initialprice = one;
		
		initialprice *= .85;
		System.out.println(initialprice);
		key *=2.5;
		System.out.println(key);
		initialprice -= key;
		
		return initialprice;
	}
	
	
}
