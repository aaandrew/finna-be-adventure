/* Leetcode
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center)
 * Symmetric
 *    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3

	* Not symmetric
	*		1
	   / \
	  2   2
	   \   \
	   3    3
 */

// Recursvie
// Time: O(n)
// Space: O(n)
public boolean isSymmetric(TreeNode root) {
	if(root == null)
		return true;
	return helper(root.left, root.right);
}

public boolean helper(TreeNode a, TreeNode b){
	if(a == null && b == null)
		return true;
	else if(a == null || b == null)
		return false;
	else if(a.val != b.val)
		return false;
	else return helper(a.left, b.right) && helper(a.right, b.left);
}


// Iterative
// Time: O(n)
// Space: O(n)
public boolean isSymmetric(TreeNode root) {
	if(root == null)
		return true;
	Queue<TreeNode> left = new LinkedList<TreeNode>();
	Queue<TreeNode> right = new LinkedList<TreeNode>();
	left.offer(root.left);
	right.offer(root.right);
	while(!left.isEmpty() && !right.isEmpty()){
		TreeNode node1 = left.poll();
		TreeNode node2 = right.poll();
		if(node1 == null && node2 != null || node1 != null && node2 == null)
			return false;
		if(node1 == null && node2 == null)continue;
		if(node1.val != node2.val)
			return false;
		left.add(node1.left);
		left.add(node1.right);
		right.add(node2.right);
		right.add(node2.left);
	}
	return true;
}