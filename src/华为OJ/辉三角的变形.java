package 华为OJ;

import java.util.Scanner;

public class 辉三角的变形 {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int count = 1;
		for (int i = 2; i <= 2 * n - 2; i++) {
			if ((find(n, i) & 1) == 0) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}

	static int find(int n, int m) {
		if (n == 1 || n == 2)
			return 1;
		if (m == 1 || m == 2 * n - 1)
			return 1;
		if (m == 2 || m == 2 * n - 1)
			return find(n - 1, m - 1) + find(n - 1, m);
		return find(n - 1, m - 2) + find(n - 1, m - 1) + find(n - 1, m);
	}
}