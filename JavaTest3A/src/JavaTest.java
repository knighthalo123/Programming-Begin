// Stephen Hung
// December 5,2012
// JavaTest.java
// This program will place peas in a string and remove them randomly


import java.util.Scanner;
import java.util.Random;
public class JavaTest {
Scanner input = new Scanner(System.in);
Random r = new Random();
String phrase,phraseafterpeas;
char letter, newletter;
int index, replaceindex, counter, newindex;

	public static void main(String[]args){
		JavaTest j = new JavaTest();
		j.GetInfo();
		j.PeaInserter();
		j.PeaDeinserter();
	}
	
	public void GetInfo(){
		System.out.print("Please enter what the plate was like before it had peas: ");
		phrase = input.nextLine();
		System.out.println("beginning String: " + phrase);
	}
	
	public void PeaInserter(){
		System.out.println("running peainserter");
		System.out.println("phrase.length() = " + phrase.length() );
		for(int i = 0; i<10; i++){
			do{
				index = r.nextInt(phrase.length());
			}while(index <= 0 || index > (phrase.length() - 1) || phrase.charAt(index) == '*');
			
			counter++;
			letter = phrase.charAt(index);
			replaceindex = phrase.indexOf(letter);
			
			phrase = phrase.substring(0,index) + "*" + phrase.substring(index);
		

			
		}
		System.out.println("intermediate String:" + phrase);
	}
	
	public void PeaDeinserter(){
		phraseafterpeas = phrase;
		
		for(int i = 0;i<10;i++){
			newindex = phraseafterpeas.indexOf('*');
			phraseafterpeas = phraseafterpeas.substring(0,newindex) + phraseafterpeas.substring(newindex+1);
		}
		System.out.println("final String: " + phraseafterpeas);
	}
	
	
}
