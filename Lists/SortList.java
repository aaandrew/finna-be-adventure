/* Leetcode
 * Sort a linked list in place.
 */

// Merge sort (recursion)
// Time: O(nlogn)
// Space: O(logn)
public ListNode sortList(ListNode head) {
	return mergeSort(head);
}

public ListNode mergeSort(ListNode head){
	if(head == null || head.next == null)
		return head;

	ListNode mid = getMid(head);
	ListNode right = mid.next;
	// Break the list
	mid.next = null;

	ListNode sortedLeft = mergeSort(head);
	ListNode sortedRight = mergeSort(right);
	return merge(sortedLeft, sortedRight);
}

public ListNode merge(ListNode left, ListNode right){
	if(left == null) return right;
	if(right == null) return left;

	ListNode dummy = new ListNode(0);
	ListNode p = dummy;

	while(left != null && right != null){
		if(left.val < right.val){
			p.next = left;
			left = left.next;
		}else{
			p.next = right;
			right = right.next;
		}
		p = p.next;
	}

	p.next = (left != null) ? left : right;

	return dummy.next;
}

public ListNode getMid(ListNode head) {
	ListNode slow = head;
	ListNode fast = head;
	while(fast.next != null && fast.next.next != null){
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow;
}