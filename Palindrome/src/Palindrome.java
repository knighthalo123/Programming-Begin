import java.util.Scanner;
 
public class Palindrome
{
    Scanner input = new Scanner(System.in);
    String original, space1, space2;
    String reverse = "";
    int length, index, indexspace, counter, ascii;
    char letter;
    boolean number;
    
    
    public void Palindrome(){
    	index = 0;
    	number = false;
    	counter = 0;
    }
    public static void main(String args[])
   {
	   System.out.println("Welcome to the Palindrome Program!");

      Palindrome p =  new Palindrome();
      p.GetInfo();
      p.tester();
   }
   
   public void GetInfo(){
	   		
	   System.out.print("Enter a string: ");
	      original = input.nextLine();
	      original = original.trim();
	      original = original.toLowerCase();
	      if(original.equals("q")){
	    	  System.exit(0);
	      }
	      spacetester();
	 
   }
   
   public void spacetester(){
	  for(int i = 0; original.indexOf(' ') != -1; i++){
		  if(counter == 0){
			  indexspace = 0;
		  }else{
			  indexspace  = original.indexOf(' ');
		  }
		   if(indexspace == -1){
			   indexspace = 0;
		   }
		   
		   if(counter != 0){
		   original = original.substring(0,indexspace) + original.substring(indexspace + 1);
		   }
		   
		   counter++;
		   
		   
	  }
      length = original.length();
      if(length == 1){
    	  original = original + " is a single letter thus it is not a palindrome";
      }
      changeword();
   
   }
   
   public void changeword(){
	      for ( int i = length - 1; i >= 0 ; i-- ){
	    	    letter = original.charAt(i);
	    	    ascii = (int)letter;
	      		index = original.lastIndexOf(letter);
	      	   symboltester();
	      	   if(number == false){
	      		  	reverse = reverse + letter;
	      	   }else{
	      		   number = false;
	      	   }
	      }
	      tester();
   }
   
   public void tester(){
	      if (original.equals(reverse)){
	         System.out.println("Yes, the string you entered is a palindrome.\n");
	      }
	      else{
	         System.out.println("No, the string you entered is NOT a palindrome.\n");
	      }
	      original = null;
	      space1 = " ";
	      space2 = " ";
	      reverse = "";
	      index = length = indexspace = counter = ascii = 0;
	      letter = ' ';
	      number = false;

	      GetInfo();
   }
   
   public void symboltester(){
	   if(ascii <= 47 || (ascii >= 58 && ascii <= 64)){
		   original = original.substring(0,index) + original.substring(index + 1);
		   number = true;
	   }
	   if(ascii >= 91 && ascii <= 96){
		   original = original.substring(0,index) + original.substring(index + 1);
		   number = true;
	   }
	   if(ascii >= 123){
		   original = original.substring(0,index) + original.substring(index + 1);
		   number = true;
	   }
   }

}