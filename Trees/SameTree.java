/* Leetcode
 * Given two binary trees, write a function to check if they are equal or not.
 * They are equal if they are structurally identical and the nodes have the same value.
 */

// Recursive
// Time: O(n)
// Space: O(n)
public boolean isSameTree(TreeNode p, TreeNode q) {
	if(p == null && q == null) return true;
	if(p != null && q != null){
		if(p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	return false;
}

// Iterative
// Time: O(n)
// Space: O(n)
public boolean isSameTree(TreeNode p, TreeNode q) {
	Queue<TreeNode> q1 = new LinkedList<TreeNode>();
	Queue<TreeNode> q2 = new LinkedList<TreeNode>();
	q1.offer(p);
	q2.offer(q);

	while(!q1.isEmpty() && !q2.isEmpty()){
		TreeNode x = q1.poll();
		TreeNode y = q2.poll();
		if(x == null){
			if (y != null) return false;
			else continue;
		}
		if(y == null || x.val != y.val) return false;
		q1.offer(x.left);
		q1.offer(x.right);
		q2.offer(y.left);
		q2.offer(y.right);
	}
	return true;
}