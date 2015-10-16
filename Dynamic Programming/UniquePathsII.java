/* Leetcode
 * A robot is located at the top-left corner of a m x n grid. (Top left)
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.

  An obstacle and empty space is marked as 1 and 0 respectively in the grid.

	For example,
	There is one obstacle in the middle of a 3x3 grid as illustrated below.

	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	The total number of unique paths is 2.
 */

	// Meh solution, improve this later
	// Time: O(n*m)
	// Space: O(n*m)
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
		int[][] dp = new int[rows][cols];

		for(int i=0; i<rows; i++){
			if(obstacleGrid[i][0] == 0)
				dp[i][0] = 1;
			else
				break;
		}

		for(int i=0; i<cols; i++){
			if(obstacleGrid[0][i] == 0)
				dp[0][i] = 1;
			else
				break;
		}

		for(int i=1; i<rows; i++){
			for(int j=1; j<cols; j++){
				if(obstacleGrid[i][j] == 0)
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[rows-1][cols-1];
	}