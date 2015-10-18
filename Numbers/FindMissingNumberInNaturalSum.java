/* 
 * An array of size n has all but one numbers between 1 and N. Find the missing one
 * Example:
 * [1,2,3,4,6,7,8,9,10]
 * 5 is missing, so the output should be 5.
 */

public static int findMissingNumber(int[] arr){
	int n = arr.length+1;
	// Sum of first n numbers
	int sum = n*(n+1)/2;
	for(int i=0; i<arr.length; i++){
		sum -= arr[i];
	}
	return sum;
}