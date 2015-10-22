/* Leetcode
 * Implement Queue using Stacks
 */

class MyQueue {

  Stack<Integer> front = new Stack<Integer>();
  Stack<Integer> back = new Stack<Integer>();
  // Push element x to the back of queue.
  public void push(int x) {
    back.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
    if(!front.empty()){
      front.pop();
    }else if(!back.empty()){
      moveBackToFront();
      front.pop();
    }
  }

  // Get the front element.
  public int peek() {
    if(!front.empty()){
      return front.peek();
    }else{
      moveBackToFront();
      return front.peek();
    }
  }

  private void moveBackToFront(){
    while(!back.empty()){
      front.push(back.pop());
    }
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return front.empty() && back.empty();
  }