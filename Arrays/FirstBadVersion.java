/* Leetcode
 * N versions of product [1,2,3,..., n] and want to find out which
 * is the first bad version (which causes all the following ones to be bad).
 */

// Time: O(logn)
// Space: O(1)
public int firstBadVersion(int n) {
	int start = 1, end = n;

	while(start < end){
		int mid = (end-start)/2 + start;
		if(isBadVersion(mid)){
			end = mid;
		}else{
			start = mid + 1;
		}
	}
	return start;
}