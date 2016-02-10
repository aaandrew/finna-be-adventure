// Time: O(n)
// Space: O(n)
public void printZigZagOrderDeque(TreeNode root){
  boolean leftToRight = true;
  Deque<TreeNode> deque = new LinkedList<TreeNode>();
  deque.addFirst(root);
  while(!deque.isEmpty()){
    int size = deque.size();
    for(int i=0; i<size; i++){
      if(leftToRight){
        // Poll from front, add to back
        TreeNode n = deque.pollFirst();
        System.out.print(n.data + " ");
        if(n.left != null) deque.addLast(n.left);
        if(n.right != null) deque.addLast(n.right);
      }else{
        // Poll from back, add in reverse order to front
        TreeNode n = deque.pollLast();
        System.out.print(n.data + " ");
        if(n.right != null) deque.addFirst(n.right);
        if(n.left != null) deque.addFirst(n.left);
      }
    }
    leftToRight = !leftToRight;
    System.out.println();
  }
}

// Time: O(n^2)
// Space: O(n)
public void printZigZagOrderRecursive(TreeNode root){
  boolean ltr = true;
  int height = getHeight(root);
  for(int i=0; i<height; i++){
    printGivenLevel(root, i, ltr);
    ltr = !ltr;
    System.out.println();
  }
}

public void printGivenLevel(TreeNode root, int level, boolean ltr) {
  if(root == null || level < 0) return;
  if(level == 0){
    System.out.print(root.data + " ");
  }else{
    if(ltr == true){
      printGivenLevel(root.left, level-1, ltr);
      printGivenLevel(root.right, level-1, ltr);
    }else{
      printGivenLevel(root.right, level-1, ltr);
      printGivenLevel(root.left, level-1, ltr);
    }
  }
}