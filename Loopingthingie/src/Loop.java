import java.util.Scanner;

public class Loop {
	public static void main(String[]args){
		counter();
	}
	public static void counter(){
		int counter;
		System.out.println("What is your number?");
		Scanner counter1 = new Scanner(System.in);
		counter = counter1.nextInt();
	
		if(counter<10){
			System.out.println(counter);
			counter();
		}else{
			System.out.println(counter);
			System.exit(0);
		}
		
		
		
		
		
		
		
		
		
	}
	

}
