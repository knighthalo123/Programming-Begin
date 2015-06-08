import java.util.Scanner;
public class apple {
	public static void main(String[]args){
		
		int age;
		Scanner input = new Scanner(System.in);
		age = input.nextInt();
		
		if(age>60)
			System.out.println("You are very old");
		else if(age >=50)
			System.out.println("You are 30");
		else if(age>=40)
			System.out.println("You are 40");
		else
			System.out.println("You are young");
		
		
		
		
		
	}
}
