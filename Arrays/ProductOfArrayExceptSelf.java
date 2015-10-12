/* Leetcode
 * 
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].

 * Solution:
 * 1st loop: Keep running product until current element in order
 		[p, 1*p, 1*2*p, 1*2*3*p]
 * 2nd loop: Keep running product until current element in reverse
 		[p*2*3*4, p*3*4, p*4, p]
 * 
 */

// Time: O(n)
// Space: O(1)
public int[] productExceptSelf(int[] nums) {
	int[] result = new int[nums.length];
	int product = 1;

	for(int i=0; i<nums.length; i++){
		result[i] = product;
		product *= nums[i];
	}

	product = 1;
	for(int i=nums.length-1; i>=0; i--){
		result[i] *= product;
		product *= nums[i];
	}

	return result;
}