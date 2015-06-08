import java.util.Scanner;

public class calculatorTut {
	public static void main(String[]args){
	
	double firstnumber, secondnumber, answer;
		
	System.out.print("Enter your first number: ");
	Scanner firstvariable = new Scanner(System.in);
	firstnumber = firstvariable.nextDouble();
	System.out.println("Enter your second number");
	secondnumber = firstvariable.nextDouble();
	answer = firstnumber + secondnumber;
	System.out.print("Your answer is: " + answer);
	}
}
