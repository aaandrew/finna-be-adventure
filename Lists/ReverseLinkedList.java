/* Leetcode
 * 
 */

// Recursive
// Time: O(n)
// Space: O(n)
public ListNode reverseList(ListNode head) {
	if(head == null || head.next == null)
		return head;
	ListNode last =  reverseList(head.next);
	head.next.next = head;
	head.next = null;
	return last;
}

// Tail Recursion
// Time: O(n)
// Space: O(n)
public ListNode reverseList(ListNode head) {
	return reverseListHelper(null, head);
}

public ListNode reverseListHelper(ListNode prev, ListNode curr){
	if(curr == null)
		return prev;
	ListNode next = curr.next;
	curr.next = prev;
	return reverseListHelper(curr, next);
	
}

// Iterative
// Time: O(n)
// Space: O(1)
public ListNode reverseList(ListNode head) {
	if(head == null || head.next == null)
		return head;
	ListNode prev = null, next = null;
	while(head != null){
		next = head.next;
		head.next = prev;
		prev = head;
		head = next;
	}
	return prev;
}