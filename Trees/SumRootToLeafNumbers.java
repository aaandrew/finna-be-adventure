/* Leetcode
 * Given a binary tree containing digits from 0-9 only, 
 * each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers
 */

// Recursion
// Time: O(n)
// Space: O(n)
public int sumNumbers(TreeNode root) {
	return dfs(root,0);
}
public int dfs(TreeNode root, int sum){
	if(root == null) return 0;
	int res =root.val+sum*10;
	if(root.left==null && root.right==null) return res;
	int val = 0;
	if (root.left != null)
		val += dfs(root.left, res);
	if (root.right != null)
		val += dfs(root.right, res);
	return val;
}