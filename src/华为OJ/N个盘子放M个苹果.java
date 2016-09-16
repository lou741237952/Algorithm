package 华为OJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class N个盘子放M个苹果 {
	static int sum = 0;
	static int disk_num;
	static HashSet<String> set = new HashSet<String>();
	static Integer[] result;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(); // 苹果个数
		disk_num = scan.nextInt(); // 盘子个数
		result = new Integer[disk_num];

		execute(a, disk_num);
		System.out.println(set.size());
	}

	static void execute(int n, int m) { // n个苹果放入m个盘子里
		if (m == 1) {
			return;
		}
		for (int i = 0; i <= n; i++) {
			// execute(i, 1);
			result[disk_num - m] = i; // 第disk_num-m+1个盘子
			if (m == 2) {
				result[disk_num - 1] = n - i;
				save(result, set);
			} else {
				execute(n - i, m - 1);// 最后一个盘子放入i个苹果，剩下m-1个盘子放入n-i个苹果
			}

		}
	}

	static void save(Integer[] result, HashSet<String> set) {
		// Arrays.sort(result); 每次处理不能对原字符串进行修改，不然之后会乱
		TreeSet<Integer> temp = new TreeSet<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 >= o2)
					return 1; // 相等的时候也要加入
				else
					return -1;
			}
		});
		temp.addAll(Arrays.asList(result));
		StringBuilder sb = new StringBuilder();
		for (int a : temp) {
			sb.append(a);
		}
		set.add(sb.toString());
		// 不排序的话输出正常顺序
		// for(Integer in:result){System.out.print(in);}System.out.println();
	}
}
