package quiz;

public class ReverseStringInPlace {

	
	public char [] reverse(char [] array) {
		int begin = 0;
		int end = array.length - 1;
		while (begin < end) {
			char tmp = array[begin];
			array[begin] = array[end];
			array[end] = tmp;
			begin++;
			end--;
		}
		return array;
	}
	
}
