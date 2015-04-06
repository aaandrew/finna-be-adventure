/* http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
 * Given a sorted singly linked list in ascending order, construct a balanced BST
 * 
 * Trivial Solution: O(nlogn)
 * 	1) Get the Middle of the linked list and make it root.
 * 	2) Recursively do same for left half and right half.
 *   	a) Get the middle of left half and make it left child of the root created in step 1
 *    b) Get the middle of right half and make it right child of the root created in step 1
 */

// Time: O(n)
// Space: O(n)
static Node h; // Use a wrapper and pass params to avoid static variable

public static TreeNode sortedListToBST(Node head){
	if(head == null) return null;
	h = head;
	int n = count(head);
	return sortedListToBST(0, n-1);

}

public static TreeNode sortedListToBST(int start, int end){
	if(start > end) return null;
	int mid = start + (end-start)/2;
	TreeNode left = sortedListToBST(start, mid-1);
	TreeNode root = new TreeNode(h.data);
	h = h.next;
	TreeNode right = sortedListToBST(mid+1, end);
	root.left = left;
	root.right = right;
	return root;
}

// Helpers
public static int count(Node head){
	int count = 0;
	Node temp = head;
	while(temp != null){
		temp = temp.next;
		count++;
	}
	return count;
}
