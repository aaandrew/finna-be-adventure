/* CTCI
 * Delete the node in given only access to that node
 * Input: c from linked list a-b-c-d-e
 * Void, but new list is a-b-c-d-e
 */


// Solution
// Works for all nodes except last node
// a b c d e : c
// a b d d e
// a b d e
public boolean deleteNode(ListNode node){
	if(node == null || node.next == null)
		return false;
	node.data = node.next.data;
	node.next = node.next.next;
	return true;
}