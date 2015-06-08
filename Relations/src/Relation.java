import java.util.Scanner;


public class Relation {
	public static void main(String[]args){
	
		int array1[] = new int[5];
		array1[0] = 2;
		array1[1] = 10;
		array1[2] = 24;
		array1[3] = 36;
		array1[4] = 120;		
		
		
		int num2 = 10;
		int num1;
		

		System.out.println("enter a number to see if it is equal to 10");
		Scanner input = new Scanner(System.in);
		num1 = input.nextInt();
		
		if( num1 !=  num2){
			System.out.println(num1 + " does not equal 7");
			for(int element:array1){
				System.out.println( element );
			}
		}else{
			System.out.println(num1 + " does equal 7");
		}
		
		
		
		
		
		
	}
}
