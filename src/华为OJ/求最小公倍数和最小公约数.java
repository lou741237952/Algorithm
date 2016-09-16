package 华为OJ;

import java.util.Scanner;

public class 求最小公倍数和最小公约数 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = cal(a, b);
		System.out.println(a * b / c);// 最小公倍数
	}

	// 最小公约数
	static int cal(int a, int b) {
		if (a < b) {
			a = a + b;
			b = a - b;
			b = a - b;
		}
		while (b != 0) {
			int reminder = a % b;
			a = b;
			b = reminder;
		}
		return a;
	}
}