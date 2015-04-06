/* Print a BST in level order
 *
 */

// Time: O(n)
// Space: O(n)
public static void printLevelOrder(TreeNode root){
	if(root == null) return;
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	queue.offer(root);
	int currLevel = 1;
	int nextLevel = 0;
	while(!queue.isEmpty()){
		TreeNode n = queue.poll();
		currLevel--;
		System.out.print(n.data + " ");
		if(n.left != null) queue.offer(n.left); nextLevel++;
		if(n.right != null) queue.offer(n.right); nextLevel++;
		if(currLevel == 0){
			currLevel = nextLevel;
			nextLevel = 0;
			System.out.println();
		}
	}
}