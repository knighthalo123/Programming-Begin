// Stephen Hung
// March 19, 2013
// Me.java
// This program will display text and images about myself.

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.*;



public class Me extends JFrame{
        Image image,image2,image3,image4,image5;
        int counter;
        String name1 = "math.jpg";
        String name2 = "Food.jpg";
        String name3 = "Gaming.jpg";
        String name4 = "Swimming.jpg";
        String name5 = "Violin Photo.jpg";
        PicturePanel pp = new PicturePanel();

        public static void main (String args[]) {
                Me m = new Me();
                m.Run();
        }

        public void Run(){
                JFrame frame = new JFrame("Me");

                GetMyImage();

                frame.setLocation(500,50);
                frame.setSize(500,700);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(pp,BorderLayout.CENTER);
                frame.addKeyListener(pp);
                frame.addMouseListener(pp);
                System.out.println("HI");
        }

        public void GetMyImage(){
                System.out.println("GetMyImage");
                try{
                        image = ImageIO.read(new File(name1));
                        image2 = ImageIO.read(new File(name2));
                        image3 = ImageIO.read(new File(name3));
                        image4 = ImageIO.read(new File(name4));
                        image5 = ImageIO.read(new File(name5));
                }catch(IOException e){
                        System.out.println("Error: picture not found.");
                        System.exit(1);
                }
        }

        class PicturePanel extends JPanel implements KeyListener, MouseListener{

                public PicturePanel(){
                        repaint();
                }
                public void paintComponent(Graphics g){
                        super.paintComponent(g);
                        switch(counter){
                                case 0: g.drawImage(image,0,0,500,500,this);
                                break;
                                case 1: g.drawImage(image2,0,0,500,500,this);
                                break;
                                case 2: g.drawImage(image3,0,0,500,500,this);
                                break;
                                case 3: g.drawImage(image4,0,0,500,500,this);
                                break;
                                case 4: g.drawImage(image5,0,0,500,500,this);
                                break;
                        }
                }
                public void keyPressed(KeyEvent e){}
                public void keyTyped(KeyEvent e){}
                public void keyReleased(KeyEvent e){}

                public void mouseReleased(MouseEvent e){}
                public void mouseClicked(MouseEvent e){
                        counter++;
                        if(counter >=5){
                                counter = 0;
                        }
                        repaint();
                }
                public void mousePressed(MouseEvent e){}
                public void mouseExited(MouseEvent e){}
                public void mouseEntered(MouseEvent e){}

        }

        class DescriptionPanel extends JPanel{}
}