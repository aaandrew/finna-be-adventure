/* CTCI
 * Parition a linked list around value x such that all nodes less than x
 * come before all nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be
 * after the elements less than x.
 */

public ListNode partition(ListNode head, int value){
	ListNode smallStart = null, smallEnd = null;
	ListNode largeStart = null, largeEnd = null;
	ListNode p = head;

	while(p != null){
		if(p.data < value){
			if(smallStart == null){
				smallStart = p;
				smallEnd = p;
			}else{
				smallEnd.next = p;
				smallEnd = p;
			}
		}else{
			if(largeStart == null){
				largeStart = p;
				largeEnd = p;
			}else{
				largeEnd.next = p;
				largeEnd = p;
			}
		}
		p = p.next;
	}

	smallEnd.next = largeStart;
	largeEnd.next = null;
	return smallStart;

}