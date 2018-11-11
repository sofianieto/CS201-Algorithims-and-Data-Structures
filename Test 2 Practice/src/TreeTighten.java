
public class TreeTighten {
	public TreeNode tighten(TreeNode tree) {
		if(tree == null) {
			return tree;
		}
		if(tree.left == null && tree.right != null) {
			return  tighten(tree.right);
		}

		if(tree.left != null && tree.right == null) {
			return  tighten(tree.left);
		}
		tree.left = tighten(tree.left);
		tree.right = tighten(tree.right);
		return tree;
	}
}
//She wrote in class I don't get how it removes the ones without 
// a node 