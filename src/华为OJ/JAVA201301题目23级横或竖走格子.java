package 华为OJ;

import java.util.Scanner;

public class JAVA201301题目23级横或竖走格子 {
	static int count = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		f(scan.nextInt() + 1, scan.nextInt() + 1);
		System.out.println(count);
	}

	static void f(int m, int n) {
		if (m == 1 | n == 1) {
			count++;
		} else {
			f(m - 1, n);
			f(m, n - 1);
		}
	}
}