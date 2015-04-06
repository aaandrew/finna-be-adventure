/* Leetcode
 * Rerverse the words in a string.
 * Given s = "the sky is blue", return "blue is sky the".
 */

// Time: O(n)
// Space: O(n)
public String reverseWords(String s) {
	if (s == null || s.length() == 0) {
		return "";
	}
	int start = -1, end = -1;
	char[] chars = s.toCharArray();
	StringBuilder sb = new StringBuilder();

	for(int i=chars.length-1; i>=0; i--){
		if(chars[i] == ' ' && start < 0){
			continue;
		}else if(chars[i] == ' ' && start >= 0){
			sb.append(chars, end, start-end+1).append(' ');
			start = -1; end = -1;
		}else if(start == -1){
			start = i; end = i;
		}else{
			end--;
		}
	}
	if(start >=0) sb.append(chars, 0, start+1).append(' ');
	return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
}

// Time: O(n)
// Space: O(n)
public String reverseWords(String s) {
	if (s == null || s.length() == 0) {
		return "";
	}
	String[] arr = s.split(" ");
	StringBuilder sb = new StringBuilder();
	for (int i = arr.length - 1; i >= 0; --i) {
		if (arr[i].length() > 0) {
			sb.append(arr[i]).append(" ");
		}
	}
	return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
}