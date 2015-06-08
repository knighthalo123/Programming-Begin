
public class ArrayMethod {
	public static void main(String[]args){
		int variable1[] = {1,2,3,4,5};
		change(variable1);
		for(int y : variable1)
		{
			System.out.println(y);
		}
	}
	
	public static void change(int x[]){
		for(int counter = 0; counter<x.length; counter++)
		x[counter] += 5;
	}
	
	
	
}
