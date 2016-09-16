package 华为OJ;

import java.util.Scanner;

public class 统计每个月兔子的总数 {
	public static void main(String[] args) {
		System.out.println(new 统计每个月兔子的总数().cal(new Scanner(System.in)
				.nextInt()));
	}

	int cal(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		return cal(n - 1) + cal(n - 2);
	}
}
