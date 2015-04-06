/* Find Kth closest points to origin
 *
 */

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