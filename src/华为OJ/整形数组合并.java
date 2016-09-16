package 华为OJ;

import java.util.Scanner;
import java.util.TreeSet;

public class 整形数组合并 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeSet<Integer> set = new TreeSet<Integer>();
		int num = scan.nextInt();
		for (int i = 1; i <= num; i++) {
			int n = scan.nextInt();
			set.add(n);
		}

		num = scan.nextInt();
		for (int i = 1; i <= num; i++) {
			int n = scan.nextInt();
			set.add(n);
		}
		for (Integer i : set) {
			System.out.print(i);
		}
	}
}