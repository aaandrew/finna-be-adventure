/* Find Kth closest points to origin
 *
 */

// Kth closest point to origin
// 1. Calculate all distances from origin to point
// 2. quickselect all distances[] with k

// Quickselect
// 1. set left = 0, right = arr.length-1
// 2. while left <= right
// 	1. Get mid, and pivot = partition(left, right, mid)
//  2. if pivot == k: return arr[pivot]
//  3. if pivot < k: left = pivot+1, else: right = pivot-1
// 3. return null

// Partition
// 1. storeIndex = left, pivotVal = arr[pivot]
// 2. for i=left to right
// 	1. if i.distance < pivotVal: swap(i, storeIndex++)
// 3. swap(right, storeInde)
// 4. return storeIndex 

// Time: O(n) expected, O(n^2) worst (Quickselect)
// Space: O(1)
public static Point kthClosestPointToOrigin(Point[] arr, int k){
	for(int i=0; i<arr.length; i++){
		arr[i].distance = Math.sqrt((arr[i].x * arr[i].x) + (arr[i].y*arr[i].y));
	}
	return quickSelect(arr, k);
}

public static int partition(Point[] arr, int left, int right, int pivot){
	double pivotVal = arr[pivot].distance;
	swap(arr, pivot, right);
	int storeIndex = left;
	for (int i = left; i < right; i++) {
		if (arr[i].distance < pivotVal) {
			swap(arr, i, storeIndex);
			storeIndex++;
		}
	}
	swap(arr, right, storeIndex);
	return storeIndex;
}

public static Point quickSelect(Point[] arr, int k){
	int left = 0, right = arr.length-1;
	while(left <= right){
		int m = (left+right)/2;
		int pivotIndex = partition(arr,left, right , m);
		if(pivotIndex == k){
			return arr[pivotIndex];
		}else if(pivotIndex < k){
			left = pivotIndex + 1;
		}else{
			right = pivotIndex - 1;
		}
	}
	return null;
}

public static void swap(Point[] arr, int i, int j){
	Point temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}