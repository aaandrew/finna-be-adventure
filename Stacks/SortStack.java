/* CTCI
 * Keep a sorted stack
 */

import java.util.Stack;

public class SortStack{
	public static void main(String[] args){
		SortStack s = new SortStack();
		s.push(3);
		s.push(4);
		s.push(10);
		s.push(5);
		while(!s.isEmpty())
			System.out.println(s.pop());
		// 3 4 5 10
	}
	
	Stack<Integer> stack;
	Stack<Integer> temp;

	public SortStack(){
		stack = new Stack<Integer>();
		temp = new Stack<Integer>();
	}

	// Time: O(n^2)
	// Space: O(n)
	public void push(int data){
		while(!isEmpty() && data > peek()){
			temp.push(stack.pop());
		}

		stack.push(data);

		while(temp.size() > 0){
			stack.push(temp.pop());
		}
	}

	public int pop(){
		return stack.pop();
	}

	public int peek(){
		return stack.peek();
	}

	public boolean isEmpty(){
		return stack.empty();
	}
}




T: 3 4 
S: 10 5 4 3   \ 5

