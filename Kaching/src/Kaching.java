// Stephen Hung
// October 29,2012
// Kaching.java
// This program creates a game based on rolling a dice.s

// Class Variables:
//       Atotal,Btotal     = Stores the position for players A
//                           and  B,  respectively.
//       Aturn,done        = Booleans to determine if it is
//                           player  A's  turn,  and  if  the  game  is
//                           done, respectively.
//       die               = A six-sided die (you can just use a
//                           random  number  generator,  if  you
//                           prefer).
//       prime,bprime      = A boolean variable that shows whether the roll
//                           was prime or not.
//       roll              = The value the dice rolls.
//		 error			   = A boolean variable that shows whether or not 
//							 an error has occured
//		 Aprime,Bprime     = the combined value of Atotal + roll,
//						     used primarily in the prime testing methods.

// Class Methods:
//       PlayGame()        			  = This method is called in main, and
//                           			calls the other methods to play the game.
//       ShowStatus()      			  = Shows the status of the game, or the
//                           			positions of the two players.
//       MoveIt()          			  = Plays one turn, alternating between
//                           			player A and player B.
//       PrintWinner()                = Prints the final status, and
//                         			    congratulates the winner.
//       rolldice()                   = rolls the dice
//       primetester(),bprimetester() = tests if the roll + Atotal is prime, if it is, it rolls the dice and 
//                                      tests if the roll + Atotal is prime, and does it again and again until it isn't prime
//		 error1(),berror1()           = tests if the roll is equal to 1.
//       error2(),berror2()           = tests if roll + Atotal can be divided by the roll, if so 
//										it subtracts (roll*2) from Atotal
//       error4(),berror4()           = tests if roll + Atotal can not be divided by roll and isnt prime,
//										if so it adds roll to Atotal and becomes 
// 		 Afinish(),Bfinish()		  = tests if the number is greater than or equal to 50, then calculates the score depending on the roll.
//										then shows the score.



import java.util.Scanner ;

public class Kaching {
private int Atotal, Btotal;
private boolean Aturn, done;
private Dice die;
private int roll;
private boolean prime, bprime;
private boolean error;
private int Aprime, Bprime;
Scanner input = new Scanner(System.in);
public Kaching(){
                Atotal = 1;
                Btotal = 1;
                Aturn  = true;
                done   = false;
                die    = new Dice();
                roll   = 0;
                error  = false;
        }
public static void main(String[]args){
                Kaching fun = new Kaching();
                fun.PlayGame();
        }
public void PlayGame(){
        ShowStatus();
        }

public void ShowStatus(){
       if(Atotal >= 50 || Btotal >= 50){
    	   PrintWinner();
       }
	
	
				System.out.println("A TOTAL IS:  " + Atotal);
                System.out.println("B TOTAL IS:  " + Btotal);
                if(Aturn == true){
                        System.out.println("PLAYER A, hit Enter to continue: ");
                        input.nextLine();
                        MoveIt();
                }
                else
                {
                        System.out.println("PLAYER B, hit Enter to continue: ");
                        input.nextLine();
                        MoveIt();
                }
}

public void MoveIt(){
                if(Aturn == true){// It is A's turn
                        rolldice();
                        primetester();
                        error1();
                        error2();
                        error4();
        }
        else{
        				rolldice();
                        bprimetester();
                        berror1();
                        berror2();
                        berror4();
        }
}

public void PrintWinner(){

        if(Atotal >= 50){
   		System.out.println(roll);
       	System.out.println("A, you are the champion.");
        System.out.println("A TOTAL IS:  " + Atotal);
        System.out.println("B TOTAL IS:  " + Btotal);
        System.exit(0);
        }
        if(Btotal >=50)
        {
   		System.out.println(roll);
        System.out.println("B, you are the champion.");
        System.out.println("A TOTAL IS:  " + Atotal);
        System.out.println("B TOTAL IS:  " + Btotal);
        System.exit(0);
        }

 }

public void rolldice(){
roll = die.Roll();
}

public void primetester(){
                        Aprime = roll+Atotal;
                        for(int i=2;i<Aprime;i++) {// prime tester
                                if(Aprime == 2){// if aprime = 2
                                error1();
                                }
                                if((Aprime)%i == 0){//aprime is not prime
                                        prime = false;// prime is false
                                        error1();
                                        error2();
                                        error4();

                                }
                                else
                                {
                                	Aturn = true;
                                	System.out.println(roll);
                                	ShowStatus();
                                }
                        }
}

public void error1(){
if(roll == 1){// error 1
                        Aturn = false;
                        error = true;
                        Afinish();
                }
}

public void error2(){
if( (Atotal + roll) % roll == 0){// error 2
                        error = true;
                        Aturn = false;
                        Atotal -= (2*roll);
                        if(Atotal <1){
                                        Atotal = 1;
                                }
                        Afinish();
	}
}

public void error4(){
if( (Atotal + roll) % roll != 0 && prime == false){// error 4
                        error = true;
                        Aturn = false;
                        Atotal += roll;
                }
                Afinish();
}

public void Afinish(){
	
if(done){
        PrintWinner();
        }
        else{
        	if(error == false){
                        Atotal += roll;
                        Aturn = false;
                        System.out.println(roll);
                        ShowStatus();
                }
                else{
                		System.out.println(roll);
                        Aturn = false;
                        ShowStatus();
                        }
                }
}

public void bprimetester(){
    Bprime = roll+Btotal;
    for(int i=2;i<Bprime;i++) {// prime tester
            if(Bprime == 2){// if Bprime = 2
            	berror1();
            }
            if((Bprime)%i == 0){//aprime is not prime
                    bprime = false;// prime is false
                    berror1();
                    berror2();
                    berror4();

            }
            else
            {
                    Aturn = false;
                    System.out.println(roll);
                    ShowStatus();
            }
    }
}

public void berror1(){
if(roll == 1){// error 1
    Aturn = true;
    error = true;
    Bfinish();
}
}

public void berror2(){
if( (Btotal + roll) % roll == 0){// error 2
    error = true;
    Aturn = true;
    Btotal -= (2*roll);
    if(Btotal <1){
                    Btotal = 1;
            }
    Bfinish();
}
}

public void berror4(){
if( (Btotal + roll) % roll != 0 && bprime == false){// error 4
    error = true;
    Aturn = true;
    Btotal += roll;
}
Bfinish();
}

public void Bfinish(){
	if(Atotal>= 50){
		done = true;
		}

if(done){
PrintWinner();
}
else{
if(error == false){
    Btotal += roll;
    Aturn = true;
    System.out.println(roll);
    ShowStatus();
}
else{
	System.out.println(roll);
    Aturn = true;
    ShowStatus();
    }
}
}
}