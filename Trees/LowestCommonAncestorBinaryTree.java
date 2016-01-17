/* Leetcode
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 	     _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
	For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
	Another example is LCA of nodes 5 and 4 is 5, since a node can be a 
	descendant of itself according to the LCA definition.
 */

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if(root == null || root == p || root == q) return root;
	TreeNode left = lowestCommonAncestor(root.left, p, q);
	TreeNode right = lowestCommonAncestor(root.right, p, q);
	if(left != null && right != null){
		return root; 
	}else if(left == null){
		return right;
	}
	return left;
}