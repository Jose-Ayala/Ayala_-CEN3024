/*
 * Author Name: Jose Ayala
 * Date: 3/16/2022
 * Program Name: Ayala_CreateSortedFreqMapTest
 * Purpose: JUnit test for the createSortedFreqMap method of the Ayala_module7_word_occurrence class.
*/

package wordOccurences;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

class Ayala_CreateSortedFreqMapTest {

	// Declare and initialize a string array of text.
	String[] wordsArray = { "Chevrolet", "Ford", "Honda", "Mazda", "Ford", "Ford", "Honda", "Ford", "Mercedes", "BMW",
			"Ford", "Mazda" };

	// Create an instance of the Ayala_module7_word_occurrenceclass
	Ayala_module7_word_occurrence occurences = new Ayala_module7_word_occurrence();

	// Test for the first key in the map after counting and sorting
	@Test
	void testFirstKey() {

		LinkedHashMap<String, Integer> sortedMap = occurences.createSortedFreqMap(wordsArray);
		
		// Test the first key/value from the sorted map
		Entry<String, Integer> firstKeyValue = sortedMap.entrySet().iterator().next();
		assertEquals(firstKeyValue.getKey(), "Ford");
	}
	
	// Test for the first value in the map after counting and sorting
	@Test
	void testFirstValue() {

		LinkedHashMap<String, Integer> sortedMap = occurences.createSortedFreqMap(wordsArray);
		
		// Test the first key/value from the sorted map
		Entry<String, Integer> firstKeyValue = sortedMap.entrySet().iterator().next();
		assertEquals(firstKeyValue.getValue(), 5);
	}
}
