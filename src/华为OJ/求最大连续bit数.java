package 华为OJ;

import java.util.Scanner;

public class 求最大连续bit数 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String test = Integer.toString(scan.nextInt(), 2);
		int count = 0, temp = 0;
		for (int i = 0; i <= test.length() - 1; i++) {
			if (test.charAt(i) == '1') {
				temp++;
			}
			count = Math.max(count, temp);
		}
		System.out.println(count);
	}
}