/* Leetcode
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * Return the indices of the pair where the first must be less than the second
 * Indexes are not zero based
 * Ex.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

// Time: O(n)
// Space: O(n)
public int[] twoSum(int[] nums, int k) {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	for(int i=0; i<nums.length; i++){
		int diff = k-nums[i];
		if(map.containsKey(diff)){
			return new int[]{map.get(diff)+1, i+1};
		}
		map.put(nums[i], i);
	}
	return new int[]{-1,-1};
}