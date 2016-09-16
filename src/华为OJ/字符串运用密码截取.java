package 华为OJ;

import java.util.Scanner;

public class 字符串运用密码截取 {
	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine().replace("", " ");
		int count = 0;
		int index = 0;
		for (int i = 0; i <= str.length() - 1; i++) {
			int temp = center(str, i);
			if (temp > count) {
				count = temp;
				index = i;
			}
		}
		String result = str.substring(index - count + 1, index + count)
				.replaceAll(" ", "");
		System.out.println(result.length());
	}

	static int center(String str, int i) {
		int count = 1;
		for (int n = 1; i - n >= 0 && i + n <= str.length() - 1; n++) {
			if (str.charAt(i - n) == str.charAt(i + n)) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
}