/* CTCI
 * Find the kth to last element of a singly linked list.
 * Example
 * 1 2 3 4 5
	k = 1 => 5
	k = 2 => 4
 */

// Trivial
// Compute the size then iterate until size-k. Two passes.
// Time: O(n)
// Space: O(1)
public static ListNode kthToLast(ListNode head, int k){
	if(head == null || k <= 0) return null;

	// Get size of list
	int size = 0;
	ListNode slow = head;

	while(slow != null){
		slow = slow.next;
		size++;
	}

	slow = head;
	// Increment until size-k or until the end of list
	while(slow != null && k < size){
		slow = slow.next;
		k++;
	}

	return slow;
}

// Best
// Two pointers, with difference of k between. One pass
// Time: O(n)
// Space: O(1)
public static ListNode kthToLast(ListNode head, int k){
	if(head == null || k <= 0) return null;

	ListNode slow = head, fast = head;

	// Increment fast until k
	// Use k > 1 based on the problem (1th to last == last element)
	while(fast != null && k > 1){
		fast = fast.next;
		k--;
	}

	// Check if k > size of list
	if(fast == null) return slow;

	// Walk both pointers until the end
	while(fast.next != null){
		fast = fast.next;
		slow = slow.next;
	}

	return slow;
}

