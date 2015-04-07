/* http://www.geeksforgeeks.org/pancake-sorting/ 
 * http://www.geeksforgeeks.org/a-pancake-sorting-question/
 * Given an unsorted array you sort it using only
 * flip(arr, i) - reverse array from 0 to i
 *
 */

// Suppose flip takes O(1)
// Time: O(nlogn)
public static void insertionSort(int[] arr){
	for(int i=1; i<arr.length; i++){
		int j = ceilSearch(arr, 0, i-1, arr[i]);
		if(j != -1){
			flip(arr, j-1);
			flip(arr, i-1);
			flip(arr, i);
			flip(arr, j);
		}
	}
}

public static int ceilSearch(int[] arr, int low, int high, int x){
	if(x <= arr[low])
		return low;
	if(x > arr[high])
	 return -1;
	int mid = low + (high-low)/2;
	if(arr[mid] == x) 
		return mid;
	if(arr[mid] < x){
		if(mid+1 <= high && x <=arr[mid+1])
			return mid+1;
		else
			return ceilSearch(arr, mid+1, high, x);
	}
	if(mid -1 >= low && x > arr[mid-1])
		return mid;
	else
		return ceilSearch(arr, low, mid-1, x);
}
	
// Flip O(n)
// O(n^2)
public static void pancakeSort(int[] arr){
	for(int size=arr.length; size > 1; size--){
		int m = max(arr, size);
		if(m != size-1){
			// Move max to beginning
			flip(arr, m);
			// Move max to end
			flip(arr, size-1);
		}
	}
}

public static void flip(int[] arr, int i){
	int temp, start = 0;
	while(start < i && start < arr.length){
		temp = arr[start];
		arr[start++] = arr[i];
		arr[i--] = temp;
	}
}

public static int max(int[] arr, int n){
	int max = 0;
	for(int i=0; i<n; i++){
		if(arr[i] > arr[max]) max = i;
	}
	return max;
}
