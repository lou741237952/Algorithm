package 华为OJ;

import java.util.ArrayList;
import java.util.Scanner;

public class 从单向链表中删除指定值的节点 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= num; i++) {
			int a = scan.nextInt();
			if (i == 1) {
				list.add(a);
			} else {
				int b = scan.nextInt();
				Integer index = list.indexOf(b);
				list.add(index + 1, a);
			}
		}
		int delete = scan.nextInt();
		int index;
		while ((index = list.indexOf(delete)) != -1) {
			list.remove(index);
		}
		for (int i : list) {
			System.out.print(i + " ");
		}
	}
}
