package quiz;

/**
 * Return <code>true</code> if the string has balanced parentheses.
 * This question was simpler than the other questions I've seen that
 * ask something similar, but with multiple kinds of braces.  One 
 * could use the same, stack-based solution for this.  But it turns
 * out it's pretty easy to just use a simple counter.  See the code 
 * below.
 * 
 * Test Data Examples:
 * <ul>
 * <li>() -- true</li>
 * <li>( -- false</li>
 * <li>) -- false </li>
 * <li>(()) -- true</li>
 * <li>(()()()) -- true</li>
 * <li>( ( ) ( ) ( ) ) -- true</li>
 * <li> -- true (empty string)</li>
 * </ul>
 */
public class BalanceParens {

	public boolean isBalanced(String s) {
		int counter = 0;
		for (int index = 0; index < s.length(); index++) {
			if (counter < 0) {
				return false;
			}
			char ch = s.charAt(index);
			if (ch == '(') {
				counter++;
			}
			else if (ch == ')') {
				counter--;
			}
			else {
				// ignore this character
			}
		}
		
		// Should be zero if all parens balance out
		return counter == 0;
	}
	
}
