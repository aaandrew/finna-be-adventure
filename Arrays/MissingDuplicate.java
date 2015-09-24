/* http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 * Given list where each number appears twice, except one.
 * Find the missing duplicate.
 */
public int findMissingDuplicate(int[] arr){
	int dup = 0;
	for(int i=0; i<arr.length; i++){
		dup ^= arr[i];
	}
	return dup;
}