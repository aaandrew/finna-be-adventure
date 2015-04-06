/* Quickselect Algorithm
 *
 */

// Time: O(n) expected, O(n^2) worst
// Space: O(1)
public static int selectKth(int[] x, int k){
	if(x == null || x.length < k)
		throw new Error();
	int left = 0;
	int right = x.length-1;
	while (left < right){
		int pivot = (left + right)/2;
		int pivotValue = x[pivot];
		int storage=left;
		x[pivot] = x[right];
		x[right]=pivotValue;
		for(int i =left; i < right; i++){
			if(x[i] < pivotValue){
				int temp =x[storage];
				x[storage] = x[i];
				x[i]=temp;
				storage++;
			}
		}
		x[right]=x[storage];
		x[storage]=pivotValue;
		if(storage < k)
			left = storage+1;
		else
			right = storage;
	}
	return x[k];
}