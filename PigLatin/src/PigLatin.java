import java.util.Scanner;

public class PigLatin {
	private String original;
	private String result;
	
	public PigLatin(){
		original = result = "";
	}
	
	public static void main(String[] args){
		PigLatin p = new PigLatin();
		p.run();
	}
	
	public void run(){
		original = getString();
		result = transformWord(original);
		System.out.print("Your result was: " + result);
	}
	
	public String getString(){
		String temp = "";
		while(temp.equals("")){
			System.out.print("Please enter a word to be translated into Pig Latin: ");
			Scanner reader = new Scanner(System.in);
			temp = reader.nextLine();
			
			if(temp.equals("")){
				System.out.println("This message will appear when you enter a blank, please enter a word.\n");
			}
		}
		
		
		return temp;
	}
	
	public String transformWord(String temp){
		String tResult = "";
		String eResult = "";
		char first = temp.charAt(0);
		
		if( conChecker(first) == false ){
			tResult = temp + "way";
		}else{
			while(conChecker(first) == true){
				eResult += first;
				temp = temp.substring(1,temp.length());
				first = temp.charAt(0);
			}
			
			tResult = temp + eResult + "ay";
		}
		
		
		return tResult;
	}
	
	public boolean conChecker(char first){
		
		if( (first == 'a') || (first == 'e') || (first == 'i') || (first == 'o') || (first == 'u') ){
			return false;
		}
		
		return true;
	}
	
	
}
