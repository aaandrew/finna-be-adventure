/* CTCI
 * Implement set of stacks with a capacity
 */

class SetOfStacks{
	int capacity;
	List<Stack<Integer>> stacks;

	public SetOfStacks(int capacity;){
		this.capacity = capacity;
		stacks = new ArrayList<Stack<Integer>>();
		stacks.add(new Stack<Integer>());
	}

	public void push(int data){
		// Case 1: Current stack has room
		// Case 2: Current stack is at capacity, add new stack and push
		Stack<Integer> last = getLast();
		if(last == null || last.size() == capacity){
			stacks.add(new Stack<Integer>);
			last = getLast();			
		}
		last.push(data);
	}

	public int pop(){
		Stack<Integer> last = getLast();
		if(last == null) 
			throw new Exception("Unable to pop empty stack.");

		// Case 1: Stack has atleast 1 element
		if(last.size() > 0){
			return last.pop();
		}else{
			// Case 2: Stack is empty: Remove stack and pop from previous stack if available
			stacks.remove(stack.size()-1);
			last = getLast();
			if(last == null)
				throw new Exception("Unable to pop empty stack.");
			return last.pop();
		}
	}

	// Returns last stack
	private Stack<Integer> getLast(){
		if(stacks.size() > 0)
			return stacks.get(stacks.size()-1);
		return null;
	}

}