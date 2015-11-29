/*
 * Implement k stacks in a single array that supports:
 * push(int data, int stackNumber)
 * pop(int stackNumber)
 * Resources:
 * 1) http://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/
 * 2) http://codercareer.blogspot.com/2013/02/no-39-stacks-sharing-array.html
 */

// Solution
// 1) top[k] stores stack indexes for top element
// 2) next[n] stores indexes of next available item in arr[]
// Time: O(1) for each operation
// Space: O(k + n), k = # of stacks, n = size of array(

class KStack{
	// Holds stack elements
	int[] arr;

	// top[k] stores stack indexes for their top elements
	int[] top;

	// next[n] stores indexes of next available item in arr
	int[] next;

	// Next Available index
	int nextAvailable;

	// Stacks - Number of stacks
	// Size - size of array
	public KStack(int stacks, int size){
		arr = new int[size];
		next = new int[size];
		top = new int[stacks];

		// All stacks are empty, so indexes are -1
		for(int i=0; i<top.length; i++){
			top[i] = -1;
		}

		// Set the next indexes for next[]
		for(int i=0; i<next.length; i++){
			next[i] = i+1;
		}
		// Last index has no next index
		next[next.length-1] = -1;

		// First index is first available
		nextAvailable = 0;
	}

	// data - data
	// stack - stack number (from 0-k-1)
	public void push(int data, int stack) throws Exception{
		if(isFull()){
			throw new Exception("Array is full");
		}

		// Store index of current available spot
		int temp = nextAvailable;
		// Update next available
		nextAvailable = next[temp];
		// Place data in array
		arr[temp] = data;
		// Update to store the previous top index of the stack
		next[temp] = top[stack];
		// Update stack's top index
		top[stack] = temp;
		

	}

	public int pop(int stack) throws Exception{
		if(isEmpty(stack)){
			throw new Exception("Stack is full");
		}

		// Store index of top of stack
		int temp = top[stack];
		// Update top of stack to previous available index
		top[stack] = next[temp];
		// Update top of stack index to point to current next available
		next[temp] = nextAvailable;
		// Update next available to be top of stack index
		nextAvailable = temp;

		return arr[temp];
	}

	public boolean isEmpty(int stack){
		return top[stack] == -1;
	}

	public boolean isFull(){
		return nextAvailable == -1;
	}
}

// Tests from GeeksForGeeks
public class KStacksInArray {
	public static void main(String[] args) throws Exception{
		KStack ks = new KStack(3, 10);
		
		// Let us put some items in stack number 2
	    ks.push(15, 2);
	    ks.push(45, 2);
	 
	    // Let us put some items in stack number 1
	    ks.push(17, 1);
	    ks.push(49, 1);
	    ks.push(39, 1);
	 
	    // Let us put some items in stack number 0
	    ks.push(11, 0);
	    ks.push(9, 0);
	    ks.push(7, 0);
	    
	    System.out.println(ks.pop(2)); // 45
	    System.out.println(ks.pop(1)); // 39
	    System.out.println(ks.pop(0)); // 7
	}
}