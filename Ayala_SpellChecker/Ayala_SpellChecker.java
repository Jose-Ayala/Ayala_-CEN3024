/*
 * Author Name: Jose Ayala
 * Date: 02/01/2022
 * Program Name: Ayala_SpellChecker
 * Purpose: A program that does spell checking
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ayala_SpellChecker {
	
	// Constants
	private static String FILE_TO_CHECK = "file to check";
	private static String DICTIONARY_FILE = "dictionary file";
	
	// Scanner object for user input.
	private static Scanner keyboard;
	

	// Main Method
	public static void main(String[] args) {
		
		// Scanner object for user input.
		keyboard = new Scanner(System.in);
		
		// ArrayLists for each file
		ArrayList<String> fileToCheckAsList = null;
		ArrayList<String> dictionaryFileAsList = null;
		
		// Ask the user to provide the name of the file to be checked
		while (fileToCheckAsList == null)
		{
			String fileToCheck = fileName(FILE_TO_CHECK);

			fileToCheckAsList = createArrayListFromFile(fileToCheck);
		}
		
		// Ask the user to provide the dictionary file
		while (dictionaryFileAsList == null)
		{
			String fileToCheck = fileName(DICTIONARY_FILE);

			dictionaryFileAsList = createArrayListFromFile(fileToCheck);
		}
		
		// If a word in the fileToCheck is not found in the dictionary, 
		// print the word indicating that it is unknown.
		for (Object word : fileToCheckAsList) 
		{ 
		    if (!dictionaryFileAsList.contains(word))
		    {
		    	System.out.println("\r\nUnknown Word: " + word);
		    	
		    }
		}
		
		// Exit the program
		System.out.println("\r\nThank you for using the Ayala_SpellChecker program.\r\n");
		System.exit(0);		
	}
	
	// Method which asks the user to provide a file name.
	public static String fileName(String fileName)
	{		
		System.out.println("Enter the path/name for the " + fileName + "? (Example: C:\\<file name>). Enter 'Quit' to exit.\r\n");
		String fileToCheck = keyboard.nextLine();
		
		return fileToCheck;
	}
	
	// Method which takes the file and puts it in an ArrayList.
	public static ArrayList<String> createArrayListFromFile(String file)
	{
		// Exit the program if the user enters 'quit'.
		if (file.equalsIgnoreCase("quit"))
		{
			System.out.println("\r\nThank you for using the Ayala_SpellChecker program.\r\n");
			System.exit(0); 
		}
		
		
		Scanner textFile;

		// Put the contents of the file in an ArrayList.
		try 
		{
			textFile = new Scanner(new File(file));
			ArrayList<String> fileAsArrayList = new ArrayList<String>();
			
			while (textFile.hasNextLine())
			{
				
				fileAsArrayList.add(textFile.nextLine());
			}
			
			textFile.close();
			
			return fileAsArrayList;
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR - FILE NOT FOUND: " + file);
		}
		
		return null;
	}

}
