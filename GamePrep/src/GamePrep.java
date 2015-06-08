// Stephen Hung
// 4/1/2013
// GamePrep.java
// A program to practice programming Java components and layouts.


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.*;
public class GamePrep {
        private MyButtonPanel buttons;
        private JFrame frame;

        public static void main (String[] args) {
                GamePrep gpa = new GamePrep();
                gpa.Run();
        }

        public void Run() {
                // Initialize and set up the JFrame
                frame = new JFrame("GamePrep");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1000, 500);
                frame.setResizable(false);

                // Create the colors panel and buttons panel
                buttons = new MyButtonPanel();
                buttons.setBackground(Color.gray);

                // add the JPanels to the frame
                frame.getContentPane().add(buttons, BorderLayout.SOUTH);
                frame.getContentPane().add(buttons.dp,BorderLayout.WEST);

                // make the frame visible
                frame.setVisible(true);
        }


        class MyButtonPanel extends JPanel{ // JPanel 1 for JButtons
                private JButton comp1, comp2, comp3, comp4;
                comp1listener c1 = new comp1listener();
                comp2listener c2 = new comp2listener();
                comp3listener c3 = new comp3listener();
                comp4listener c4 = new comp4listener();
                boolean co1,co2,co3,co4;
                Image image;
                DrawPanel dp;

                public MyButtonPanel() {
                        co1 = co2 = co3 = co4 = false;
                        dp = new DrawPanel();

                        setLayout(new GridLayout());

                        comp1 = new JButton("Click to use JComponent 1");
                        this.add(comp1);
                        comp1.addActionListener(c1);

                        comp2 = new JButton("Click to use JComponent 2");
                        this.add(comp2);
                        comp2.addActionListener(c2);

                        comp3 = new JButton("Click to use JComponent 3");
                        this.add(comp3);
                        comp3.addActionListener(c3);

                        comp4 = new JButton("Click to use JComponent 4");
                        this.add(comp4);
                        comp4.addActionListener(c4);

                        dp.setPreferredSize(new Dimension(250,443));
                        this.add(dp);
                }

                class comp1listener implements ActionListener{
                        public void actionPerformed(ActionEvent e){
                                co1 = true;
                                dp.Run();
                                dp.repaint();
                        }
                }
                class comp2listener implements ActionListener{
                        public void actionPerformed(ActionEvent e){
                                co2 = true;

                        }
                }
                class comp3listener implements ActionListener{
                        public void actionPerformed(ActionEvent e){
                                co3 = true;
                        }
                }
                class comp4listener implements ActionListener{
                        public void actionPerformed(ActionEvent e){
                                co4 = true;
                        }
                }

                class DrawPanel extends JPanel{
                        perform p = new perform();
                        Timer time = new Timer(10,p);
                        int counter;

                        public DrawPanel(){
                                counter = 0;
                        }

                        class perform implements ActionListener{
                                public void actionPerformed(ActionEvent e){
                                        counter++;
                                        if(counter == 10){
                                                time.stop();
                                        }
                                        repaint();
                                }
                        }

                        public void Run(){
                                try{
                                        image = ImageIO.read(new File("character.jpg"));
                                }catch(IOException e){
                                        System.err.println("Error: picture.jpg not found");
                                        System.exit(1);
                                }
                        }
                        public void paintComponent(Graphics g){
                                super.paintComponent(g);

                                g.setColor(Color.white);
                                g.fillRect(0,0,250,443);

                                g.setColor(Color.black);
                                if(co1){
                                        time.start();
                                        g.drawImage(image,counter,counter,10,10,this);
                                        co1 = false;
                                        repaint();
                                }
                        }
                }


        }



}