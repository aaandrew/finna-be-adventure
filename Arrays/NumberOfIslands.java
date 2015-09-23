/* Leetcode
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */

// Time: O(N)
// Loop through each cell, explore the island and convert anything in island to water
public int numIslands(char[][] grid) {
	int islands = 0;

	for(int i=0; i<grid.length; i++){
		for(int j=0; j<grid[0].length; j++){
			if(grid[i][j] == '1'){
				checkIsland(i, j, grid);
				islands++;
			}
		}
	}
	return islands;
}

public void checkIsland(int row, int col, char[][] grid){
	if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == '0')
		return;

	grid[row][col] = '0';

	checkIsland(row-1, col, grid);
	checkIsland(row+1, col, grid);
	checkIsland(row, col-1, grid);
	checkIsland(row, col+1, grid);
}