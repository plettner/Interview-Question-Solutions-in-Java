package strings;

/**
 * The question is, How does one strip the white space from a character array in
 * place? This is more of a C language question, given that Java Strings are
 * immutable. But we'll perform the solution using an array of characters. We
 * won't worry about unicode, but some people might ask about this.
 */
public class StripWhiteSpaceInPlace {

	public char [] strip(char [] array) {
		
		int putIndex = 0;
		int getIndex = 0;
		
		while (getIndex < array.length) {
			char ch = array[getIndex];
			if (!isWhiteSpace(ch)) {
				array[putIndex++] = ch;
			}
			getIndex++;
		}
		
		// Because we can't null terminate the string, we need
		// to create a new array here.  We'll pretend we did it
		// in place.
		if (putIndex == array.length) {
			return array;
		}
		
		char [] newArray = new char[putIndex];
		for (int index = 0; index < putIndex; index++) {
			newArray[index] = array[index];
		}
		return newArray;
	}
	
	private boolean isWhiteSpace(char ch) {
		return ch == ' ';
	}
	
}
