//Ray Zhang
//9/3/13
//OpenFile.java
//Create utilities for opening txtfile(for reading from and writing to)

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class OpenFile
{
	public OpenFile()
	{
	}
	
	public static Scanner openToRead(String filestring)
	{
		Scanner fromFile = null;
		File filename = new File(filestring);
		try
		{
			fromFile = new Scanner(filename);
		}
		catch(FileNotFoundException e)
		{
			System.out.print("Sorry but no such file was found");
			System.exit(1);//the method returns a 1, a FLAG
		}
		return fromFile;
	}
	
	public static PrintWriter openToWrite(String filestring)
	{
		PrintWriter outFile = null;
		try
		{
			FileWriter fstream = new FileWriter(filestring);
			outFile = new PrintWriter(fstream);
		}
		catch(Exception e)
		{
			System.out.println("Sorry but the file could not be created");
			System.exit(1);
		}
		return outFile;
	}
}