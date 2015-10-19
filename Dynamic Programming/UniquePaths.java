/* Leetcode 
 * A robot is located at the top-left corner of a m x n grid.
	The robot can only move either down or right at any point in time. 
	The robot is trying to reach the bottom-right corner of the grid.
	How many possible unique paths are there?
 */

// Padded
// Time: O(n*m)
// Space: O(n*m)
public int uniquePaths(int m, int n) {
	int[][] dp = new int[m+1][n+1];
	dp[0][1] = 1;
	for(int i=1; i<=m; i++){
		for(int j=1; j<=n; j++){
			dp[i][j] = dp[i-1][j] + dp[i][j-1];
		}
	}
	return dp[m][n];
}

// More verbose solution
public int uniquePaths(int m, int n) {
	int[][] dp = new int[m][n];
	
	for(int i=0; i<dp.length; i++){
		dp[i][0] = 1;
	}
	
	for(int i=0; i<dp[0].length; i++){
		dp[0][i] = 1;
	}
	
	for(int i=1; i<m; i++){
		for(int j=1; j<n; j++){
			dp[i][j] = dp[i-1][j] + dp[i][j-1];
		}
	}
	
	return dp[m-1][n-1];
}