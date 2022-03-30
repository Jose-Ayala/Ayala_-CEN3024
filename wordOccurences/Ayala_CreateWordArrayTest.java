/*
 * Author Name: Jose Ayala
 * Date: 3/16/2022
 * Program Name: Ayala_CreateWordArrayTest
 * Purpose: JUnit test for the createWordsArray method of the Ayala_module7_word_occurrence class.
*/

package wordOccurences;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Ayala_CreateWordArrayTest {

	// Declare and initialize a string of text.
	String urlText = "Write a text analyzer that reads a file and outputs statistics about that file.";
	
	// Create an instance of the Ayala_module7_word_occurrenceclass
	Ayala_module7_word_occurrence occurences = new Ayala_module7_word_occurrence();

	// Test the length of the array
	@Test
	void testWordsArrayLength() {

		// Test the length of createWordsArray method of the Ayala_module7_word_occurrence class.
		String[] wordsArray = occurences.createWordsArray(urlText);
		assertEquals(wordsArray.length, 14);
	}

	// Test the contents of the array
	@Test
	void testWordsArrayContents() {

		// Test the contents of createWordsArray method of the Ayala_module7_word_occurrence class.
		String[] wordsArray = occurences.createWordsArray(urlText);
		assertTrue(Arrays.asList(wordsArray).contains("statistics"));

	}

}
