package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * The question is to remove all repeated characters, leaving only one instance
 * of each character in the string. Two solutions found online. One is to sort
 * the string, then delete any duplicates. The second is to use a hash map of
 * some sort to track duplicate characters.
 */
public class RemoveRepeatingCharacters {

	/**
	 * This solution to the problem uses a map to track which characters have
	 * been duped. This retains the original ordering of the character array
	 * once the dupes are removed.
	 * 
	 * @param array
	 *            array of characters, possibly with duplicates
	 * @return an array with any duplicate characters removed
	 */
	public char[] removeRepeatingChars(char[] array) {
		Map<Character, Integer> map = new HashMap<>();

		int putIndex = 0;
		for (int getIndex = 0; getIndex < array.length; getIndex++) {
			char ch = array[getIndex];
			Integer count = map.get(ch);
			if (count == null) {
				map.put(ch, 1);
				array[putIndex++] = array[getIndex];
			}
		}

		// We can't null terminate a string in Java. So we'll cheat
		// and create a new, proper length array and copy the results
		// into it.
		char[] newArray = new char[putIndex];
		for (int index = 0; index < newArray.length; index++) {
			newArray[index] = array[index];
		}
		return newArray;
	}
}
