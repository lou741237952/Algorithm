package 华为OJ;

import java.util.Scanner;

public class 表示数字 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] a = scan.nextLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean isNum = (a[0] >= '0' && a[0] <= '9') ? true : false;
		for (int i = 0; i <= a.length - 1; i++) {
			if (a[i] >= '0' && a[i] <= '9') {
				if (!isNum) {
					isNum = true;
					sb.append("*" + a[i]);

				} else {
					sb.append(a[i]);
				}
			} else {
				if (isNum) {
					sb.append("*" + a[i]);
					isNum = false;
				} else {
					sb.append(a[i]);
				}

			}
		}
		if (a[a.length - 1] >= '0' && a[a.length - 1] <= '9') {
			sb.append("*");
		}
		System.out.println(sb);
	}
}