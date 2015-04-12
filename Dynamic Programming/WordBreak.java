/* Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a sequence of one or more dictionary words.
 * Ex.
 * s = "leetcode", dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */

// Time: O(n^2)
// Space: O(n)
public boolean wordBreak(String s, Set<String> dict) {
	boolean[] dp = new boolean[s.length()+1];
	dp[0] = true;

	for(int i=1; i<=s.length(); i++){
		for(int j=0; j<i; j++){
			String suffix = s.substring(j, i);
			if(dp[j] && dict.contains(suffix)){
				dp[i] = true;
				break;
			}
		}
	}
	return dp[s.length()];
}