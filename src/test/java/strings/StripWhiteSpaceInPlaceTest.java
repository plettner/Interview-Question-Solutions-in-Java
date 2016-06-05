package strings;

import org.junit.Assert;
import org.junit.Test;

public class StripWhiteSpaceInPlaceTest {

	private StripWhiteSpaceInPlace instance = new StripWhiteSpaceInPlace();

	@Test
	public void stripLeading() {
		char[] start = { ' ', ' ', 'a', 'b', ' ', 'c', ' ' };
		char[] expected = { 'a', 'b', 'c' };

		char[] actual = instance.strip(start);
		Assert.assertEquals(expected.length, actual.length);
		for (int index = 0; index < actual.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}

	@Test
	public void nothingToStrip() {
		char[] start = { 'a', 'b', 'c' };
		char[] expected = { 'a', 'b', 'c' };

		char[] actual = instance.strip(start);
		Assert.assertEquals(expected.length, actual.length);
		for (int index = 0; index < actual.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}

}
