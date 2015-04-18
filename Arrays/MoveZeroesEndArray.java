/* Move all zeroes to the end of the array. Maintain order.
 *
 */

// Time: O(n)
// Space: O(1)
public static void moveZeroesEnd(int[] arr){
	int count = 0;
	for(int i=0; i<arr.length; i++){
		if(arr[i] != 0){
			arr[count++] = arr[i];
		}
	}
	while(count < arr.length){
		arr[count++] = 0;
	}
}