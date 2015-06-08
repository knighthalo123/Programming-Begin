import java.util.Scanner;

public class ReverseString {
	private String original;
	private String result; 
	
	public ReverseString(){
		original = result = "";
	}
	
	public static void main(String[]args){
		ReverseString rs = new ReverseString();
		rs.run();
	}
	
	public void run(){
		original = getString();
		reverseString(original);
		printString();
	}
	
	public String getString(){
		String temp = "";
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter String to be reversed: ");
		temp = reader.nextLine();
		
		return temp;
	}
	
	public void reverseString(String input){
		while(input.length() != 0){
			result += input.charAt(input.length()-1);
			input = input.substring(0,input.length()-1);
		}
	}
	
	public void printString(){
		System.out.println("Your reversed String is: " + result);
	}
	
	
}
