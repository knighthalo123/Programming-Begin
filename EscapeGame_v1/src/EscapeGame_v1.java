/*
 * 	 Developed by Abdullah Alharbi
 *   user.afh@gmail.com
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class EscapeGame_v1 extends JFrame 
{
	private JPanel boxPanel = new JPanel();
	private Graphics2D g;

	
	private JLabel score;
	private JLabel scoreNumber;
	private JLabel pause;
	private JLabel menu;
	
	private String pauseString = "Pause";
	private String continueString = "Continue";
	
	private boolean newGame = true;
	private boolean fired;
	private boolean running;
	private boolean jumping;
	private boolean killed;
	private boolean runningState;
	private boolean firstJump = true;
	private boolean doneJumping;
	private boolean pauseState;
	private boolean resume;
	private boolean menuPressed;
	private boolean gameRestarted;
	private boolean add;
	private boolean added;
	private boolean otherWindowIsRunning;
	
	private double angle;
	
	private int scoreCount = 0;
	
	private ArrayList<Integer> scores = new ArrayList<Integer>();
	
	private int bulletSpeed = 8;
	
	private int width;
	private int height;
	
	//// pistol
	private int pistolX1;
	private int pistolY1;
	private int pistolX2;
	private int pistolY2;
	private double pistolAngle;
	
	//// head
	//head coordinate
	private int headX;
	private int headY;
	//head width&height
	private int headW;
	private int headH;
	
	//// body
	// body coordinate
	private int bodyX1;
	private int bodyY1;
	private int bodyX2;
	private int bodyY2;
	
	//// hands
	// right hand
	private int rightHandX1;
	private int rightHandY1;
	private int rightHandX2;
	private int rightHandY2;
	private int rightHandX3;
	private int rightHandY3;
	// left hand
	private int leftHandX1;
	private int leftHandY1;
	private int leftHandX2;
	private int leftHandY2;
	private int leftHandX3;
	private int leftHandY3;
	
	//// legs
	// right leg
	private int rightLegX1;
	private int rightLegY1;
	private int rightLegX2;
	private int rightLegY2;
	// left leg
	private int leftLegX1;
	private int leftLegY1;
	private int leftLegX2;
	private int leftLegY2;
	

	
	public EscapeGame_v1()
	{
		super("Escape Game (Beta version)");
		setResizable(false);
		setSize(600, 650);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		boxPanel.setLayout(new FlowLayout());
		boxPanel.setBackground(Color.WHITE);
		
		addMouseMotionListener(new MouseML());
		addMouseListener(new MouseL());
		addKeyListener(new KeyL());
		
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(1, 3));
		north.setBackground(Color.BLACK);
		
		pause = new JLabel("Pause");
		pause.setFont(new Font("Arial Black", Font.PLAIN , 20));
		pause.setForeground(Color.WHITE);
		pause.addMouseListener(new MouseL());
		
		
		JLabel none = new JLabel("");
		
		menu = new JLabel("Menu");
		menu.setFont(new Font("Arial Black", Font.PLAIN , 20));
		menu.setForeground(Color.WHITE);
		
		
		
		north.add(pause); north.add(none); north.add(menu);
		
		JPanel south = new JPanel();
		south.setBackground(Color.BLACK);
		south.setLayout(new FlowLayout());
		
		score = new JLabel("Score: ");
		score.setFont(new Font("Arial Black", Font.PLAIN , 20));
		score.setForeground(Color.WHITE);
		
		scoreNumber = new JLabel("0");
		scoreNumber.setFont(new Font("Arial Black", Font.PLAIN, 20));
		scoreNumber.setForeground(Color.WHITE);
		
		south.add(score); south.add(scoreNumber);
		
		
		JPanel west = new JPanel();
		west.setBackground(Color.BLACK);
		
		JPanel east = new JPanel();
		east.setBackground(Color.BLACK);
		
		add(boxPanel, BorderLayout.CENTER);
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(west, BorderLayout.WEST);
		add(east, BorderLayout.EAST);
	}
	
	
	
	public void paint(Graphics gf)
	{
		super.paint(gf);
		
		g = (Graphics2D)boxPanel.getGraphics();
		
							/////////////////////////////////
		                    //   values and coordinates    //
							/////////////////////////////////
		width  = (int)Math.round(boxPanel.getWidth());
		height = (int)Math.round(boxPanel.getHeight());
		
		if(newGame)
		{
			//// head
			//head coordinate
			headX = 80;
			headY = (height-80) - 1;
		}
		
		//head width&height
		headW = 30;
		headH = 30;
		
		if(!running)
		{
			//// body
			// body coordinate
			bodyX1 = headX + (headW/2);
			bodyY1 = headY + headH;
			bodyX2 = headX + (headW/2);
			bodyY2 = headY + headH + 20;
			
			//// hands
			// right hand
			rightHandX1 = bodyX1;
			rightHandY1 = bodyY1 + 5;
			if(newGame)
			{
				rightHandX2 = bodyX1 + (headW/2) + 5;
				rightHandY2 = bodyY1 + 5 + 5;
				pistolX1 = rightHandX2;
				pistolY1 = rightHandY2-3;
				pistolX2 = rightHandX2;
				pistolY2 = rightHandY2-3;
				pistolAngle  = 0.3;
			}
			// left hand
			leftHandX1 = bodyX1;
			leftHandY1 = bodyY1 + 5;
			leftHandX2 = bodyX1 - (headW/2) - 5;
			leftHandY2 = bodyY1 + 5 + 5;
			
			//// legs
			// right leg
			rightLegX1 = bodyX2;
			rightLegY1 = bodyY2;
			rightLegX2 = bodyX2 + 10;
			rightLegY2 = bodyY2 + 30;
			// left leg
			leftLegX1 = bodyX2;
			leftLegY1 = bodyY2;
			leftLegX2 = bodyX2 - 10;
			leftLegY2 = bodyY2 + 30;
			
			
		}
		else
		{
			if(!runningState)
			{
				runningOne();
			}
			else
			{
				runningTwo();
			}
		}
		
		if(jumping)
			jumping();
		
		if(doneJumping)
			jumping = false;
		
						/////////////////////////////////
				        //      	drawing area       //
						/////////////////////////////////
		g.setColor(Color.BLACK);
		
		//drawing head
		g.fillOval(headX, headY, headW, headH);
		
		//drawing body
		g.drawLine(bodyX1, bodyY1, bodyX2, bodyY2);
		
		//drawing right hand
		g.drawLine(rightHandX1, rightHandY1, rightHandX2, rightHandY2);
		//drawing left hand
		g.drawLine(leftHandX1, leftHandY1, leftHandX2, leftHandY2);
		
		//drawing right leg
		g.drawLine(rightLegX1, rightLegY1, rightLegX2, rightLegY2);
		//drawing left leg
		g.drawLine(leftLegX1, leftLegY1, leftLegX2, leftLegY2);
		
		//drawing pistol
		g.rotate(pistolAngle, pistolX1, pistolY1);
		g.fillRect(pistolX2, pistolY2, 10, 5);
		g.fillRect(pistolX1, pistolY1, 3, 10);	
	}
	
	
	private class MouseML extends MouseMotionAdapter
	{
		public void mouseMoved(MouseEvent e)
		{

			newGame = false;
			
			if(!fired)
			{
				int A, B, C, a, b, c;
				
				A = (e.getX() - rightHandX1);
				B = (e.getY() - rightHandY1);
				C = (int) Math.round(Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2)));
				
				angle = Math.atan(B/(double) A);
				
				if(e.getX() < rightHandX1)
					c = 22;
				else
					c = -22;
				
				a = (int) Math.round(Math.cos(angle) * c);
				b = (int) Math.round(Math.sin(angle) * c);
				
				rightHandX2 = (rightHandX1 - a);
				rightHandY2 = (rightHandY1 - b);
				
				if(e.getX() < rightHandX1)
				{
					pistolX1 = rightHandX2 - 3;
					pistolY1 = (rightHandY2-3);
					pistolX2 = rightHandX2 - 10;
					pistolY2 = (rightHandY2-3);
				}
				else
				{
					pistolX1 = rightHandX2;
					pistolY1 = (rightHandY2-3);
					pistolX2 = rightHandX2;
					pistolY2 = (rightHandY2-3);
				}
				
				pistolAngle  = angle;
				
				repaint();
			}
		}
	}
	
	private class MouseL extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			if(!fired)
			{
				new FireThread().start();
				gameRestarted = false;
				if(!gameRestarted)
					new ScoreCountThread().start();
				
				fired = true;
			}
			
			if(e.getX()<80 && e.getY()<44)
			{
				if(!otherWindowIsRunning)
				{
					if(!menuPressed)
					{
						if(!pauseState)
						{
							pause.setText(continueString);
							pauseState = true;
						}
						else
						{
							pause.setText(pauseString);
							pauseState = false;
		
						}
					}
				}
			}
			
			if(e.getX()>395 && e.getX()<457 && e.getY()<44)
			{
				if(!otherWindowIsRunning)
				{
					pauseState = true;
					menuPressed = true;
					MenuWindow mw = new MenuWindow();
				}
				
			}
		}
	}
	
	private class KeyL extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				
			{
				if(fired)
				{
					if(!killed)
					{
						if(!pauseState)
						{
							newGame = false;
							running = true;
							new RightMovingThread().start();
						}
					}
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if(fired)
				{
					if(!killed)
					{
						if(!pauseState)
						{
							newGame = false;
							running = true;
							new LeftMovingThread().start();
						}
					}
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				if(fired)
				{
					jumping = true;
					if(firstJump)
					{
						new JumpThread().start();
						firstJump = false;
					}
					if(doneJumping)
						new JumpThread().start();
				}
			}
		}
	}
	
	private class FireThread extends Thread
	{
		private Graphics2D bullet = (Graphics2D)boxPanel.getGraphics();
		
		private int width  = (int) Math.round(boxPanel.getWidth())-9;
		private int heigth = (int) Math.round(boxPanel.getHeight())-9;
		
		private int x = pistolX2 + 10;
		private int y = pistolY2 - 11;
		
		private int x_velocity = (int) Math.round(Math.cos(angle) * 5);
		private int y_velocity = (int) Math.round(Math.sin(angle) * 5);
		
		int count = 0;
		
		
		public void run()
		{
			while(!killed)
			{
				while(!pauseState)
				{
					
					
					if(x<0)
					{
						x = 0;
						x_velocity = -x_velocity;
					}
					else if(x>width)
					{
						x = width;
						x_velocity = -x_velocity;
					}
					
					if(y<0)
					{
						y = 0;
						y_velocity = -y_velocity;
					}
					else if(y>height-9)
					{
						y = height-9;
						y_velocity = -y_velocity;
					}
					
					
					
					if(count==0)
					{
						if(x < rightHandX1)
						{
							x_velocity = -x_velocity;
							y_velocity = -y_velocity;
						}
					}
					

					
					bullet.setColor(Color.RED);
					
					bullet.fillOval(x+=x_velocity, y+=y_velocity, 9, 9);
					
					
					

					
					if(count>3)
					{
						if(bullet.hit(new Rectangle(x, y, 9, 9), new Rectangle(headX, headY, 30, 30), false) ||
					   		bullet.hit(new Rectangle(x, y, 9, 9), new Line2D.Double(bodyX1, bodyY1, bodyX2, bodyY2), false) ||
					   		bullet.hit(new Rectangle(x, y, 9, 9), new Line2D.Double(rightHandX1, rightHandY1, rightHandX2, rightHandY2), false) ||
					   		bullet.hit(new Rectangle(x, y, 9, 9), new Line2D.Double(leftHandX1, leftHandY1, leftHandX2, leftHandY2), false) ||
					   		bullet.hit(new Rectangle(x, y, 9, 9), new Line2D.Double(rightLegX1, rightLegY1, rightLegX2, rightLegY2), false) ||
					   		bullet.hit(new Rectangle(x, y, 9, 9), new Line2D.Double(leftLegX1, leftLegY1, leftLegX2, leftLegY2), false))
					   		{
					   			killed = true;
					   			
					   			if(!isHeightScore(scoreCount))
					   			{
					   				otherWindowIsRunning = true;
					   				new DeadWindow();
					   			}
					   			else
					   			{
					   				scores.add(scoreCount);
					   				otherWindowIsRunning = true;
					   				new DeadWindowWithNewHeightScore();
					   			}
					   			break;
					  		 }
					}
					
						
					
					count++;
					

					pause(bulletSpeed);
						
					if(count%10==0)
						repaint();
						
					if(!fired)
						break;
				}
				if(!fired)
						break;
			}
		}
		
		public void pause(int mise)
		{
			try
			{
				Thread.sleep(mise);
			}
			catch(InterruptedException e)
			{
				
			}
		}
	}
	
	
	private class RightMovingThread extends Thread
	{
		public void run()
		{
			if(headX > boxPanel.getWidth())
				headX = 5;
			else
				headX += 10;
			repaint();
		}
	}
	
	private class LeftMovingThread extends Thread
	{
		public void run()
		{
			if(headX < 0)
				headX = (int)Math.round(boxPanel.getWidth());
			else
				headX -= 10;
			repaint();
		}
	}

	private class JumpThread extends Thread
	{
		public void run()
		{
			int ground = (int) Math.round(boxPanel.getHeight());
			int rate = 22;
			while(!killed)
			{
				while(headY <= 500)
				{
					System.out.println("y" + headY);
					while(!pauseState)
					{
						doneJumping = false;
						pause(30);
						
						headY -= (rate--);
						
						// in case it doesn't work with you correctly just change(473) to the first y printed in the output
						if(headY>=473)
							break;
					
						
						repaint();
						
						if(!fired)
							break;
						if(killed)
							break;
					}
					//same thing here
					if(headY==473)
						break;

					if(killed)
						break;
				}
				if(headY==473)
					break;
			}
			doneJumping = true;
		}
		
		public void pause(int mise)
		{
			try
			{
				Thread.sleep(mise);
			}
			catch(InterruptedException e)
			{
				
			}
		}
	}
	
	private class ScoreCountThread extends Thread
	{
		public void run()
		{
			while(!killed)
			{
		//		if(gameRestarted)
		//			return;
				while(!pauseState)
				{
					pause(750);
					scoreCount++;
					scoreNumber.setText(""+scoreCount);
					
					if(gameRestarted)
						return;
					if(killed)
						return;
				}
				
				if(gameRestarted)
					return;
			}
		}
		
		public void pause(int mise)
		{
			try
			{
				Thread.sleep(mise);
			}
			catch(InterruptedException e)
			{
				
			}
		}
	}
	
	
	private class MenuWindow extends JWindow
	{
		public MenuWindow()
		{
			setSize(300, 350);
			setLocation(220, 150);
			setVisible(true);
			setLayout(new GridLayout(5, 1));
			getContentPane().setBackground(Color.BLACK);
			
			
			
			String[] str = new String[5];
			str[0] = "Resume";
			str[1] = "Restart";
			str[2] = "Top Scores";
			str[3] = "About";
			str[4] = "Exit";
			
			for(int i=0; i<5; i++)
			{
				JLabel l = new JLabel(str[i]);
				l.setFont(new Font("Arial Black", Font.PLAIN, 30));
				l.setForeground(Color.WHITE);
				
				JPanel p = new JPanel();
				p.setLayout(new FlowLayout());
				p.setBackground(Color.BLACK);
				
				p.add(l);
				add(p);
			}
			
			addMouseListener(new MouseListener());
			
		}
		
		private class MouseListener extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				
				if(e.getY()>22 && e.getY()<47)
				{
					//resume
					menuPressed = false;
					resume = true;
					setVisible(false);
					pauseState = false;
				}
				if(e.getY()>92 && e.getY()<118)
				{
					//restart
					newGame = true;
					gameRestarted = true;
					killed = false;
					fired = false;
					running = false;
					menuPressed = false;
					pauseState = false;
					scoreCount = 0;
					scoreNumber.setText(""+scoreCount);
					repaint();
					setVisible(false);
				}
				if(e.getY()>161 && e.getY()<194)
				{
					//Top Scores
					new ScoreWindow();
				}
				if(e.getY()>231 && e.getY()<258)
				{
					//about
					new AboutWindow();
				}
				if(e.getY()>299 && e.getY()<328)
				{
					//exit
					System.exit(0);
				}
				
			}
		}
	}
	
	private class ScoreWindow extends JWindow
	{
		public ScoreWindow()
		{
			setSize(300, 350);
			setLocation(220, 150);
			setVisible(true);
			setLayout(new BorderLayout());
			getContentPane().setBackground(Color.BLACK);
			
			Collections.sort(scores);

			
			JLabel top = new JLabel("Top Scores");
			
			top.setFont(new Font("Arial Black", Font.PLAIN, 30));
			top.setForeground(Color.WHITE);
			
			
			JPanel up = new JPanel();
			up.setLayout(new FlowLayout());
			up.setBackground(Color.BLACK);
			
			up.add(top);
			
			//center area
			
			JPanel center = new JPanel();
			center.setBackground(Color.BLACK);
			
			
			JPanel[] scoreList;
			JLabel[] hScore;
			
			int cnt = 0;
			
			if(scores.size()<10)
			{
				center.setLayout(new GridLayout(scores.size(), 1));
				scoreList = new JPanel[scores.size()];
				hScore = new JLabel[scores.size()];
				
				for(int i=scores.size(); i>0; i--)
				{
					scoreList[cnt] = new JPanel();
					scoreList[cnt].setLayout(new FlowLayout());
					scoreList[cnt].setBackground(Color.BLACK);
					
					hScore[cnt] = new JLabel("(Top" + (cnt+1) + "): " + scores.get(i-1));
					hScore[cnt].setFont(new Font("Arial Black", Font.PLAIN, 17));
					hScore[cnt].setForeground(Color.YELLOW);
					
					scoreList[cnt].add(hScore[cnt]);
					center.add(scoreList[cnt]);
					cnt++;
				}
			}
			else
			{
				center.setLayout(new GridLayout(10, 1));
				scoreList = new JPanel[10];
				hScore = new JLabel[10];
				
				for(int i=scores.size(); i>scores.size()-10; i--)
				{
					scoreList[cnt] = new JPanel();
					scoreList[cnt].setLayout(new FlowLayout());
					scoreList[cnt].setBackground(Color.BLACK);
					
					hScore[cnt] = new JLabel("(Top" + (cnt+1) + "): " + scores.get(i));
					hScore[cnt].setFont(new Font("Arial Black", Font.PLAIN, 17));
					hScore[cnt].setForeground(Color.YELLOW);
					
					scoreList[cnt].add(hScore[cnt]);
					center.add(scoreList[cnt]);
					cnt++;
				}
			}
			
			
			JLabel back = new JLabel("Back");

			back.setFont(new Font("Arial Black", Font.PLAIN, 15));
			back.setForeground(Color.RED);
			
			JPanel down = new JPanel();
			down.setLayout(new FlowLayout());
			down.setBackground(Color.BLACK);
			
			down.add(back);
					
			addMouseListener(new MouseListener());
			
			add(up, BorderLayout.NORTH); add(center, BorderLayout.CENTER); add(down, BorderLayout.SOUTH);
			
		}
		
		private class MouseListener extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getX() > 126 && e.getX() < 173 && e.getY() > 324 && e.getY() < 342)
					setVisible(false);
			}
		}
	}
	

	private class AboutWindow extends JWindow
	{
		public AboutWindow()
		{
			setSize(300, 350);
			setLocation(220, 150);
			setVisible(true);
			setLayout(new GridLayout(3, 1));
			getContentPane().setBackground(Color.BLACK);
			
			
			

			
			JLabel about = new JLabel("About");
			
			about.setFont(new Font("Arial Black", Font.PLAIN, 30));
			about.setForeground(Color.WHITE);
			
			
			JPanel up = new JPanel(); 
			up.setLayout(new FlowLayout());
			up.setBackground(Color.BLACK);
			
			up.add(about);
			
			JPanel center = new JPanel();
			center.setLayout(new FlowLayout());
			center.setBackground(Color.BLACK);
			
			String[] text = new String[4];
			
			text[0] = "Developed by Abdullah Alharbi";
			text[1] = "user.afh@gmail.com";
			
			for(int i=0; i<2; i++)
			{
				JLabel t = new JLabel(text[i]);
				t.setFont(new Font("Arial Black", Font.PLAIN, 15));
				t.setForeground(Color.WHITE);
				center.add(t);
			}
			
			
			JLabel back = new JLabel("Back");

			back.setFont(new Font("Arial Black", Font.PLAIN, 15));
			back.setForeground(Color.RED);
			
			JPanel down = new JPanel();
			down.setLayout(new FlowLayout());
			down.setBackground(Color.BLACK);
			
			down.add(back);
					
			addMouseListener(new MouseListener());
			
			add(up); add(center); add(down);
			
		}
		
		private class MouseListener extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getX() > 128 && e.getX() < 173 && e.getY() > 237 && e.getY() < 258)
					setVisible(false);
			}
		}
	}
	
	
	private class DeadWindow extends JWindow
	{
		public DeadWindow()
		{
			setSize(350, 100);
			setLocation(140, 250);
			setVisible(true);
			setLayout(new GridLayout(2, 1));
			
			JPanel panel1 = new JPanel();
			panel1.setLayout(new FlowLayout());
			panel1.setBackground(Color.BLACK);
			
			JLabel dead = new JLabel("GAME   OVER");
			
			panel1.add(dead);
			
			dead.setFont(new Font("Arial Black", Font.PLAIN, 30));
			dead.setForeground(Color.RED);
			
			
			JPanel panel2 = new JPanel();
			panel2.setLayout(new FlowLayout());
			panel2.setBackground(Color.BLACK);
			
			JLabel resGame = new JLabel("New Game              Exit");
			
			resGame.setFont(new Font("Arial Black", Font.PLAIN, 20));
			resGame.setForeground(Color.WHITE);

			panel2.add(resGame);
			
			addMouseListener(new MouseL());
			
			add(panel1); add(panel2);
		}
		
		private class MouseL extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getX()>44 && e.getX()<166 && e.getY()>56 && e.getY()<79)
				{
					// restart
					newGame = true;
					gameRestarted = true;
					killed = false;
					fired = false;
					running = false;
					menuPressed = false;
					pauseState = false;
					otherWindowIsRunning = false;
					scoreCount = 0;
					scoreNumber.setText(""+scoreCount);
					repaint();
					setVisible(false);
				}
				
				if(e.getX()>241 && e.getX()<288 && e.getY()>56 && e.getY()<79)
				{
					// exit
					System.exit(0);
				}
			}
		}
	}
	

	private class DeadWindowWithNewHeightScore extends JWindow
	{
		public DeadWindowWithNewHeightScore()
		{
			setSize(350, 135);
			setLocation(140, 250);
			setVisible(true);
			setLayout(new GridLayout(3, 1));
			
			JPanel panel1 = new JPanel();
			panel1.setLayout(new FlowLayout());
			panel1.setBackground(Color.BLACK);
			
			JLabel dead = new JLabel("GAME   OVER");
			
			panel1.add(dead);
			
			JPanel panel2 = new JPanel();
			panel2.setLayout(new FlowLayout());
			panel2.setBackground(Color.BLACK);
			
			JLabel heightScore = new JLabel("congratulations! You recored a new height score.");
			heightScore.setForeground(Color.YELLOW);
			
			panel2.add(heightScore);
			
			dead.setFont(new Font("Arial Black", Font.PLAIN, 30));
			dead.setForeground(Color.RED);
			
			
			JPanel panel3 = new JPanel();
			panel3.setLayout(new FlowLayout());
			panel3.setBackground(Color.BLACK);
			
			JLabel resGame = new JLabel("New Game              Exit");
			
			resGame.setFont(new Font("Arial Black", Font.PLAIN, 20));
			resGame.setForeground(Color.WHITE);

			panel3.add(resGame);
			
			addMouseListener(new MouseL());
			
			add(panel1); add(panel2); add(panel3);
		}
		
		private class MouseL extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				
				if(e.getX()>44 && e.getX()<166 && e.getY()>97 && e.getY()<119)
				{
					// restart
					newGame = true;
					gameRestarted = true;
					killed = false;
					fired = false;
					running = false;
					menuPressed = false;
					pauseState = false;
					otherWindowIsRunning = false;
					scoreCount = 0;
					scoreNumber.setText(""+scoreCount);
					repaint();
					setVisible(false);
				}
				
				if(e.getX()>241 && e.getX()<288 && e.getY()>97 && e.getY()<119)
				{
					// exit
					System.exit(0);
				}
			}
		}
	}
	
	
	public void runningOne()
	{
				//// body
				// body coordinate
				bodyX1 = headX + (headW/2);
				bodyY1 = headY + headH;
				bodyX2 = headX + (headW/2);
				bodyY2 = headY + headH + 20;
				
				rightHandX1 = bodyX1;
				rightHandY1 = bodyY1 + 5;
				
				rightHandX2 = bodyX1 + (headW/2) + 5;
				rightHandY2 = bodyY1 + 5;
				
				pistolX1 = rightHandX2;
				pistolY1 = rightHandY2-3;
				pistolX2 = rightHandX2;
				pistolY2 = rightHandY2-3;
				pistolAngle  = 0.3;
				
				// left hand
				leftHandX1 = bodyX1;
				leftHandY1 = bodyY1 + 5;
				leftHandX2 = bodyX1 - (headW/2) - 5;
				leftHandY2 = bodyY1 + 10;
				
				//// legs
				// right leg
				rightLegX1 = bodyX2;
				rightLegY1 = bodyY2;
				rightLegX2 = bodyX2 + 25;
				rightLegY2 = bodyY2 + 30;
				
				// left leg
				leftLegX1 = bodyX2;
				leftLegY1 = bodyY2;
				leftLegX2 = bodyX2 - 15;
				leftLegY2 = bodyY2 + 30;
				
				runningState = true;
	}
	
	
	public void runningTwo()
	{
		//// body
				// body coordinate
				bodyX1 = headX + (headW/2);
				bodyY1 = headY + headH;
				bodyX2 = headX + (headW/2);
				bodyY2 = headY + headH + 20;
				
				rightHandX1 = bodyX1;
				rightHandY1 = bodyY1 + 5;
				
				rightHandX2 = bodyX1 + (headW/2) + 5;
				rightHandY2 = bodyY1 + 7;
				
				pistolX1 = rightHandX2;
				pistolY1 = rightHandY2-3;
				pistolX2 = rightHandX2;
				pistolY2 = rightHandY2-3;
				pistolAngle  = 0.3;
				
				// left hand
				leftHandX1 = bodyX1;
				leftHandY1 = bodyY1 + 5;
				leftHandX2 = bodyX1 - (headW/2) - 5;
				leftHandY2 = bodyY1 + 5;
				
				//// legs
				// right leg
				rightLegX1 = bodyX2;
				rightLegY1 = bodyY2;
				rightLegX2 = bodyX2 + 30;
				rightLegY2 = bodyY2 + 30;
				
				// left leg
				leftLegX1 = bodyX2;
				leftLegY1 = bodyY2;
				leftLegX2 = bodyX2 - 20;
				leftLegY2 = bodyY2 + 30;
				
				runningState = false;
	}
	
	
	public void jumping()
	{
		//// body
				// body coordinate
				bodyX1 = headX + (headW/2);
				bodyY1 = headY + headH;
				bodyX2 = headX + (headW/2);
				bodyY2 = headY + headH + 20;
				
				rightHandX1 = bodyX1;
				rightHandY1 = bodyY1 + 5;
				
				rightHandX2 = bodyX1 + (headW/2) + 5;
				rightHandY2 = bodyY1 + 7;
				
				pistolX1 = rightHandX2;
				pistolY1 = rightHandY2-3;
				pistolX2 = rightHandX2;
				pistolY2 = rightHandY2-3;
				pistolAngle  = 0.3;
				
				// left hand
				leftHandX1 = bodyX1;
				leftHandY1 = bodyY1 + 5;
				leftHandX2 = bodyX1 - (headW/2) - 5;
				leftHandY2 = bodyY1 + 5;
				
				//// legs
				// right leg
				rightLegX1 = bodyX2;
				rightLegY1 = bodyY2;
				rightLegX2 = bodyX2 + 30;
				rightLegY2 = bodyY2 + 5;
				
				// left leg
				leftLegX1 = bodyX2;
				leftLegY1 = bodyY2;
				leftLegX2 = bodyX2 - 20;
				leftLegY2 = bodyY2 + 5;
				
				runningState = false;
	}
	
	
	public boolean isHeightScore(int n)
	{
		int max = 0;
		for(int score : scores)
		{
			if(max<score)
				max = score;
		}
		
		if(n>max)
			return true;
		else
			return false;
	}
	
	
	public static void main(String[] args)
	{
		new EscapeGame_v1().setVisible(true);
	}
}
