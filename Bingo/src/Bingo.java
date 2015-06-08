import java.util.Random;


public class Bingo {
	
	int[][] table = new int[5][5];
	int row, column;
	int min, max;
	Random rand = new Random();
	
	
	public static void main(String[]args){
		Bingo binge = new Bingo();
		binge.Creator();
		System.out.println("hi");
	}
	
	public void Creator(){
		for(column = 0; column < 5; column++){
			for(row = 0; row < 5; row++){
				min = column * 15;
				max = 1 + ( * 	15);
				System.out.println("max = " + max);
				do{
					table[row][column] = rand.nextInt(max);
				}while(table[row][column] <= min || Checker(table[row][column]));
			}
			
		}
	}
	
	public boolean Checker(int check){
	
		for(int z = 0; z < 5; z++){
			if(table[z][column] == check){
				System.out.println(table[z][column]);
				return true;
			}
		}
		return false;
	}
	
}
