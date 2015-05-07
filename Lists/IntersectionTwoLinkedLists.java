/* Leetcode
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * Example:
 * A:      a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
	 B:	b1 → b2 → b3
	begin to intersect at node c1.
 * Return null if no interseciton
 */

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	if(headA == null || headB == null) return null;
	int alength = 0;
	int blength = 0;
	ListNode a = headA;
	ListNode b = headB;
	while(a != null){
		a = a.next;
		alength++;
	}
	while(b != null){
		b = b.next;
		blength++;
	}
	a = headA;
	b = headB;
	while(alength  > blength){
		a = a.next;
		alength--;
	}
	while(alength < blength){
		b = b.next;
		blength--;
	}
	while(a != b){
		a = a.next;
		b = b.next;
	}
	return a;
}

