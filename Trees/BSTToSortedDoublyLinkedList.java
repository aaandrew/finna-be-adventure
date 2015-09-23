/* Leetcode http://articles.leetcode.com/2010/11/convert-binary-search-tree-bst-to.html
 * Convert a BST to a sorted circular doubly-linked list in-place.
 * Think of the left and right pointers as prev/next pointers in a list.
 */


// Divide and Conquer
public static TreeNode BSTToDoublyList(TreeNode root){
	if(root == null) return root;

	TreeNode leftList = BSTToDoublyList(root.left);
	TreeNode rightList = BSTToDoublyList(root.right);

	root.left = root;
	root.right = root;

	leftList = append(leftList, root);
	leftList = append(leftList, rightList);

	return leftList;
}

public static TreeNode append(TreeNode listA, TreeNode listB){
	if(listA == null) return listB;
	if(listB == null) return listA;

	TreeNode aLast = listA.left;
	TreeNode bLast = listB.left;

		// Connect the last node of A with the first of B
	join(aLast, listB);
		// Connect the last node of B with the first of A
	join(bLast, listA);

	return listA;
}

public static void join(TreeNode a, TreeNode b){
	a.right = b;
	b.left = a;
}


// In order Traversal
public class ConvertBSTToList {
	TreeNode prev = null;
	TreeNode listHead = null;
	TreeNode listTail = null;

	// Connect the head and tail pointers
	public void BSTToDoublyList(TreeNode root){
		convertToList(root);
		listHead.left = listTail;
		listTail.right = listHead;
		return listHead;
	}

	public void convertToList(TreeNode node){
		if(node == null) return;

		convertToList(node.left);

		if(listHead == null)
			listHead = node;

		if(prev == null){
			prev = node;
		}else{
			node.left = prev;
			prev.right = node;
		}
		prev = node;
		convertToList(node.right);
		if(node.right == null)
			listTail = node;
	}
}

