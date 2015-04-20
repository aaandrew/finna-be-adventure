/* Leetcode
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */

// Time: O(n) Moore voting algorithm
// Space: O(1)
// Explanation:
// We maintain a current candidate and a counter initialized to 0. 
// As we iterate the array, we look at the current element x:
// If the counter is 0, we set the current candidate to x and the counter to 1.
// If the counter is not 0, we increment or decrement the counter based on whether x is the current candidate.
// After one pass, the current candidate is the majority element.
public int majorityElement(int[] num) {
	int index = 0;
	for(int i=1, count=1; i<num.length; i++){
		if(num[i] == num[index])
			count++;
		else
			count--;
		if(count == 0){
			index = i;
			count = 1;
		}
	}
	return num[index];
}