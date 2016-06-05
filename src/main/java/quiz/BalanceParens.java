package quiz;

/**
 * Return <code>true</code> if the string has balanced parens.
 * Examples:
 * <ul>
 * <li>() -- true</li>
 * <li>( -- false</li>
 * <li>) -- false </li>
 * <li>(()) -- true</li>
 * <li>(()()()) -- true</li>
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
