/* CTCI/Leetcode
 * Check if a binary tree is balanced. The height of two subtrees 
 * of any node never differ by more than one.
 */

// Bottom up
// Return -1 for unbalanced subtree, height for balanced tree
// If -1 is returned then the whole subtree and subsequently the parent
// of the larger tree is also unbalanced, so propogate -1
// Time: O(n)
// Space: O(h) h is height of tree
public boolean isBalanced(TreeNode root){
  return getHeight(root) >= 0;
}

public int getHeight(TreeNode root){
  if(root == null) return 0;
  int left = getHeight(root.left);
  if(left == -1) return -1;
  int right = getHeight(root.right);
  if(right == -1 || Math.abs(left-right) > 1) return -1;
  return Math.max(left, right) + 1;
}

// Top Down
// Check if left and right subtree height difference <= 1, next
// Check again for left child and right child, recurse
// Time: O(n^2) n is number of nodes in the tree
// Space: O(h)
public boolean isBalanced(TreeNode root){
  if(root == null) return true;
  int left = getHeight(root.left);
  int right = getHeight(root.right);
  if(Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right))
    return true;
  return false;
}

public int getHeight(TreeNode root){
  if(root == null) return 0;
  return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}


              1
          2       2
        2   3       
      3  4 
    4
