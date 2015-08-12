/* Leetcode
 * Given an array of integers, find three numbers such that they add up closest to a target number.
 * Return the sum of the three integers
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

// Time: O(n^2)
// Space: O(1)
public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[nums.length-1];
		for(int i=0; i<nums.length-2; i++){
			int j = i+1, k = nums.length-1;
			while(j < k){
				int sum = nums[i] + nums[j] + nums[k];
				if(Math.abs(target-sum) < Math.abs(target-result)){
					result = sum;
					if(result == target) return result;
				}
				if (sum > target){
					k--;
				}else{
					j++;
				}
			}
		}
		return result;
	}
}