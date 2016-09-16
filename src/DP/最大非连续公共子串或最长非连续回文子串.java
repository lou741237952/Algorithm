package DP;

import java.util.LinkedList;

public class 最大非连续公共子串或最长非连续回文子串 {
	// 回文子串，把字符串反转，再求最大非连续公共子串
	static LinkedList<Character>[][] result;

	public static void main(String[] args) {
		deal("gAoAoAgle", "elgoog");
		System.out.println(result[result.length - 1][result[0].length - 1]);
	}

	static void deal(String str1, String str2) {
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		result = new LinkedList[a.length][b.length];

		// 开辟二位数组，result[i][j]表示取str1中前i个跟str2中前j个字符情况
		// 如果a[i]==b[j]说明公共子串加1，result[i][j]=result[i-1][j-1]
		// 如果a[i]！=b[j]说明公共子串不变，result[i][j]={result[i][j-1]，result[i-1][j]}中公共子串长度最长的那个

		for (int i = 0; i <= a.length - 1; i++) {
			for (int j = 0; j <= b.length - 1; j++) {
				// 二维数组中每个元素都要new一个LinkedList
				result[i][j] = new LinkedList<Character>();
				if (i == 0 || j == 0) {
					// i、j有一个为0，result[0][0]已经创建了
					if (i != j) {
						// i或j为0,等于上一个result
						result[i][j].addAll((i == 0) ? result[i][j - 1]
								: result[i - 1][j]);
					}
					// 如果相等，则公共子串加入新元素
					if (a[i] == b[j]) {
						result[i][j].add(a[i]);
					}
				} else if (a[i] == b[j]) {
					// 相等
					result[i][j].addAll(result[i - 1][j - 1]);
					result[i][j].add(a[i]);
				} else {
					// 不相等
					result[i][j]
							.addAll((result[i - 1][j].size() > result[i][j - 1]
									.size()) ? result[i - 1][j]
									: result[i][j - 1]);
				}
			}
		}
	}
}
