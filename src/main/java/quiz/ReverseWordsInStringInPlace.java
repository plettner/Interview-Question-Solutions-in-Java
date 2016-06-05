package quiz;

public class ReverseWordsInStringInPlace {

	public char [] reverse(char [] array) {

		int index = 0;
		int begin = 0;
		int end = 0;
		while (index < array.length) {
			
			// skip any spaces
			while (index < array.length && array[index] == ' ') {
				index++;
			}
			
			// Mark the start of a word
			begin = index;
			
			// Find end of the word
			while (index < array.length && array[index] != ' ') {
				end = index;
				index++;
			}
			
			reverseWord(array, begin, end);
		}
		
		reverseWord(array, 0, array.length - 1);
		
		return array;
		
	}
	
	private void reverseWord(char [] array, int begin, int end) {
		while (begin < end) {
			char tmp = array[begin];
			array[begin] = array[end];
			array[end ] = tmp;
			begin++;
			end--;
		}
	}
}
