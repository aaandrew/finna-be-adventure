/* Leetcode
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 *	 it should invalidate the least recently used item before 
 */
public class LRUCache {
	private class DNode{
		int key, val;
		DNode next, prev;
		DNode(int key, int val){ this.key = key; this.val = val; }
		DNode(){};
	}

	private void delete(DNode node){
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void addHead(DNode node){
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	private void moveHead(DNode node){
		delete(node);
		addHead(node);
	}

	private DNode removeTail(){
		DNode temp = tail.prev;
		delete(temp);
		return temp;
	}

	DNode head, tail;
	HashMap<Integer, DNode> map;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, DNode>();
		head = new DNode();
		tail = new DNode();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if(map.containsKey(key)){
			DNode node = map.get(key);
			moveHead(node);
			return node.val;
		}
		return -1;
	}

	public void set(int key, int value) {
		if(!map.containsKey(key)){
			DNode node = new DNode(key, value);
			map.put(key, node);
			addHead(node);
			if(map.size() > capacity){
				DNode t = removeTail();
				map.remove(t.key);
			}
		}else{
			DNode node = map.get(key);
			node.val = value;
			moveHead(node);
		}
	}
}