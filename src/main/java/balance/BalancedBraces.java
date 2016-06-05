package balance;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * The interview question is to examine a string and determine if the various
 * braces in it are balanced. Three types of braces are used: (), {}, and [].
 * 
 * Test data:
 * <ul>
 * <li>(){}[] -- true</li>
 * <li>( -- false</li>
 * <li>({[]}) -- true</li>
 * <li>(}) -- false</li>
 * </ul>
 */
public class BalancedBraces {

	private static final Character LP = '(';
	private static final Character RP = ')';

	private static final Character LC = '{';
	private static final Character RC = '}';

	private static final Character LS = '[';
	private static final Character RS = ']';

	/**
	 * One solution I read about said to use a stack to determine if the various
	 * braces are balanced. Use a map to match the open bracket to its partner
	 * closing bracket. When you find an open bracket, push it onto the stack.
	 * When you find a closing bracket, see if it's partner is on the top of the
	 * stack. If it is, pop it off, and if it's not, return false. If you get to
	 * the end and your stack is empty, return true, and return false if the
	 * stack isn't empty.
	 * 
	 * @param s
	 *            a String containing braces that may or may not be balanced
	 * @return true if the given string has balanced parentheses and false if
	 *         not.
	 */
	public boolean isBalanced(String s) {
		Map<Character, Character> partnerMap = createPartnerMap();
		Stack<Character> stack = new Stack<>();

		for (int index = 0; index < s.length(); index++) {
			char ch = s.charAt(index);
			if (isOpenBracket(ch)) {
				stack.push(ch);
			} else if (isCloseBracket(ch)) {
				char openPartner = partnerMap.get(ch);
				if (!stack.empty() && stack.peek() == openPartner) {
					stack.pop();
				} else {
					return false;
				}
			} else {
				// ignore other kinds of characters
			}
		}
		
		// We've exhausted our string.  Now make sure we also 
		// exhausted our stack.  If we didn't, then brackets are 
		// not balanced.  If we did, we're balanced.
		
		return stack.empty();
	}

	private Map<Character, Character> createPartnerMap() {
		Map<Character, Character> map = new HashMap<>();
		map.put(RP, LP);
		map.put(RC, LC);
		map.put(RS, LS);
		return map;
	}

	private boolean isOpenBracket(char ch) {
		return (ch == LP || ch == LS || ch == LC);
	}

	private boolean isCloseBracket(char ch) {
		return ch == RP || ch == RS || ch == RC;
	}

}
