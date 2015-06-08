


import java.util.Scanner;

public class ReverseIt {
	Scanner input = new Scanner(System.in);
	private int index, index2, indexl, indexl2, length;
	private String phrase, partphrase;
	private char letter, newletter;	
	
	public static void main(String[]args){
	ReverseIt r = new ReverseIt();
	r.GetInfo();
	r.ChangeWord();
	
	}
	
	public void GetInfo(){
	System.out.print("Enter the phrase you would like to change: ");
	phrase = input.nextLine();
	System.out.println();
	
	}
	
	public void ChangeWord(){
		phrase = phrase.trim();
		
		if(phrase.charAt(0) != 32){
			index = 0;
			index2 = phrase.indexOf(' ', index+1);
		}
		if(index2 == -1){
			index2 = phrase.length();// should be phrase.length -1
			length = phrase.length();
		}

		
		
		
		
		System.out.println("index = " + index + " \nindex2 = " + index2);
		partphrase = phrase.substring(index,index2);
		length = partphrase.length();
		System.out.println("length = " + length);
		
		
		
		for(int i = 0; i<partphrase.length() ;i++){
			letter = partphrase.charAt(i);
			index = (partphrase.indexOf(letter));
			newletter = partphrase.charAt(length- index - 1);
			indexl = partphrase.indexOf(letter);
			System.out.println(indexl);
			indexl2 = partphrase.indexOf(newletter);
			System.out.println(indexl2);
			partphrase = partphrase.substring(0,indexl) 
					+ newletter + 
					partphrase.substring(indexl ,indexl2) + 
					letter + partphrase.substring(indexl2+1);
			
			
			
			
		}
		System.out.println(partphrase);
		
	}
	public void ReverseIt(){
		index = index2 = indexl = indexl2 = length = 0;
		
		
	}
	
	

}
