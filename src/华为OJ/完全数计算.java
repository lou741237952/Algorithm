package 华为OJ;

import java.util.Scanner;

public class 完全数计算 {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		if (n <= 0 || n >= 500000) {
			System.out.println(-1);
			return;
		}
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= i - 1; j++) {
				if (i % j == 0)
					sum += j;
			}
			if (sum == i) {
				count++;
			}
		}
		System.out.println(count);
	}
}
