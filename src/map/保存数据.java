package map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class 保存数据 {
	// map存放每个点和点的邻接矩阵
	static HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
	// list存放所有点
	static LinkedList<String> list = new LinkedList<String>();

	// 4
	// 0 0 0 1
	// 0 0 1 0
	// 0 1 1 1
	// 1 0 1 1
	// 4个点 每行是两个点形成的线段
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();// 数据组数
		for (int i = 1; i <= n; i++) {
			String first = scan.nextInt() + "," + scan.nextInt();
			String second = scan.nextInt() + "," + scan.nextInt();
			insertData(first, second);
		}
		System.out.println(map);
		System.out.println(list);
	}

	/**
	 * 插入数据，HashMap Key:节点 Value:节点的邻接矩阵 LinkedList 保存每个节点
	 * 
	 * @param first
	 * @param second
	 */
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
