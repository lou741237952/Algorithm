package 华为OJ;

import java.util.Scanner;

public class 自守数 {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			String a = String.valueOf(i);
			String b = String.valueOf(i * i);
			for (int m = 0; m <= a.length() - 1; m++) {
				if (a.charAt(a.length() - 1 - m) != b
						.charAt(b.length() - 1 - m)) {
					break;
				}
				if (m == a.length() - 1)
					sum++;
			}
		}
		System.out.println(sum);
	}
}