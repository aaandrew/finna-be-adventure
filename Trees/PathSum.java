/* Leetcode
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such
 * that adding up all the values along the path equals the given sum.
 */

// Iterative
public boolean hasPathSum(TreeNode root, int sum) {
	if(root == null) return false;
	LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
	LinkedList<Integer> sums = new LinkedList<Integer>();
	nodes.add(root);
	sums.add(root.val);

	while(!nodes.isEmpty()){
		TreeNode curr = nodes.poll();
		int result = sums.poll();
		if(result == sum && curr.left == null && curr.right == null)
			return true;
		if(curr.left != null){
			nodes.add(curr.left);
			sums.add(result + curr.left.val);
		}
		if(curr.right != null){
			nodes.add(curr.right);
			sums.add(result + curr.right.val);
		}

	}
	return false;
}
    
// Recursive
public boolean hasPathSum(TreeNode root, int sum) {
	if(root == null) return false;
	if(root.val == sum && root.left == null && root.right == null)
		return true;
	return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum-root.val);
}