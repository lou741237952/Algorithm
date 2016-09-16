package DP;

import java.util.LinkedList;

public class 判断括号 {

	public static void main(String[] args) {
		char[] arr = "(()(()))".toCharArray();
		LinkedList<Character> list = new LinkedList<Character>();
		boolean validate = true;
		for (int i = 0; i <= arr.length - 1; i++) {
			if (list.isEmpty()) {
				// 空
				if (arr[i] == ')') {
					validate = false;
					break;
				} else {
					list.addFirst(arr[i]);
				}
			} else {
				// 非空
				if (list.peek() == '(' && arr[i] == ')') {
					list.poll();
				} else {
					list.addFirst(arr[i]);
				}
			}
			if (i == arr.length - 1 && !list.isEmpty()) {
				validate = false;
			}
		}
		System.out.println(validate);
	}

}
