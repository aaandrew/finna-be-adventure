/* 
 * Removes a cycle from list and return true, otherwise returns false
 */

// Time: O(n)
// Space: O(1)
public static boolean removeCycle(Node head) {
	if(head == null || head.next == null) return false;
	Node slow = head;
	Node fast = head;
	while(fast.next != null && fast.next.next != null){
		fast = fast.next.next;
		slow = slow.next;
		if(fast == slow) break;
	}
	if(fast.next == null || fast.next.next == null) return false;
	slow = head;
	while(fast != slow){
		slow = slow.next;
		if(fast.next == slow){
			fast.next = null;
			break;
		}else{
			fast = fast.next;
		}
	}
	return true;
}