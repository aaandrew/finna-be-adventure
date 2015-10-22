/*
 * Check if balanced parentheses
 */

public static boolean isValid(String s) {
	if(s == null || s.length() == 0) return true;

	Stack<Character> stack = new Stack<Character>();
	int i=0;
	while(i < s.length()){
		if(s.charAt(i) == '('){
			stack.push(s.charAt(i));
		}else if(s.charAt(i) == ')'){
			if( !stack.empty()){
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