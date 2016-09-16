package 华为OJ;

import java.util.Scanner;

public class 挑7 {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int sum = 0;
		if (n >= 7) {
			for (int i = 7; i <= n; i++) {
				if (i % 7 == 0 || String.valueOf(i).contains("7")) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
}