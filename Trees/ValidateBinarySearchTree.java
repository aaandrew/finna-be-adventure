/* Leetcode
 * Given a Binary tree determine if it's a valid BST
 * Left subree is strictly less than node's key
 * Right subtree is strictly greater than node's key
 */

// Using Max/Min
public boolean isValidBST(TreeNode root) {
	return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
}

public boolean helper(TreeNode root, long max, long min){
	if(root == null)
		return true;
	if(root.val >= max || root.val <= min)
		return false;
	return helper(root.left,root.val,min) && helper(root.right,max,root.val);
}

// In order Traversal
public boolean isValidBST(TreeNode root) {
	return inorderTraverse(root);
}

TreeNode prev = null;
public boolean inorderTraverse(TreeNode root) {
	if(root == null) 
		return true;
	if(!inorderTraverse(root.left)) 
		return false;
	if(prev != null && root.val <= prev.val)
		return false;
	prev = root;
	return inorderTraverse(root.right);
}