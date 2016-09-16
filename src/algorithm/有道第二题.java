package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
//4
//0 0 0 1
//0 0 1 0
//0 1 1 1
//1 0 1 1

public class 有道第二题 {
	static int[] temp = new int[2];
	static String start;
	static String stop;
	static HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
	static LinkedList<String> list = new LinkedList<String>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();// 数据组数
		for (int i = 1; i <= n; i++) {
			String first = scan.nextInt() + "," + scan.nextInt();
			String second = scan.nextInt() + "," + scan.nextInt();
			insertData(first, second);
		}
		System.out.println(map);
		System.out.println(list + "\n");
		choose(0, list.size() - 1, 2, 2);
	}

	static boolean check() {
		start = list.get(temp[0]);
		stop = list.get(temp[1]);

		String[] a = start.split(",");
		String[] b = stop.split(",");
		String startup = a[0] + "," + b[1];
		String startright = b[0] + "," + a[1];

		LinkedList<String> A = map.get(start);
		LinkedList<String> up = map.get(startup);
		LinkedList<String> right = map.get(startright);

		if (A.contains(startup) && A.contains(startright) && up.contains(stop)
				&& right.contains(stop)) {
			System.out.println(a[0] + " " + a[1] + " " + b[0] + " " + b[1]);
			return true;
		}
		return false;
	}

	static void choose(int start, int end, int a, int num) {
		if (a == 0) {
			if (check()) {
				System.exit(0);
			}
			return;
		}
		if ((end - start + 1) == a) {
			for (int i = 0; i <= a - 1; i++, start++) {
				temp[num - a + i] = start;
			}
			if (check()) {
				System.exit(0);
			}
			return;
		}
		temp[num - a] = start;
		choose(start + 1, end, a - 1, num);
		choose(start + 1, end, a, num);
	}

	static void insertData(String first, String second) {
		LinkedList<String> temp = map.get(first);
		if (temp == null) {
			temp = new LinkedList<String>();
			temp.add(second);
			map.put(first, temp);
		} else {
			temp.add(second);
		}
		// 无向图情况
		// temp = map.get(second);
		// if (temp == null) {
		// temp = new LinkedList<String>();
		// temp.add(first);
		// map.put(second, temp);
		// } else {
		// temp.add(first);
		// }
		if (!list.contains(first)) {
			list.add(first);
		}
		if (!list.contains(second)) {
			list.add(second);
		}
	}
}
