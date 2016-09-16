package 二叉树;

public class 反转二叉树 {
	public Node invertTree(Node root) {
		if (root != null) {
			// 左右两边交换即可
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}
}
