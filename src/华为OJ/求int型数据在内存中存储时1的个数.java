package 华为OJ;

import java.util.Scanner;

public class 求int型数据在内存中存储时1的个数 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String result = Integer.toBinaryString(n);
		int count = 0;
		for (int i = 0; i <= result.length() - 1; i++) {
			if (result.charAt(i) == '1')
				count++;
		}
		System.out.println(count);
	}
}
