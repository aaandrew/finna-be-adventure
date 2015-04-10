/* Leetcode
 * Given a binary tree, flatten it to a linked list in-place.

   			 1					Returns 1-2-3-4-5-6 (all right childs)
        / \
       2   5
      / \   \
     3   4   6
 */

// Space Complexity: O(1)
public void flatten(TreeNode root) {
	while(root != null){
		if(root.left != null){
			TreeNode curr = root.left;
			while(curr.right != null)
				curr = curr.right;
			curr.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		root = root.right;
	}
}

// Alternative
// Space Complexity: O(n)
public void flatten(TreeNode root) {
	if (root == null) return;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	stack.push(root);
	while (!stack.isEmpty()){
		TreeNode curr = stack.pop();
		if (curr.right!=null)  
			stack.push(curr.right);
		if (curr.left!=null)  
			stack.push(curr.left);
		if (!stack.isEmpty()) 
			curr.right = stack.peek();
		curr.left = null;
	}
}
