/* CTCI
 * Given a increasing sorted array with unique integer elements,
 * create a bst with minimal height.
 */

/* Example
	 [0,1,2,3,4,5,6]
	      3
	 		/   \
     1     5
	   / \   / \
	 0   2 4   6
 */

// Time: O(n)
// Space: O(1)
public static TreeNode minimalTree(int[] arr){
	return minimalTree(arr, 0, arr.length-1);
}

public static TreeNode minimalTree(int[] arr, int start, int end){
	if(start > end) return null;

	int mid = (end-start)/2 + start;
	TreeNode midNode = new TreeNode(arr[mid]);
	midNode.left = minimalTree(arr, start, mid-1);
	midNode.right = minimalTree(arr, mid+1, end);

	return midNode;
}