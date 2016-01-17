/* Leetcode
 * Given a BST, find LCA of two nodes
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

// Time: O(logn)
// Space: O(1)
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  int max = Math.max(p.val, q.val);
  int min = Math.min(p.val, q.val);
  while(root != null){
    if(root == p || root == q){
      return root;
    }else if(root.val < max && root.val > min){
      return root;
    }else if(root.val > max){
      root = root.left;
    }else{
      // Equivalent to root.val < min
      root = root.right;
    }
  }
  return root;
}