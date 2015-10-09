/*
 * Return the kth smallest node in a BST
 */

public TreeNode kthSmallestBST(TreeNode root, int k) {
	if(root == null) return root;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode curr = root;

	while(curr != null || !stack.isEmpty()){
		if(curr != null){
			stack.push(curr);
			curr = curr.left;
		}else{
			TreeNode n = stack.pop();
			if(--k == 0) return n;
			curr = n.right;
		}
	}
	return null;
}