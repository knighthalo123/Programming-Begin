import java.util.Scanner;


public class Calculatooor extends Exiting{

	public static void main (String[]args){
		double num1;
		double num2;
		double answer;
		boolean answer3;
		boolean answer2;
		
		System.out.print("Hello, Please enter your first number to be added: ");
		Scanner input = new Scanner(System.in);
		num1 = input.nextDouble();
	
		System.out.print(num1);
		System.out.println(" Is this the correct number? ");
	
	
		System.out.println("Please choose one of 2 options, true or false");
		
		Scanner input3 = new Scanner(System.in);
		answer2 = input3.nextBoolean();
		
		if(answer2 == false){
			System.out.println("I'm sorry please restart the program to do it again.");
			Exiting ExitingObject = new Exiting();
			ExitingObject.Close();
		}else{
			System.out.println("Ok continue on.");
		}
		
		System.out.println("Please enter your second number to be added: ");
		Scanner input2 = new Scanner(System.in);
		num2 = input2.nextDouble();
		
		answer = num1 + num2;
		
		System.out.print("This is your answer: ");
		System.out.println(answer);
		
		System.out.println("Would you like to run the program again?");
		Scanner input4 = new Scanner(System.in);
		answer3 = input4.nextBoolean();
		
		if(answer3 == true){
		}else{
			System.out.println("Ok bye bye");
			System.exit(0);
		}
	
		
		
	}
	

	
}
