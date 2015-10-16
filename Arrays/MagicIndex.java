/* CTCI
 * A magic index in A[0,...n-1] is  defined as A[i] = i.
 * Given sorted array of distinct integers, write a method to find
 * a magic index if one exists.
 *
 * Example
 * [-1,0,2] => 2
 */

public static int magicIndex(int[] arr){
	int low = 0;
	int high = arr.length-1;
	while(low<=high){
		int mid = (high-low)/2 + low;
		if(arr[mid] == mid){
			return mid;
		}else if(arr[mid] < mid){
			low = mid+1;
		}else{
			high = mid;
		}
	}
	return -1;
}