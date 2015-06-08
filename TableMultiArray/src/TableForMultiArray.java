
public class TableForMultiArray {
	static int variable1;
	public static void main(String[]args){
		int arrarow1[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int arrarow2[][] = {{13,14,15,16},{17,18,19,20},{21,22,23,24}};
		
		System.out.println("This is the first array");
		displarowingMultiArrarow(arrarow1);
		
		System.out.println("This is the second array");
		displarowingMultiArrarow(arrarow2);
	}
	
	public static void displarowingMultiArrarow(int x[][]){
		for(int row = 0; row<x.length; row++)
		{
			for(int column = 0;column < x[row].length;column++  ){
				System.out.print(x[row][column] + "\t");
			}
			
			System.out.println();
			
		
		}
		
	}
}

