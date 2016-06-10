package balance;

import org.junit.Assert;
import org.junit.Test;

public class BalanceParensTest {

	private final BalanceParens instance = new BalanceParens();

	@Test
	public void balancedSimple() {
		final String data = "()";
		Assert.assertTrue(this.instance.isBalanced(data));
	}

	@Test
	public void balancedSingleLeft() {
		final String data = "(";
		Assert.assertFalse(this.instance.isBalanced(data));
	}

	@Test
	public void balancedSingleRight() {
		final String data = ")";
		Assert.assertFalse(this.instance.isBalanced(data));
	}

	@Test
	public void balancedTwoRight() {
		Assert.assertFalse(this.instance.isBalanced("())"));
	}

	@Test
	public void balancedComplex1() {
		final String data = "()()()";
		Assert.assertTrue(this.instance.isBalanced(data));
	}

	@Test
	public void balancedComplex2() {
		final String data = "(()()())";
		Assert.assertTrue(this.instance.isBalanced(data));
	}

	@Test
	public void balancedComplex3_False() {
		final String data = "(()()))";
		Assert.assertTrue(!this.instance.isBalanced(data));
	}

	@Test
	public void balancedComplex4_false() {
		final String data = "((()())";
		Assert.assertTrue(!this.instance.isBalanced(data));
	}

	@Test
	public void balancedComplex5_extraspaces() {
		final String data = " ( () () () ) ";
		Assert.assertTrue(this.instance.isBalanced(data));
	}

}
