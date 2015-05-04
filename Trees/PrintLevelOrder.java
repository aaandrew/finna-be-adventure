/* Print a BST in level order
 *
 */

// Time: O(n)
// Space: O(n)
public static void printLevelOrder(Node root) {
  Queue<Node> queue = new LinkedList<Node>();
  queue.add(root);
  while(!queue.isEmpty()) {
    int levelSize = queue.size();
    for(int i=0; i<levelSize; i++) {
      Node curNode = queue.remove();
      System.out.print(curNode.value + " ");

      if (curNode.left != null) {
        queue.add(curNode.left);
      }
      if (curNode.right != null) {
        queue.add(curNode.right);
      }
    }
    System.out.println();
  }
}