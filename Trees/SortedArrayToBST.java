/* Leetcode
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */

// Time: O(n)
public TreeNode sortedArrayToBST(int[] num) {
	if(num == null) return null;
	return helper(num, 0, num.length-1);
}

public TreeNode helper(int[] num, int start, int end){
	if(start > end) return null;
	
	int mid = start + (end-start)/2;
	TreeNode root = new TreeNode(num[mid]);
	root.left = helper(num, start, mid -1);
	root.right = helper(num, mid+1, end);
	return root;
}