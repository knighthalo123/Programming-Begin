// Stephen Hung
// 9/3/2013
// OpenFile.java
// Create some methods for reading from a file and writing to a file.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OpenFile {
	
	public static Scanner openToRead(String fileString){
		Scanner fromfile = null;
		
		try{
			File fileName = new File(fileString);
			fromfile = new Scanner(fileName);
		}catch(FileNotFoundException e){
			System.out.println("\n\nSorry, but the file could not be found.\n\n");
			System.exit(0);
		}
		
		return fromfile;
	}
	
	public static PrintWriter openToWrite(String fileString){
		PrintWriter tofile = null;
		try{
			tofile = new PrintWriter(fileString);
		}catch(Exception e){
			System.err.println("\n\nSorry but the file could not be opened for writing\n\n");
			System.exit(0);
		}
		return tofile;
	}
}