/* Leetcode
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]
 */

// Time: O(n)
// Space: O(1)
public static void moveZeroesEnd(int[] arr){
	int count = 0;
	for(int i=0; i<arr.length; i++){
		if(arr[i] != 0){
			arr[count++] = arr[i];
		}
	}
	while(count < arr.length){
		arr[count++] = 0;
	}
}

// Juggling solution
// Time: O(n)
// Space: O(1)
public void moveZeroes(int[] nums) {
	int startZero = 0;
	for(int i=0; i<nums.length; i++){
		if(nums[i] != 0){
			swap(nums, startZero, i);
			startZero++;
		}
	}
}

private void swap(int[] nums, int i, int j){
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
} 