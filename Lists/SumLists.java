/* CTCI
 * You have two numbers represented by a linked list.
 * Write a function that adds two numbers and returns the sum as a list
 */

// Digits are stored in reverse order
// Example
// (7-1-6) + (5-9-2) = (2-1-9)
// 617 + 295 = 912
public static ListNode add(ListNode a, ListNode b){
	int carry = 0, sum = 0;
	ListNode dummy = new ListNode(0);
	ListNode p = dummy;
	while(a != null || b != null || carry > 0){
		sum = carry;
		if(a != null){
			sum += a.val;
			a = a.next;
		}

		if(b != null){
			sum += b.val;
			b = b.next;
		}

		carry = sum/10;
		p.next = new ListNode(sum % 10);
		p = p.next;
	}
	return dummy.next;
}


// Digits stored in forward order
// Example
// (6-1-7) + (2-9-5) = (9-1-2)
public static ListNode add(ListNode a, ListNode b){
	ListNode ap = a, bp = b;

	// Pad smaller list with 0's in the front
	while(ap != null || bp != null){
		if(ap == null){
			// Add node to front of list A
			ListNode newHead = new ListNode(0);
			newHead.next = a;
			a = newHead;
			bp = bp.next;
		}else if(bp == null){
			// Add node to front of list B
			ListNode newHead = new ListNode(0);
			newHead.next = b;
			b = newHead;
			ap = ap.next;
		}else{
			ap = ap.next;
			bp = bp.next;
		}
	}

	ListNodeWrapper node  = sum(a, b);
	ListNode start = null;
	if(node.carry > 0){
		start = new ListNode(node.carry);
		start.next = node.node;
	}else{
		start = node.node;
	}
	return start;
}

// Invariant: a and b are the same size
public static ListNodeWrapper sum(ListNode a, ListNode b){
	if(a == null && b == null)
		return new ListNodeWrapper(null, 0);

	ListNodeWrapper node = sum(a.next, b.next);
	int sum = a.data + b.data + node.carry;
	ListNode n = new ListNode(sum % 10);
	n.next = node.node;
	return new ListNodeWrapper(n, sum/10);
}

class ListNodeWrapper {
	ListNode node;
	int carry;
	public ListNodeWrapper(ListNode node, int carry){
		this.node = node;
		this.carry = carry;
	}
}

