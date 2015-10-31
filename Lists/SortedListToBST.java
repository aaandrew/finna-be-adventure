/* Leetcode
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */

// Time: O(nlogn)
// Space: O(logn)
public TreeNode sortedListToBST(ListNode head) {
	if(head == null){
		return null;
	}else if(head.next == null){
		return new TreeNode(head.val);
	}

	ListNode slow = head, fast = head, prev = null;
	while(fast.next != null && fast.next.next != null){
		fast = fast.next.next;
		prev = slow;
		slow = slow.next;
	}

	ListNode mid = slow;
	TreeNode n = new TreeNode(mid.val);
	n.right = sortedListToBST(mid.next);

	if(prev != null){
		prev.next = null;
	}else{
		head = null;
	}

	n.left = sortedListToBST(head);
	return n;
}

// Inorder traversal
// Time: O(n)
// Space: O(logn)
ListNode node;

public TreeNode sortedListToBST(ListNode head) {
	int size = count(head);
	node = head;
	return helper(0, size-1);
}

public TreeNode helper(int start, int end){
	if(start > end) return null;
	int mid = (end-start)/2 + start;
	TreeNode left = helper(start, mid-1);
	TreeNode midNode = new TreeNode(node.val);
	midNode.left = left;
	node = node.next;
	TreeNode right = helper(mid+1, end);
	midNode.right = right;
	return midNode;
}

public int count(ListNode head){
	int count = 0;
	if(head == null) return 0;
	ListNode p = head;
	while(p != null){
		p = p.next;
		count++;
	}
	return count;
}