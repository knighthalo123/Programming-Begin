import java.util.Scanner;
public class apples {
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		double total = 0;
		double grade;
		double average;
		double counter = 0;

		System.out.println("Enter your grades 10 times");
		while(counter<10){
			grade = input.nextDouble();
			total +=grade;
			counter++;
		}
		
		average = total/10;
		System.out.println("You're average is: " + average);
		
		
		
	}

}
