/* CTCI
 * Check if linked list is a palindrome
 */

// Solution: Push first half of elements into the stack
// Pop elements off and check if they match with the middle of list to end
// Time: O(n)
// Space: O(n)
public static boolean isPalindrome(ListNode head){
	if(head == null) return true;
	Stack<ListNode> stack = new Stack<ListNode>();
	ListNode slow = head, fast = head;

	while(fast != null && fast.next != null){
		stack.push(slow);
		slow = slow.next;
		fast = fast.next.next;
	}

	// Odd number of elements, skip middle
	if(fast != null){
		slow = slow.next;
	}

	while(!stack.empty()){
		if(stack.pop().data != slow.data)
			return false;
		slow = slow.next;
	}

	return true;
}

// 