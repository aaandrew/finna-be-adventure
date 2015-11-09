/* Leetcode
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
  If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

  The replacement must be in-place, do not allocate extra memory.

  Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
  1,2,3 → 1,3,2
  3,2,1 → 1,2,3
  1,1,5 → 1,5,1

 */    

public void nextPermutation(int[] nums) {
  // Find first descending number that breaks right->left ascending numbers
  int firstDescending = findFirstDescending(nums);
  if(firstDescending >= 0) {
  // Find next largest number > firstDescending and swap it
  int nextAscending = findNextAscending(nums, nums[firstDescending], firstDescending+1);
    swap(nums, firstDescending, nextAscending-1);
  }
  // Reverse remaining numbers after firstDescending (basically sorts remaining numbers)
  reverse(nums, firstDescending+1);
}

private void swap(int[] nums, int i, int j) {
  int temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
}

private int findFirstDescending(int[] nums){
  int i = nums.length - 2;
  for(;i >= 0 && nums[i] >= nums[i+1]; i--);
    return i;
}

private int findNextAscending(int[] nums, int value, int start){
  for(; start<nums.length && value < nums[start]; start++);
    return start;
}

private void reverse(int[] nums, int start){
  int end = nums.length - 1;
  for(int i=start;i<end; i++, end--){
    swap(nums, i, end);
  }
}