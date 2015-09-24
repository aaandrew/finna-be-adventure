/* http://www.geeksforgeeks.org/remove-characters-from-the-first-string-which-are-present-in-the-second-string/
 * Remove characters from first string that are present in second string.
 */

// Time: O(n+m)
// Space: O(m)
public String maskString(String a, String b){
	boolean[] count = new boolean[256];
	StringBuilder sb = new StringBuilder();

	for(int i=0; i<a.length(); i++){
		count[a.charAt(i)] = true;
	}

	for(int i=0; i<b.length(); i++){
		char c = b.charAt(i);
		if(count[c] == false)
			sb.append(b.charAt(i));
	}
	return sb.toString();
}