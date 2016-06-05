package balance;

import org.junit.Assert;
import org.junit.Test;

public class BalanceParensTest {

	private BalanceParens instance = new BalanceParens();
	
	@Test
	public void balancedSimple() {
		String data = "()";
		Assert.assertTrue(instance.isBalanced(data));
	}

	@Test
	public void balancedSingleLeft() {
		String data = "(";
		Assert.assertTrue(!instance.isBalanced(data));
	}

	@Test
	public void balancedSingleRight() {
		String data = ")";
		Assert.assertTrue(!instance.isBalanced(data));
	}


	@Test
	public void balancedComplex1() {
		String data = "()()()";
		Assert.assertTrue(instance.isBalanced(data));
	}

	@Test
	public void balancedComplex2() {
		String data = "(()()())";
		Assert.assertTrue(instance.isBalanced(data));
	}
	
	@Test
	public void balancedComplex3_False() {
		String data = "(()()))";
		Assert.assertTrue(!instance.isBalanced(data));
	}
	
	@Test
	public void balancedComplex4_false() {
		String data = "((()())";
		Assert.assertTrue(!instance.isBalanced(data));
	}
	
	
	@Test
	public void balancedComplex5_extraspaces() {
		String data = " ( () () () ) ";
		Assert.assertTrue(instance.isBalanced(data));
	}
		
	
	
	
}
