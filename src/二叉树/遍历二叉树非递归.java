package 二叉树;

import java.util.LinkedList;

public class 遍历二叉树非递归 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void preTraverse(Node root) {
		LinkedList<Node> stack = new LinkedList<Node>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				System.out.println(root.val);// 前序
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				root = root.right;
			}
		}
	}

	static void inTraverse(Node root) {
		LinkedList<Node> stack = new LinkedList<Node>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				System.out.println(root.val);// 中序
				root = root.right;
			}
		}
	}

	static void postTraverse(Node root) {
		LinkedList<Node> stack = new LinkedList<Node>();
		LinkedList<Node> resultStack = new LinkedList<Node>();
		// 先把右边放完，然后放左边
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				resultStack.push(root);
				stack.push(root);
				root = root.right;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				root = root.left;
			}
		}
		// 打印结果
		while (!resultStack.isEmpty()) {
			System.out.println(resultStack.pop());
		}
	}
}
