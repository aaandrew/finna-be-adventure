/* Leetcode
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */

// Time: O(n)
// Space: O(1)
public int maxSubArray(int[] A) {
	int sum = 0, max = A[0];
	for(int i=0; i<A.length; i++){
		sum += A[i];
		max = Math.max(max, sum);
		sum = Math.max(sum, 0);
	}
	return max;
}