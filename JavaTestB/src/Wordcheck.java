// Stephen Hung
// December 5,2012
// JavaTest.java
// this program will sort words into 4 catagories based on suffixes

import java.util.Scanner;

public class Wordcheck   { 
Scanner s = new Scanner(System.in);
	 private String input; 
	 private int part;       //  1 for adverb, 2 for verb, 3 for adjective, 4 for noun, 
	         //  0 if classification cannot be determined 
	 public Wordcheck ( )   { 
	  input = ""; part = 0; 
	 } 
	 public static void main ( String [] args )   { 
	  Wordcheck run = new Wordcheck ( ); 
	  run.LoopIt ( ); 
	 } 
	 public void LoopIt ( )   { 
	  GetWord ( ); 
	  while ( !input.toLowerCase ( ).equals ( "done" ) )   { 
	   DeterminePartOfSpeech ( ); 
	   PrintPartOfSpeech ( ); 
	   GetWord ( ); 
	  }  
	 }  
	 public void GetWord ( )   { 
		 System.out.print("Enter a word (done to quit) -> ");
		 input = s.nextLine();
	 } 
	 public void DeterminePartOfSpeech ( )   { 
		 if(input.endsWith("ly")){
			 part = 1;
		 }
		 else if(input.endsWith("ing")){
			 part = 2;
		 }
		 else if(input.endsWith("ful") || input.endsWith("ous")){
			 part = 3;
		 }
		 else if(input.endsWith("tion") || input.endsWith("cion") || input.endsWith("sion")){
			 part = 4;
		 }
		 else{
			 part = 0;
		 }
	 }
	 
	 public void PrintPartOfSpeech ( )   { 
		 switch(part){
		 case 1: System.out.println("The word " + input + " is an adverb");
		 break;
		 case 2: System.out.println("The word " + input + " is a verb");
		 break;
		 case 3: System.out.println("The word " + input + " is an adjective");
		 break;
		 case 4: System.out.println("The word " + input + " is a noun");
		 break;
		 default: System.out.println("Hmmm, I am unsure of the classification for " + input );
		 }
	 }  
	 
	}













