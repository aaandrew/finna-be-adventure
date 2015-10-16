import java.util.LinkedList;
import java.util.Queue;

public class BST {
	TreeNode root;
	
	public void insert(int value){
		root = insert(root, value);
	}
	
	// Recursive Insert
	private TreeNode insert(TreeNode curr, int value){
		if(curr == null){
			return new TreeNode(value);
		}
		if(value <= curr.data){
			curr.left = insert(curr.left, value);
		}else{
			curr.right = insert(curr.right, value);
		}
		return curr;
	}
	
	// Iterative Insert
	public void insertIterative(int value){
		TreeNode insertedNode = new TreeNode(value);
		if(root == null){
			root = insertedNode;
		}else{
			// Find spot to insert node
			TreeNode parent = root;
			TreeNode curr = root;
			while(curr != null){
				parent = curr;
				if(value <= curr.data){
					curr = curr.left;
				}else{
					curr = curr.right;
				}
			}
			if(value <= parent.data){
				parent.left = insertedNode;
			}else{
				parent.right = insertedNode;
			}
		}
	}
	
	public TreeNode find(int value){
		return find(root, value);
	}
	
	private TreeNode find(TreeNode root, int value){
		if(root == null || root.data == value)
			return root;
		if(value <= root.data)
			return find(root.left, value);
		else
			return find(root.right, value);
	}
	
	public TreeNode delete(int value){
		root = delete(root, value);
		return root;
	}

	private TreeNode delete(TreeNode root, int value){
		if(root == null)
			return root;
		
		if(value < root.data){
			root.left = delete(root.left, value);
		}else if(value > root.data){
			root.right = delete(root.right, value);
		}else{
			// Case 1: No children
			if(root.left == null && root.right == null){
				root = null;
			}
			// Case 2: One child
			else if(root.left == null){
				root = root.right;
			}else if(root.right == null){
				root = root.left;
			}
			// Case 3: Two children
			else{
				TreeNode temp = findMin(root.right);
				root.data = temp.data;
				root.right = delete(root.right, temp.data);
			}
		}
		return root;
	}
	
	public void printTree(){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int currentLevelSize = queue.size();
			for(int i=0; i<currentLevelSize; i++){
				TreeNode node = queue.poll();
				System.out.print(node.data + " ");
				if(node.left != null){
					queue.offer(node.left);
				}
				if(node.right != null){
					queue.offer(node.right);
				}
			}
			System.out.println();
		}
	}
	
	private TreeNode findMin(TreeNode root){
		if(root == null)
			return root;
		TreeNode curr = root;
		while(curr.left != null){
			 curr = curr.left;
		}
		return curr;
	}
	
	public static void inorderTraversal(TreeNode root){
		if(root != null){
			inorderTraversal(root.left);
			System.out.println(root.data);
			inorderTraversal(root.right);
		}
	}
	
	public void addArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			this.insert(arr[i]);
		}
	}
	
	public static void main(String[] args){
		BST bst = new BST();
		int[] arr = new int[]{12, 5, 15, 3, 1, 7, 9, 13, 17, 20};
		bst.addArray(arr);
		bst.printTree();
		System.out.println("/////");
		bst.delete(15);
		bst.printTree();
		
	}
}
