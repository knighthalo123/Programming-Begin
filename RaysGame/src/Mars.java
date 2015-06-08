//Ray Zhang
//01/12/12
//Mars.java
//This program

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;

public class Mars
{
       private char [][]grid;
       private final int SIZE,SIZE2;
       private int r, c, ice, hem, aliencount,turn, counter;
       private char direction, player, alien;
       private String temp;
       private boolean border;


       public Mars()
       {
               border = true;
               SIZE = 25;
               SIZE2 = 26;
               grid = new char[SIZE][SIZE2];
               for(int row = 0; row < grid.length; row++)
               {

                       for(int col = 1; col < grid[row].length; col++)
                       {
                               grid[row][col] = '-';
                       }
               }

               grid[0][0] = '0';
               grid[1][0] = '1';
               grid[2][0] = '2';
               grid[3][0] = '3';
               grid[4][0] = '4';
               grid[5][0] = '5';
               grid[6][0] = '6';
               grid[7][0] = '7';
               grid[8][0] = '8';
               grid[9][0] = '9';
               grid[10][0] = '0';
               grid[11][0] = '1';
               grid[12][0] = '2';
               grid[13][0] = '3';
               grid[14][0] = '4';
               grid[15][0] = '5';
               grid[16][0] = '6';
               grid[17][0] = '7';
               grid[18][0] = '8';
               grid[19][0] = '9';
               grid[20][0] = '0';
               grid[21][0] = '1';
               grid[22][0] = '2';
               grid[23][0] = '3';
               grid[24][0] = '4';


       }

       public static void main(String[] args)
       {
               Mars surface = new Mars();
               surface.Repeat();
               surface.input();
               surface.createCharacter();
               surface.loadRocks();
               surface.printGrid();
               surface.moveCharacter();
               surface.createAlien();

       }
       
       public void Repeat()
       {
            loadRocks();
            input();
            createCharacter();
            createAlien();
            
            for(turn = 0; turn <= 30; turn++)
            {
                printGrid();
                if(turn == 30)
                {
                    break;
                }
                moveCharacter();
                
            }
            System.out.print("\n\n\nTHANK YOU FOR VISITING MARS, GOODBYE!!!!\n\n");
            
        }
       
       public void input()
       {
               Scanner keyboard = new Scanner(System.in);
               System.out.print("Enter a grid row coordinate (0 - 24, -1 for random choice) -> ");
               r = keyboard.nextInt();
               if(r == -1)
               {
                  r = (int)(Math.random() * 26);
               }
               System.out.print("Enter a grid column coordinate (0 - 24, -1 for random choice) -> ");
               c = keyboard.nextInt();
               if(c == -1)
               {
                 c = (int)(Math.random() * 25 + 1);
               }
       }

       public void createCharacter()
       {
               player = 'R';
               grid[r][c] = player;

       }

       public void printGrid()
       {
               
               System.out.print("__________________________________________________________________________________");
               System.out.print("STATUS REPORT: ROW:" + r + " COLUMN:" + c + " " + turn + " OF 30 STEPS TAKEN\n");
               System.out.print("COLLECTED: " + ice + " ICE SAMPLES, " + hem + " HEMATITE SAMPLES " + aliencount + " ALIEN ENCOUNTERS");
               System.out.print("\n   0  1  2  3  4  5  6  7  8  9  0  1  2  3  4  5  6  7  8  9  0  1  2  3  4 \n");
               for(int row = 0; row < grid.length; row++)
               {
                    for(int col = 0; col < grid[row].length; col++)
                    {
                         if(col == 0)
                         {
                           System.out.print(grid[row][col] + "  ");  
                         }
                         else
                         {
                             
                             if((col + 3 >= c && col -3 <= c)&& (row + 3 >= r && row - 3 <= r)&& (Math.abs(row-r) + Math.abs(col-c) <= 3))
                            {
                                System.out.print(grid[row][col] + "  ");
                            }
                            else
                            {
                                System.out.print("   ");
                            }    
                         }
                         //System.out.print(grid[row][col] + "  ");
                    }
                    System.out.println();
                }
        
        }

       public void loadRocks()
       {
               Scanner reader;
               try
               {
                       reader = new Scanner(new File("Rocks.txt"));
                       getIce(reader);
                       getHematite(reader);
                       reader.close();
               }
               catch(FileNotFoundException e)
               {
                       System.out.println("NO FILE FOUND");
                       System.exit(1);
               }
       }

       public void getIce(Scanner read)
       {
               int icenum = read.nextInt();
               for(int i = 0; i < icenum; i++)
               {
                       int row = read.nextInt();
                       int col = read.nextInt();
                       grid[row][col] = 'I';
               }
       }

       public void getHematite(Scanner read)
       {
               int hemnum = read.nextInt();
               for(int h = 0; h < hemnum; h++)
               {
                       int row = read.nextInt();
                       int col = read.nextInt();
                       grid[row][col] = 'H';
               }
       }
       
       public void moveCharacter()
       {
           Scanner keyboard = new Scanner(System.in);
           
           System.out.print("\n\n'a' is left, 'd' is right, 'w' is up, and 's' is down");
           border = true;
           while(border)
          {   
            System.out.print("\nEnter a letter choice to move -> "); 
            temp = keyboard.nextLine();
            direction = temp.charAt(0);
            switch(direction)
            {
                case 'a': 
                {
                    if(c-1 <= 0)
                    {
                        border = true;                        
                    }
                    else
                    {
                        border = false;
                        grid[r][c] = '-';
                            if(grid[r][c-1] == 'I')
                            {
                                ice++;
                            }
                            
                            if(grid[r][c-1] == 'H')
                            {
                                hem++;
                            }    
                            
                            if(grid[r][c-1] == '@')
                            {
                                aliencount++;
                                player = alien;
                            }    
                            grid[r][c-1] = player;
                            c = c-1;
                    }
                    break;
                }
                
                case 'w':
                {
                    if(r -1 < 0)
                    {
                        border = true;
                    }
                    else
                    {
                        border = false;
                        grid[r][c] = '-';
                            if(grid[r-1][c] == 'I')
                            {
                                ice++;
                            }
                            
                            if(grid[r-1][c] == 'H')
                            {
                                hem++;
                            }    
                            
                            if(grid[r-1][c] == '@')
                            {
                                aliencount++;
                                player = alien;
                            }    
                            grid[r-1][c] = player;
                            r = r-1;
                    }
                    break;
                }
                
                case 's':
                {
                    if(r+1 >= 25)
                    {
                        border = true;
                    }
                    else
                    {
                        border = false;
                        grid[r][c] = '-';
                            if(grid[r+1][c] == 'I')
                            {
                                ice++;
                            }
                            
                            if(grid[r+1][c] == 'H')
                            {
                                hem++;
                            }    
                            
                            if(grid[r+1][c] == '@')
                            {
                                aliencount++;
                                player = alien;
                            }    
                            grid[r+1][c] = player;
                            r = r+1;
                            break;
                    }
                    break;
                }
                                
                case 'd':
                {
                    if(c+1 >=26)
                    {
                        border = true;
                    }
                    else
                    {
                        border = false;
                        grid[r][c] = '-';
                            if(grid[r][c+1] == 'I')
                            {
                                ice++;
                            }
                            
                            if(grid[r][c+1] == 'H')
                            {
                                hem++;
                            }    
                            
                            if(grid[r][c+1] == '@')
                            {
                                aliencount++;
                                player = alien;
                            }    
                            grid[r][c+1] = player;
                            c = c+1;
                    }
                    break;
                         
                }
                
                }
            }
    }
    public void createAlien()
    {
        int temp, temp2;
        alien = '@';
        temp = (int)(Math.random() * 26);
        temp2 = (int)(Math.random() * 25 + 1);
        grid[temp][temp2] = alien;
    }
}