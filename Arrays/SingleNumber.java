/* Leetcode
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */

// Time: O(n)
// Space: O(1)
public int singleNumber(int[] A) {
	if(A == null) return -1;
	int result = 0;
	for(int i=0; i<A.length; i++){
		result ^=A[i];
	}
	return result;
}