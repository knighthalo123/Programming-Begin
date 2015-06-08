import java.util.Scanner;


public class SqRT {
	public static void main(String[]args){
		double answer;
		double num1;
		

		System.out.println("Print out the number you want square rooted");

		Scanner input = new Scanner(System.in);
		num1 = input.nextInt();
		
		
		answer = (double) Math.sqrt(num1);
		
		System.out.println("This is the square root of" + num1 + " : " + answer);
		
		
		
	}
}
