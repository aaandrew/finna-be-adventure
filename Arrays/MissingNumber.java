/* Leetcode
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
   find the one that is missing from the array.
	 For example,
	 Given nums = [0, 1, 3] return 2.
 */

// Time: O(n)
// Space: O(n)
public int missingNumber(int[] nums) {
	Set<Integer> set = new HashSet<Integer>();
	int min = 0;
	for(int i=0; i<nums.length; i++){
		set.add(nums[i]);
		if(nums[i] < min)
			min = nums[i];
	}
	for(int i=0; i<nums.length; i++){
		if(!set.contains(min)){
			return min;
		}
		min++;
	}
	return min;
}

// Solution:
// Subtract natural sum n*(n+1)/2 from array sum which gets the missing number
// Time: O(n)
// Space: O(1)
public int missingNumber(int[] nums) {
	int naturalSum = (nums.length)*(nums.length+1)/2;
	for(int i=0; i<nums.length; i++){
		naturalSum -= nums[i];
	}
	return naturalSum;
}

// Best solution, avoids overflow
// XOR all numbers in array and [0,1,2,...n-1]
// res = 3
// arr = [0,1,3]
// result = 3001123 => 2
// Time: O(n)
// Space: O(1)
public int missingNumber(int[] nums){
	int res = nums.length;
	for(int i=0; i<nums.length; i++){
		res ^= i;
		res ^= nums[i];
	}
	return res;
}
