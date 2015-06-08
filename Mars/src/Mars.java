// Stephen Hung
// January 15, 2013
// Mars.java

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Scanner;

import java.util.Random;
public class Mars {

        Random rand = new Random(); // Random number generator object.
        Random rand1 = new Random();
        Random rand2 = new Random();
        Scanner inputer = new Scanner(System.in); // Scanner object
        int row, column; // number of rows and columns.
        int rowI, columnI; // row and column numbers for Ice.
        int rowH, columnH; // Row and column numbers for Hermatite.
        int inum, hnum, anum; // number of Ice, number of Hermatite ores, and number of Alien Encounters.
        int Iscore, Hscore; // number of Ice gotten and number of Hermatite ore gotten.
        int steps; // number of steps the user takes.
        char move = ' ';
        File ifile = new File("rocks.txt"); // creates a File object to hold rocks.txt
        Scanner input; // A Scanner to read rocks.txt.
        String list; // String Object containing the locations of ice and hermatite.
        int counter, overallcounter;
        String mover;

        char [][] ground = new char [25][25];

        public static void main (String args[]) { // calls Methods to run Mars
                Mars m = new Mars();
                m.TextReader();
                m.Intro();
                        m.Board();
        }

        public void Intro(){

                do{
                        System.out.print("Enter a grid row coordinate (0 - 24, -1 for random choice) -> ");
                        row = inputer.nextInt();
                }while(row < -1 || row > 24);

                do{
                        System.out.print("Enter a grid column coordinate (0 - 24, -1 for random choice) -> ");
                        column = inputer.nextInt();
                }while(column < -1 || column > 24);

                if(row == -1){
                        row = rand.nextInt(24);
                }
                if(column == -1){
                        column = rand.nextInt(24);
                }


                if(ground[row][column] == 'H'){
                        Hscore++;
                        ground[row][column] = 'R';
                }
                if(ground[row][column] == 'I'){
                        Iscore++;
                        ground[row][column] = 'R';
                }
                ground[row][column] = 'R';

                ground[rand1.nextInt(25)][rand2.nextInt(25)] = '@';

        }

        public void TextReader(){
                try{
                        input = new Scanner(ifile);
                }catch(IOException e){
                        System.out.println("Error: rocks.txt could not be found.");
                        System.exit(1);
                }

                while(input.hasNext()){
                        inum = input.nextInt();
                        for(int a = 0; a < inum; a++){
                                rowI = input.nextInt();
                                columnI = input.nextInt();
                                ground[rowI][columnI] = 'I';
                        }

                        hnum = input.nextInt();
                        for(int b = 0; b < hnum; b++){
                                rowH = input.nextInt();
                                columnH = input.nextInt();
                                ground[rowH][columnH] = 'H';
                        }

                }
                input.close();

        }

        public void Board(){
                for(int a = 0; a < 24; a++){
                        for(int b = 0; b < 24; b++){
                                if( ground[a][b] != 'I' && ground[a][b] != 'H' && ground[a][b] != 'R'
&& ground[a][b] != '@'  ){
                                        ground[a][b] = ' ';
                                }
                        }
                }


                //STATUS REPORT: ROW:9 COLUMN: 18               1 OF 30 STEPS TAKEN
        //COLLECTED: 0 ICE SAMPLES,  0 HEMATITE SAMPLES 0 ALIEN ENCOUNTERS
        inputer.nextLine();
        while(steps != 30){

                System.out.println("STATUS REPORT: ROW: " + row + " COLUMN: " +
column + "\t\t" + steps + " OF 30 STEPS TAKEN");
                System.out.println("COLLECTED: " + Iscore + " ICE SAMPLES, " +
Hscore + " HEMATITE SAMPLES " + anum + " ALIEN ENCOUNTERS");

                        for(int x = 0; x < 24; x++){ // prints top horizontal numbers.
                                for(int z = 0; z < 24; z++){
                                        if(counter == 10){
                                                counter = 0;
                                        }

                                        if(overallcounter <= 25){
                                                System.out.print(counter + " ");
                                        }

                                        counter++;
                                        overallcounter++;
                                }
                        }
                        System.out.println();
                        counter = 0;
                        for(int c = 0; c < 24; c++){
                                if(counter == 9){ // pritns out vertical numbers.
                                        counter = 0;
                                }

                                if(overallcounter <= 25){
                                        System.out.print(counter);
                                }

                                counter++;
                                overallcounter++;
                                System.out.print(counter);
                                for(int d = 0; d < 24; d++){
                                        System.out.print(ground[c][d] + " ");
                                }
                                System.out.println();
                        }
                         System.out.println("before while loop");
                        while( !(move == 'a' || move == 'd' || move == 'w' || move == 's') ){
                                System.out.println("'a' is left, 'd' is right, 'w' is up, and 's' is down");
                                System.out.print("Enter a letter choice to move -> ");
                                move = inputer.nextLine().charAt(0);
                                System.out.println("move = " + move);
                        }

                        System.out.println(move);
                        System.out.println("before switch statement");
                        switch(move){
                                case 'a' :
                                        if(column != 0){
                                                ground[row][column] = ' ';
                                                column--;
                                                if(ground[row][column] == 'I'){
                                                        Iscore++;
                                                }
                                                else if(ground[row][column] == 'H'){
                                                        Hscore++;
                                                }
                                                else if(ground[row][column] == '@'){
                                                        ground[row][column] = '@';
                                                        anum++;
                                                }
                                                if(anum == 0){
                                                        ground[row][column] = 'R';
                                                }
                                                if(anum == 1){
                                                        ground[row][column] = '@';
                                                }
                                                steps++;
                                        }
                                        break;
                                case 'd' :
                                        if(column != 24){
                                                ground[row][column] = ' ';
                                                column++;
                                                if(ground[row][column] == 'I'){
                                                        Iscore++;
                                                }
                                                else if(ground[row][column] == 'H'){
                                                        Hscore++;
                                                }
                                                else if(ground[row][column] == '@'){
                                                        ground[row][column] = '@';
                                                        anum++;
                                                }
                                                if(anum == 0){
                                                        ground[row][column] = 'R';
                                                }
                                                if(anum == 1){
                                                        ground[row][column] = '@';
                                                }
                                                steps++;
                                        }
                                        break;
                                case 'w' :
                                        if(row != 0){
                                                ground[row][column] = ' ';
                                                row--;
                                                if(ground[row][column] == 'I'){
                                                        Iscore++;
                                                }
                                                else if(ground[row][column] == 'H'){
                                                        Hscore++;
                                                }
                                                else if(ground[row][column] == '@'){
                                                        ground[row][column] = '@';
                                                        anum++;
                                                }
                                                if(anum == 0){
                                                        ground[row][column] = 'R';
                                                }
                                                if(anum == 1){
                                                        ground[row][column] = '@';
                                                }
                                                steps++;
                                        }
                                        break;
                                case 's' :
                                        if(row != 24){
                                                ground[row][column] = ' ';
                                                row++;
                                                if(ground[row][column] == 'I'){
                                                        Iscore++;
                                                }
                                                else if(ground[row][column] == 'H'){
                                                        Hscore++;
                                                }
                                                else if(ground[row][column] == '@'){
                                                        ground[row][column] = '@';
                                                        anum++;
                                                }
                                                if(anum == 0){
                                                        ground[row][column] = 'R';
                                                }
                                                if(anum == 1){
                                                        ground[row][column] = '@';
                                                }
                                                steps++;
                                        }
                                        break;
                        }
                        move = ' ';
                }
        }


}