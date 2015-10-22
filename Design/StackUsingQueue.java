/* Leetcode
 * Implement Stack using Queue
 */

class MyStack {
  Queue<Integer> queue = new LinkedList<Integer>();

  public void push(int x) {
    queue.offer(x);
    for(int i=1; i<queue.size(); i++){
      queue.offer(queue.poll());
    }
  }

  public void pop() {
    queue.poll();
  }

  public int top() {
    return queue.peek();
  }

  public boolean empty() {
    return queue.isEmpty();
  }
}