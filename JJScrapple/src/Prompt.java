//  Stephen Hung
//  8/21/2013
//  Prompt.java
//  We want to enhance the Scanner class so
//  that our program doesn't crash when the user
//  enters "invalid" input.  We also want to restrict
//  the user to a range of values.  

import java.util.Scanner;

public class Prompt
{
	public static String getString (String ask)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print(ask);
		String input = keyboard.nextLine();
		System.out.println();
		return input;
	}
	
	public static int getInt (String ask)
	{
		int value = 0;
		String input = new String("");
		boolean badinput = false;
		do
		{
			badinput = false;
			input = getString(ask);
			try
			{
				value = Integer.parseInt(input);
			}
			catch (NumberFormatException e)
			{
				badinput = true;
			}
		}
		while(badinput);
		return value;
	}
	
	public static int getInt (String ask, int min, int max)
	{
		int value = 0;
		do
		{
			value = getInt(ask + " (" + min + " - " + max + ") -> ");
		}
		while(value < min || value > max);
		return value;
	}
	
	
	
	public static double getDouble(String ask){
		double value = 0.0;
		String input = new String("");
		boolean badinput = false;
		do{
			badinput = false;
			input = getString(ask);
			try{
				value = Double.parseDouble(input);
			}catch(NumberFormatException e){
				badinput = true;
			}
		}while(badinput);
		
		return value;
	}
	
	public static double getDouble(String ask, double min, double max){
		double value = 0;
		do{
			String minString = String.format("%.2f",min);
			String maxString = String.format("%.2f",max);
			value = getDouble(ask + " (" + minString + " - " + maxString + ") -> ");
		}while(value < min || value > max);
		
		return value;
	}
	
	
	
}