/* CTCI
 * A magic index in A[0,...n-1] is  defined as A[i] = i.
 * Given sorted array of distinct integers, write a method to find
 * a magic index if one exists.
 *
 * Example
 * [-1,0,2] => 2
 */



public static int magicIndex(int[] arr){
	int start = 0, end = arr.length-1;
	while(start <= end){
		int mid = (end-start)/2 + start;
		if(arr[mid] == start){
			return mid;
		}else if(mid < arr[mid]){
			end = mid - 1;
		}else{
			start = mid + 1;
		}
	}
	return -1;
}

