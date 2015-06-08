// Stephen Hung
// October 26,2012
// College.java
// This program will help the user choose choices using switch statements.

// Class Variables:
//       english    	   = the character the user inputs to decide the english class they want
//       math         	   = the character the user inputs to decide the math class they want
//       science     	   = the character the user inputs to decide the science they want

// Class Methods:
//       College()         = declares variables
//       main()            = runs methods in the class College
//       EnglishClass()    = Tells the english classes available and 
//                           gets input for what english class the user wants
//       MathClass()       = Tells the math classes available and 
//						     gets input for what math class the user wants
//       ScienceClass()    = Tells the science classes available and
//                           gets input for what science class the user wants
//       PrintInfo()       = Prints out the classes the user chose

import java.util.Scanner;
public class College {

        Scanner input = new Scanner(System.in);
        char english, math, science;


        public College(){
        english = 0;
        math = 0;
        science = 0;
        }
        public static void main (String args[]) {
                College c = new College();
                c.EnglishClass();
                c.MathClass();
                c.ScienceClass();
                c.PrintInfo();



        }



        public void EnglishClass(){

                System.out.println("Welcome to SCHEDULE CHOOSER\n");
                System.out.println("Here are four possible English Classes:");
                System.out.println("\t\t(1) Literature for the Illiterate");
                System.out.println("\t\t(2) AP Lit for try hards");
                System.out.println("\t\t(3) War Journalism");
                System.out.println("\t\t(4) Critiquing for Pessimists");

                System.out.print("\nChoose One Class (1-4)  ->\t");
                english = (char)input.nextInt();
        }

        public void MathClass(){
                System.out.println("Here are four possible Math Classes:");
                System.out.println("\t\t(1) Statistically Impossible(Formulas, Equations, and Theories)");
                System.out.println("\t\t(2) Teaching in Binary");
                System.out.println("\t\t(3) Calculus for Competent People");
                System.out.println("\t\t(4) Money Making 101 as an Accountant");

                System.out.print("\nChoose One Class (1-4)  ->\t");
                math = (char)input.nextInt();

        }

        public void ScienceClass(){
                System.out.println("Here are four possible Science Classes:");
                System.out.println("\t\t(1) Superhero Physics");
                System.out.println("\t\t(2) Magic Logic");
                System.out.println("\t\t(3) Chemical Formulas you never knew");
                System.out.println("\t\t(4) How to Hover 101");

                System.out.print("\nChoose One Class (1-4)  ->\t");
                science = (char)input.nextInt();

        }

        public void PrintInfo(){


                        switch(english){
                        case 1: System.out.println("Literature for the Illiterate");;
                        break;
                        case 2: System.out.println("AP Lit for try hards");
                        break;
                        case 3: System.out.println("War Journalism");
                        break;
                        case 4: System.out.println("Critiquing for Pessimists");
                        break;
                }
                switch(math){

                        case 1: System.out.println("Statistically Impossible (Formulas, Equations, and Theories)");
                        break;
                        case 2: System.out.println("Teaching in Binary");
                        break;
                        case 3: System.out.println("Calculus for Competent People");
                        break;
                        case 4: System.out.println("Money Making 101 as an Accountant");
                        break;
                }
                switch(science){

                        case 1: System.out.println("Superhero Physics");
                        break;
                        case 2: System.out.println("Magic Logic");
                        break;
                        case 3: System.out.println("Chemical Formulas you never knew");
                        break;
                        case 4: System.out.println("How to Hover 101");
                        break;
                }
        }
}