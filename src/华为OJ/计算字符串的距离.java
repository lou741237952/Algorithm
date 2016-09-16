package 华为OJ;

import java.util.Scanner;

public class 计算字符串的距离 {
	static int[][] result;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		deal(scan.next(), scan.next());
		System.out.println(result[result.length - 1][result[0].length - 1]);
	}

	static void deal(String str1, String str2) {
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		result = new int[str1.length()][str2.length()];
		for (int i = 0; i <= str1.length() - 1; i++) {
			for (int j = 0; j <= str2.length() - 1; j++) {
				if (i == 0 || j == 0) {
					int temp = (a[i] == b[j]) ? 0 : 1;
					if (i == j) {
						result[i][j] = temp;
					} else {
						result[i][j] = (i == 0) ? result[i][j - 1] + temp
								: result[i - 1][j] + temp;
					}
				} else if (a[i] == b[j]) {
					result[i][j] = result[i - 1][j - 1];
				} else {
					int replace = result[i - 1][j - 1] + 1;
					int delete = result[i - 1][j] + 1;
					int insert = result[i][j - 1] + 1;
					result[i][j] = Math.min(replace, Math.min(delete, insert));
				}
			}
		}
	}
}
