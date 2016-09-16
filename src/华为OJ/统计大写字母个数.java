package 华为OJ;

import java.util.Scanner;

public class 统计大写字母个数 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		if (str == null) {
			System.out.println(0);
			return;
		}
		int count = 0;
		for (int i = 0; i <= str.length() - 1; i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				count++;
			}
		}
		System.out.println(count);
	}
}