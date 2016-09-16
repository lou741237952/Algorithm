package 华为OJ;

import java.util.Scanner;

public class 密码验证合格程序 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println(cheakAll(scan.next()));
		}
	}

	static String cheakAll(String str) {
		if (checkLen(str) && checkType(str) && checkRepeat(str)) {
			return "OK";
		}
		return "NG";
	}

	static boolean checkLen(String str) {
		return (str.length() > 8) ? true : false;
	}

	static boolean checkType(String str) {
		char[] temp = str.toCharArray();
		int upper = 0, lower = 0, num = 0, other = 0;
		for (char c : temp) {
			if ('A' <= c && c <= 'Z')
				upper = 1;
			else if ('a' <= c && c <= 'z')
				lower = 1;
			else if ('0' <= c && c <= '9')
				num = 1;
			else
				other = 1;
			if ((upper + lower + num + other) >= 3) {
				return true;
			}
		}
		return false;
	}

	static boolean checkRepeat(String str) {
		if (str.length() <= 5)
			return false;
		for (int i = 3; i <= str.length() - 1; i++) {
			for (int n = 0; n + i <= str.length(); n++) {
				String test = str.substring(n, n + i);
				if (str.indexOf(test) != str.lastIndexOf(test)) {
					return false;
				}
			}
		}
		return true;
	}
}