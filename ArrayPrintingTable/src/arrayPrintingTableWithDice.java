import java.util.Random;

public class arrayPrintingTableWithDice {
	public static void main(String[]args){
	
		Random dice = new Random();
		
		int diceArray[] = new int[7];
		
		for(int x = 1;x<101; x++ )
		{
			++diceArray[1+dice.nextInt(6)];
		}
		
		System.out.println("Face\tFrequency");
		
		
		for(int face=1; face<diceArray.length; face++)
		{
			System.out.println(face+"\t"+diceArray[face]);
		}
		
		
		
		
		
		
		
		
	}
}
