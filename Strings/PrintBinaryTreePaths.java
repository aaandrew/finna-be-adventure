/* Leetcode
		Given a binary tree, return all root-to-leaf paths.

		For example, given the following binary tree:

		   1
		 /   \
		2     3
		 \
		  5
		All root-to-leaf paths are:

		["1->2->5", "1->3"]
*/

public List<String> binaryTreePaths(TreeNode root) {
	List<String> result = new ArrayList<String>();
	if(root != null)
		binaryTreePaths(result, root, "");
	return result;
}
    
public void binaryTreePaths(List<String> result, TreeNode root, String path){
	if(root.left == null && root.right == null){
            result.add(path + root.val);
	}
	
	if(root.left != null){
		binaryTreePaths(result, root.left, path + root.val + "->");
	}
	
	if(root.right != null){
		binaryTreePaths(result, root.right, path + root.val + "->");
	}
}