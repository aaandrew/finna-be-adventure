/*
 * Form a palindrome by adding 0 or more characters at any location
 * Return the minimum number of inserted characters.
 *
 * Constraints:
 * S may consist up to 1000 characters with only lowercase alphabet letters
 *
 * Example:
 * S = "abab"
 * => 1 because "ababa"
 *
 * S = "abacaba"
 * => 0, already a palindrome
 *
 * Resources:
 * http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
 */

public static int shortPalin(String s){
	if(s == null || s.length() <= 1) return 0;

	int[][] dp = new int[s.length()][s.length()];
	for(int col=1; col<s.length(); col++){
		for(int i=0, j=col; j<s.length(); i++, j++){
			dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i+1][j-1] : Math.min(dp[i+1][j], dp[i][j-1]) + 1;
		}
	}
	return dp[0][s.length()-1];
}