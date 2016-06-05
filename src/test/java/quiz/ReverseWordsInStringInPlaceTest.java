package quiz;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsInStringInPlaceTest {

	@Test
	public void reverseSingleWord() {
		char [] start = { 'a', 'b', 'c' };
		char [] expected = { 'a', 'b', 'c' };
		
		ReverseWordsInStringInPlace instance = new ReverseWordsInStringInPlace();
		char [] actual = instance.reverse(start);
		for (int index = 0; index < start.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}


	@Test
	public void reverseTwoWords() {
		char [] start = { 'a', 'b', 'c', ' ', 'd', 'e', 'f', 'g' };
		char [] expected = { 'd', 'e', 'f', 'g', ' ',  'a', 'b', 'c'};
		
		ReverseWordsInStringInPlace instance = new ReverseWordsInStringInPlace();
		char [] actual = instance.reverse(start);
		for (int index = 0; index < start.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}

	@Test
	public void reverseThreeWords() {
		char [] start = { 'a', 'b', 'c', ' ', 'd', 'e', 'f', 'g', ' ', 'x', 'y', 'z' };
		char [] expected = {  'x', 'y', 'z', ' ', 'd', 'e', 'f', 'g', ' ',  'a', 'b', 'c'};
		
		ReverseWordsInStringInPlace instance = new ReverseWordsInStringInPlace();
		char [] actual = instance.reverse(start);
		for (int index = 0; index < start.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}
	
	@Test
	public void reverseThreeWordsPreceedingWhiteSpace() {
		char [] start = { ' ', ' ', 'a', 'b', 'c', ' ', 'd', 'e', 'f', 'g', ' ', 'x', 'y', 'z' };
		char [] expected = { 'x', 'y', 'z', ' ', 'd', 'e', 'f', 'g', ' ',  'a', 'b', 'c', ' ', ' ' };
		
		ReverseWordsInStringInPlace instance = new ReverseWordsInStringInPlace();
		char [] actual = instance.reverse(start);
		for (int index = 0; index < start.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}

	
	@Test
	public void reverseThreeWordsTrailingWhiteSpace() {
		char [] start = { 'a', 'b', 'c', ' ', 'd', 'e', 'f', 'g', ' ', 'x', 'y', 'z', ' ', ' ' };
		char [] expected = { ' ', ' ', 'x', 'y', 'z', ' ', 'd', 'e', 'f', 'g', ' ',  'a', 'b', 'c' };
		
		ReverseWordsInStringInPlace instance = new ReverseWordsInStringInPlace();
		char [] actual = instance.reverse(start);
		for (int index = 0; index < start.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}

}
