/* Leetcode
 * Given an unsorted array, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */

// Time: O(n)
// Space: O(1)
public void wiggleSort(int[] arr){
	if(arr == null || arr.length < 2) return;

	for(int i=1; i<arr.length; i++){
		int prev = arr[i-1];
		if(i%2==1 == prev > arr[i]){
			arr[i-1] = arr[i];
			arr[i] = prev;
		}
	}
}