

public class plusOut {

	public static void main(String[] args){
		plusOut p = new plusOut();
		System.out.println(p.out("Good Work","o"));
		System.out.println(p.modifyString("COMPUTER"));
		System.out.println(p.alternate("excellent", "work"));
		p.number9();
	}
	
	
	
	public String out(String str, String word)
	{
		int[] index = new int[100];
		int length = word.length();
		int arrayCounter = 0;
		
		for(int a = 0; a < str.length(); a++){
			if(str.substring(a,a+length).equals(word) ){
				index[arrayCounter] = a;
				arrayCounter++;
			}
		}
		arrayCounter = 0;
		
		String newWord = "";
		
		for(int a = 0; a < str.length(); a++){
			if(a == index[arrayCounter]){
				newWord+= word;
				arrayCounter++;
			}else{
				newWord+="X";
			}
		}
		return newWord;
	}
	
	public String modifyString(String input){
		
		String output = "";
		
		for(int k = 1; k < input.length(); k+=2){
			output+=input.substring(k,k+1);
		}
		
		
		return output;
	}
	
	public String alternate(String one, String two){
		String str = "";
		
		int min = 100;
		boolean oneLength = true;
		
		if(one.length() < min){
			min = one.length();
			oneLength = true;
		}
		
		if(two.length() < min){
			min = two.length();
			oneLength = false;
		}
		
		for(int a = 0; a < min; a++){
			str+= one.charAt(a);
			str+= two.charAt(a);
		}
		
		if(oneLength){
			str+= two.substring(min);
		}else{
			str+= one.substring(min);
		}
		
		
		
		return str;
	}
	
	public void number9(){
		int [] array = {2,4,6,8,10,12};
		for(int k = 2; k < array.length-1;k++){
			array[k] = array[k+1];
			
		}
		for(int a = 0; a < array.length; a++){
			System.out.println(array[a]);
		}
	}
	
	
	
}