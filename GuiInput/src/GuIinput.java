import javax.swing.JOptionPane;
import java.util.Random;


public class GuIinput {
	static int randomNumber;
	
	static int counter;
	static int points;
	static int num1;
	static int num2;
	static int checkEasyNumber;
	static int checkHardNumber;
	static int hardGuessNumber;
	
	public static void main(String[]args){
		JOptionPane.showMessageDialog(null, "Welcome to Stephen's Guessing Game");
		JOptionPane.showMessageDialog(null, "You will earn points, but you can will only have a certain amount of guesses, and then the game will end.");
		JOptionPane.showMessageDialog(null, "You can use points to buy hints or more guesses");
		JOptionPane.showMessageDialog(null, "Hints cost 1 point, while more guesses cost 2");

		JOptionPane.showMessageDialog(null,"What kind of Difficulty Would you like? Easy or Hard", "Difficulty choosing", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null,"Easy only has choices between 0 and 10, it has 5 guesses", "Easy Difficulty", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Hard has choices between 0 and 50, It has 25 guesses.", "Hard Difficulty", JOptionPane.PLAIN_MESSAGE);
		String difficultySetting = JOptionPane.showInputDialog("Input your Difficult");
		JOptionPane.showMessageDialog(null, "You have chosen " + difficultySetting);

		if(difficultySetting.equalsIgnoreCase("Easy")){
			Random random1 = new Random();
			checkEasyNumber = random1.nextInt(10);
			
			easyGuess();
		}
		else if(difficultySetting.equalsIgnoreCase("Hard"))
		{
			Random random2 = new Random();
			checkHardNumber = random2.nextInt(50);
			hardGuess();
		}
		else{
			JOptionPane.showMessageDialog(null,"You have entered something that is neither easy or hard. Please try again");
			new GuIinput();
		}
		

	}
	
	public static void hardGuess(){
		String firstHardGuess = JOptionPane.showInputDialog("Input your guess");
		num1 = Integer.parseInt(firstHardGuess);
		if(num1 == checkHardNumber){
			JOptionPane.showMessageDialog(null, "Congratulations you got it right");
			points+=5;
			JOptionPane.showMessageDialog(null,"You have: " + points + " points");
			
		}else{
			hardWrongGuess();

		}
	}
	
	public static void hardWrongGuess(){
		
		counter++;
		hardGuessNumber = 25 - counter; 
		if(hardGuessNumber == 0){
			JOptionPane.showMessageDialog(null, "I'm Sorry, you have lost the game");
			System.exit(0);
		}else
		{
			hardWrongGuessHint();
		}	
	}
	public static void hardWrongGuessHint(){
		String hardHint = JOptionPane.showInputDialog("Would you like to buy a hint?");
		if(hardHint.equalsIgnoreCase("Yes")){
			JOptionPane.showMessageDialog(null, "You have " + hardGuessNumber + " number of guesses left");
			points--;
			JOptionPane.showMessageDialog(null,"You have " + points + "points left");
		}
		else if(hardHint.equalsIgnoreCase("No")){
			JOptionPane.showMessageDialog(null, "Ok continue on.");
			hardGuess();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "I'm sorry, that wasn't a Yes or No, Please try again");
			hardWrongGuessHint();
			}
	}
	
	public static void easyGuess(){
		String firstEasyGuess = JOptionPane.showInputDialog("Input your first guess");
		num2 = Integer.parseInt(firstEasyGuess);
		
		if(num2 == checkEasyNumber){
			JOptionPane.showMessageDialog(null, "Congratulations you got it right");
			points +=1;
			JOptionPane.showMessageDialog(null, "You have: " + points + " points");
			int reply = JOptionPane.showConfirmDialog(null,"Would you like to play this game again?");
			if(reply == JOptionPane.YES_OPTION){
				new GuIinput();
			}else{
				JOptionPane.showMessageDialog(null,"Bye, Bye");
			}
		}else{
			easyWrongGuess();
		}
		
		
	}
	
	public static void easyWrongGuess(){
		counter++;
		hardGuessNumber = 5 - counter;
		if(hardGuessNumber == 0){
			JOptionPane.showMessageDialog(null,"I'm sorry you have lost");
		}
		else{
			easyGuess();
		}
	}
	
	
	
	
}
