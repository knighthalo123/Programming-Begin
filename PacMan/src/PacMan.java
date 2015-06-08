// Stephen Hung
// March 4,2013
// PacMan.java
// This program will create a basic version of the PacMan game,
// where the "PacMan" attemps to get 6 pieces of cheese
// to win the game, if touched by a "Ghost" the game ends.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class PacMan extends JFrame{

        public static void main (String args[]) {
                        PacMan pm = new PacMan();
                        pm.Run();
        }

        public void Run(){
                        JFrame frame = new JFrame("PacMan"); // creates JFrame
                        GamePanel gp = new GamePanel(); // creates GamePanel object
                        InstructionPanel ip = new InstructionPanel(); // create InstructionPanel object

                        ip.setPreferredSize(new Dimension(520,100)); // sets size of instruction panel
                        frame.setLocation(450,0); // sets location
                        frame.setResizable(true); // sets resizable false
                        frame.setVisible(true); // sets visible true
                        frame.setSize(560,710); // sets size to 510 by 600
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes program on window close
                        frame.getContentPane().add(gp,BorderLayout.CENTER); // adds GamePanel to JFrame
                        frame.getContentPane().add(ip, BorderLayout.SOUTH); // adds InstructionPanel to JFrame
                        frame.addKeyListener(gp); // adds KeyListener to JPanel

        }
}

class GamePanel extends JPanel implements KeyListener{
        Random rand = new Random(); // random object for rand numb
        Random timing = new Random(); // random object for rand timing
        int array[][] = new int [2][13]; // array to hold points
        int mouthangle, chooser, counter; // mouth angle, random number, and global counter
        int cheesecounter;// a cheese counter
        boolean firsttime, gameover; // first time running program boolean and
        // game over boolean
        boolean mouthopen; // is mouth is open
        MouthOpener mo = new MouthOpener(); // MouthOpener object
        Timer mouth = new Timer(5,mo); // mouth opening timer
        Monster m = new Monster();
        Timer monster = new Timer(250,m);

        private class MouthOpener implements ActionListener{ /// mouth opener
        /// ActionListener
                        public void actionPerformed(ActionEvent e){
                                        if(mouthopen){ /// start of mouthopening method
                                        // if boolean mouthopen is true, increase mouthangle
                                        // if not decreases mouthangle
                                                        mouthangle++; // increase mouthangle (mouth moves down)
                                        }else{ // else
                                                        mouthangle--; // decreases mouthangle(mouth moves up)
                                        }
                                        if(mouthangle == 0 || mouthangle == 60){ // if mouthangle is 0 or 60
                                                        mouthopen = !mouthopen; // makes it go back up or down
                                        } /// end of mouthopening method

                                        repaint();
                        }
        }

        private class Monster implements ActionListener{ /// monster moving ActionListener
                        public void actionPerformed(ActionEvent e){
                                if(gameover == false){
                                        for(int i = 1; i <=6; i++){
                                        chooser = rand.nextInt(10); // moves monster
                                                switch(chooser){ /// different movements
                                                        case 1 : array[1][i]-=50; //'w'
                                                                if(array[1][i] <= 0){ // wraparound to the bottom
                                                                        array[1][i]+= 500;
                                                                }
                                                                break;
                                                        case 2 : array[0][i]-=50; // 'a'
                                                                if(array[0][i] <= 0){ //wraparound to the right
                                                                        array[0][i]+=500;
                                                                }
                                                                break;
                                                        case 3: array[1][i]+=50; // 's'
                                                                if(array[1][i] >= 500){ // wraparound to the top
                                                                        array[1][i]-=500;
                                                                }
                                                                break;
                                                        case 4 : array[0][i]+=50; // 'd'
                                                                if(array[0][i] >= 500){ // wraparound to the left
                                                                        array[0][i]-=500;
                                                                }
                                                                break;
                                                } /// end switch
                                        }
                                        repaint();
                                }
                        }
        }
        public GamePanel(){
                        firsttime = true;
                        gameover = false;
                        mouthangle = 1;
                        counter = 1;
                        mouth.start(); // makes PacMan's mouth move from the start
        }
        public void paintComponent(Graphics g){
                        monster.start(); // starts monster timer.
                        super.paintComponent(g);
                        setBackground(Color.blue); // sets background to blue
                        setSize(580,610); // sets size of panel
                        g.setColor(Color.white); // sets color for the gamepanel
                        g.fillRect(20,20,500,500); // draws gamepanel
                        g.setColor(Color.lightGray); // sets color for lines
                        for(int a = 20; a < 550; a+=50){ // draws grid
                                        for(int b = 20;b < 550; b+=50){
                                                        g.drawLine(a,b,a,a); // vertical line
                                                        g.drawLine(a+1,b+1,a+1,a+1); // makes line thicker
                                                        g.drawLine(a+2,b+2,a+2,a+2); // makes line thicker
                                                        g.drawLine(b,a,a,a); // horizontal line
                                                        g.drawLine(b+1,a+1,a+1,a+1); // makes line thicker
                                                        g.drawLine(b+2,a+2,a+2,a+2); // makes line thicker
                                        }
                        } // ends for loop for drawing grid

                        if(firsttime){ /// start of beginning positioning
                        // creates for loop to make sure it only
                        // creates random coordinates when the program is first run
                                        do{ // sets the coordinates for PacMan in the square
                                                        array[0][0] = rand.nextInt(500);
                                                        array[1][0] = rand.nextInt(500);
                                        }while(array[0][0] % 50 != 0 || array[1][0] % 50 != 0);
                                        array[0][0] += 20; // aligns it to the grid
                                        array[1][0] +=20; // aligns it to the grid

                                        for(int a = 1; a<=6; a++){ // sets coordiantes for Ghosts
                                                        do{ // sets the coordinates for Ghosts in the square
                                                                        array[0][a] = rand.nextInt(500);
                                                                        array[1][a] = rand.nextInt(500);
                                                        }while(array[0][a] % 50 != 0 || array[1][a] % 50 != 0);
                                                        array[0][a] +=20;
                                                        array[1][a] +=20;
                                        }
                                        for(int a = 7; a<=12; a++){ // sets coordiantes for Cheese
                                                        do{ // sets the coordinates for Cheese in the square
                                                                        array[0][a] = rand.nextInt(500);
                                                                        array[1][a] = rand.nextInt(500);
                                                        }while(array[0][a] % 50 != 0 || array[1][a] % 50 != 0);
                                                        array[0][a] +=20;
                                                        array[1][a] +=20;
                                        }
                                        firsttime = false;
                        } /// end of beginning positioning

                        for(int a = 7; a<=12; a++){ // cheese checker
                                if(array[0][a] == array[0][0] && array[1][a] == array[1][0]){
                                        cheesecounter++;
                                        array[0][a] = -100; // remove cheese from panel
                                        array[1][a] = -100;
                                }
                        }

                        for(int x = 7; x <=12; x++){ // draws cheese
                                g.setColor(Color.yellow);
                                g.fillRect(array[0][x]+1,array[1][x]+1,48,48);
                        }
                        for(int x = 1; x <=6; x++){ // draws ghost
                                g.setColor(Color.red);
                                g.fillArc(array[0][x],array[1][x],50,50,0,360); // actual ghost
                                g.fillArc(array[0][x]+10,array[1][x]+40,40,10,0,360); // tail
                                g.setColor(Color.black);
                                g.fillRect(array[0][x]+10,array[1][x]+10,5,5); // eye on the left
                                g.fillRect(array[0][x]+30,array[1][x]+10,5,5); // eye on the right
                                g.fillRect(array[0][x]+15,array[1][x]+25,5,5); // mouth 1
                                g.fillRect(array[0][x]+30,array[1][x]+25,5,5); // mouth 2
                                g.fillRect(array[0][x]+20,array[1][x]+30,10,5); // mouth
                        }
                        g.setColor(Color.blue); // set blue for PacMan
                        g.fillArc(array[0][0],array[1][0],50,50,mouthangle/2,360-mouthangle);//draws PacMan
                        if(counter == 6){ // resets counter
                                counter = 1;
                        }
                        if(cheesecounter == 6){ // all cheeses eaten
                                mouth.stop();
                                gameover = true;
                                g.setColor(Color.green);
                                g.setFont(new Font("Arial", Font.BOLD,100));    // font name, style, size
                                g.drawString("You Win!",35,200);
                        }
                        for(int a = 1; a<=6; a++){ //ghost checker
                                if(array[0][a] == array[0][0] && array[1][a] == array[1][0]){
                                        monster.stop();
                                        mouth.stop();
                                        gameover = true;
                                        g.setColor(Color.orange
                                        );
                                        g.setFont(new Font("Arial", Font.BOLD,90));     // font name, style, size
                                        g.drawString("You Lose!",35,200);
                                }
                        }
        }

        public void keyPressed(KeyEvent e){
        int x , y;
                        char c = e.getKeyChar();// gets key input
                        switch(c){
                        case 'w':
                                if(gameover == false){
                                        array[1][0]-=50; // if w moves up
                                        if(array[1][0] <= 0){ // wraparound to the bottom
                                                array[1][0]+= 500;
                                        }
                                        for(int a = 7; a<=12; a++){ // cheese checker
                                                if(array[0][a] == array[0][0] && array[1][a] == array[1][0]){
                                                        cheesecounter++;
                                                        array[0][a] = -100; // remove cheese from panel
                                                        array[1][a] = -100;
                                                }
                                        }
                                repaint();
                                }
                        break;
                        case 'a':
                                if(gameover == false){
                                        array[0][0]-=50;  // if a moves left
                                        if(array[0][0] <= 0){ //wraparound to the right
                                                array[0][0]+=500;
                                        }
                                        for(int a = 7; a<=12; a++){ // cheese checker
                                                if(array[0][a] == array[0][0] && array[1][a] == array[1][0]){
                                                        cheesecounter++;
                                                        array[0][a] = -100; // remove cheese from panel
                                                        array[1][a] = -100;
                                                }
                                        }
                                repaint();
                                }
                        break;
                        case 's':
                                if(gameover == false){
                                        array[1][0]+=50; // if s moves down
                                        if(array[1][0] >= 500){ // wraparound to the top
                                                array[1][0]-=500;
                                        }
                                        for(int a = 7; a<=12; a++){ // cheese checker
                                                if(array[0][a] == array[0][0] && array[1][a] == array[1][0]){
                                                        cheesecounter++;
                                                        array[0][a] = -100; // remove cheese from panel
                                                        array[1][a] = -100;
                                                }
                                        }
                                repaint();
                                }
                        break;
                        case 'd':
                                if(gameover == false){
                                        array[0][0]+=50; // if d moves right
                                        if(array[0][0] >= 500){ // wraparound to the left
                                                array[0][0]-=500;
                                        }
                                        for(int a = 7; a<=12; a++){ // cheese checker
                                                if(array[0][a] == array[0][0] && array[1][a] == array[1][0]){
                                                        cheesecounter++;
                                                        array[0][a] = -100; // remove cheese from panel
                                                        array[1][a] = -100;
                                                }
                                        }
                                repaint();
                                }
                        break;
                        case 'r':
                                firsttime = true;
                                mouth.start();
                                monster.start();
                                cheesecounter = 0;
                                counter = 1;
                                mouthangle = 1;
                                gameover = false;
                                repaint();
                        break;
                        }
        }

        public void keyTyped(KeyEvent e){}

        public void keyReleased(KeyEvent e){}
}

class InstructionPanel extends JPanel{ // draws instructions for playing PacMan.
        public void paintComponent(Graphics g){
                        super.paintComponent(g);
                        setBackground(Color.red);
                        g.setFont(new Font("Comic Sans", Font.BOLD,10)); // font name, style, size
                        g.drawString("Directions: a = left, d = right, w = up, s = down, r = reset",100,75); // draws directions
        }
}