package 二叉树;

import java.util.LinkedList;

public class 判断二叉树是否合法 {
	public boolean isValidBST(Node root) {
		// 核心就是中序遍历，用一个temp保存目前遍历节点前面的一个节点，如果前面大于现在的则不合法
		LinkedList<Node> stack = new LinkedList<Node>();
		Node pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				if (pre != null && pre.val >= root.val) {
					// 前面的节点大则不合法
					return false;
				}
				pre = root;
				root = root.right;
			}
		}
		return true;
	}
}
