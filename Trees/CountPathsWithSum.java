/* CTCI
 * Count number of paths in binary tree that sum to target
 */

import java.util.HashMap;
import java.util.Map;


public class PathsWithSum {

	// Brute force
	// O(n^2) unbalanced, O(nlogn) balanced
	public static int countPathsWithSum(TreeNode root, int target){
		if(root == null) return 0;
		
		// Check paths that sum to target from root
		int paths = countPaths(root, target, 0);
		
		// Try left and right child for paths that sum to target
		paths += countPathsWithSum(root.left, target);
		paths += countPathsWithSum(root.right, target);
		
		return paths;
	}
	
	// Returns number of paths with target sum from current node
	public static int countPaths(TreeNode node, int target, int current){
		if(node == null) return 0;
		current += node.data;
		
		int paths = (current == target) ? 1 : 0;

		paths += countPaths(node.left, target, current);
		paths += countPaths(node.right, target, current);
		return paths;
	}
	
	
	// O(n)
	// Using a DFS, keep a running sum in a hash table <runningsum, active> (active is 0 or 1)
	// If runningsum-target is in hashmap then we know that there is a subset path, so inc
	// Recurse of left and right
	// Make sure to set active and unset appropriately
	public static int countPathSum(TreeNode root, int target){
		if(root == null) return 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		incMap(map, 0, 1);
		return countPathSum(root, target, 0, map);
	}
	
	public static int countPathSum(TreeNode root, int target, int current, Map<Integer, Integer> map) {
		if(root == null) return 0;
		
		current += root.data;
		incMap(map, current, 1);
		
		int diff = current - target;
		int paths = map.containsKey(diff) ? map.get(diff) : 0;
		
		paths += countPathSum(root.left, target, current, map);
		paths += countPathSum(root.right, target, current, map);
		
		incMap(map, current, -1);
		return paths;
				
	}
	
	public static void incMap(Map<Integer, Integer> map, int key, int delta){
		if(!map.containsKey(key)){
			map.put(key, 0);
		}
		map.put(key, map.get(key) + delta);
	}
	
	public static void main(String [] args) {
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(-3);
		TreeNode d = new TreeNode(11);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(1);
		TreeNode g = new TreeNode(3);
		TreeNode i = new TreeNode(3);
		TreeNode j = new TreeNode(-2);
		
		a.left = b;
		a.right = c;
		c.right = d;
		b.left = g;
		b.right = e;
		e.right = f;
		g.left = i;
		i.left = j;
		
		System.out.println(countPathSum(a, 8));
	}
}
