/* CTCI
 * You have two numbers represented by a linked list.
 * Write a function that adds two numbers and returns the sum as a list
 */

// Digits are stored in reverse order
// Example
// (7-1-6) + (5-9-2) = (2-1-9)
// 617 + 295 = 912
public static ListNode add(ListNode a, ListNode b){
		int carry = 0;
		ListNode ap = a, bp = b;
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;

		while(ap != null && bp != null){
			int sum = ap.data + bp.data + carry;
			carry = sum/10;
			p.next = new ListNode(sum % 10);
			p = p.next;
			ap = ap.next;
			bp = bp.next;
		}
		
		// Append remaining list
		if(ap == null){
			p.next = bp;
		}else{
			p.next = ap;
		}

		// Add carry
		if(carry > 0){
			// Keep adding carry until end of list
			while(p.next != null && carry > 0){
				int sum = p.next.data + carry;
				carry = sum/10;
				p.next.data = sum % 10;
				p = p.next;
			}
			// Check if need to add carry node
			if(carry > 0){
				p.next = new ListNode(carry);
			}
		}

		// return new head
		return dummy.next;
	}


// Digits stored in forward order
// Example
// (6-1-7) + (2-9-5) = (9-1-2)
public static ListNode add(ListNode a, ListNode b){
	
}

