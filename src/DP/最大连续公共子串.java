package DP;

import java.util.Scanner;

public class 最大连续公共子串 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();
		int start = 0, end = 0;
		int savestart = 0, saveend = 0;
		int sum = 0;
		for (; end <= str1.length() - 1;) {
			if (str2.indexOf(str1.substring(start, end + 1)) != -1) {
				int newsum = end - start + 1;
				if (newsum > sum) {
					sum = newsum;
					savestart = start;
					saveend = end;
				}
				end++;
			} else {
				start++;
				if (start == end)
					end++;
			}
		}
		System.out.println(str1.substring(savestart, saveend + 1));
	}
}