/* Leetcode
 *
 */


// Recursive
// Time: O(n)
// Space: O(n)
public int maxDepth(TreeNode root) {
	if(root == null) return 0;
	int left = maxDepth(root.left);
	int right = maxDepth(root.right);
	return left > right ? left + 1 : right + 1;
}


// Iterative
// Time: O(n)
// Space: O(n)
public int maxDepth(TreeNode root) {
	if(root == null) return 0;
	int depth = 1;
	Stack<TreeNode> wq = new Stack<TreeNode>();
	Stack<TreeNode> paths = new Stack<TreeNode>();
	wq.push(root);
	while(!wq.empty()){
		TreeNode r = wq.peek();
		if(paths.size() != 0 && r== paths.peek()){
			if(paths.size() > depth)
				depth = paths.size();
			paths.pop();
			wq.pop();
		}else{
			paths.push(r);
			if(r.left != null) wq.push(r.left);
			if(r.right != null)wq.push(r.right);
		}
	}
	return depth;
}