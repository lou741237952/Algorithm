package 华为OJ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class 称砝码 {
	static HashSet<Integer> result = new HashSet<Integer>();
	static Integer[] data;
	static int[] temp;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer num = scan.nextInt();
		int[] weight = new int[num];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= num - 1; i++) {
			weight[i] = scan.nextInt();
		}
		for (int i = 0; i <= num - 1; i++) {
			int n = scan.nextInt();
			for (int m = 1; m <= n; m++) {
				list.add(weight[i]);
			}
		}
		data = list.toArray(new Integer[list.size()]);
		for (int i = 1; i <= data.length; i++) {
			init(i);
		}
		System.out.println(result.size() + 1);
	}

	static void init(int n) {
		temp = new int[n];
		choose(0, data.length - 1, n, n, temp);
	}

	static void core() {
		int re = 0;
		for (int i : temp) {
			re += data[i];
		}
		result.add(re);
	}

	static void choose(int start, int end, int a, int num, int[] temp) {
		if (a == 0) {
			core();
			return;
		}
		if ((end - start + 1) == a) {
			for (int i = 0; i <= a - 1; i++, start++) {
				temp[num - a + i] = start;
			}
			core();
			return;
		}
		temp[num - a] = start;
		choose(start + 1, end, a - 1, num, temp);
		choose(start + 1, end, a, num, temp);
	}

}

