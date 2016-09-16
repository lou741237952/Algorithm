package DP;

public class 字符串编辑距离 {
	static int[][] result;

	public static void main(String[] args) {
		// ALGOR I THM
		// AL TRUISTTC
		deal("ALGORITHM", "ALTRUISTTC");
		System.out.println(result[result.length - 1][result[0].length - 1]);
	}

	static void deal(String str1, String str2) {
		// 对于两个字符串，有四种匹配情况，插入，删除，替换，不动
		// result[i][j]表示str1[0-i]和str2[0-j]的最小编辑距离
		// dp[i][j]=min{dp[i-1][j],dp[i][j-1]+1,dp[i-1][j-1]+(S1[i]==S2[j])?0:1)}

		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		result = new int[str1.length()][str2.length()];

		for (int i = 0; i <= str1.length() - 1; i++) {
			for (int j = 0; j <= str2.length() - 1; j++) {
				// 边界情况
				if (i == 0 || j == 0) {
					int temp = (a[i] == b[j]) ? 0 : 1;
					if (i == j) {
						result[i][j] = temp;
					} else {
						result[i][j] = (i == 0) ? result[i][j - 1] + temp
								: result[i - 1][j] + temp;
					}
				} else if (a[i] == b[j]) {
					// 相等则不需要动
					result[i][j] = result[i - 1][j - 1];
				} else {
					// str1替代
					int replace = result[i - 1][j - 1] + 1;
					// str1删除
					int delete = result[i - 1][j] + 1;
					// str1插入
					int insert = result[i][j - 1] + 1;
					result[i][j] = Math.min(replace, Math.min(delete, insert));
				}
			}
		}
	}
}
