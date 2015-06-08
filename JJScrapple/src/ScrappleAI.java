// Stephen Hung
// September 19, 2013
// ScrappleAI.java


import java.util.Scanner;

public class ScrappleAI {
	private static String tilesLeft, tilesInHand, highestWord, temp;
	private static String[] possibleWords, correctWords;
	private static Scanner inputWord, secondInputWord;
	private static int count;
	private static int [] scoretable = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};	
	
	public ScrappleAI(){
		possibleWords = null;
		correctWords = null;
		inputWord = secondInputWord = null;
		tilesLeft = "";
		tilesInHand = "";
		highestWord = "";
		count = 0;
		secondInputWord = OpenFile.openToRead("wordlist.txt");
		while(secondInputWord.hasNext()){
			temp = secondInputWord.nextLine();
			count++;
		}
		possibleWords = new String[count];
		correctWords = new String[count];
		count = 0;
		inputWord = OpenFile.openToRead("wordlist.txt");
		while(inputWord.hasNext()){
			temp = inputWord.nextLine();
			possibleWords[count] = temp;
			correctWords[count] = "";
			count++;
		}
	}
	
	public static void convertTilesLeft(String a){
		tilesLeft = a;
	}
	
	public static void converTilesInHand(String b){
		tilesInHand = b;
	}
	
	public static String getTilesLeft(){
		return tilesLeft;
	}
	
	public static String getTilesInHand(){
		return tilesInHand;
	}
	
	
	public static String getRandomTiles(String a){
		tilesLeft = a;
		double lengthTiles = 1.0 * tilesLeft.length()-1;
		
		while(tilesInHand.length() < 8 && tilesLeft.length()!= 0){
			int randomChar = (int)(Math.random()*lengthTiles);
			tilesInHand = tilesInHand + tilesLeft.charAt(randomChar);
			tilesLeft = tilesLeft.substring(0,randomChar) + tilesLeft.substring(randomChar+1);
			lengthTiles = 1.0 * tilesLeft.length()-1;
		};
		
		
		return tilesInHand;
	}
	
	public static String getHighestWord(){
		String temp = "";
		int arrayCounter = 0;
		
		for(int a = 0; a < possibleWords.length; a++){ // get correct word
			if(getPossibleWords(possibleWords[a])){
				correctWords[arrayCounter] = possibleWords[a];
				arrayCounter++;
			}
		}
		
		highestWord = highestScore();
		for(int a = 0; a < highestWord.length(); a++){
			for(int b = 0; b < tilesInHand.length(); b++){
				if(highestWord.charAt(a) == tilesInHand.charAt(b)){
					tilesInHand = tilesInHand.substring(0,a) + tilesInHand.substring(a+1);
				}
			}
		}
		System.out.println("comp tile = " + tilesInHand + " highest word = " + highestWord);
		return highestWord;
	}
	
	public static boolean getPossibleWords(String inputString){
		boolean veri = false;
		String tilesHand = tilesInHand;
		tilesHand = tilesHand.toLowerCase();
		
		for(int b = 0; b < inputString.length(); b++){
			veri = false;
			for(int c = 0; c < tilesHand.length(); c++){
				if(inputString.charAt(b) == tilesHand.charAt(c)){
					tilesHand = tilesHand.substring(0,c) + tilesHand.substring(c+1);
					c = tilesHand.length();
					veri = true;
				}
			}	
		}	
		
		if(veri == false){
			return false;
		}
		
		System.out.println("correct Input = " + inputString + " tilesInHand = " + tilesInHand + " used TilesInHand = " + tilesHand);
		return true;
	}
	
	public static String highestScore(){
		int minScore = 0;
		int score = 0;
		String superWord = "";
		int charInt = 97;
		int alphabetCounter = 0;
		for(int i = 0; i < correctWords.length; i++){ // gets highest score.
			for(int a = 0; a < correctWords[i].length(); a++){
				for(int b = 0; b < scoretable.length; b++){
					if(correctWords[i].charAt(a) == charInt){
						score = score +  scoretable[alphabetCounter];
					}
					alphabetCounter++;
					charInt++;
				}
			}		
			if(minScore < score){
				minScore = score;
				superWord = correctWords[i];
			}
			score = 0;
			charInt = 97;
			alphabetCounter = 0;
		}
		return superWord;
	}
	
	public static boolean matchletters(String temp, String copy){ // temp = word list's next word
	// copy = series of letters the user has
		boolean matched = false;
		
		for(int i = 0; i < temp.length(); i++){
			matched = false;
			for(int j = 0; j < copy.length(); j++){
				if(temp.charAt(i) == copy.charAt(j)){
					copy = copy.substring(0,j) + copy.substring(j+1);
					matched = true;
					j = copy.length();
				}
			}
			if(!matched){
				return false;
			}
		}
		
		return true;
	}
	
	
	
}