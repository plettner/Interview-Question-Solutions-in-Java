package quiz;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringInPlaceTest {

	@Test
	public void reverseOddLength() {
		char [] start = { 'a', 'b', 'c', 'd', 'e' };
		char [] expected= { 'e', 'd', 'c', 'b', 'a' };
		
		ReverseStringInPlace rsip = new ReverseStringInPlace();
		char [] actual = rsip.reverse(start);
		for (int index = 0; index < start.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}

	@Test
	public void reverseEvenLength() {
		char [] start = { 'a', 'b', 'c', 'd' };
		char [] expected= { 'd', 'c', 'b', 'a' };
		
		ReverseStringInPlace rsip = new ReverseStringInPlace();
		char [] actual = rsip.reverse(start);
		for (int index = 0; index < start.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}
	
	@Test
	public void reverseEmptyArray() {
		char [] start = {};
		char [] expected = {};
		
		ReverseStringInPlace rsip = new ReverseStringInPlace();
		char [] actual = rsip.reverse(start);
		for (int index = 0; index < start.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}
}
