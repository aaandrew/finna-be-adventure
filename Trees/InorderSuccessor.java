/* 
 * Return the inorder successor of a node
 */

public static TreeNode inorderSuccessor(TreeNode root){
	if(root == null) return root;
	if(root.right != null){
		// Get leftmost child
		TreeNode curr = root.right;
		while(curr.left != null){
			curr = curr.left;
		}
		return curr;
	}else{
		// Return first node that is greater than current which means
		// return the closest parent that has root's parent as a left child
		while(root.parent != null && root.parent.right == root){
			root = root.parent;
		}
	}
	return root;
}