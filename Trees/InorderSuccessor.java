/* 
 * Return the inorder successor of a node
 */


public static TreeNode getSuccessor(TreeNode node){
	if(node == null) return null;
	
	if(node.right == null){
		TreeNode parent = node.parent;
		if(parent.left == node){
			return parent;
		}else{
			return getSuccessorParent(parent);
		}
	}else{
		TreeNode rightChild = node.right;
         // Get leftmost
		TreeNode p = rightChild;
		while(p.left != null){
			p = p.left;
		}
		return p;
	}
}
}

public static TreeNode getSuccessorParent(TreeNode node){
	if(node == null) return null;
	
	TreeNode parent = node.parent;
	if(parent.left == node){
		return parent;
	}else{
		return getSuccessorParent(parent);
	}
}