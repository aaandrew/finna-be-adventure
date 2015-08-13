/* Leetcode
 * Invert a binary tree.

	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9

	to

	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1
 *
 */

public class Solution {
	// Recursive
	// Time: O(n)
	// Space: O(n)
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;

		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	// Iterative DFS
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			if(node.left != null)
				stack.push(node.left);
			if(node.right != null)
				stack.push(node.right);
		}
		return root;
	}

	// Iterative BFS (Level order traversal)
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			if(node.left != null)
				queue.offer(node.left);
			if(node.right != null)
				queue.offer(node.right);
		}
		return root;
	}

}