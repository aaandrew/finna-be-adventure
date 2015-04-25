/* Leetcode
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid. The brackets must close in the correct
 * order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

// Time: O(n)
// Space: O(n)
public boolean isValid(String s) {
	if(s == null || s.length() == 0) return true;
	Stack<Character> stack = new Stack<Character>();
	int i=0;
	while(i < s.length()){
		if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
			stack.push(s.charAt(i));
		}else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
			if( !stack.empty() && isMatch(s.charAt(i), stack.peek())){
				stack.pop();
			}else
			return false;
		}else{
			return false;
		}
		i++;
	}
	if(stack.empty()) return true;
	return false;
}

public boolean isMatch(char a, char b){
	String chars = "()[]{}";
	if(chars.indexOf(a) < 0 || chars.indexOf(b) < 0) return false;
	if(chars.indexOf(a) == chars.indexOf(b) + 1) return true;
	return false;
}
