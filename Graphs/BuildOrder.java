/* CTCI
 * You are given a list of projects and depedencies formatted as [a,b]
 * where a is dependent on b. All of the dependencies must be built before the project
 * Find a build order that will allow the project sto be built, otherwise return an error
 *
 * Example
 * Input
 * projects: a, b, c, d, e, f
 * dependencies: [d,a], [b,f], [d,b], [a,f], [c,d]
 * output: f, e, a, b, d, c
 */

// Algorithm
// Create graph such that edge (a->b) where b is dependent on a
// Find all nodes that have 0 outgoing edges (dependencies) and add to order list
// Remove their edges (or decrement depenencies) of their neighbors and repeat until no nodes left
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class BuildOrder {
	
	// Dependencies is [[a,b],[b,a]] format
	public static String[] buildOrder(String[] projects, String[][] dependencies){
		String[] finalOrder = new String[projects.length];
		GraphList graph = createGraph(projects, dependencies);
		
		// Create a dependency map
		Set<GraphNode> set = new HashSet<GraphNode>();
		HashMap<GraphNode, Integer> numDependencies = createDepenencyMap(graph);
		int index = 0; // Index of the finalOrder
		
		while(index < projects.length){
			List<GraphNode> list = getNonDependentNodes(set, numDependencies);
			// Check for circular dependency
			if(list.size() == 0) throw new Error("Circular dependency");
			for(GraphNode node : list){
				set.add(node);
				finalOrder[index++] = node.val;
				// Decrement dependencies
				for(GraphNode target : node.neighbors){
					numDependencies.put(target, numDependencies.get(target) - 1);
				}
			}
		}
		return finalOrder;
	}
	
	// Creates graph
	private static GraphList createGraph(String[] projects, String[][] dependencies){
		GraphList graph = new GraphList();
		// Add all projects to graph
		for(String project: projects){
			graph.addNode(project);
		}
		// Add all edges (a,b) meaning b is dependent on a
		for(String[] edge : dependencies){
			// edge 1 must be compiled/dependent before edge 0
			graph.addEdge(edge[1], edge[0]);
		}
		return graph;
	}
	
	// Creates a dependency map
	public static HashMap<GraphNode, Integer> createDepenencyMap(GraphList graph){
		HashMap<GraphNode, Integer> map = new HashMap<GraphNode, Integer>();
		for(GraphNode node : graph.graphNodes){
			map.put(node, 0);
		}
		for(GraphNode node : graph.graphNodes){
			for(GraphNode target: node.neighbors){
				map.put(target, map.get(target) + 1);
			}
		}
		return map;
	}
	
	// Returns a list of nodes that have no dependencies
	public static List<GraphNode> getNonDependentNodes(Set<GraphNode> set, HashMap<GraphNode, Integer> map){
		List<GraphNode> list = new ArrayList<GraphNode>();
		// Add nodes to the list that have zero dependencies
		for(GraphNode node : map.keySet()){
			if(!set.contains(node) && map.get(node) == 0){
				list.add(node);
			}
		}
		return list;
	}
	
	public static String[] buildOrderDFS(String[] projects, String[][] dependencies){
		GraphList graph = createGraph(projects, dependencies);
		List<String> finalOrder = new ArrayList<String>();
		String[] output = new String[projects.length];
		Set<GraphNode> visited = new HashSet<GraphNode>();
		for(GraphNode node : graph.graphNodes){
			if(!visited.contains(node)){
				Set<GraphNode> set = new HashSet<GraphNode>();
				dfs(node, visited, set, finalOrder);
			}
		}
		
		for(int i=0; i<output.length; i++){
			output[i] = finalOrder.get(i);
		}
		return output;
	}
	
	public static void dfs(GraphNode node, Set<GraphNode> visited, Set<GraphNode> set, List<String> finalOrder){
		if(visited.contains(node)) return;
		if(node.neighbors.size() == 0){
			set.add(node);
			visited.add(node);
			finalOrder.add(0, node.val);
		}else{
			set.add(node);
			for(GraphNode target : node.neighbors){
				// Check circular dependency
				if(set.contains(target)) throw new Error("Circular dependency");
				dfs(target, visited, set, finalOrder);
			}
			visited.add(node);
			finalOrder.add(0, node.val);
		}
	}
	
	public static void main(String[] args){
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] dependencies = {
			{"d", "a"}, {"b","f"}, {"d","b"}, {"a","f"}, {"c", "d"}
		};
		
		String[] output = buildOrderDFS(projects, dependencies);
		for(String name : output)
			System.out.println(name);
	}
}

class GraphList {
	List<GraphNode> graphNodes;
	HashMap<String, GraphNode> map = new HashMap<String, GraphNode>();
	
	public GraphList(){
		graphNodes = new ArrayList<GraphNode>();
	}
	
	public void addNode(String value){
		GraphNode node = new GraphNode(value);
		graphNodes.add(node);
		map.put(value, node);
	}
	
	public void addEdge(String source, String dest){
		if(map.containsKey(source) && map.containsKey(dest)){
			GraphNode sourceNode = map.get(source);
			GraphNode destNode = map.get(dest);
			sourceNode.addEdge(destNode);
		}
	}
}

class GraphNode {
	String val;
	List<GraphNode> neighbors;
	public GraphNode(String value){
		val = value;
		neighbors = new ArrayList<GraphNode>();
	}
	public void addEdge(GraphNode dest){
		neighbors.add(dest);
	}
}