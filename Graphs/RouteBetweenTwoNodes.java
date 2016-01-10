/* CTCI
 * Given a directed graph, design an algorithm to find if there 
 * is a route between two nodes from source to target.
 */
public class RouteBetweenTwoNodes {
	
	public static void main(String[] args){
		Node node0 = new Node("0");
		Node node1 = new Node("1");
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		
		node0.children = new Node[]{node1, node2};
		node1.children = new Node[]{node2};
		node2.children = new Node[]{node0, node3};
		node3.children = new Node[]{node3};
		
		System.out.println(routeBetweenTwoNodes(node0,node3)); // true
	}

	// BFS
	// Time: O(n) - n is number of nodes in graph
	// Space: O(n)
	public static boolean routeBetweenTwoNodes(Node a, Node b){
		if(a == b) return true;

		Set<Node> set = new HashSet<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(a);
		set.add(a);

		while(!queue.isEmpty()){
			Node node = queue.poll();
			for(int i=0; i<node.children.length; i++){
				Node neighbor = node.children[i];
				if(neighbor == b) return true;
				if(!set.contains(neighbor)){
					queue.offer(neighbor);
					set.add(neighbor);
				}
			}
		}
		return false;
	}
}
