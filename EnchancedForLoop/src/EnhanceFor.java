
public class EnhanceFor {
	
	public static void main(String[]args){
	int variable1[] = {3,10,23,12};
	int total = 0;
	
	for(int y: variable1){//this is an enhanced for loop
		total+= y;
	}
	
	System.out.println(total);
	
	
	}
}
