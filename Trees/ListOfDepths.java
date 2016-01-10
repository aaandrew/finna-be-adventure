/* CTCI
 * Given a binary tree create a linked list of all the nodes at each depth
 * (if you a a tree with depth D, you have D linked lists).
 */

// Time: O(n)
// Space: O(n)
public class ListOfDepths {
  public static List<LinkedList<TreeNode>> listOfDepths(TreeNode root){
    List<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();  
    if(root == null) return list;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while(!queue.isEmpty()){
      int size = queue.size();
      LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
      // Add all nodes in row
      for(int i=0; i<size; i++){
        TreeNode node = queue.poll();
        temp.offer(node);

        // Add children
        if(node.left != null) 
          queue.offer(node.left);
        if(node.right != null)
          queue.offer(node.right);
      }
      // Add to list
      list.add(temp);
    }
    return list;
  }
  
  public static void main(String[] args){
    TreeNode node0 = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    
    node3.left = node1;
    node3.right = node5;
    node1.left = node0;
    node1.right = node2;
    node5.left = node4;
    node5.right = node6;
    
    List<LinkedList<TreeNode>> list = listOfDepths(node3);
    printList(list);
  }
  
  public static void printList(List<LinkedList<TreeNode>> list){
    for(int i=0; i<list.size(); i++){
      LinkedList<TreeNode> tempList = list.get(i);
      for(int j=0; j<tempList.size(); j++){
        System.out.print(tempList.get(j).data + " ");
      }
      System.out.println();
    }
  }
}
