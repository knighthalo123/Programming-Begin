import java.util.Random;
public class apple {
	public static void main(String[]args){
		
		Random number1 = new Random(); // makes random number
		int array[] = new int[7]; //makes array going for 7 numbers, but 0 is excluded since no 0 in dice.
		
		for(int roll = 1;roll<101;roll++){ //as roll =1, and roll is less than 101, increase roll by 1
			++array[1 + number1.nextInt(6)];//makes random number generator make it 1-6, ++array means it adds 1 to frequency for each number
		}
		
		System.out.println("Face\tFrequency of Rolls");//creates header
		
		for(int face = 1;face<array.length;face++){// as face =1, and is less than array length which is 6, increase face by 1
			System.out.println(face + "\t" + array[face]);// print out the faces(1-6) then print out value of each array index  ( face is arrays index) since face = 1-6.
		}
	}
}
