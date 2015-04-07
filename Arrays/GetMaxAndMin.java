/* http://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 * Return minimum and maximum using minimum number of comparisons
 */

class Pair{
	int min, max;
}

// Recursive solution
// Time: O(3/2n -2) if n is power of 2. More if not power of 2.
public static Pair getMinMax(int arr[]){
	return getMinMax(arr, 0, arr.length-1);
}

public static Pair getMinMax(int[] arr, int low, int high){
	Pair pair = new Pair();
	if(low == high){
		pair.min = arr[low];
		pair.max = arr[low];
		return pair;
	}
	if(low + 1 == high){
		if(arr[low] < arr[high]){
			pair.min = arr[low];
			pair.max = arr[high];
		}else{
			pair.min = arr[high];
			pair.max = arr[low];
		}
		return pair;
	}
	int mid = low + (high-low)/2;
	Pair left = getMinMax(arr, low, mid);
	Pair right = getMinMax(arr, mid+1, high);
	if(left.min < right.min){
		pair.min = left.min;
	}else{
		pair.min = right.min;
	}
	if(left.max > right.max){
		pair.max = left.max;
	}else{
		pair.max = right.max;
	}
	return pair;
}

// Iterative
// Time: O(3*(n-1)/2) if n is odd
// 			 O(3/2n -2) if n is even
public static Pair getMinimumMaximum(int arr[]){
	Pair pair = new Pair();
	if(arr.length % 2 == 0){
		if(arr[0] < arr[1]){
			pair.min = arr[0];
			pair.max = arr[1];
		}else{
			pair.min = arr[1];
			pair.max = arr[0];
		}
	}else{
		pair.min = arr[0];
		pair.max = arr[0];
	}
	for(int i=2; i<arr.length-1; i+=2){
		if(arr[i] > arr[i+1]){
			if(arr[i] > pair.max){
				pair.max = arr[i];
			}
			if(arr[i+1] < pair.min){
				pair.min = arr[i+1];
			}
		}else{
			if(arr[i+1] > pair.max){
				pair.max = arr[i+1];
			}
			if(arr[i] < pair.min){
				pair.min = arr[i];
			}
		}
	}
	return pair;
}