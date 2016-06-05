package strings;

import org.junit.Assert;
import org.junit.Test;

public class RemoveRepeatingCharactersTest {

	private RemoveRepeatingCharacters instance = new RemoveRepeatingCharacters();

	@Test
	public void success() {
		char[] data = { 'A', 'A', 'B', 'A', 'B', 'B', 'B', 'C' };
		char[] expected = { 'A', 'B', 'C' };

		char[] actual = instance.removeRepeatingChars(data);
		Assert.assertEquals(expected.length, actual.length);
		for (int index = 0; index < actual.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}

	@Test
	public void successEmpty() {
		char[] data = {};
		char[] expected = {};

		char[] actual = instance.removeRepeatingChars(data);
		Assert.assertEquals(expected.length, actual.length);
		for (int index = 0; index < actual.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}

	@Test
	public void successNoDupes() {
		char[] data = { 'A', 'B', 'C' };
		char[] expected = { 'A', 'B', 'C' };

		char[] actual = instance.removeRepeatingChars(data);
		Assert.assertEquals(expected.length, actual.length);
		for (int index = 0; index < actual.length; index++) {
			Assert.assertEquals(expected[index], actual[index]);
		}
	}

}
