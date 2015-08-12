/* Leetcode
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Ex.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

// Time: O(n)
// Space: O(1)
public class Solution {
	public ListNode swapPairs(ListNode head) {
		int count = 1;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		while(p.next != null && p.next.next != null){
			p.next = swap(p.next, p.next.next);
			p = p.next.next;
		}
		return dummy.next;
	}

	private ListNode swap(ListNode a, ListNode b){
		a.next = b.next;
		b.next = a;
		return b;
	}

	// Recursive solution
	public ListNode swapPairs(ListNode head) {
		if ((head == null) || (head.next == null))
			return head;
		ListNode n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}

}