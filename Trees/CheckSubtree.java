/* CTCI
 * Check if smaller tree b is a subtree of a
 */

public boolean isSubtree(TreeNode a, TreeNode b) {
  if(b == null) return true;
  return isSubtreeHelper(a, b);
}

public boolean isSubtreeHelper(TreeNode a, TreeNode b) {
  if(a == null) return false;
  if(a.data == b.data && matchTree(a, b)) return true;
  return isSubtreeHelper(a.left, b) || isSubtreeHelper(a.right, b);
}

public boolean matchTree(TreeNode a, TreeNode b) {
  if(a == null && b == null) return true;
  if(a == null || b == null || a.data != b.data) return false;
  return matchTree(a.left, b.left) && matchTree(a.right, b.right);
}