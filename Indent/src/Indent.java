//Ray Zhang
//10/22/13
//Indent.java
//This program reads in a program that is scrambled
//and reformats it so that it follows the allman writing convention
//The textfile is also changed, along with the display in the terminal window of the changed version.

import java.util.Scanner;//For reading in text files and writing them, and anticipating error messages
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Indent
{
	String filename;
	public Indent()//Constructor
	{
	}
	public Indent(String name)
	{
		filename = name;
	}
	public static void main(String[] args)
	{
		Indent reformat = new Indent(args[0]);
		reformat.putIntoString();
	} 
	private void putIntoString()
	{
		Scanner read;
		String program = "";
		read = OpenFile.openToRead(filename);
		while(read.hasNext())
		{
			program += read.nextLine();
		}
		program = findRemoval(program);
		System.out.println("\n\n\n" + program);
		program = addFormatting(program);
		PrintWriter write;
		write = OpenFile.openToWrite("Testing.java");
		write.print(program);
		write.close();
		System.out.println("\n\n" + program);
	}
	
	private String findRemoval(String raw)
	{
		while(raw.indexOf('\t') != -1 || raw.indexOf('\n') != -1)
			if(raw.indexOf('\t') != -1)
				raw = removeCharacters(raw, '\t');
			else
				raw = removeCharacters(raw, '\n');
		return raw;
	}
	
	private String removeCharacters(String raw, char remove)
	{
		raw = raw.substring(0, raw.indexOf(remove)) + raw.substring(raw.indexOf(remove)+1);
		return raw;
	}
	
	private String addFormatting(String raw)
	{
		System.out.println(raw);
		int forcounter = 0, ifelsecounter = 0, indent = 0;
		String program = "";
		for(int i = 0; i < raw.length(); i++)
		{
			//If import keyword, give new line
			if(i < raw.length() - 6 && raw.substring(i,i+6).equals("import"))
				program += '\n';
			//If there is a semicolon, and it is NOT preceded by a for loop, then next line
			if(i < raw.length() - 3 && raw.substring(i,i+3).equals("for"))
				forcounter = 2;
			//if((i < raw.length() - 2 && raw.substring(i,i+2).equals("if")) || (i < raw.length() - 4 && raw.substring(i,i+4).equals("else")))
			//	ifelsecounter = 1;
			if(raw.charAt(i) == ';')
			{
				if(forcounter != 0)
				{
					forcounter --;
					program += raw.charAt(i);
				}
				else
				{
					program += raw.charAt(i);
					program += '\n';
					program = addIndent(program,indent);
				}
			}
			//If there are '{' or '}', then next line AND add indent
			else if(raw.charAt(i) == '}' || raw.charAt(i) == '{')
			{
				program += '\n';
				if(raw.charAt(i) == '}')
				{
					indent--;
					program = addIndent(program,indent);
					program += raw.charAt(i);
				}

				if(raw.charAt(i) == '{')
				{
					program = addIndent(program,indent);
					program += raw.charAt(i);
					indent++;
					program += '\n';
				}
				
				program = addIndent(program,indent);
			}
			//If there is an IF or ELSE statement, followed by a ')', then next line
			else if(raw.charAt(i) == ')')
			{
				if(ifelsecounter != 0)
				{
					ifelsecounter = 0;
					program += raw.charAt(i);
					program += '\n';
					program = addIndent(program,indent);
				}
				else
				{
					program += raw.charAt(i);
					//program = addIndent(program,indent);
				}
			}
			//If there are no errors, just add the letter
			else
			{
				program += raw.charAt(i);
			}
		}
		//Remove indents
		program = removeIndents(program);
		//If there are any excess spaces, detected by seeing spaces after indents, spaces after new lines, then REMOVE
		
		return program;
	}
	//removes indents between two parentheses anywhere inside the program
	private String removeIndents(String program)
	{
		int start, end;
		for(int i = 0; i < program.length(); i ++)
		{
			if(program.charAt(i) == '}')
			{
				for(int e = i+1; e < program.length(); e++)
				{
					if(program.charAt(e) != '\t' || program.charAt(e) != '\n')
					{
						if(program.charAt(e) == '}')
							program = program.substring(0,i+1) + program.substring(e);
						else
							break;
					}
				}
			}
		}
		return program;
	}
	private String addIndent(String program, int indent)
	{
		for(int e = 0; e < indent; e++)
		{
			program += "\t";
		}
		return program;
	}
}