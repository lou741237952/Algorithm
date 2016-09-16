package 华为OJ;

import java.util.Scanner;

public class 蛇形矩阵 {
	public static void main(String[] args) {
		new 蛇形矩阵();
	}

	蛇形矩阵() {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for (int i = 0; i <= num - 1; i++) {
			StringBuffer sb = new StringBuffer();
			for (int n = i; n <= num - 1; n++) {
				sb.append(Integer.toString(f(n, i)) + " ");
			}
			System.out.println(sb.toString().trim());
		}
	}

	int f(int column, int gnum) {
		if (column == gnum)
			return g(gnum);
		return f(column - 1, gnum) + (column + 1);
	}

	int g(int row) {
		if (row == 0)
			return 1;
		return g(row - 1) + row;
	}
}