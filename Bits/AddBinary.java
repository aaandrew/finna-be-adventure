/* Leetcode
 * Given two binary strings, return their sum (also a binary string)
	Ex.
	a = "11" b = "1". Returns "100".
 */

// Time: O(n)
// Space: O(n)
public String addBinary(String a, String b) {
	if(a==null || a.length() == 0) return b;
	if(b == null || b.length() == 0) return a;

	int carry = 0;
	int lasta = a.length() -1;
	int lastb = b.length() - 1;

	StringBuilder sb = new StringBuilder();

	while(lasta >=0 || lastb >= 0 || carry > 0){
		int x = lasta >=0 ? a.charAt(lasta--) - '0' : 0;
		int y = lastb >=0 ? b.charAt(lastb--) - '0' : 0;
		int sum = (x ^ y ^ carry);
		carry = (x & y) | (x & carry) | (y & carry);
		sb.insert(0, sum);
	}
	return sb.toString();
}