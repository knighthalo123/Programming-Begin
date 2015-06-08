import java.util.Scanner;


public class UserInput {
public static void main(String[]args){
	
	String name;	
	int answer;
	int math;

	
	
	System.out.println("Hello what is your name: ");
	Scanner name1 = new Scanner(System.in);
	name= name1.nextLine();
	
	System.out.print("Hello ");
	System.out.println(name);
	System.out.println("Welcome to The World");
	System.out.println("");
	
	System.out.println("What is the answer to 2 + 2?");
	
	Scanner answer1 = new Scanner(System.in);
	answer = answer1.nextInt();
	
	if ((answer == 4))
	{
		System.out.println("Congratulations that is the correct answer");
		System.exit(0);
	}
     else 
	{
		System.out.println("Wrong here is way to find if a number is below 10");
	}
	
	System.out.println("Enter a number to see if it is below 10");
	Scanner math1 = new Scanner(System.in);
	math = math1.nextInt();
	
	for (math = math; math<=10;math++)
		{
		System.out.println("No this is not below 10"); 
		System.exit(0);
		
	}
}
	
	
	
	
	
}
	

