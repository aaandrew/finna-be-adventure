/* CTCI
 * Remove duplicates from unsorted list.
 */

// Time: O(n)
// Space: O(n)
public void removeDups(ListNode head){
	if(head == null) return;
	Set<Integer> set = new HashSet<Integer>();
	ListNode p = head;
	set.add(p.data);

	while(p.next != null){
		if(!set.contains(p.next.data)){
			set.add(p.next.data);
			p = p.next;
		}else{
			p.next = p.next.next;
		}
	}
}

// Time: O(n^2)
// Space: O(1)
public void removeDups(ListNode head){
	if(head == null) return;
	ListNode curr = head;
	while(curr != null){
		ListNode runner = curr;
		while(runner.next != null){
			if(curr.data == runner.next.data){
				runner.next = runner.next.next;
			}else{
				runner = runner.next;
			}
		}
		curr = curr.next;
	}
}