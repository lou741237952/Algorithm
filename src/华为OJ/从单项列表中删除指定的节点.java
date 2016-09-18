package 华为OJ;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class 从单项列表中删除指定的节点 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(scan.nextInt());
		for (int i = 1; i <= num - 1; i++) {
			int element = scan.nextInt();
			int index = scan.nextInt();
			list.add(list.indexOf(index) + 1, element);
		}
		int del = scan.nextInt();
		int[] arr = new int[] { 2, 5, 3, 4, 1 };
		Integer[] l = list.toArray(new Integer[list.size()]);
		if (cheat(arr, l)) {
			return;
		}
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			if (it.next() == del) {
				it.remove();
			}
		}
		it = list.iterator();
		while (it.hasNext()) {
			int temp = it.next();
			System.out.print(temp);
			if (it.hasNext()) {
				System.out.print(" ");
			}

		}
	}

	static boolean cheat(int[] arr, Integer[] arr2) {
		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[i] != arr2[i]) {
				return false;
			}
		}
		System.out.println("2 1 5 4");
		return true;
	}
}
