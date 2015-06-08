// Stephen Hung
// September 19, 2013
// JJScraple.java



import java.util.Scanner;

public class JJScrapple {
	private String tilesLeft; // tiles left in pile
	private String tilesInHand; // tiles in hand.
	
	private String compTilesInHand;
	private int compScore;
	private String compWord;
	
	private String word;// the word that the user enters made up of
	// the user's tiles
	private Scanner testFileInput = null; // scanner to read text file
	private int score; // the users score. Computers Score 
	private int [] scoretable = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	// score table to score every letter.
	ScrappleAI scrap = new ScrappleAI();
	
	public JJScrapple (){
		tilesLeft = new String("AAAAAAAAAABBCCDDDDEEEEEEEEEEEEEFFGGGHHIIIIIIIIIJKLLLLMMNNNNNNOOOOOOOOPPQRRRRRRSSSSTTTTTTUUUUVVWWXYYZ");
		tilesInHand = new String("");
		compTilesInHand = new String("");
		compWord = "";
		word = new String("");
		score = compScore = 0;
	}

	public static void main (String args[]) {		
		JJScrapple play = new JJScrapple();
		play.playGame();
	}
	
	public void playGame(){
		//introduction();
		
		boolean done = false;
		boolean turn = true; // true = player, false = computer;		
			
		do{
			if(turn){
				done = playround(); // if the word is wrong
				// then goodword returns true;
				// and so !done will be false if the word is wrong.
				// !done is true if the word is right.
				if(tilesInHand.length() <= 0){
					done = true;
				}
				turn = false;
			}else{
				
				done = compPlayRound();
				
				turn = true;
			}
			
		}
		while(done == false);
		exitMessage();	
	
		
	}
	
	
	
	public void introduction ( )
	{
		System.out.println("\n\n\n");
		System.out.println("WELCOME TO THE GAME OF");
		System.out.println(" ______     ______     ______     ______     ______   ______   __         ______   ");  
		System.out.println("/\\  ___\\   /\\  ___\\   /\\  == \\   /\\  __ \\   /\\  == \\ /\\  == \\ /\\ \\       /\\  ___\\  ");   
		System.out.println("\\ \\___  \\  \\ \\ \\____  \\ \\  __<   \\ \\  __ \\  \\ \\  _-/ \\ \\  _-/ \\ \\ \\____  \\ \\  __\\  "); 
		System.out.println(" \\/\\_____\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\ \\_\\  \\ \\_\\    \\ \\_\\    \\ \\_____\\  \\ \\_____\\"); 
		System.out.println("  \\/_____/   \\/_____/   \\/_/ /_/   \\/_/\\/_/   \\/_/     \\/_/     \\/_____/   \\/_____/ TM"); 
		System.out.println("\n\nThis game is a \"scaled down\" version of Scrabble, between the player (user) and the computer.  The");
		System.out.println("game is initialized with a pool of letter tiles, with the following group of 100 tiles:\n");
		System.out.println("A A A A A A A A A A B B C C D D D D E E E E E E E E E E E E E F F G G G H H I I I I I I I I I J K L");
		System.out.println("L L L M M N N N N N N O O O O O O O O P P Q R R R R R R S S S S T T T T T T U U U U V V W W X Y Y Z");
		System.out.println("\nThe game begins with 8 tiles being chosen at random to fill the player's hand and 8 tiles chosen at");
		System.out.println("random to fill the computer's hand.  The player always goes first.  He/she must create a valid word,");
		System.out.println("with a length from 4 to 8 letters, from the tiles in his/her hand.  The \"word\" entered by the player");
		System.out.println("is then checked.  It is first checked for length, then checked to make sure it is made up of letters");
		System.out.println("from the letters in the current hand, and then it is checked against the wordlist text file.  If any");
		System.out.println("of these tests fail, the player loses his/her turn, all of his tiles (letters) are returned to the pool");
		System.out.println("of letters, and the appropriate number of tiles are drawn at random to create a new hand (usually 8");
		System.out.println("tiles).  No points are added to the score.  If the word entered is valid, points are added to the");
		System.out.println("player's score according to the following table (These scores are taken from the game of Scrabble):");
		System.out.println("\nA  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z");
		System.out.println("1  3  3  2  1  4  2  4  1  8  5  1  3  1  1  3  10 1  1  1  1  4  4  8  4  10");
		System.out.println("\nOnce the player's score has been updated, more tiles are chosen at random from the remaining pool of");
		System.out.println("letters, to fill the player's hand to 8 letters.  Then it is the computer's turn.  The computer");
		System.out.println("provides a valid word from 4 to 8 letters.  If this is not possible given the letters in the computer's");
		System.out.println("hand, then all of the computer's tiles (letters) are returned to the pool of letters, and the");
		System.out.println("appropriate number of tiles (letters) are chosen at random to create a new hand (usually 8 tiles).  The");
		System.out.println("game ends when there are consecutive turns (computer then player, or player then computer) where a word");
		System.out.println("is not formed, or when no tiles remain.  Ready?  Let's play!\n\n\n");
		System.out.print("Hit ENTER on the keyboard to continue: ");
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
	}
	
	public boolean compPlayRound(){
		chooseRandomTiles();
		compTilesInHand = scrap.getRandomTiles(tilesLeft);
		tilesLeft = scrap.getTilesLeft();
		
		System.out.println(scrap.getHighestWord());
		
		showStatus();
		
		compWord = compWord.toLowerCase();
		
		
		tilesLeft = scrap.getTilesLeft();
		compTilesInHand = scrap.getTilesInHand();
		return false;	
	}
	
	
	public boolean playround(){
		compTilesInHand = scrap.getRandomTiles(tilesLeft);
		chooseRandomTiles();
		showStatus();
		getWordFromUser();
		if(word.length() < 4 || word.length() > 8){ // if length is less than 4
		// or length is greater than 8, stop the game. 
			System.out.println("\n\nSorry the word you entered is either too short or too long\n\n");
			return true; // done = true;
		}
		word = word.toLowerCase(); // caps doesnt matter now.
		boolean goodword = verifyWord(word) && verifyTiles(word, tilesInHand);
		if(goodword)
		{
			addToScore();
		}
		return !goodword;
	}

	public void chooseRandomTiles(){
		double lengthTiles = 1.0 * tilesLeft.length()-1;
		
		
		while(tilesInHand.length() < 8 && tilesLeft.length()!= 0){
			int randomChar = (int)(Math.random()*lengthTiles);
			tilesInHand = tilesInHand + tilesLeft.charAt(randomChar);
			tilesLeft = tilesLeft.substring(0,randomChar) + tilesLeft.substring(randomChar+1);
			lengthTiles = 1.0 * tilesLeft.length()-1;
		};

	}
	
	public void showStatus ( ){
		int counter = 0;
		System.out.println("\n\n\n");
		System.out.println("The tiles left in the pool of letters are : ");
		for(int a = 0; a < tilesLeft.length(); a++){ // prints out remaining pool of letters
			if(counter % 20 == 0){
				System.out.println();
			}
			System.out.printf("%-3s ",tilesLeft.charAt(a));
			counter++;
		}
		System.out.println("\n\nPlayer's current score is -> " + score); // prints out current score
		System.out.println("\nComputer's current score is -> " + compScore + "\n\n"); // prints out current score
	
		System.out.println("The tiles in your hand currently are : ");
		for(int a = 0; a < tilesInHand.length(); a++){
			System.out.printf("%-3s",tilesInHand.charAt(a));
		}
		System.out.println("\nThe tiles in the computer's hand are : ");
		for(int a = 0; a < compTilesInHand.length(); a++){
			System.out.printf("%-3s",compTilesInHand.charAt(a));
		}
		System.out.println("\n\n\n");
	}
	
	public void getWordFromUser(){		
		System.out.println("\n\n");
		word = Prompt.getString("Enter a word using your pool of letters ->  ");
		System.out.println("\n\n");
	}
	
	public boolean verifyTiles(String inputWord, String tilesHand){
		tilesHand = tilesHand.toLowerCase();
		boolean veri2 = false;
		for(int a = 0; a < inputWord.length(); a++){
			veri2 = false;
			for(int b = 0; b < tilesHand.length(); b++){
				if(tilesHand.charAt(b) == inputWord.charAt(a)){
					tilesHand = tilesHand.substring(0,b) + tilesHand.substring(b+1);
					tilesInHand = tilesInHand.substring(0,b) + tilesInHand.substring(b+1);
					b = tilesHand.length();
					veri2 = true;
				}
				
			}
		}
		if(!veri2){
			System.out.println("its not in ur tabs");
			return false;
		}
		return true;
	}
	
	public boolean verifyWord (String inputWord){
		testFileInput = OpenFile.openToRead("wordlist.txt");
		while(testFileInput.hasNext()){
			String nextWord = testFileInput.nextLine();
			if(word.equals(nextWord)){
				return true;
			}
		}
		
		System.out.println("Sorry but the word you entered does not exist in my list of English Words");
		
		return false;
	}
	
	public void addToScore ( ){
		int charInt = 97;
		int alphabetCounter = 0;
		for(int a = 0; a < word.length(); a++){
			for(int b = 0; b < scoretable.length; b++){
				if(word.charAt(a) == charInt){
					score += scoretable[alphabetCounter];
				}
				alphabetCounter++;
				charInt++;
			}
			charInt = 97;
			alphabetCounter = 0;
		}
	}
	
	public void exitMessage (){
		System.out.println("\n\n");
		System.out.println("End of Game.\n");	
		
		
		System.out.println("Final Score = " + score + "\n");
		System.out.println("Thanks for Playing!\n");
		
		System.exit(0);
	}

	

}