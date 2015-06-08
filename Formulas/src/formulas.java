import java.util.Scanner;
import java.math.*;
public class formulas {
	static String shape;
	public static void main(String []args){
		whatShape();
	}
	
	public static void whatShape(){
		System.out.println("What Shape would you like to find the Area of?");
		System.out.println("These are the Shapes I can compute: Square, Triangle, Trapezoid, Circle, and Parallelogram");
		Scanner input = new Scanner(System.in);
		shape = input.nextLine();
		
		System.out.println("Is " + shape + " your correct shape?");
		Scanner input2 =  new Scanner(System.in);
		String verification = input2.nextLine();
		
		if(verification.equalsIgnoreCase("Yes")){
			System.out.println("Great, please continue");
			shapeConfirmed();
		}else{
			System.out.println("I'm sorry please try again");
			whatShape();
		}
	}
	public static void shapeConfirmed(){	
		
		if(shape.equalsIgnoreCase("Square")){
			System.out.println("What is the length of the Square's side?");
			Scanner input3 = new Scanner(System.in);
			double squareLength = input3.nextDouble();
			
			double squareRootSquare = Math.pow(squareLength, 2.0);
			
			System.out.println("The Area of Your Square is: " + squareRootSquare);			
		}
		else if(shape.equalsIgnoreCase("Triangle")){
			System.out.println("What is the base value?(b) and what is the height value?(h)");
			System.out.print("Please type in your base's value: ");
			Scanner input4 = new Scanner(System.in);
			double baseTriangle = input4.nextDouble();
			
			System.out.println("Great now enter your height's value");
			Scanner input5 = new Scanner(System.in);
			double heightTriangle = input5.nextDouble();
			
			double triangleAnswer1 = baseTriangle * heightTriangle;
			double triangleAnswer = triangleAnswer1/2;
			
			System.out.println("This is the Area of your Triangle: " + triangleAnswer);
			
		}
		
		else if(shape.equalsIgnoreCase("Trapezoid")){
			System.out.println("What is the first base's value?");
			Scanner input6 = new Scanner(System.in);
			double trapezoidBase1 = input6.nextDouble();
			System.out.println("What is the second base's value?");
			Scanner input7 = new Scanner(System.in);
			double trapezoidBase2 = input7.nextDouble();
			System.out.println("What is the height's value?");
			Scanner input8 = new Scanner(System.in);
			double trapezoidHeight = input8.nextDouble();
			
			double trapezoidAnswer = trapezoidHeight/2 * (trapezoidBase1 + trapezoidBase2);
			
			System.out.println("The Area of Your Trapezoid is: " + trapezoidAnswer);
		
		}
		else if(shape.equalsIgnoreCase("Circle")){
			
		}
		else if(shape.equalsIgnoreCase("Parallelogram")){
	
		}else{
			System.out.print("I'm sorry you have entered an unknown word, or a shape I cannot compute.");
			System.out.println(" Please try again");
			whatShape();
		}
		}

	}
	
	
	
	
	
	
	
	
