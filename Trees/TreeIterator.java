// In order Tree Iterator
public class TreeIterator{

	Stack<TreeNode> stack;

	public TreeIterator(TreeNode root) {
		stack = new Stack<>();

		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public int next() {
		if (!hasNext()) {
			throw new Exception("No elements left");
		}

		TreeNode next = stack.pop();

		TreeNode nroot = next.right;

		while (nroot != null) {
			stack.push(nroot);
			nroot = nroot.left
		}

		return next.val;
	}

	public boolean hasNext() {
		return !stack.empty();
	}
}