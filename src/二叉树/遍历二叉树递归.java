package 二叉树;

public class 遍历二叉树递归 {

	public static void main(String[] args) {

	}

	static void traverse(Node root) {
		if (root != null) {
			System.out.println(root.val);// 前序
			traverse(root.left);
			System.out.println(root.val);// 中序
			traverse(root.right);
			System.out.println(root.val);// 后序
		}
	}
}
