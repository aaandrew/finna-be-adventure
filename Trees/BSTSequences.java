/* CTCI
 * Given a BST with distinct elements, print all possible arrays that could
 * lead to this tree.
 * Ex.
      2
    1   3

 * Output: {2,1,3}, {2,3,1}
 */

public static List<LinkedList<Integer>> sequences(TreeNode root){
		List<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		// If null return empty list
		if(root == null){
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(root.data);
		
		List<LinkedList<Integer>> left = sequences(root.left);
		List<LinkedList<Integer>> right = sequences(root.right);
		
		for(LinkedList<Integer> ls : left){
			for(LinkedList<Integer> rs : right){
				List<LinkedList<Integer>> temp = new ArrayList<LinkedList<Integer>>();
				weave(ls, rs, temp, prefix);
				result.addAll(temp);
			}
		}
		return result;
	}
	
	public static void weave(LinkedList<Integer> left, LinkedList<Integer> right, 
			List<LinkedList<Integer>> result, LinkedList<Integer> prefix){
		
		if(left.isEmpty() || right.isEmpty()){
			LinkedList<Integer> temp = (LinkedList<Integer>) prefix.clone();
			temp.addAll(left);
			temp.addAll(right);
			result.add(temp);
		}else{
			// Add left head to prefix's tail
			Integer head = left.removeFirst();
			prefix.addLast(head);
			weave(left, right, result, prefix);
			// Undo action
			left.addFirst(prefix.removeLast());
			
			// Add right head to prefix's tail
			head = right.removeFirst();
			prefix.addLast(head);
			weave(left, right, result, prefix);
			// Undo action
			right.addFirst(prefix.removeLast());
		}
	}
	
	public static void main(String[] args){
		TreeNode a = new TreeNode(2);
		a.left = new TreeNode(1);
		a.right = new TreeNode(3);
		
		List<LinkedList<Integer>> allSeq = sequences(a);
		for (LinkedList<Integer> list : allSeq) {
			System.out.println(list);
		}
		System.out.println(allSeq.size());		
	}