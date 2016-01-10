/* http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 * 
 */

public static int longestPalindromicSubsequence(String s){
	if(s == null || s.length() == 0) return 0;
	int[][] dp = new int[s.length()][s.length()];

  // All diagonals are length 1 palindrome
	for(int i=0; i<dp.length; i++){
		dp[i][i] = 1;
	}

	for(int len=2; len<=dp.length; len++){
		for(int i=0; i<dp.length-len+1; i++){
			int j = i+len-1;
			if(s.charAt(i) == s.charAt(j) && len == 2){
				dp[i][j] = 2;
			}else if(s.charAt(i) == s.charAt(j)){
				dp[i][j] = dp[i+1][j-1] + 2;
			}else{
				dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
			}
		}
	}
	return dp[0][dp.length-1];
}