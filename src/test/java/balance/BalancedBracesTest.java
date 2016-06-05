package balance;

import org.junit.Assert;
import org.junit.Test;

public class BalancedBracesTest {
	
	BalancedBraces instance = new BalancedBraces();

	@Test
	public void balancedParens() {
		String data = "()";
		Assert.assertTrue(instance.isBalanced(data));
	}

	@Test
	public void balancedCurlies() {
		String data = "{}";
		Assert.assertTrue(instance.isBalanced(data));
	}

	@Test
	public void balancedSquares() {
		String data = "[]";
		Assert.assertTrue(instance.isBalanced(data));
	}

	@Test
	public void balancedMix() {
		String data = "{{[[([])]]}}";
		Assert.assertTrue(instance.isBalanced(data));
	}
	
	@Test
	public void notBalanced1() {
		String data = "(";
		Assert.assertFalse(instance.isBalanced(data));
	}

	@Test
	public void notBalanced2() {
		String data = "((((((((((((((()))))))))))))";
		Assert.assertFalse(instance.isBalanced(data));
	}

	@Test
	public void notBalancedTooManyRight() {
		String data = "))))))))))))";
		Assert.assertFalse(instance.isBalanced(data));
	}


	@Test
	public void emptyString() {
		String data = "";
		Assert.assertTrue(instance.isBalanced(data));
	}


	@Test
	public void emptySuperfluousChars() {
		String data = " (xx{yy[foofoofoo]yy}xx) ";
		Assert.assertTrue(instance.isBalanced(data));
	}

}
