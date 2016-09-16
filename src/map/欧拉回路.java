package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class 欧拉回路 {
	// 一笔画，每次选最小的数时，可以画的最长路经,如果没有回路则执行一条深度搜索走到头为止
	// 9个点 ，1 2表示1到2的有向路径
	// 9 1 2 2 3 3 4 4 5 5 6 6 4 4 7 7 8 8 4
	static HashMap<Integer, HashSet<Integer>> adj = new HashMap<Integer, HashSet<Integer>>();
	static HashMap<Integer, Boolean> visit = new HashMap<Integer, Boolean>();
	static LinkedList<Integer> road = new LinkedList<Integer>();
	static LinkedList<Integer> temproad = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for (int i = 1; i <= num; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			HashSet<Integer> temp;
			if (adj.containsKey(n)) {
				temp = adj.get(n);
			} else {
				temp = new HashSet<Integer>();
			}
			temp.add(m);
			adj.put(n, temp);
			visit.put(n, false);
			visit.put(m, false);
		}
		Integer first = adj.keySet().iterator().next();
		oulaRoad(first);
		System.out.println(road);
	}

	static void oulaRoad(Integer i) {
		temproad.add(i);// 保存入临时路径
		visit.put(i, true);// 设置访问
		if (allVisited(i)) {
			HashSet<Integer> adjTemp = adj.get(i);
			// 所有邻接点都被访问过，形成一个环
			if (adjTemp == null) {
				// 防止没有回路情况
				road.addAll(temproad);
				return;
			}
			int backnode = adjTemp.iterator().next();// 链接回原路径的某一个节点，形成环
			temproad.add(backnode);
			if (road.isEmpty()) {
				road.addAll(temproad);
			} else {
				// 更新路径
				int index = road.lastIndexOf(backnode);// 链接回原路径的某个点的序号
				temproad.poll();
				road.addAll(index + 1, temproad);// 插入新的环到原路径
			}
			temproad.clear();// 更新完路径后，清空临时路径
			// 回溯继续寻找，如果所有点的邻接矩阵都访问过了，则退出
			for (Integer n : road) {
				if (allVisited(n) == false) {
					oulaRoad(n);
					break;
				}// 如果路径中有点的邻接矩阵没有访问完，则回溯继续深度搜索
			}
		} else {
			// 访问邻接点
			HashSet<Integer> adjcant = adj.get(i);// 得到邻接矩阵
			for (Integer adjnode : adjcant) {
				if (visit.get(adjnode) == false) {
					oulaRoad(adjnode);
					break;// 只找第一个没有访问的邻点访问
				}
			}
		}
	}

	static boolean allVisited(Integer i) {
		HashSet<Integer> set = adj.get(i);
		if (set != null) {
			for (Integer in : set) {
				if (visit.get(in) == false) {
					return false;
				}
			}
		}
		return true;
	}
}
