package 华为OJ;

import java.util.Scanner;

public class 查找输入整数二进制中1的个数 {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		String str = Integer.toBinaryString(n);
		int sum = 0;
		for (int i = 0; i <= str.length() - 1; i++) {
			if (str.charAt(i) == '1')
				sum++;
		}
		System.out.println(sum);
	}
}