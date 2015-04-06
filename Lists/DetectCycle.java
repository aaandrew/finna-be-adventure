/* Leetcode
 * Return start of cycle or null if no cycle
 */

// Time: O(n)
// Space: O(1)
public static Node detectCycle(Node head) {
	if(head == null || head.next == null) return null;
	Node slow = head;
	Node fast = head;
	while(fast.next != null && fast.next.next != null){
		fast = fast.next.next;
		slow = slow.next;
		if(fast == slow) break;
	} 
	if(fast.next == null || fast.next.next == null) return null;
	slow = head;
	while(fast != slow){
		fast = fast.next;
		slow = slow.next;
	}
	return slow;
}