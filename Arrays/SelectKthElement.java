/* Quickselect Algorithm
 * Select kth smallest element
 * Based on 0 index
 * Example: {6,4,1,3,2,5}
 * k = 5 => 6
 * k = 0 => 1
 */

// Algorithm:
// 1. Set left and right variables
// 2. while left < right
// 	1. Pivot is middle. Store left index
// 	2. swap value: pivot with right
//	3. loop for left < right
// 		1. if i < pivot's value: swap left updated++ with i
// 	4. right's value = left's value
//  5. left's updated value = pivot
// 	6. if left's updated < k: left = left's updated++
// 		 else right = left's updated
// 3. return x[k]

// Time: O(n) expected, O(n^2) worst
// Space: O(1)
public static int selectKth(int[] x, int k){
	if(x == null || x.length < k)
		throw new Exception();
	int left = 0;
	int right = x.length-1;
	while (left < right){
		int pivot = (left + right)/2;
		int pivotValue = x[pivot];
		int storage = left;
		x[pivot] = x[right];
		x[right] = pivotValue;
		for(int i =left; i < right; i++){
			if(x[i] < pivotValue){
				int temp = x[storage];
				x[storage] = x[i];
				x[i] = temp;
				storage++;
			}
		}
		x[right] = x[storage];
		x[storage] = pivotValue;
		if(storage < k)
			left = storage+1;
		else
			right = storage;
	}
	return x[k];
}