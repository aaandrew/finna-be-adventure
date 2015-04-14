/* Leetcode
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below
 * [
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */

// Time: O(n^2) 
// Space: O(n)
// n = # of rows
public int minimumTotal(List<List<Integer>> triangle) {
	int[] total = new int[triangle.size() + 1];
	for(int i=triangle.size()-1; i>=0; i--){
		for(int j=0; j<i+1; j++){
			total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j+1]);
		}
	}
	return total[0];
}