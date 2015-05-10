/* Leetcode
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element
 */

// Time: O(logn)
// Space: O(1)
public int findMin(int[] num) {
	if(num == null) return -1;
	int start = 0; 
	int end = num.length - 1;
	while(start < end){
		if(num[start] < num[end]) return num[start];
		int mid = start + (end-start)/2;
		if(num[start] <= num[mid]){
			start = mid + 1;
		}else{
			end = mid;
		}
	}
	return num[start];
}