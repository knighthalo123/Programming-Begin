import java.util.Random;
import java.util.Scanner;

class Guess{
	static int number2;
	static int number1;
	static int count;
	static int totalcount;
	public static void main(String[]args){
		intro();
		random();
		guess();
		check();	
		
	}
	
	public static void intro(){
		System.out.println("Hi, Time to guess the number.");
		System.out.println("Enter a number and see if you can guess the randomly generated number in 10 guesses!");
	}
	public static void random(){
		Random generator = new Random();
		number1 = generator.nextInt(100);
		if( number1 > 50 ){
			System.out.println("This number is greater than 50");
		}else{
			System.out.println("This number is not greater than 50");
		}
		
	}
	
	public static void guess(){
		Scanner input = new Scanner(System.in);
		number2 = input.nextInt();
	}
	
	public static void check () {
	if(number2 == number1){
		System.out.println("Good job you got it correct");
	}else{
		System.out.println("I'm sorry you got it wrong please try again");
		counter();
		guess();
		check();
		
		
	}
		
		
	}
	
	public static void counter() {
		count++;
		totalcount = 10 - count;
		if(count>10){
			System.out.println("you have excedded the number of guess(10) Good Bye");
			System.out.println(number1);
			System.exit(0);
		}else{
			System.out.println("You have: " + totalcount + " more guesses");
		}
	}
	
	
}